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

-- Crea un procedimiento que permita realizar un INSERT en la tabla
-- nacionalidad, antes del insert inicie transac y después haga 
-- commit para registrar a disco los datos.

DELIMITER //
CREATE PROCEDURE insertar_nacionalidad(id int, pais varchar(45))
BEGIN
	START TRANSACTION;
    INSERT INTO nacionalidad VALUES (id, pais);
    COMMIT;
END //
DELIMITER ;

CALL insertar_nacionalidad(1, "Guatemalteco");
SELECT * FROM nacionalidad;

DROP DATABASE personal;

    
