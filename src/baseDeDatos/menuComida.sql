-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema menu
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema menu
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `menu` DEFAULT CHARACTER SET utf8 ;
USE `menu` ;

-- -----------------------------------------------------
-- Table `menu`.`comida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `menu`.`comida` (
  `idcomi` INT NOT NULL AUTO_INCREMENT,
  `nombre_comi` VARCHAR(25) NOT NULL,
  `precio_comi` DECIMAL(5,2) NOT NULL,
  `tipo_comi` VARCHAR(10) NOT NULL,
  `descripción_comi` VARCHAR(45) NOT NULL,
  `imagen_comi` LONGBLOB NOT NULL,
  PRIMARY KEY (`idcomi`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `menu`.`complemento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `menu`.`complemento` (
  `idcomple` INT NOT NULL,
  `nombre_comple` VARCHAR(25) NOT NULL,
  `precio_comple` DECIMAL(5,2) NOT NULL,
  `descripción_comple` VARCHAR(45) NOT NULL,
  `imagen_comple` LONGBLOB NOT NULL,
  `tamaño_comple` VARCHAR(11) NOT NULL,
  `sabor_comple` VARCHAR(20) NULL,
  PRIMARY KEY (`idcomple`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `menu`.`platillo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `menu`.`platillo` (
  `comida_idcomi` INT NOT NULL,
  `complemento_idcomple` INT NOT NULL,
  `imagen_plati` LONGBLOB NOT NULL,
  PRIMARY KEY (`comida_idcomi`, `complemento_idcomple`),
  INDEX `fk_comida_has_complemento_complemento1_idx` (`complemento_idcomple` ASC) VISIBLE,
  INDEX `fk_comida_has_complemento_comida_idx` (`comida_idcomi` ASC) VISIBLE,
  CONSTRAINT `fk_comida_has_complemento_comida`
    FOREIGN KEY (`comida_idcomi`)
    REFERENCES `menu`.`comida` (`idcomi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comida_has_complemento_complemento1`
    FOREIGN KEY (`complemento_idcomple`)
    REFERENCES `menu`.`complemento` (`idcomple`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `menu`.`comida` (`idcomi`, `nombre_comi`, `precio_comi`, `tipo_comi`, `descripción_comi`, `imagen_comi`) VALUES ('1', 'Hamburguesa', '60.00', 'doble', 'Deliciosa Hamburguesa', ?);
