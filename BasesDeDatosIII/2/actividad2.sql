-- Ejecute: `create-db.sql` antes de este script
USE `db3-actividad2`;

/*
 * El alumno debe insertar los datos de información para poder hacer las pruebas.
 */
INSERT INTO Proveedor VALUES (1, "Proveedor S.A", "8888-8888");
INSERT INTO Marca VALUES (1, "Marca Registrada", 1);
INSERT INTO Cliente VALUES (
    1,
    "2244555-k",
    "Cliente Anonimo",
    "11-22 3ra Avenida C, Zona 4, Guatemala Guatemala"
);

INSERT INTO Producto VALUES
    (1, "Producto 1", 10.00, 1),
    (2, "Prodcuto 2", 30.50, 1),
    (3, "Producto 3", 5.00, 1),
    (4, "Producto 4", 100.00, 1);

INSERT INTO Factura VALUES
    (1, CURDATE(), 1),
    (2, CURDATE(), 1);
    
INSERT INTO DetalleFactura VALUES
    (1, 1, 1),
    (2, 1, 2),
    (3, 2, 3),
    (4, 2, 4);
    
-- Tabla para guardar los resultados de los calculos.
CREATE TABLE ResultadosCalculos (
    idCalculo int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ganancias decimal(7, 2),
    cantidadArticulosVendidos int,
    iva decimal(7, 2),
    tipoCalculo varchar(30)
);

--
-- Funciones utilitarias
--
DELIMITER //

-- Calcula las ganancias de una factura usando su id
CREATE FUNCTION calcularGananciasDeFactura (idDeFactura int)
RETURNS decimal(7, 2)
NOT DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE total decimal(7, 2);
    SELECT SUM(precio) INTO total FROM Producto
        WHERE idProducto IN (SELECT idProducto FROM DetalleFactura WHERE idFactura=idDeFactura);
    RETURN total;
END //

-- Calcula las ganancias de todas las facturas cuya `fecha` sea mayor a `inicio`,
-- y menor o igual a `final`
CREATE FUNCTION calcularGananciaEnRango (inicio date, final date)
RETURNS decimal(7, 2)
NOT DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE total decimal(7, 2);
    SELECT SUM(calcularGananciasDeFactura(idFactura)) INTO total FROM Factura WHERE fecha > inicio AND fecha <= final;
    RETURN total;
END //

-- Calcula la cantidad de productos de una factura usando su id
CREATE FUNCTION calcularCantidadDeFactura (idDeFactura int)
RETURNS int
NOT DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE total int;
    SELECT COUNT(*) INTO total FROM Producto
        WHERE idProducto IN (SELECT idProducto FROM DetalleFactura WHERE idFactura=idDeFactura);
    RETURN total;
END //

-- Calcula la cantidad de productos de todas las facturas cuya `fecha` sea mayor a `inicio`,
-- y menor o igual a `final`
CREATE FUNCTION calcularCantidadEnRango (inicio date, final date)
RETURNS int
NOT DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE total int;
    SELECT SUM(calcularCantidadDeFactura(idFactura)) INTO total FROM Factura WHERE fecha > inicio AND fecha <= final;
    RETURN total;
END //

CREATE PROCEDURE registarDatosEnRango (inicio date, final date, tipo varchar(30))
BEGIN
    DECLARE ganancias decimal(7, 2);
    DECLARE cantidad int;
    DECLARE iva decimal(7, 2);
    
    SET ganancias = calcularGananciaEnRango(inicio, final);
    SET cantidad = calcularCantidadEnRango(inicio, final);
    SET iva = ganancias * 0.12;
    
    INSERT INTO ResultadosCalculos (ganancias, cantidadArticulosVendidos, iva, tipoCalculo)
        VALUES (ganancias, cantidad, iva, tipo);
END//

DELIMITER ;

-- Test rapido: CALL registarDatosEnRango(DATE_SUB(CURDATE(), INTERVAL 1 DAY), CURDATE(), "Diario")//
    
/*
 * Crea un evento que haga un cálculo de ganancias, cantidad de artículos
 * vendidos e IVA de la base de datos SuperMercado por día.
 */
 -- Calcula los datos del mismo dia
CREATE EVENT registroDiario
    ON SCHEDULE
    EVERY 1 DAY
    DO CALL registarDatosEnRango(DATE_SUB(CURDATE(), INTERVAL 1 DAY), CURDATE(), "Diario");
 

/*
 * Crea un evento que haga un cálculo de ganancias, cantidad de artículos
 * vendidos e IVA de la base de datos SuperMercado por semana.
 */
-- Calcula los datos de la semana pasada
CREATE EVENT registroSemanal
    ON SCHEDULE
    EVERY 1 WEEK
    DO CALL registarDatosEnRango(DATE_SUB(CURDATE(), INTERVAL 1 WEEK), CURDATE(), "Semanal");

/*
 * Crea un evento que haga un cálculo de ganancias, cantidad de artículos
 * vendidos e IVA de la base de datos SuperMercado por mes.
 */
CREATE EVENT registroMensual
    ON SCHEDULE
    EVERY 1 MONTH
    DO CALL registarDatosEnRango(DATE_SUB(CURDATE(), INTERVAL 1 MONTH), CURDATE(), "Mensual");
    
-- Cleanup
DROP DATABASE `db3-actividad2`;
