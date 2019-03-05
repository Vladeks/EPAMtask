-- MySQL Workbench Forward Engineering
use sample;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sample
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sample
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sample` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `sample` ;

-- -----------------------------------------------------
-- Table `sample`.`contacts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample`.`contacts` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `tel` VARCHAR(50) NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sample`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample`.`employee` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(200) NULL DEFAULT NULL,
  `lastName` VARCHAR(200) NULL DEFAULT NULL,
  `contacts_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_employee_contacts1_idx` (`contacts_id` ASC) VISIBLE,
  CONSTRAINT `fk_employee_contacts1`
    FOREIGN KEY (`contacts_id`)
    REFERENCES `sample`.`contacts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sample`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample`.`address` (
  `ad_id` INT(11) NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(200) NULL DEFAULT NULL,
  `city` VARCHAR(200) NULL DEFAULT NULL,
  `fk_contact_id` INT(11) NOT NULL,
  PRIMARY KEY (`ad_id`),
  INDEX `fk_contact_id` (`fk_contact_id` ASC) VISIBLE,
  CONSTRAINT `address_ibfk_1`
    FOREIGN KEY (`fk_contact_id`)
    REFERENCES `sample`.`employee` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sample`.`cars`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample`.`cars` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `driver_id` INT(11) NOT NULL,
  `model` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sample`.`employee_car`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sample`.`employee_car` (
  `employee_id` INT(11) NOT NULL,
  `car_id` INT(11) NOT NULL,
  INDEX `employee_id` (`employee_id` ASC) VISIBLE,
  INDEX `car_id` (`car_id` ASC) VISIBLE,
  CONSTRAINT `employee_car_ibfk_1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `sample`.`employee` (`id`),
  CONSTRAINT `employee_car_ibfk_2`
    FOREIGN KEY (`car_id`)
    REFERENCES `sample`.`cars` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
