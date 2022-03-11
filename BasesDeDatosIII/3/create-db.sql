-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db3-actividad2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db3-actividad2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db3-actividad2` DEFAULT CHARACTER SET utf8 ;
USE `db3-actividad2` ;

-- -----------------------------------------------------
-- Table `db3-actividad2`.`Proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db3-actividad2`.`Proveedor` (
  `idProveedor` INT NOT NULL,
  `nombre` VARCHAR(255) NULL,
  `telefono` VARCHAR(12) NULL,
  PRIMARY KEY (`idProveedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db3-actividad2`.`Marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db3-actividad2`.`Marca` (
  `idMarca` INT NOT NULL,
  `nombre` VARCHAR(255) NULL,
  `idProveedor` INT NOT NULL,
  PRIMARY KEY (`idMarca`),
  INDEX `fk_Marca_Proveedor_idx` (`idProveedor` ASC) VISIBLE,
  CONSTRAINT `fk_Marca_Proveedor`
    FOREIGN KEY (`idProveedor`)
    REFERENCES `db3-actividad2`.`Proveedor` (`idProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db3-actividad2`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db3-actividad2`.`Producto` (
  `idProducto` INT NOT NULL,
  `nombre` VARCHAR(255) NULL,
  `precio` DECIMAL(7,2) NULL,
  `idMarca` INT NOT NULL,
  PRIMARY KEY (`idProducto`),
  INDEX `fk_Producto_Marca1_idx` (`idMarca` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_Marca1`
    FOREIGN KEY (`idMarca`)
    REFERENCES `db3-actividad2`.`Marca` (`idMarca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db3-actividad2`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db3-actividad2`.`Cliente` (
  `idCliente` INT NOT NULL,
  `nit` VARCHAR(45) NULL,
  `nombre` VARCHAR(255) NULL,
  `direccion` VARCHAR(255) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db3-actividad2`.`Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db3-actividad2`.`Factura` (
  `idFactura` INT NOT NULL,
  `fecha` DATE NULL,
  `idCliente` INT NOT NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `fk_Factura_Cliente1_idx` (`idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_Factura_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `db3-actividad2`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db3-actividad2`.`DetalleFactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db3-actividad2`.`DetalleFactura` (
  `idDetalleFactura` INT NOT NULL,
  `idFactura` INT NOT NULL,
  `idProducto` INT NOT NULL,
  PRIMARY KEY (`idDetalleFactura`),
  INDEX `fk_DetalleFactura_Factura1_idx` (`idFactura` ASC) VISIBLE,
  INDEX `fk_DetalleFactura_Producto1_idx` (`idProducto` ASC) VISIBLE,
  CONSTRAINT `fk_DetalleFactura_Factura1`
    FOREIGN KEY (`idFactura`)
    REFERENCES `db3-actividad2`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetalleFactura_Producto1`
    FOREIGN KEY (`idProducto`)
    REFERENCES `db3-actividad2`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
