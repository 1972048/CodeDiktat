-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema schoop1
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `schoop1` ;

-- -----------------------------------------------------
-- Schema schoop1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `schoop1` DEFAULT CHARACTER SET utf8 ;
USE `schoop1` ;

-- -----------------------------------------------------
-- Table `schoop1`.`curriculum`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoop1`.`curriculum` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schoop1`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schoop1`.`course` (
  `id` VARCHAR(6) NOT NULL,
  `name` VARCHAR(150) NOT NULL,
  `credits` INT(2) NOT NULL,
  `lab_session` TINYINT(1) NOT NULL DEFAULT 0,
  `semester` VARCHAR(45) NOT NULL,
  `curriculum_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_course_curriculum_idx` (`curriculum_id` ASC),
  CONSTRAINT `fk_course_curriculum`
    FOREIGN KEY (`curriculum_id`)
    REFERENCES `schoop1`.`curriculum` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `schoop1`.`curriculum`
-- -----------------------------------------------------
START TRANSACTION;
USE `schoop1`;
INSERT INTO `schoop1`.`curriculum` (`id`, `name`) VALUES (DEFAULT, 'Kurikulum 2014 IF');
INSERT INTO `schoop1`.`curriculum` (`id`, `name`) VALUES (DEFAULT, 'Kurikulum 2016 IF');
INSERT INTO `schoop1`.`curriculum` (`id`, `name`) VALUES (DEFAULT, 'Kurikulum 2016 SI');
INSERT INTO `schoop1`.`curriculum` (`id`, `name`) VALUES (DEFAULT, 'Kurikulum KKNI 2020 IF');
INSERT INTO `schoop1`.`curriculum` (`id`, `name`) VALUES (DEFAULT, 'Kurikulum KKNI 2020 SI');

COMMIT;


-- -----------------------------------------------------
-- Data for table `schoop1`.`course`
-- -----------------------------------------------------
START TRANSACTION;
USE `schoop1`;
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('﻿IN010', 'Dasar Pemrograman', 3, 1, '1', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN011', 'Pengantar Teknologi Informasi', 2, 0, '1', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN012', 'Pengenalan Aplikasi Komputer ', 2, 0, '1', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN013', 'Matematika Informatika', 2, 0, '1', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN014', 'Bahasa Inggris 1', 2, 0, '1', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('MK024', 'Kewarganegaraan', 2, 0, '1', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('MK060', 'Fenomenologi Agama', 2, 0, '1', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('MK062', 'Pendidikan Agama Kristen', 2, 0, '1', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN020', 'Algoritma dan Struktur Data 1', 2, 1, '2', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN021', 'Pemrograman Web 1', 3, 1, '2', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN022', 'Jaringan Komputer 1', 3, 1, '2', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN023', 'Aljabar Linier dan Matriks', 3, 0, '2', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN024', 'Bahasa Inggris 2', 2, 0, '2', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('MK017', 'Pancasila', 2, 0, '2', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN030', 'Algoritma dan Struktur Data 2', 2, 1, '3', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN031', 'Basis Data 1', 3, 1, '3', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN032', 'Rekayasa Perangkat Lunak 1', 3, 0, '3', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN033', 'Pengantar Arsitektur Komputer', 2, 0, '3', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN034', 'Teknologi Multimedia', 3, 0, '3', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN035', 'Matematika Diskrit', 3, 0, '3', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('MK039', 'Bahasa Indonesia', 2, 0, '3', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN040', 'Pemrograman Berorientasi Objek 1 A', 3, 1, '4', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN041', 'Pemrograman Berorientasi Objek 1 B', 3, 1, '4', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN042', 'Basis Data 2', 3, 1, '4', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN043', 'Rekayasa Perangkat Lunak 2', 3, 0, '4', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN044', 'Jaringan Komputer 2', 3, 0, '4', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN045', 'Sistem Operasi Komputer', 3, 0, '4', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN046', 'Statistika', 3, 0, '4', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN050', 'Pemrograman Berorientasi Objek 2 A', 3, 1, '5', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN051', 'Pemrograman Berorientasi Objek 2 B', 3, 1, '5', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN052', 'Pemrograman Web 2', 3, 1, '5', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN053', 'Strategi Algoritmik', 2, 0, '5', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN054', 'Manajemen Proyek', 3, 0, '5', 2);
INSERT INTO `schoop1`.`course` (`id`, `name`, `credits`, `lab_session`, `semester`, `curriculum_id`) VALUES ('IN055', 'Proses Bisnis', 3, 0, '5', 2);

COMMIT;

