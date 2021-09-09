/*

Hay una seccion al fondo con el codigo de la actividad 6. Al principio dejo el
codigo de la actividad 5 para que se le haga mas facil probarlo.

*/

CREATE DATABASE actividad5;
USE actividad5;

CREATE TABLE marcas (
    id_marca int PRIMARY KEY NOT NULL,
    nombre varchar(30) NOT NULL
);

CREATE TABLE proveedores (
    id_proveedor int PRIMARY KEY NOT NULL,
    nombre varchar(30) NOT NULL
);

CREATE TABLE departamentos (
    id_departamento int PRIMARY KEY NOT NULL,
    nombre varchar(30) NOT NULL
);

-- Y ahora las entidades debiles

CREATE TABLE empleados (
    id_empleado int PRIMARY KEY NOT NULL,
    nombre varchar(30) NOT NULL,
    id_departamento int NOT NULL,
    
    INDEX(id_departamento),
    FOREIGN KEY(id_departamento) REFERENCES departamentos(id_departamento)
);

CREATE TABLE cañoneras (
    id_cañonera int PRIMARY KEY NOT NULL,
    fecha_ingreso date NOT NULL,
    
    id_marca int NOT NULL,
    INDEX(id_marca),
    FOREIGN KEY(id_marca) REFERENCES marcas(id_marca),
    
    modelo varchar(30) NOT NULL,
    no_serie int NOT NULL,
    fecha_compra date NOT NULL,
    años_garantia int NOT NULL,
    no_factura int NOT NULL,
    
    id_proveedor int NOT NULL,
    INDEX(id_proveedor),
    FOREIGN KEY(id_proveedor) REFERENCES proveedores(id_proveedor),
    
    persona_contacto varchar(30) NOT NULL,
    telefono char(9) NOT NULL,
    fecha_vencimiento_garantia date NOT NULL
);

CREATE TABLE prestamos (
    id_prestamo int PRIMARY KEY NOT NULL,
    
    id_cañonera int NOT NULL,
    INDEX(id_cañonera),
    FOREIGN KEY (id_cañonera) REFERENCES cañoneras(id_cañonera),
    
    id_empleado int NOT NULL,
    INDEX(id_empleado),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado),
    
    fecha_entrega date NOT NULL,
    hora_entrega time NOT NULL,
    
    fecha_devolucion date NOT NULL,
    hora_devolucion time NOT NULL
);

-- ------------------- --
--     Actividad 6     --
-- ------------------- --

-- Ejemplos de `INSERT`
INSERT INTO departamentos VALUES (1, 'Contabilidad'); 
INSERT INTO departamentos VALUES(2, 'Electronica');
INSERT INTO empleados VALUES (1, 'Carlos Perez', 1);

/* Un par extras para tener cuando toque el delete */
INSERT INTO empleados VALUES (2, 'Andres Martinez', 2);
INSERT INTO empleados VALUES (3, 'Carlos Morazan', 2);


-- Ejemplos de `UPDATE`
UPDATE empleados SET nombre = 'Andres Martines' WHERE id_empleado = 2;
UPDATE empleados SET nombre = 'Carlos Moratan' WHERE id_empleado = 3;
UPDATE departamentos SET nombre = 'Ingenieria Electronica' WHERE id_departamento = 2;


-- Ejemplos de `DELETE`
DELETE FROM empleados WHERE id_empleado = 2;
DELETE FROM empleados WHERE id_empleado = 3;
DELETE FROM departamentos WHERE id_departamento = 2;


-- Ejemplos de `SELECT`
SELECT * FROM departamentos;
SELECT nombre AS identificacion FROM departamentos;
SELECT id_empleado AS id, nombre, id_departamento AS "Numero de departamento" FROM empleados;


-- Ejemplos de `LEFT JOIN`
SELECT * FROM empleados 
	LEFT OUTER JOIN departamentos ON empleados.id_departamento = departamentos.id_departamento;
SELECT empleados.nombre AS Nombre, departamentos.nombre AS Departamento FROM empleados 
	LEFT OUTER JOIN departamentos ON empleados.id_departamento = departamentos.id_departamento;
SELECT * FROM departamentos
	LEFT OUTER JOIN empleados ON departamentos.id_departamento = empleados.id_departamento;
    
    
-- Ejemplos de `RIGHT JOIN`
SELECT * FROM empleados
	RIGHT OUTER JOIN departamentos ON empleados.id_departamento = departamentos.id_departamento;
SELECT empleados.nombre AS Nombre, departamentos.nombre AS Departamento FROM empleados 
	RIGHT OUTER JOIN departamentos ON empleados.id_departamento = departamentos.id_departamento;
SELECT * FROM departamentos
	RIGHT OUTER JOIN empleados ON departamentos.id_departamento = empleados.id_departamento;
    
    
-- Ejemplos de `INNER JOIN`
SELECT * FROM empleados
	INNER JOIN departamentos ON empleados.id_departamento = departamentos.id_departamento;
SELECT empleados.nombre AS Nombre, departamentos.nombre AS Departamento FROM empleados 
	INNER JOIN departamentos ON empleados.id_departamento = departamentos.id_departamento;
SELECT * FROM departamentos
	INNER JOIN empleados ON departamentos.id_departamento = empleados.id_departamento;
