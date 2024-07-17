use db_agenda_contactos;

/*TRIGGERS*/

CREATE TRIGGER after_contacto_insert
AFTER INSERT ON contactos
FOR EACH ROW
BEGIN
    DECLARE num_contactos INT;

    SELECT COUNT(*) INTO num_contactos FROM reportes WHERE id_usuario = NEW.id_usuario;

    IF num_contactos > 0 THEN
        UPDATE reportes
        SET 
            num_total_contactos = num_total_contactos + 1,
            num_contactos_agregados = num_contactos_agregados + 1
        WHERE id_usuario = NEW.id_usuario;
    ELSE
        INSERT INTO reportes (id_usuario, num_total_contactos, num_contactos_agregados)
        VALUES (NEW.id_usuario, 1, 1);
    END IF;
END;



CREATE TRIGGER after_contacto_update
AFTER UPDATE ON contactos
FOR EACH ROW
BEGIN
    UPDATE reportes
    SET 
        num_contactos_editados = num_contactos_editados + 1
    WHERE id_usuario = NEW.id_usuario;
END;



CREATE TRIGGER after_contacto_delete
AFTER DELETE ON contactos
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT 1 FROM reportes WHERE id_usuario = OLD.id_usuario) THEN
        UPDATE reportes
        SET 
            num_total_contactos = num_total_contactos - 1,
            num_contactos_eliminados = num_contactos_eliminados + 1
        WHERE id_usuario = OLD.id_usuario;
    END IF;
END;
