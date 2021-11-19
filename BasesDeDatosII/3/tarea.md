---
title: "Actividad 3"
date: "14/11/21"
author: "Pablo Sanchez (Carnet: 21001135)"
---

```sql
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
   
-- 
-- Crea  los siguientes índices:
-- 

-- Un índice del tipo unique sobre la llave primaria idpersona de la tabla
-- persona.
CREATE UNIQUE INDEX	index_idpersona ON persona (idpersona);

-- Un índice del tipo unique sobre el campo correo en la tabla persona.
CREATE UNIQUE INDEX index_correo ON persona (correo);

-- Un índice sobre el campo apellido de la tabla persona.
CREATE INDEX index_apellido ON persona (apellido);

-- Un índice del tipo unique sobre la llave primaria idnacionalidad de la tabla
-- nacionalidad.
CREATE INDEX index_idnacionalidad ON nacionalidad (idnacionalidad);

--
-- Crea las siguientes funciones
--

-- Funcion de utilidad para los siguientes ejercicios:
DELIMITER //
CREATE FUNCTION calcular_porcentaje(valor int, porcentaje float) RETURNS float
DETERMINISTIC -- Dadas las mismas entradas, siempre da los mismos resultados
              -- Me lo pide para poder crear la funcion
BEGIN
	RETURN valor * porcentaje;
END//
DELIMITER ;

-- Una función que calcule un descuento del 10% sobre el salario de un empleado.
DELIMITER //
CREATE FUNCTION calcular_descuento(salario int) RETURNS float
DETERMINISTIC
BEGIN
	RETURN calcular_porcentaje(salario, 0.1);
END//
DELIMITER ;

-- Una función que calcule el IGSS (4.83%) sobre el salario de un empleado.
DELIMITER //
CREATE FUNCTION calcular_igss(salario int) RETURNS float
DETERMINISTIC
BEGIN
	RETURN calcular_porcentaje(valor, 0.0483);
END//
DELIMITER ;

-- Una función que calcule el seguro del empleado del 15% sobre el salario.
DELIMITER //
CREATE FUNCTION calcular_seguro(salario int) RETURNS float
DETERMINISTIC
BEGIN
	RETURN calcular_porcentaje(valor, 0.15);
END//
DELIMITER ;

-- Cleanup
DROP FUNCTION calcular_porcentaje;
DROP FUNCTION calcular_descuento;
DROP FUNCTION calcular_igss;
DROP FUNCTION calcular_seguro;
DROP DATABASE personal;
```
