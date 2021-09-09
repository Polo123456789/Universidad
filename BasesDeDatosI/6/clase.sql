-- DML (Data manipulation language)

/*
 * Este permite manipular los datos que se encuentran en la base de datos
 * 
 * Consta de las operaciones para:
 * 
 * * insertar
 * * actualizar
 * * eliminar
 * * consultar
 *
 * **Nota:** [] Indica que es opcional
 */

-- Consultar
SELECT campos, ... FROM tabla [WHERE condicion];

-- Insertar
INSERT INTO tabla [(campos,....)] VALUES (valores,...);

-- Actualizar
UPDATE tabla SET campo = valor, ... WHERE condicion;

-- Eliminar
DELETE FROM tabla WHERE condicion;

-- Consultas Avanzadas
-- ===================

-- Operaciones de union (JOIN)
-- ---------------------------

-- ### Combinaciones internas (INNER JOIN)
-- 
-- Retorna unicamente aquellos registros que tienen valores identicos en los 2
-- campos que se comparan para unir ambas tablas

SELECT campos, ... FROM tabla1 INNER JOIN tabla2 ON condicion de vinculo;

-- ### Combinaciones externas (OUTER JOIN)
--
-- Permite seleccionar los campos de una tabla aunque no tengan correspondencia
-- con los de la otra tabla

