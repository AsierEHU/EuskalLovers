-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema euskallovers
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema euskallovers
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `euskallovers` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `euskallovers` ;

-- -----------------------------------------------------
-- Table `euskallovers`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `euskallovers`.`Usuario` (
  `Nick` VARCHAR(15) NOT NULL,
  `Email` VARCHAR(25) NOT NULL,
  `Password` VARCHAR(15) NOT NULL,
  `Genero` TINYINT(1) NULL,
  `Edad` INT NULL,
  `Altura` FLOAT NULL,
  `Peso` FLOAT NULL,
  `Constitucion` VARCHAR(15) NULL,
  `Ciudad` VARCHAR(25) NULL,
  `CP` INT NULL,
  `Foto` VARCHAR(125) NULL,
  UNIQUE INDEX `Nick_UNIQUE` (`Nick` ASC),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC),
  PRIMARY KEY (`Nick`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `euskallovers`.`Aficion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `euskallovers`.`Aficion` (
  `Nombre` VARCHAR(15) NOT NULL,
  `Nick` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`Nombre`, `Nick`),
  INDEX `fk_Aficion_Usuario1_idx` (`Nick` ASC),
  CONSTRAINT `fk_Aficion_Usuario1`
    FOREIGN KEY (`Nick`)
    REFERENCES `euskallovers`.`Usuario` (`Nick`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `euskallovers`.`Personalidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `euskallovers`.`Personalidad` (
  `Nick` VARCHAR(15) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Nick`, `Nombre`),
  CONSTRAINT `NickForeignUser`
    FOREIGN KEY (`Nick`)
    REFERENCES `euskallovers`.`Usuario` (`Nick`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `euskallovers`.`Interes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `euskallovers`.`Interes` (
  `Nick` VARCHAR(15) NOT NULL,
  `Genero` TINYINT(1) NULL,
  `Edad` INT NULL,
  `CP` INT NULL,
  `Peso` DOUBLE NULL,
  `Altura` DOUBLE NULL,
  `Constitucion` VARCHAR(15) NULL,
  PRIMARY KEY (`Nick`),
  CONSTRAINT `Nick_fkUser`
    FOREIGN KEY (`Nick`)
    REFERENCES `euskallovers`.`Usuario` (`Nick`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `euskallovers`.`Premium`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `euskallovers`.`Premium` (
  `Nick` VARCHAR(15) NOT NULL,
  `CuentaTarjeta` MEDIUMTEXT NULL,
  `Saldo` INT NULL,
  `FechaHora` DATETIME NULL,
  `pack` INT NULL,
  PRIMARY KEY (`Nick`),
  CONSTRAINT `NickFkUser`
    FOREIGN KEY (`Nick`)
    REFERENCES `euskallovers`.`Usuario` (`Nick`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `euskallovers`.`Visita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `euskallovers`.`Visita` (
  `Nick1` VARCHAR(15) NOT NULL,
  `Nick2` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`Nick1`, `Nick2`),
  INDEX `nick2_idx` (`Nick2` ASC),
  CONSTRAINT `nick1`
    FOREIGN KEY (`Nick1`)
    REFERENCES `euskallovers`.`Usuario` (`Nick`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `nick2`
    FOREIGN KEY (`Nick2`)
    REFERENCES `euskallovers`.`Usuario` (`Nick`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
