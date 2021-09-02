-- Comentario

/*
 * Comentario multilinea
 */

-- Para crear una base de datos
CREATE DABATABSE <nombre>

-- Para indicar en que base vamos a trabajar
USE <nombre>

/*
 * Para crear una tabla.
 * 
 * **Nota:** Es mejor empezar con las entidades fuertes, las que no tienen
 * llaves foraneas.
 */
CREATE TABLE <nombre> (
    <campo> <tipo> <propiedades...>,
    <campo2> <tipo> <propiedades...>,
    ...
);

-- Por ejemplo

CREATE TABLE cliente (
    cod_cliente INT NOT NULL PRIMARY KEY,
    nombre CHAR(25),
    direccion CHAR(50),
    telefono CHAR(15)
);


-- Llaves foraneas
CREATE TABLE <nombre> (
    ...,

    -- Creas el campo normalmente
    <campo> <tipo> <propiedades...>,

    -- Y indexas con ese campo
    index(<campo>),

    -- E indicas la relacion
    foreign key(<campo>) references <tabla donde viene>(<campo al que referencia>),

    ...

);

-- Llave primaria compuesta
CREATE TABLE <nombre> (
    -- Creas los campos normalmente
    <campo> <tipo> <propiedades...>,
    <campo2> <tipo> <propiedades...>,
    ...,

    -- Y usas primary key
    PRIMARY KEY(<campo>, <campo2>)
);

-- Ejemplo
CREATE TABLE detalle_pedido (
    num_pedido int NOT NULL,
    cod_producto int NOT NULL,

    PRIMARY KEY(num_pedido, cod_producto),

    INDEX(num_pedido),
    FOREIGN KEY(num_pedido) REFERENCES pedidos(num_pedido),
    INDEX(cod_producto),
    FOREIGN KEY(cod_producto) REFERENCES productos(cod_producto),

    cantidad int NOT NULL
);

-- Para obtener el schema de una tabla
DESCRIBE <tabla>

-- Para ver las tablas
SHOW TABLES

-- Para añadir campos a una tabla
ALTER TABLE empleado ADD sexo char(1);
ALTER TABLE empleado ADD sueldo dec(8, 2);

-- Para modificar campos
ALTER TABLE productos MODIFY precio dec(8, 2);

-- Para obtener todos los valores de la tabla
SELECT * FROM cliente;

-- Para agregar datos a la tabla
INSERT INTO cliente
    VALUES (2030, 'Omar', '7c. 22-34', '2343523'),
           (2310, 'Carlos', '11b. 45-23', '344564');

-- Para actualizar valores en una tabla
UPDATE <nombre> SET <campo> = <valor> WHERE <condicion>;

-- Ejemplo
UPDATE cliente SET telefono = '23435642' WHERE cod_cliente = 1;

-- Para borrar registros
DELETE FROM <tabla> WHERE <condicion>;
