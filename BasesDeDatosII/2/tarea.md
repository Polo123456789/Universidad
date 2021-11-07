---
title: "Tarea 2"
date: "07/11/21"
author: "Pablo Sanchez (Carnet: 21001135)"
---

```sql
-- Script de la tarea 1, las consultas de esta tarea estan mas abajo

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
    (4, 4, 4, CURDATE()); -- Borre el 5 para tener que mostrar
                          -- en la consulta que va sin nacinalidad

-- Muestre el nombre de las personas que _no_ tienen asignada una nacionalidad.
SELECT nombre FROM persona
    WHERE idpersona NOT IN (SELECT idpersona FROM control);

-- Muestre el nombre de las personas que _ tienen_ asignada una nacionalidad.
SELECT nombre FROM persona WHERE idpersona IN (SELECT idpersona FROM control);

-- Mostrar nombre, apellido de la tabla persona y pais
-- de nacionalidad(INNER JOIN). 
SELECT persona.nombre, persona.apellido, nacionalidad.pais
    FROM persona INNER JOIN nacionalidad
        WHERE nacionalidad.idnacionalidad = 
            (SELECT idnacionalidad FROM control
                WHERE idpersona = persona.idpersona);

-- Mostrar nombre, apellido y correo.
SELECT nombre, apellido, correo FROM persona;

DROP DATABASE personal;
```
