-- Corra `crear-db.sql` para crear la base de datos
USE `db3_proyectoFinal`;

-- Crea una Bitácora (Tabla) en donde se registren las operaciones de todas las tablas
-- mediante Triggers.
CREATE TABLE bitacora (
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tabla varchar(30),
    operacion varchar(30),
    fecha datetime
);

--
-- Operaciones CRUD y triggers
--

