-- crea la base de datos con el nombre “Personal’.
CREATE DATABASE	personal;
USE personal;

CREATE TABLE nacionalidad (
    idnacionalidad int PRIMARY KEY NOT NULL,
    pais varchar(45)
);

CREATE TABLE persona (
    idpersona int PRIMARY KEY NOT NULL,
    nombre varchar(45),
    apellido varchar(45),
    fechanac date,
    correo varchar(45),
    estatus varchar(45)
);

CREATE TABLE control (
    idcontrol int PRIMARY KEY NOT NULL,
    idpersona int NOT NULL,
    idnacionalidad int NOT NULL,
    fecha date,
    
    INDEX(idpersona),
    FOREIGN KEY (idpersona) REFERENCES persona(idpersona),
    INDEX(idnacionalidad),
    FOREIGN KEY (idnacionalidad) REFERENCES nacionalidad(idnacionalidad)
);

-- Para registrar los cambios
CREATE TABLE bitacora (
	id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idnacionalidad int NOT NULL,
    fecha datetime,
    usuario varchar(45)
);

-- Valores para probar despues el trigger.
INSERT INTO nacionalidad VALUES
    (1, 'Guatemala'),
    (2, 'Mexico'),
    (3, 'El Salvador'),
    (4, 'Belice'),
    (5, 'Honduras');

DELIMITER //
CREATE TRIGGER tg_registrar_eliminacion_nacionalidad
BEFORE DELETE ON nacionalidad
FOR EACH ROW 
BEGIN
	INSERT INTO bitacora (idnacionalidad, fecha, usuario)
    VALUES (old.idnacionalidad, NOW(), SESSION_USER());
END//
DELIMITER ;

DELETE FROM nacionalidad WHERE idnacionalidad = 5;
SELECT * FROM bitacora;

DROP DATABASE personal;

    
