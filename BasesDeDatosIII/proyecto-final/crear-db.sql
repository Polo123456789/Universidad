-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db3_proyectoFinal
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db3_proyectoFinal
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db3_proyectoFinal` DEFAULT CHARACTER SET utf8 ;
USE `db3_proyectoFinal` ;

-- -----------------------------------------------------
-- Table `db3_proyectoFinal`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db3_proyectoFinal`.`proveedor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `telefono` CHAR(9) NULL,
  `correo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db3_proyectoFinal`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db3_proyectoFinal`.`producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `precio` DECIMAL(7,2) NULL,
  `existencias` INT NULL,
  `proveedor_id` INT NOT NULL,
  PRIMARY KEY (`id`, `proveedor_id`),
  INDEX `fk_producto_proveedor_idx` (`proveedor_id` ASC) VISIBLE,
  CONSTRAINT `fk_producto_proveedor`
    FOREIGN KEY (`proveedor_id`)
    REFERENCES `db3_proyectoFinal`.`proveedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db3_proyectoFinal`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db3_proyectoFinal`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `nit` CHAR(13) NULL,
  `telefono` CHAR(9) NULL,
  `correo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db3_proyectoFinal`.`venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db3_proyectoFinal`.`venta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NULL,
  `cliente_id` INT NOT NULL,
  `total` DECIMAL(7,2) NULL DEFAULT 0.0,
  PRIMARY KEY (`id`, `cliente_id`),
  INDEX `fk_venta_Cliente1_idx` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_venta_Cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `db3_proyectoFinal`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db3_proyectoFinal`.`venta_tiene_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db3_proyectoFinal`.`venta_tiene_producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `producto_id` INT NOT NULL,
  `venta_id` INT NOT NULL,
  `cantidad` INT NULL,
  PRIMARY KEY (`id`, `producto_id`, `venta_id`),
  INDEX `fk_venta_tiene_producto_producto1_idx` (`producto_id` ASC) VISIBLE,
  INDEX `fk_venta_tiene_producto_venta1_idx` (`venta_id` ASC) VISIBLE,
  CONSTRAINT `fk_venta_tiene_producto_producto1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `db3_proyectoFinal`.`producto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_tiene_producto_venta1`
    FOREIGN KEY (`venta_id`)
    REFERENCES `db3_proyectoFinal`.`venta` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `db3_proyectoFinal`;

DELIMITER $$
USE `db3_proyectoFinal`$$
CREATE DEFINER = CURRENT_USER TRIGGER `db3_proyectoFinal`.`validar_cantidad_de_producto` BEFORE INSERT ON `venta_tiene_producto` FOR EACH ROW
BEGIN
	DECLARE cantidad_disponible INT;
    SELECT existencias INTO cantidad_disponible FROM producto p WHERE p.id = new.producto_id;
    
    IF new.cantidad > cantidad_disponible THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No hay suficientes productos en existencia';
    END IF;
END$$

USE `db3_proyectoFinal`$$
CREATE DEFINER = CURRENT_USER TRIGGER `db3_proyectoFinal`.`actualizar_existencias` AFTER INSERT ON `venta_tiene_producto` FOR EACH ROW
BEGIN
	UPDATE producto SET existencias = existencias - new.cantidad WHERE id = new.producto_id;
END$$

USE `db3_proyectoFinal`$$
CREATE DEFINER = CURRENT_USER TRIGGER `db3_proyectoFinal`.`actualizar_total` AFTER INSERT ON `venta_tiene_producto` FOR EACH ROW
BEGIN
	DECLARE precio_producto DECIMAL(7, 2);
    
    SELECT precio INTO precio_producto FROM producto p WHERE p.id = new.producto_id;
    
	UPDATE venta SET total = total + (precio_producto * new.cantidad) WHERE id = new.venta_id;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
