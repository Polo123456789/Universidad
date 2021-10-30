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
    correo varchar(45)
);

CREATE TABLE control (
    idcontrol int PRIMARY KEY NOT NULL,
    idpersona int NOT NULL,
    idnacionalidad int NOT NULL,
    fecha DATE,
    
    INDEX(idpersona),
    FOREIGN KEY (idpersona) REFERENCES persona(idpersona),
    INDEX(idnacionalidad),
    FOREIGN KEY (idnacionalidad) REFERENCES nacionalidad(idnacionalidad)
);

-- Ingrese 5 registros en cada una de las tablas.

INSERT INTO nacionalidad VALUES
    (1, 'Guatemala'),
    (2, 'Mexico'),
    (3, 'El Salvador'),
    (4, 'Belice'),
    (5, 'Honduras');
    
INSERT INTO persona VALUES
    (1, 'Pablo', 'Sanchez', 'PabloSanchez@gmail.com'),
    (2, 'Marcos', 'Sanchez', 'MarcosSanchez@gmail.com'),
    (3, 'Pedro', 'Perez', 'PedroPerez@gmail.com'),
    (4, 'Juan', 'Martinez', 'JuanMartinez@gmail.com'),
    (5, 'Carlos', 'Perez', 'CarlosPerez@gmail.com');

INSERT INTO control VALUES
    (1, 1, 1, CURDATE()),
    (2, 2, 2, CURDATE()),
    (3, 3, 3, CURDATE()),
    (4, 4, 4, CURDATE()),
    (5, 5, 5, CURDATE());
    
-- Cree un usuario llamado ‘sam’ con los siguientes privilegios:
-- 	* Acceso únicamente para consultar (personal.*) las tablas de la base de datos “Personal”.
-- 	* El acceso únicamente debe ser local (localhost).

CREATE USER 'sam'@'localhost' IDENTIFIED BY 'galileo';
GRANT SELECT ON personal.* TO 'sam'@'localhost';

-- Cree un usuario llamado ‘Andy’ con los siguientes privilegios:
-- 	* Que pueda ejecutar: select, insert, update, delete, create, alter (personal.*)
-- 	* El acceso es permitido desde cualquier computadora.

CREATE USER 'Andy'@'%' IDENTIFIED BY 'galileo';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER ON personal.* TO 'Andy'@'%';

-- Limpieza

DROP USER 'sam'@'localhost';
DROP USER 'Andy'@'%';
DROP DATABASE personal;

    
