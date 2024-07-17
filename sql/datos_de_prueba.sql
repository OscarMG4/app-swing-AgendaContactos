use db_agenda_contactos;

/*INSERTAR DATOS DE PRUEBA*/

INSERT INTO usuarios (nombre_usuario, contrasena)
VALUES ('oscar', '12345');

INSERT INTO usuarios (nombre_usuario, contrasena)
VALUES ('aixa', '54321');


CALL insertarContacto(1, 'Juan Pérez', 'juan@example.com', '1980-09-10', NULL, 'Notas sobre Juan Pérez', 'Av. Principal 123', 'Lima', 'Perú', '999888777', 'Personal');
CALL insertarContacto(1, 'María Gómez', 'maria@example.com', '1980-09-13', NULL, 'Notas sobre María Gómez', 'Calle Secundaria 456', 'Lima', 'Perú', '777888999', 'Trabajo');
CALL insertarContacto(1, 'Carlos Torres', 'carlos@example.com', '1987-08-25', NULL, 'Notas sobre Carlos Torres', 'Jr. Primavera 789', 'Lima', 'Perú', '555666777', 'Personal');
CALL insertarContacto(1, 'Ana Rodríguez', 'ana@example.com', '1992-03-25', NULL, 'Notas sobre Ana Rodríguez', 'Calle Principal 321', 'Lima', 'Perú', '333444555', 'Trabajo');
CALL insertarContacto(1, 'Pablo Martínez', 'pablo@example.com', '1995-12-10', NULL, 'Notas sobre Pablo Martínez', 'Av. Norte 567', 'Lima', 'Perú', '111222333', 'Personal');
CALL insertarContacto(1, 'Laura Sánchez', 'laura@example.com', '1987-06-05', NULL, 'Notas sobre Laura Sánchez', 'Jr. Sur 890', 'Lima', 'Perú', '888999000', 'Trabajo');
CALL insertarContacto(1, 'Diego González', 'diego@example.com', '1980-09-12', NULL, 'Notas sobre Diego González', 'Av. Este 111', 'Lima', 'Perú', '666777888', 'Personal');
CALL insertarContacto(1, 'Carla López', 'carla@example.com', '1975-04-18', NULL, 'Notas sobre Carla López', 'Calle Oeste 222', 'Lima', 'Perú', '444555666', 'Trabajo');
CALL insertarContacto(1, 'Renato Ramírez', 'renato@example.com', '1983-11-08', NULL, 'Notas sobre Renato Ramírez', 'Av. Central 333', 'Lima', 'Perú', '222333444', 'Personal');
CALL insertarContacto(1, 'Elena Díaz', 'elena@example.com', '1990-02-28', NULL, 'Notas sobre Elena Díaz', 'Jr. Occidente 444', 'Lima', 'Perú', '999000111', 'Trabajo');

CALL insertarContacto(2, 'Luis Ramírez', 'luis@example.com', '1988-08-30', NULL, 'Notas sobre Luis Ramírez', 'Jr. Independencia 789', 'Arequipa', 'Perú', '555666777', 'Personal');
CALL insertarContacto(2, 'Ana Martínez', 'ana.m@example.com', '1992-03-25', NULL, 'Notas sobre Ana Martínez', 'Calle Principal 321', 'Arequipa', 'Perú', '333444555', 'Trabajo');
CALL insertarContacto(2, 'Mario Rodríguez', 'mario@example.com', '1987-08-25', NULL, 'Notas sobre Mario Rodríguez', 'Jr. Primavera 789', 'Arequipa', 'Perú', '777888999', 'Personal');
CALL insertarContacto(2, 'Lucía Sánchez', 'lucia@example.com', '1987-06-05', NULL, 'Notas sobre Lucía Sánchez', 'Jr. Sur 890', 'Arequipa', 'Perú', '888999000', 'Trabajo');
CALL insertarContacto(2, 'Pedro González', 'pedro@example.com', '1995-12-10', NULL, 'Notas sobre Pedro González', 'Av. Norte 567', 'Arequipa', 'Perú', '111222333', 'Personal');
CALL insertarContacto(2, 'Laura López', 'laura.l@example.com', '1987-06-05', NULL, 'Notas sobre Laura López', 'Jr. Sur 890', 'Arequipa', 'Perú', '888999000', 'Trabajo');
CALL insertarContacto(2, 'Martín Torres', 'martin@example.com', '1980-09-12', NULL, 'Notas sobre Martín Torres', 'Av. Este 111', 'Arequipa', 'Perú', '666777888', 'Personal');
CALL insertarContacto(2, 'Carla Martínez', 'carla.m@example.com', '1975-04-18', NULL, 'Notas sobre Carla Martínez', 'Calle Oeste 222', 'Arequipa', 'Perú', '444555666', 'Trabajo');
CALL insertarContacto(2, 'Renato Rodríguez', 'renato.r@example.com', '1983-11-08', NULL, 'Notas sobre Renato Rodríguez', 'Av. Central 333', 'Arequipa', 'Perú', '222333444', 'Personal');
CALL insertarContacto(2, 'Elena Ramírez', 'elena.r@example.com', '1990-02-28', NULL, 'Notas sobre Elena Ramírez', 'Jr. Occidente 444', 'Arequipa', 'Perú', '999000111', 'Trabajo');
