-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ControlPedidos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ControlPedidos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ControlPedidos` DEFAULT CHARACTER SET utf8 ;
USE `ControlPedidos` ;

-- -----------------------------------------------------
-- Table `ControlPedidos`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControlPedidos`.`Cliente` (
  `idCliente` INT NOT NULL,
  `Nombre` VARCHAR(30) NULL,
  `Direccion` VARCHAR(45) NULL,
  `Telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ControlPedidos`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControlPedidos`.`Empleado` (
  `idEmpleado` INT NOT NULL,
  `Nombre` VARCHAR(30) NULL,
  `Apellidos` VARCHAR(30) NULL,
  `Genero` CHAR(1) NULL,
  `FechaDeNacimiento` DATE NULL,
  `Sueldo` DECIMAL(8,2) NULL,
  PRIMARY KEY (`idEmpleado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ControlPedidos`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControlPedidos`.`Producto` (
  `idProducto` INT NOT NULL,
  `Descripcion` VARCHAR(90) NULL,
  `Precio` DECIMAL(8,2) NULL,
  `Existencia` INT NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ControlPedidos`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControlPedidos`.`Pedido` (
  `idPedido` INT NOT NULL,
  `FechaDePedido` DATE NULL,
  `FechaDeEntrega` DATE NULL,
  `Status` VARCHAR(25) NULL,
  `Cliente_idCliente` INT NOT NULL,
  `Empleado_idEmpleado` INT NOT NULL,
  PRIMARY KEY (`idPedido`),
  INDEX `fk_Pedido_Cliente_idx` (`Cliente_idCliente` ASC) VISIBLE,
  INDEX `fk_Pedido_Empleado1_idx` (`Empleado_idEmpleado` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ControlPedidos`.`DetallePedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControlPedidos`.`DetallePedido` (
  `Pedido_idPedido` INT NOT NULL,
  `Producto_idProducto` INT NOT NULL,
  `Cantidad` INT NULL,
  PRIMARY KEY (`Pedido_idPedido`, `Producto_idProducto`),
  INDEX `fk_Pedido_has_Producto_Producto1_idx` (`Producto_idProducto` ASC) VISIBLE,
  INDEX `fk_Pedido_has_Producto_Pedido1_idx` (`Pedido_idPedido` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
