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

DELIMITER //

-- Procedimientos para proveedor

CREATE PROCEDURE insertar_proveedor (p_id int, p_nombre varchar(45), p_telefono char(9), p_correo varchar(45))
BEGIN
    INSERT INTO proveedor (id, nombre, telefono, correo) VALUES (p_id, p_nombre, p_telefono, p_correo);
END//

CREATE PROCEDURE seleccionar_proveedor ()
BEGIN
    SELECT * FROM proveedor;
END//

CREATE PROCEDURE borrar_proveedor (p_id int)
BEGIN
    DELETE FROM proveedor WHERE id = p_id;
END//

CREATE PROCEDURE actualizar_proveedor (p_id int, p_nombre varchar(45), p_telefono char(9), p_correo varchar(45))
BEGIN
    UPDATE proveedor SET nombre = p_nombre, telefono = p_telefono, correo = p_correo WHERE id = p_id;
END//

-- Triggers para proveedor

CREATE TRIGGER t_proveedor_before_insert BEFORE INSERT ON proveedor
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("proveedor", "insert", CURDATE());
END//

CREATE TRIGGER t_proveedor_before_update BEFORE UPDATE ON proveedor
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("proveedor", "update", CURDATE());
END//

CREATE TRIGGER t_proveedor_before_delete BEFORE DELETE ON proveedor
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("proveedor", "delete", CURDATE());
END//

/*
Test:
CALL insertar_proveedor(1, "Pedro", "3245-9876", "pedro@mail.com")//
CALL actualizar_proveedor(1, "Pepe", "1122-3344", "n/a")//
CALL borrar_proveedor(1)//
CALL seleccionar_proveedor()//
SELECT * FROM bitacora//
*/

-- Procedimientos para producto

CREATE PROCEDURE insertar_producto (p_id int, p_nombre varchar(45), p_precio decimal(7,2), p_existencias int, p_proveedor_id int)
BEGIN
    INSERT INTO producto (id, nombre, precio, existencias, proveedor_id) VALUES (p_id, p_nombre, p_precio, p_existencias, p_proveedor_id);
END//

CREATE PROCEDURE seleccionar_producto ()
BEGIN
    SELECT * FROM producto;
END//

CREATE PROCEDURE borrar_producto (p_id int)
BEGIN
    DELETE FROM producto WHERE id = p_id;
END//

CREATE PROCEDURE actualizar_producto (p_id int, p_nombre varchar(45), p_precio decimal(7,2), p_existencias int, p_proveedor_id int)
BEGIN
    UPDATE producto SET nombre = p_nombre, precio = p_precio, existencias = p_existencias, proveedor_id = p_proveedor_id WHERE id = p_id;
END//

-- Triggers para producto

CREATE TRIGGER t_producto_before_insert BEFORE INSERT ON producto
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("producto", "insert", CURDATE());
END//

CREATE TRIGGER t_producto_before_update BEFORE UPDATE ON producto
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("producto", "update", CURDATE());
END//

CREATE TRIGGER t_producto_before_delete BEFORE DELETE ON producto
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("producto", "delete", CURDATE());
END//

-- Procedimientos para venta_tiene_producto

CREATE PROCEDURE insertar_venta_tiene_producto (p_id int, p_producto_id int, p_venta_id int, p_cantidad int)
BEGIN
    INSERT INTO venta_tiene_producto (id, producto_id, venta_id, cantidad) VALUES (p_id, p_producto_id, p_venta_id, p_cantidad);
END//

CREATE PROCEDURE seleccionar_venta_tiene_producto ()
BEGIN
    SELECT * FROM venta_tiene_producto;
END//

CREATE PROCEDURE borrar_venta_tiene_producto (p_id int)
BEGIN
    DELETE FROM venta_tiene_producto WHERE id = p_id;
END//

CREATE PROCEDURE actualizar_venta_tiene_producto (p_id int, p_producto_id int, p_venta_id int, p_cantidad int)
BEGIN
    UPDATE venta_tiene_producto SET producto_id = p_producto_id, venta_id = p_venta_id, cantidad = p_cantidad WHERE id = p_id;
END//

-- Triggers para venta_tiene_producto

CREATE TRIGGER t_venta_tiene_producto_before_insert BEFORE INSERT ON venta_tiene_producto
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("venta_tiene_producto", "insert", CURDATE());
END//

CREATE TRIGGER t_venta_tiene_producto_before_update BEFORE UPDATE ON venta_tiene_producto
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("venta_tiene_producto", "update", CURDATE());
END//

CREATE TRIGGER t_venta_tiene_producto_before_delete BEFORE DELETE ON venta_tiene_producto
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("venta_tiene_producto", "delete", CURDATE());
END//

-- Procedimientos para venta

CREATE PROCEDURE insertar_venta (p_id int, p_fecha date, p_cliente_id int, p_total decimal(7,2))
BEGIN
    INSERT INTO venta (id, fecha, cliente_id, total) VALUES (p_id, p_fecha, p_cliente_id, p_total);
END//

CREATE PROCEDURE seleccionar_venta ()
BEGIN
    SELECT * FROM venta;
END//

CREATE PROCEDURE borrar_venta (p_id int)
BEGIN
    DELETE FROM venta WHERE id = p_id;
END//

CREATE PROCEDURE actualizar_venta (p_id int, p_fecha date, p_cliente_id int, p_total decimal(7,2))
BEGIN
    UPDATE venta SET fecha = p_fecha, cliente_id = p_cliente_id, total = p_total WHERE id = p_id;
END//

-- Triggers para venta

CREATE TRIGGER t_venta_before_insert BEFORE INSERT ON venta
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("venta", "insert", CURDATE());
END//

CREATE TRIGGER t_venta_before_update BEFORE UPDATE ON venta
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("venta", "update", CURDATE());
END//

CREATE TRIGGER t_venta_before_delete BEFORE DELETE ON venta
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("venta", "delete", CURDATE());
END//

-- Procedimientos para cliente

CREATE PROCEDURE insertar_cliente (p_id int, p_nombre varchar(45), p_nit char(13), p_telefono char(9), p_correo varchar(45))
BEGIN
    INSERT INTO cliente (id, nombre, nit, telefono, correo) VALUES (p_id, p_nombre, p_nit, p_telefono, p_correo);
END//

CREATE PROCEDURE seleccionar_cliente ()
BEGIN
    SELECT * FROM cliente;
END//

CREATE PROCEDURE borrar_cliente (p_id int)
BEGIN
    DELETE FROM cliente WHERE id = p_id;
END//

CREATE PROCEDURE actualizar_cliente (p_id int, p_nombre varchar(45), p_nit char(13), p_telefono char(9), p_correo varchar(45))
BEGIN
    UPDATE cliente SET nombre = p_nombre, nit = p_nit, telefono = p_telefono, correo = p_correo WHERE id = p_id;
END//

-- Triggers para cliente

CREATE TRIGGER t_cliente_before_insert BEFORE INSERT ON cliente
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("cliente", "insert", CURDATE());
END//

CREATE TRIGGER t_cliente_before_update BEFORE UPDATE ON cliente
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("cliente", "update", CURDATE());
END//

CREATE TRIGGER t_cliente_before_delete BEFORE DELETE ON cliente
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("cliente", "delete", CURDATE());
END//

-- Agregue un evento que haga el cierre y guarde el total de ganancias 
-- (únicamente) de las ventas en una tabla llamada Ganancias (idGanancia, fechaHora, ganancia)

CREATE TABLE ganancias (
	idGanancia int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fechaHora datetime,
    ganancia decimal(7, 2)
)//

CREATE EVENT registrar_ganancias
ON SCHEDULE EVERY 1 DAY
STARTS "2022-3-30 20:00:00" -- Asumiendo que cierran a las 8:00 PM
DO 
BEGIN
	-- No hace falta calcular los totales ya que hay triggers que los van creando
    -- conforme se añanden productos a la venta (Los triggers estan en `crear-db.sql`)
	INSERT INTO ganancias (fechaHora, ganancia) VALUES (NOW(), (SELECT SUM(total) FROM venta WHERE fecha = CURDATE()));
END//

DELIMITER ;



-- Clean up
DROP DATABASE `db3_proyectoFinal`;