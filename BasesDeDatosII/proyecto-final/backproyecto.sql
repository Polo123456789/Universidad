-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: ControlPersonal
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asigna`
--

DROP TABLE IF EXISTS `asigna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asigna` (
  `CodAsigna` int NOT NULL,
  `CodPersona` int NOT NULL,
  `CodDepto` int NOT NULL,
  `CodPuesto` int NOT NULL,
  `FechaAsigna` date DEFAULT NULL,
  `FechaInicioLab` date DEFAULT NULL,
  PRIMARY KEY (`CodAsigna`),
  UNIQUE KEY `IndexCodAsigna` (`CodAsigna`),
  KEY `CodPersona` (`CodPersona`),
  KEY `CodDepto` (`CodDepto`),
  KEY `CodPuesto` (`CodPuesto`),
  CONSTRAINT `asigna_ibfk_1` FOREIGN KEY (`CodPersona`) REFERENCES `personal` (`CodPersona`),
  CONSTRAINT `asigna_ibfk_2` FOREIGN KEY (`CodDepto`) REFERENCES `departamento` (`CodDepto`),
  CONSTRAINT `asigna_ibfk_3` FOREIGN KEY (`CodPuesto`) REFERENCES `puesto` (`CodPuesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asigna`
--

LOCK TABLES `asigna` WRITE;
/*!40000 ALTER TABLE `asigna` DISABLE KEYS */;
INSERT INTO `asigna` VALUES (1,1,1,1,'2021-12-02','2021-12-02'),(2,2,2,2,'2021-12-02','2021-12-02'),(3,3,3,3,'2021-12-02','2021-12-02'),(4,4,4,4,'2021-12-02','2021-12-02'),(5,5,5,5,'2021-12-02','2021-08-08');
/*!40000 ALTER TABLE `asigna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bitacora`
--

DROP TABLE IF EXISTS `bitacora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bitacora` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `CodPersona` int DEFAULT NULL,
  `Fecha` datetime DEFAULT NULL,
  `Usuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacora`
--

LOCK TABLES `bitacora` WRITE;
/*!40000 ALTER TABLE `bitacora` DISABLE KEYS */;
/*!40000 ALTER TABLE `bitacora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `CodDepto` int NOT NULL,
  `NombreDepto` varchar(45) DEFAULT NULL,
  `Descripcion` varchar(90) DEFAULT NULL,
  `CantEmpleados` int DEFAULT NULL,
  PRIMARY KEY (`CodDepto`),
  UNIQUE KEY `IndexCodDepto` (`CodDepto`),
  KEY `IndexDepartamentoNombreDepartamento` (`NombreDepto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Contabilidad','Gestion de las cuentas de la empresa',10),(2,'Ventas','Gestiona la entrada y salida de productos',15),(3,'Publicidad','Se encarga de la publicidad de la empresa',5),(4,'Limpieza','Se encarga de la sanitizacion de las franquicias',30),(5,'Recursos Humanos','Supervisa los demas departamentos',10);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal`
--

DROP TABLE IF EXISTS `personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal` (
  `CodPersona` int NOT NULL,
  `Nombres` varchar(45) DEFAULT NULL,
  `Apellidos` varchar(45) DEFAULT NULL,
  `CorreoE` varchar(45) DEFAULT NULL,
  `FechaNacimiento` date DEFAULT NULL,
  PRIMARY KEY (`CodPersona`),
  UNIQUE KEY `IndexCodPersona` (`CodPersona`),
  KEY `IndexPersonalNombresApellidos` (`Nombres`,`Apellidos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal`
--

LOCK TABLES `personal` WRITE;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT INTO `personal` VALUES (1,'Pablo','Sanchez Galdamez','some_mail@example.com','2002-09-11'),(2,'Pedro','Martinez Morales','other.mail@example.com','2003-11-12'),(3,'Juan','Martinez Morales','example@[164.135.0.100]','2001-01-09'),(4,'Andrez','Sanchez Galdamez','\" \"@exmample.org','1999-01-01'),(5,'Carlos','Martinez Morales','carlos@mail.com','1998-08-08');
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `TgRegistrarEliminacionDePersona` BEFORE DELETE ON `personal` FOR EACH ROW BEGIN
    INSERT INTO Bitacora (CodPersona, Fecha, Usuario)
    VALUES (old.CodPersona, NOW(), SESSION_USER());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `personalpuesto`
--

DROP TABLE IF EXISTS `personalpuesto`;
/*!50001 DROP VIEW IF EXISTS `personalpuesto`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `personalpuesto` AS SELECT 
 1 AS `Nombres`,
 1 AS `Apellidos`,
 1 AS `Puesto`,
 1 AS `Sueldo`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `puesto`
--

DROP TABLE IF EXISTS `puesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puesto` (
  `CodPuesto` int NOT NULL,
  `NombrePuesto` varchar(45) DEFAULT NULL,
  `Descrip` varchar(90) DEFAULT NULL,
  `SueldoBase` double DEFAULT NULL,
  `Bono` double DEFAULT NULL,
  `Bonificacion` double DEFAULT NULL,
  PRIMARY KEY (`CodPuesto`),
  UNIQUE KEY `IndexCodPuesto` (`CodPuesto`),
  KEY `IndexPuestoNombrePuesto` (`NombrePuesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puesto`
--

LOCK TABLES `puesto` WRITE;
/*!40000 ALTER TABLE `puesto` DISABLE KEYS */;
INSERT INTO `puesto` VALUES (1,'Supervisor','Encargado de la supervision',10000,150,35.5),(2,'Administrador de Redes','Encargado de las redes',5000,150,0),(3,'Administrador de Proyectos','Encargado de supervisar el progreso de los proyectos',6000,150,0),(4,'Gerente','Encargado de supervisar una franquicia',5000,150,0),(5,'Cajero','Encargado de cobrarle a los clientes',3500,150,0);
/*!40000 ALTER TABLE `puesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `personalpuesto`
--

/*!50001 DROP VIEW IF EXISTS `personalpuesto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `personalpuesto` AS select `pe`.`Nombres` AS `Nombres`,`pe`.`Apellidos` AS `Apellidos`,`pu`.`NombrePuesto` AS `Puesto`,`pu`.`SueldoBase` AS `Sueldo` from (`personal` `pe` join `puesto` `pu` on((`pu`.`CodPuesto` = (select `asigna`.`CodPuesto` from `asigna` where (`asigna`.`CodPersona` = `pe`.`CodPersona`))))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-02 10:52:40
