-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema banco
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema banco
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `banco` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `banco` ;

-- -----------------------------------------------------
-- Table `banco`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco`.`clientes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `contrasenia` VARCHAR(100) NULL DEFAULT NULL,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `apellido_paterno` VARCHAR(50) NULL DEFAULT NULL,
  `apellido_materno` VARCHAR(50) NULL DEFAULT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  `edad` INT NULL DEFAULT NULL,
  `calle` VARCHAR(90) NULL DEFAULT NULL,
  `num` VARCHAR(10) NULL DEFAULT NULL,
  `colonia` VARCHAR(110) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `banco`.`cuentas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco`.`cuentas` (
  `numero_cuenta` BIGINT NOT NULL AUTO_INCREMENT,
  `saldo` FLOAT NULL DEFAULT NULL,
  `fecha_apertura` DATETIME NULL DEFAULT NULL,
  `id_cliente` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`numero_cuenta`),
  INDEX `id_cliente` (`id_cliente` ASC) ,
  CONSTRAINT `cuentas_ibfk_1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `banco`.`clientes` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `banco`.`retirosincuenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco`.`retirosincuenta` (
  `folio` INT NOT NULL AUTO_INCREMENT,
  `numero_cuenta` BIGINT NOT NULL,
  `cantidad` FLOAT NOT NULL,
  `estado` VARCHAR(30) NOT NULL,
  `contraseña` INT NOT NULL,
  `fechaHora` DATETIME NOT NULL,
  `fechaHoraRetirado` DATETIME NULL DEFAULT NULL,
  `fechaHoraLimite` DATETIME NOT NULL,
  PRIMARY KEY (`folio`),
  INDEX `numero_cuenta_idx` (`numero_cuenta` ASC) ,
  CONSTRAINT `numero_cuenta`
    FOREIGN KEY (`numero_cuenta`)
    REFERENCES `banco`.`cuentas` (`numero_cuenta`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `banco`.`transferencias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco`.`transferencias` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `fecha_hora` DATETIME NULL DEFAULT NULL,
  `monto` FLOAT NULL DEFAULT NULL,
  `cuenta_origen` BIGINT NULL DEFAULT NULL,
  `cuenta_destino` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `cuenta_origen_idx` (`cuenta_origen` ASC) ,
  CONSTRAINT `cuenta_origen`
    FOREIGN KEY (`cuenta_origen`)
    REFERENCES `banco`.`cuentas` (`numero_cuenta`))
ENGINE = InnoDB
AUTO_INCREMENT = 58
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `banco` ;

-- -----------------------------------------------------
-- procedure SaldoCuenta
-- -----------------------------------------------------

DELIMITER $$
USE `banco`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SaldoCuenta`(in numeroCuentaB int,out saldoDinero float)
begin
select saldo into saldoDinero
from cuentas
where numero_cuenta=numeroCuentaB;
end$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure realizarRetiroSinCuenta
-- -----------------------------------------------------

DELIMITER $$
USE `banco`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `realizarRetiroSinCuenta`(
  IN folioB INT,
  IN contraseñaB INT
)
BEGIN
  DECLARE cantidadDinero FLOAT;
  DECLARE fechaInicio DATETIME;
  DECLARE fechaFin DATETIME;
  DECLARE NumeroCuentaB int;
  DECLARE estadoB varchar(40);
  
  SELECT numero_cuenta INTO NumeroCuentaB FROM retiroSinCuenta WHERE folio = folioB AND contraseña = contraseñaB;
  
  CALL SaldoCuenta(NumeroCuentaB, @saldoCuenta); 
  
  SELECT fechaHora, fechaHoraLimite, cantidad, numero_cuenta, estado INTO fechaInicio, fechaFin, cantidadDinero, NumeroCuentaB, estadoB
  FROM retirosincuenta WHERE folio = folioB AND contraseña = contraseñaB FOR UPDATE;
  
  IF estadoB = 'COBRADO' THEN
    UPDATE RetiroSinCuenta SET estado = 'COBRADO' WHERE folio = folioB AND contraseña = contraseñaB;
    
  ELSEIF fechaInicio <= CURRENT_TIMESTAMP() AND fechaFin >= CURRENT_TIMESTAMP() THEN
    IF @saldoCuenta < cantidadDinero THEN 
      UPDATE RetiroSinCuenta SET estado = 'INSUFICIENTE' WHERE folio = folioB AND contraseña = contraseñaB;
    ELSE
      UPDATE RetiroSinCuenta SET estado = 'COBRADO' WHERE folio = folioB AND contraseña = contraseñaB;
      UPDATE RetiroSinCuenta set fechaHoraRetirado = CURRENT_TIMESTAMP() WHERE folio = folioB AND contraseña = contraseñaB;
      UPDATE cuentas SET saldo = @saldoCuenta - cantidadDinero WHERE numero_cuenta = NumeroCuentaB; 
    END IF;
  ELSE
    UPDATE RetiroSinCuenta SET estado = 'CADUCADO' WHERE folio = folioB AND contraseña = contraseñaB;
  END IF;
  
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure transferir
-- -----------------------------------------------------

DELIMITER $$
USE `banco`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `transferir`(idorigen INT, iddestino INT, monto FLOAT)
BEGIN
  DECLARE EXIT HANDLER FOR SQLEXCEPTION
  BEGIN
    SELECT 'Ocurrio un error durante la transferencia';
    ROLLBACK;
  END;

  START TRANSACTION;
  IF (SELECT `saldo` FROM `cuentas` WHERE `numero_cuenta` = idorigen) >= monto THEN
    UPDATE `cuentas` SET `saldo` = `saldo` - monto WHERE `numero_cuenta` = idorigen;

    UPDATE `cuentas` SET `saldo` = `saldo` + monto WHERE `numero_cuenta` = iddestino;
  ELSE 
  SELECT 'Fondos insuficientes';
    ROLLBACK;
  END IF;

  

  COMMIT;
  
  INSERT INTO transferencias (`fecha_hora`, `monto`, `cuenta_origen`, `cuenta_destino`) VALUES (curdate(), monto, idorigen, iddestino);
END$$

DELIMITER ;
USE `banco`;

DELIMITER $$
USE `banco`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `banco`.`edad_calcular`
BEFORE INSERT ON `banco`.`clientes`
FOR EACH ROW
BEGIN
  DECLARE fecha DATE;
  DECLARE edad_C INT;
  
  SET fecha = NEW.fecha_nacimiento;
  SET edad_C = YEAR(CURRENT_DATE()) - YEAR(fecha) - (RIGHT(CURRENT_DATE(), 5) < RIGHT(fecha, 5));
  SET NEW.edad = edad_C;
END$$

USE `banco`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `banco`.`edad_calcular_update`
BEFORE UPDATE ON `banco`.`clientes`
FOR EACH ROW
BEGIN
  DECLARE fecha DATE;
  DECLARE edad_C INT;
  
  SET fecha = NEW.fecha_nacimiento;
  SET edad_C = YEAR(CURRENT_DATE()) - YEAR(fecha) - (RIGHT(CURRENT_DATE(), 5) < RIGHT(fecha, 5));
  SET NEW.edad = edad_C;
END$$

USE `banco`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `banco`.`insertRetiroSinCuenta`
BEFORE INSERT ON `banco`.`retirosincuenta`
FOR EACH ROW
begin
  SET NEW.estado = 'ACTIVO';
  SET NEW.fechaHora = CURRENT_TIMESTAMP();
  SET NEW.fechaHoraLimite = date_add(CURRENT_TIMESTAMP(),interval 10 minute);
end$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
