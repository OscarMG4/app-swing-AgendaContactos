create database db_agenda_contactos;

use db_agenda_contactos;

/*TABLAS*/

CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50) NOT NULL,
    contrasena VARCHAR(255) NOT NULL
);

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

CREATE TABLE direcciones (
    id_direccion INT AUTO_INCREMENT PRIMARY KEY,
    id_contacto INT,
    calle VARCHAR(255),
    ciudad VARCHAR(255),
    pais VARCHAR(255),
    FOREIGN KEY (id_contacto) REFERENCES contactos(id_contacto)
);


CREATE TABLE telefonos (
    id_telefono INT AUTO_INCREMENT PRIMARY KEY,
    id_contacto INT NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    tipo_telefono VARCHAR(50),
    FOREIGN KEY (id_contacto) REFERENCES contactos(id_contacto)
);


CREATE TABLE reportes (
    id_reporte INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    num_total_contactos INT NOT NULL DEFAULT 0,
    num_contactos_editados INT NOT NULL DEFAULT 0,
    num_contactos_eliminados INT NOT NULL DEFAULT 0,
    num_contactos_agregados INT NOT NULL DEFAULT 0,
    fecha_generado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);