create database db_agenda_contactos;

-- Estructura de tabla para la tabla `usuarios`
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50) NOT NULL,
    contrasena VARCHAR(255) NOT NULL
);

-- Estructura de tabla para la tabla `contactos`
CREATE TABLE contactos (
    id_contacto INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    cumpleanios DATE,
    foto BLOB,
    nota TEXT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);


-- Estructura de tabla para la tabla `direcciones`
CREATE TABLE direcciones (
    id_direccion INT AUTO_INCREMENT PRIMARY KEY,
    id_contacto INT,
    calle VARCHAR(255),
    ciudad VARCHAR(255),
    pais VARCHAR(255),
    FOREIGN KEY (id_contacto) REFERENCES contactos(id_contacto)
);


-- Estructura de tabla para la tabla `telefonos`
CREATE TABLE telefonos (
    id_telefono INT AUTO_INCREMENT PRIMARY KEY,
    id_contacto INT NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    tipo_telefono VARCHAR(50),
    FOREIGN KEY (id_contacto) REFERENCES contactos(id_contacto)
);

-- Estructura de tabla para la tabla `reportes`
CREATE TABLE reportes (
    id_reporte INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    num_total_contactos INT,
    num_contactos_editados INT,
    num_contactos_eliminados INT,
    num_contactos_agregados INT,
    fecha_generado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);



CREATE PROCEDURE obtenerContactosDetallados()
BEGIN
    SELECT
        c.id_contacto,
        c.nombre AS nombre_contacto,
        c.email,
        c.cumpleanios,
        c.foto,
        c.nota,
        GROUP_CONCAT(DISTINCT CONCAT(d.calle, ', ', d.ciudad, ', ', d.pais) SEPARATOR '; ') AS direccion,
        GROUP_CONCAT(DISTINCT CONCAT(t.telefono, ' - ', t.tipo_telefono) SEPARATOR '; ') AS telefonos
    FROM
        contactos c
        LEFT JOIN direcciones d ON c.id_contacto = d.id_contacto
        LEFT JOIN telefonos t ON c.id_contacto = t.id_contacto
    GROUP BY
        c.id_contacto;
END


CREATE PROCEDURE obtenerContactoPorId(IN p_idContacto INT)
BEGIN
    SELECT
        c.id_contacto,
        c.nombre,
        c.email,
        c.cumpleanios,
        c.foto,
        c.nota,
        GROUP_CONCAT(DISTINCT CONCAT(d.calle, ', ', d.ciudad, ', ', d.pais) SEPARATOR '; ') AS direccion,
        GROUP_CONCAT(DISTINCT CONCAT(t.telefono, ' - ', t.tipo_telefono) SEPARATOR '; ') AS telefonos
    FROM
        contactos c
        LEFT JOIN direcciones d ON c.id_contacto = d.id_contacto
        LEFT JOIN telefonos t ON c.id_contacto = t.id_contacto
    WHERE
        c.id_contacto = p_idContacto 
    GROUP BY
        c.id_contacto;
END


CREATE PROCEDURE insertarContacto(
    IN p_id_usuario INT,
    IN p_nombre VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_foto BLOB,
    IN p_nota TEXT,
    IN p_cumpleanios DATE,
    IN p_calle VARCHAR(255),
    IN p_ciudad VARCHAR(255),
    IN p_pais VARCHAR(255),
    IN p_telefono VARCHAR(20),
    IN p_tipo_telefono VARCHAR(50),
    IN p_direccion VARCHAR(255) -- Nuevo parámetro para la dirección
)
BEGIN
    DECLARE last_insert_id INT;
    
    -- Insertar el contacto principal
    INSERT INTO contactos (id_usuario, nombre, email, foto, nota, cumpleanios)
    VALUES (p_id_usuario, p_nombre, p_email, p_foto, p_nota, p_cumpleanios);
    
    -- Obtener el ID del contacto insertado
    SET last_insert_id = LAST_INSERT_ID();
    
    -- Insertar la dirección asociada al contacto
    INSERT INTO direcciones (id_contacto, calle, ciudad, pais)
    VALUES (last_insert_id, p_calle, p_ciudad, p_pais);
    
    -- Insertar el teléfono asociado al contacto
    INSERT INTO telefonos (id_contacto, telefono, tipo_telefono)
    VALUES (last_insert_id, p_telefono, p_tipo_telefono);
    
    -- Opcional: Si deseas guardar la dirección en la tabla contactos
    UPDATE contactos SET direccion = CONCAT(p_calle, ', ', p_ciudad, ', ', p_pais) WHERE id_contacto = last_insert_id;
    
    -- Opcional: Si necesitas devolver algún valor, como el ID del nuevo contacto
    SELECT last_insert_id AS new_contact_id;
END


CREATE PROCEDURE actualizarContactoDetallado(
    IN p_id_contacto INT,
    IN p_id_usuario INT,
    IN p_nombre VARCHAR(100),
    IN p_email VARCHAR(100),
    IN p_foto BLOB,
    IN p_nota TEXT,
    IN p_cumpleanios DATE,
    IN p_direccion VARCHAR(255),
    IN p_telefonos TEXT 
)
BEGIN
    DECLARE v_end_pos INT DEFAULT 0;
    DECLARE v_delim_pos INT;
    DECLARE v_telefono VARCHAR(20);
    DECLARE v_tipo_telefono VARCHAR(50);

    -- Verificar que el usuario exista antes de actualizar
    IF NOT EXISTS (SELECT 1 FROM usuarios WHERE id_usuario = p_id_usuario) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El usuario especificado no existe.';
    END IF;

    -- Actualizar el contacto principal
    UPDATE contactos
    SET id_usuario = p_id_usuario,
        nombre = p_nombre,
        email = p_email,
        foto = p_foto,
        nota = p_nota,
        cumpleanios = p_cumpleanios
    WHERE id_contacto = p_id_contacto;

    -- Actualizar la dirección asociada al contacto
    IF p_direccion IS NOT NULL AND p_direccion != '' THEN
        IF EXISTS (SELECT 1 FROM direcciones WHERE id_contacto = p_id_contacto) THEN
            UPDATE direcciones
            SET calle = SUBSTRING_INDEX(p_direccion, ',', 1),
                ciudad = SUBSTRING_INDEX(SUBSTRING_INDEX(p_direccion, ',', 2), ',', -1),
                pais = SUBSTRING_INDEX(p_direccion, ',', -1)
            WHERE id_contacto = p_id_contacto;
        ELSE
            INSERT INTO direcciones (id_contacto, calle, ciudad, pais)
            VALUES (p_id_contacto,
                    SUBSTRING_INDEX(p_direccion, ',', 1),
                    SUBSTRING_INDEX(SUBSTRING_INDEX(p_direccion, ',', 2), ',', -1),
                    SUBSTRING_INDEX(p_direccion, ',', -1));
        END IF;
    END IF;

    -- Actualizar los teléfonos asociados al contacto
    IF p_telefonos IS NOT NULL AND p_telefonos != '' THEN
        DELETE FROM telefonos WHERE id_contacto = p_id_contacto;
        WHILE LENGTH(p_telefonos) > 0 DO
            -- Encontrar la posición del delimitador ';' en p_telefonos
            SET v_delim_pos = LOCATE(';', p_telefonos);
            IF v_delim_pos = 0 THEN
                SET v_telefono = TRIM(p_telefonos);
                SET p_telefonos = '';
            ELSE
                SET v_telefono = TRIM(SUBSTRING(p_telefonos, 1, v_delim_pos - 1));
                SET p_telefonos = TRIM(SUBSTRING(p_telefonos, v_delim_pos + 1));
            END IF;

            -- Extraer el tipo de teléfono
            SET v_tipo_telefono = SUBSTRING_INDEX(v_telefono, '-', -1);
            SET v_telefono = TRIM(SUBSTRING_INDEX(v_telefono, '-', 1));

            -- Insertar el teléfono en la tabla telefonos
            INSERT INTO telefonos (id_contacto, telefono, tipo_telefono)
            VALUES (p_id_contacto, v_telefono, v_tipo_telefono);
        END WHILE;
    END IF;
END;



CREATE PROCEDURE eliminarContacto( IN idContacto INT
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error: No se pudo eliminar el contacto y sus relaciones';
    END;

    START TRANSACTION;
    
    -- Eliminar registros
    DELETE FROM telefonos WHERE id_contacto = idContacto;

    
    DELETE FROM direcciones WHERE id_contacto = idContacto;

  
    DELETE FROM contactos WHERE id_contacto = idContacto;

    COMMIT;
END;

CREATE PROCEDURE obtenerContactosPorUsuario(
    IN id_usuario INT
)
BEGIN
    SELECT *
    FROM contactos
    WHERE id_usuario = id_usuario;
end;




CALL insertarContacto(
    1,
    'ghjkgh Doe', 
    'gjvjjv@example.com', 
    NULL, 
    'Nota de ejemplo', 
    '1980-01-01',
    '434 Main St', 
    'chicla',
    'USA', 
    '123-456-7890', 
    'móvil'
);

CALL actualizarContacto(
    6,
    1,
    'Jane Doe',
    'janedoe@example.com',
    NULL,
    'Nota actualizada',
    '1990-02-02',
    '456 Oak St',
    'Springfield', 
    'USA', 
    '987-654-3210',
    'casa'
);


CALL insertarContacto(
	1, 
	'Maria Prado', 
	'Maria@example.com', 
	NULL, 
	'Nota de Carlos',
	'1994-05-15', 
	'Calle Principal 123', 
	'Ciudad Principal', 
	'Pais Principal', 
	'123456789', 
	'Personal'
);

-- Insertar un contacto con foto y sin dirección ni teléfono



CALL eliminarContacto(4);


-- Insertar datos en la tabla usuarios
INSERT INTO usuarios (nombre_usuario, contrasena) VALUES
('oscar', '12345'),
('aixa', '54321');

select * from contactos c ;
-- Insertar datos en la tabla contactos
INSERT INTO contactos (id_usuario, nombre, email, foto, nota) VALUES
(1, 'John Doe', 'john.doe@example.com', NULL, 'Amigo de la universidad'),
(2, 'Alice Smith', 'alice.smith@example.com', NULL, 'Colega de trabajo');

-- Insertar datos en la tabla direcciones
INSERT INTO direcciones (id_contacto, calle, ciudad, pais)
VALUES (@last_insert_id, '123 Main St', 'Springfield', 'USA');

INSERT INTO direcciones (id_contacto, calle, ciudad, pais)
VALUES (2, '456 Elm St', 'Shelbyville', 'USA');


-- Insertar datos en la tabla telefonos
INSERT INTO telefonos (id_contacto, telefono, tipo_telefono) VALUES
(1, '555-1234', 'Móvil'),
(2, '555-5678', 'Trabajo');

UPDATE contactos
SET cumpleanios = '1980-01-01'
WHERE id_contacto = 1;

UPDATE contactos
SET cumpleanios = '1990-02-02'
WHERE id_contacto = 2;

CALL obtenerContactosDetallados();



