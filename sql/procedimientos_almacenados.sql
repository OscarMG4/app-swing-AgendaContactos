use db_agenda_contactos;

/*PROCEDIMIENTOS ALMACENADOS*/
/*NOTA: SI TIENE PROBLEMAS PARA EJECUTAR LA HOJA SCRIPT COMPLETA, EJECUTE LOS PROCEDIMIENTOS ALMACENADOS UNO POR UNO*/

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
    IN p_cumpleanios DATE,
    IN p_foto BLOB,
    IN p_nota TEXT,
    IN p_calle VARCHAR(255),
    IN p_ciudad VARCHAR(255),
    IN p_pais VARCHAR(255),
    IN p_telefono VARCHAR(20),
    IN p_tipo_telefono VARCHAR(50)
)
BEGIN
    DECLARE id_contacto INT;
    DECLARE exito BOOLEAN DEFAULT TRUE;

    START TRANSACTION;

    INSERT INTO contactos (id_usuario, nombre, email, cumpleanios, foto, nota)
    VALUES (p_id_usuario, p_nombre, p_email, p_cumpleanios, p_foto, p_nota);

    -- Obtener el ID generado automáticamente
    SET id_contacto = LAST_INSERT_ID();

    INSERT INTO direcciones (id_contacto, calle, ciudad, pais)
    VALUES (id_contacto, p_calle, p_ciudad, p_pais);

    INSERT INTO telefonos (id_contacto, telefono, tipo_telefono)
    VALUES (id_contacto, p_telefono, p_tipo_telefono);

    IF (ROW_COUNT() = 0) THEN
        SET exito = FALSE;
    END IF;

    IF (exito) THEN
        COMMIT;
    ELSE
        ROLLBACK;
    END IF;

    SELECT id_contacto;
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
