-- Ejecute: `create-db.sql` antes de este script
USE `db3-actividad2`;

DELIMITER //

CREATE PROCEDURE insertarProveedor(id int, nombre varchar(255), telefono varchar(12))
BEGIN
    INSERT INTO Proveedor VALUES (id, nombre, telefono);
END//

CREATE PROCEDURE modificarProveedor(i int, n varchar(255), t varchar(12))
BEGIN
    UPDATE Proveedor SET nombre = n, telefono = t WHERE idProveedor = i;
END//

CREATE PROCEDURE eliminarProveedor(i int)
BEGIN
    DELETE FROM Proveedor WHERE idProveedor = i;
END//

-- CALL insertarProveedor(1, "nombre", "1122-3344")//
/**
 * CALL modificarProveedor(1, "Otro nombre", "4455-6677")//
 * CALL eliminarProveedor(1)//
 * SELECT * FROM Proveedor//
 */
 
CREATE PROCEDURE insertarMarca(id int, nombre varchar(255), idProveedor int)
BEGIN
    INSERT INTO Marca VALUES (id, nombre, idProveedor);
END//

CREATE PROCEDURE modificarMarca(id int, n varchar(255), idP int)
BEGIN
    UPDATE Marca SET nombre = n, idProveedor = idP WHERE idMarca = id;
END//

CREATE PROCEDURE eliminarMarca(id int)
BEGIN
    DELETE FROM Marca WHERE idMarca = id;
END//

-- CALL insertarMarca(1, "Marca", 1)//
/**
 * CALL modificarMarca(1, "Nueva marca", 1)//
 * CALL eliminarMarca(1)//
 * SELECT * FROM Marca//
 */

CREATE PROCEDURE insertarProducto(id int, nombre varchar(255), precio decimal(7, 2), idMarca int)
BEGIN
    INSERT INTO Producto VALUES (id, nombre, precio, idMarca);
END//

CREATE PROCEDURE modificarProducto(id int, n varchar(255), p decimal(7, 2), idM int)
BEGIN
    UPDATE Producto SET nombre = n, precio = p, idMarca = idM WHERE idProducto = id;
END//

CREATE PROCEDURE eliminarProducto(id int)
BEGIN
    DELETE FROM Producto WHERE idProducto = id;
END//

-- CALL insertarProducto(1, "Producto", 10.00, 1)//
/**
 * CALL modificarProducto(1, "Nuevo producto", 20.00, 1)//
 * CALL eliminarProducto(1)//
 * SELECT * FROM Producto//
 */

CREATE PROCEDURE insertarCliente(id int, nit varchar(45), nombre varchar(255), direccion varchar(255))
BEGIN
    INSERT INTO Cliente VALUES (id, nit, nombre, direccion);
END//

CREATE PROCEDURE modificarCliente(id int, ni varchar(45), nom varchar(255), di varchar(255))
BEGIN
   UPDATE Cliente SET nit = ni, nombre = nom, direccion = di WHERE idCliente = id;
END//

CREATE PROCEDURE eliminarCliente(id int)
BEGIN
    DELETE FROM Cliente WHERE idCliente = id;
END//

-- CALL insertarCliente(1, "5467923-k", "Pepe", "1ra Ave C, Mesquital")//
/**
 * CALL modificarCliente(1, "5463223-k", "Carlos", "1ra Ave B, Bosques")//
 * CALL eliminarCliente(1)//
 * SELECT * FROM Cliente//
 */

CREATE PROCEDURE insertarFactura(id int, fecha date, idCliente int)
BEGIN
    INSERT INTO Factura VALUES (id, fecha, idCliente);
END//

CREATE PROCEDURE modificarFactura(id int, f date, idC int)
BEGIN
    UPDATE Factura SET fecha = f, idCliente = idC WHERE idFactura = id;
END//

CREATE PROCEDURE eliminarFactura(id int)
BEGIN
	DELETE FROM Factura WHERE idFactura = id;
END//

-- CALL insertarFactura(1, CURDATE(), 1)//
/**
 * CALL modificarFactura(1, DATE_SUB(CURDATE(), INTERVAL 1 DAY), 1)//
 * CALL eliminarFactura(1)//
 * SELECT * FROM Factura//
 */

CREATE PROCEDURE insertarDetalleFactura(id int, idF int, idP int)
BEGIN
    INSERT INTO DetalleFactura VALUES (id, idF, idP);
END//

CREATE PROCEDURE modificarDetalleFactura(id int, idF int, idP int)
BEGIN
	UPDATE DetalleFactura SET idFactura = idF, idProducto = idP WHERE idDetalleFactura = id;
END//

CREATE PROCEDURE eliminarDetalleFactura(id int)
BEGIN
    DELETE FROM DetalleFactura WHERE idDetalleFactura = id;
END//

-- CALL insertarDetalleFactura(1, 1, 1)//
/**
 * CALL eliminarDetalleFactura(1)//
 * SELECT * FROM DetalleFactura//
 */
 
CREATE TRIGGER validarPrecioProducto
BEFORE INSERT ON Producto
FOR EACH ROW
BEGIN
    IF NEW.precio <= 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El precio tiene que ser mayor que 0';
    END IF;
END//

-- Este tiene que fallar:
-- CALL insertarProducto(2, "Producto con precio incorrecto", -10.00, 1)//

DELIMITER ;

DROP DATABASE `db3-actividad2`;
