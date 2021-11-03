-- Las subconsultas son un SELECT dentro de un SELECT, usan las palabras
-- clave ALL, ANY, IN
-- SELECT campos FROM tabla WHERE campo <operadores> (Otro SELECT)

-- Usaremos el dump de clase de la unidad 1 para estos ejemplos.

USE colegio;

-- El profesor nos dio estos querys primero

insert into estudiantes values (2017001,'Juan','Velasquez','jvelasquez@gmail.com','Activo');
insert into estudiantes values (2017002,'Julio','Quezada','jquez@gmail.com','Activo');

DELETE FROM asigna WHERE idasigna = 101;
DELETE FROM asigna WHERE idasigna = 102;

insert into asigna values(101,2017001,2002,'2020-01-20');
insert into asigna values(102,2017002,2002,'2020-01-21');

-- 1. Mostrar por medio de una subconsulta los estudiantes que tengan cursos asignados

SELECT carnet, nombres, apellidos FROM estudiantes
	WHERE carnet IN (SELECT carnet FROM asigna);
    
-- 2. Mostrar por medio de una subconsulta los estudiantes que tienen cursos asignados 
--    del año 2020.

SELECT carnet, nombres, apellidos FROM estudiantes
	WHERE carnet IN (SELECT carnet FROM asigna WHERE YEAR(fecha)=2020);
    
-- Ejemplo con aliases

SELECT est.carnet, est.nombres, est.apellidos FROM estudiantes est
	WHERE est.carnet IN (SELECT asig.carnet FROM asigna asig
		WHERE YEAR(asig.fecha)=2020);
        
-- Mostar cursos con un precio menor a la media

SELECT nombre, precio FROM cursos WHERE precio < (SELECT AVG(precio) FROM cursos);

SELECT nombre, precio from cursos
	WHERE precio < (SELECT MAX(precio) FROM cursos WHERE nombre LIKE "Negocios%");

