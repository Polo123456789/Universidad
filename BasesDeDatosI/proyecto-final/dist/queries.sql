/*
--------------------------
Script de la base de datos
--------------------------
*/
CREATE DATABASE proyecto_final;
USE proyecto_final;

-- Entitades fuertes

CREATE TABLE producto (
    codigo int PRIMARY KEY NOT NULL,
    categoria int,
    descripcion varchar(45),
    precio_unitario decimal(8, 2),
    precio_docena decimal(8, 2),
    precio_mayor decimal(8, 2),
    existencia int,
    tipo_empaque int
);

CREATE TABLE cliente (
    dpi int PRIMARY KEY NOT NULL,
    nit char(13),
    nombre varchar(45),
    direccion varchar(45),
    telefono char(9),
    email varchar(45)
);

CREATE TABLE proveedor (
    codigo int PRIMARY KEY NOT NULL,
    nit char(13),
    razon_social varchar(45),
    direccion varchar(45),
    telefono char(9),
    pagina_web varchar(45),
    correo_electronico varchar(45),
    contacto_principal varchar(45)
);

-- Entidades debiles

CREATE TABLE factura (
    no_factura int PRIMARY KEY NOT NULL,
    fecha date,
    descripcion varchar(45),
    precio decimal(8,2),
    cantidad int,
    total decimal(8,2),
    cliente_dpi int,
    producto_codigo int,

    INDEX(cliente_dpi),
    FOREIGN KEY(cliente_dpi) REFERENCES cliente(dpi),
    INDEX(producto_codigo),
    FOREIGN KEY(producto_codigo) REFERENCES producto(codigo)
);

CREATE TABLE compra (
    no_docuemto int PRIMARY KEY NOT NULL,
    fecha date,
    cantidad int,
    precio decimal(8,2),
    total decimal (8,2),
    producto_codigo int,
    proveedor_codigo int,
    
    INDEX(producto_codigo),
    FOREIGN KEY(producto_codigo) REFERENCES producto(codigo),
    INDEX(proveedor_codigo),
    FOREIGN KEY(proveedor_codigo) REFERENCES proveedor(codigo)
);

CREATE TABLE inventario (
    id int PRIMARY KEY NOT NULL,
    tipo_registro char(1),
    fecha date,
    precio decimal(8,2),
    entradas int,
    salidas int,
    producto_codigo int,
    
    INDEX(producto_codigo),
    FOREIGN KEY(producto_codigo) REFERENCES producto(codigo)
);

/*
---------------------------------------------------------------------------------------------
Realizar por lo menos un ejemplo de cada una de las sentencias de SQL utilizadas en el curso.
---------------------------------------------------------------------------------------------
*/
SET @categoria_alimento = 1;
SET @empaque_plastico = 3;

-- Ejemplos de insert
-- ==================

--  (Son bastantes para poder usar los datos mas adelante)

INSERT INTO producto VALUES (
    1,
    @categoria_alimento,
    'Manzna', -- Mal escrito para corregirlo en el ejemplo de update
    5.50,
    60.0,
    5.25,
    10,
    @empaque_plastico
);

INSERT INTO producto VALUES (
    2,
    @categoria_alimento,
    'Banana',
    4.00,
    40.00,
    3.75,
    30,
    @empaque_plastico
);

INSERT INTO producto VALUES (
    3,
    @categoria_alimento,
    'Zanahoria',
    5.00,
    55.00,
    4.50,
    30,
    @empaque_plastico
);

INSERT INTO producto VALUES (
    4,
    @categoria_alimento,
    'Fresa',
    3.00,
    30.00,
    2.75,
    50,
    @empaque_plastico
);

INSERT INTO producto VALUES (
    5,
    @categoria_alimento,
    'Pera',
    5.00,
    57.50,
    4.25,
    30,
    @empaque_plastico
);

INSERT INTO proveedor VALUES (
    1,
    '1953422-k',
    'Bananero S.A',
    '12-32 Zona 15',
    '2334-0987',
    'bananero.com.gt',
    'elbananero@gmail.com',
    'Carlos Martinez'
);

INSERT INTO proveedor VALUES (
    2,
    '1854451-k',
    'Verdureria Cristina',
    '34-00 zona 1',
    '5674-9438',
    'cristinaverduras.com',
    'cristinaverduras@gmail.com',
    'Cristina Perez'
);

SET @hoy = CURDATE();

-- Compra de Manzanas
INSERT INTO compra VALUES (
    1,
    @hoy,
    10,
    4.00,
    40.00,
    1,
    2
);

-- Compra de bananas
INSERT INTO compra VALUES (
    2,
    @hoy,
    30,
    3.50,
    105.0,
    2,
    1
);

-- Compra de zanahorias
INSERT INTO compra VALUES (
    3,
    @hoy,
    30,
    4.50,
    135.0,
    3,
    2
);

-- Compra de fresas
INSERT INTO compra VALUES (
    4,
    @hoy,
    50,
    2.25,
    112.5,
    4,
    2
);

-- Compra de peras
INSERT INTO compra VALUES (
    5,
    @hoy,
    30,
    4.25,
    127.5,
    5,
    2
);

-- Y este es para despues tener un ejemplo de eliminar
INSERT INTO producto VALUES (6, null, null, null, null, null, null, null);

-- Ejemplo de Update
-- =================

UPDATE producto SET descripcion = 'Manzana' WHERE codigo = 1;

-- Ejemplo de Delete
-- =================

DELETE FROM producto WHERE codigo = 6;

-- Ejemplo de Select
-- =================

SELECT * FROM compra WHERE proveedor_codigo = 2; -- Compras a Cristina

-- Ejemplo de Join
-- ===============
SELECT *
FROM producto INNER JOIN proveedor ON  proveedor.codigo IN 
	(SELECT proveedor_codigo FROM compra WHERE producto_codigo = producto.codigo)
ORDER BY proveedor.razon_social, producto.descripcion;

/*
----------------------------------------------------------------------
Despliegue los cinco productos más costosos, en orden descendente, del 
más costoso hasta la menos costoso, la cantidad en existencia de cada
uno y el tipo de empaque.
----------------------------------------------------------------------
*/

SELECT descripcion, precio_unitario, existencia, tipo_empaque
	FROM producto ORDER BY precio_unitario DESC LIMIT 5;
    
/*
------------------------------------------------------------------------
Despliegue una lista de cada proveedor, sus productos, las cantidades en
existencia y los niveles de reabastecimiento asociados; se debe ordenar
en forma alfabética por proveedor; dentro de cada categoría de proveedor
hay que colocar los productos en orden alfabético.
------------------------------------------------------------------------
*/

SELECT proveedor.razon_social AS Proveedor, 
    producto.descripcion AS Producto, 
    producto.existencia AS Existencia
FROM producto INNER JOIN proveedor ON  proveedor.codigo IN 
    (SELECT proveedor_codigo FROM compra WHERE producto_codigo = producto.codigo)
ORDER BY proveedor.razon_social, producto.descripcion;

/*
----------------------------------------------------------------------------
Despliegue una lista de los productos que tengan un nivel bajo de existencia
 y necesiten reabastecerse. La consulta debe proveer información a los
 proveedores para los productos identificados.
----------------------------------------------------------------------------
*/

-- Consideramos que las existencias son bajas si hay menos de 20 productos

SELECT producto.descripcion AS Producto, 
    producto.existencia AS Existencia,
    proveedor.razon_social AS Proveedor,
    proveedor.telefono AS Telefono,
    proveedor.contacto_principal AS "Preguntar por"
FROM producto INNER JOIN proveedor ON  proveedor.codigo IN 
    (SELECT proveedor_codigo FROM compra WHERE producto_codigo = producto.codigo) 
WHERE producto.existencia < 20;
