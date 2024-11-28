-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: Assicurazioni
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `assicurazioni`
--

DROP TABLE IF EXISTS `assicurazioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assicurazioni` (
  `CodAss` varchar(20) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `sede` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CodAss`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assicurazioni`
--

LOCK TABLES `assicurazioni` WRITE;
/*!40000 ALTER TABLE `assicurazioni` DISABLE KEYS */;
INSERT INTO `assicurazioni` VALUES ('ASSR001A','SARA','Trieste'),('ASSR002B','UnipolSai','Bologna'),('ASSR003C','Allianz','Milano'),('ASSR004D','Reale Mutua','Torino'),('ASSR005E','SARA','Roma');
/*!40000 ALTER TABLE `assicurazioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auto`
--

DROP TABLE IF EXISTS `auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auto` (
  `targa` varchar(20) NOT NULL,
  `marca` varchar(20) DEFAULT NULL,
  `cilindrata` varchar(20) NOT NULL,
  `potenza` int DEFAULT NULL,
  `CodF` varchar(20) NOT NULL,
  `CodAss` varchar(20) NOT NULL,
  PRIMARY KEY (`targa`),
  UNIQUE KEY `marca` (`marca`),
  KEY `CodF` (`CodF`),
  KEY `CodAss` (`CodAss`),
  CONSTRAINT `auto_ibfk_1` FOREIGN KEY (`CodF`) REFERENCES `proprietari` (`CodF`),
  CONSTRAINT `auto_ibfk_2` FOREIGN KEY (`CodAss`) REFERENCES `assicurazioni` (`CodAss`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto`
--

LOCK TABLES `auto` WRITE;
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` VALUES ('AA123BB','Fiat','3902 cc',70,'RSSMRA85M01H501Z','ASSR001A'),('CC456DD','Volkswagen','6498 cc',110,'VRDLGI75C12F205K','ASSR002B'),('EE789FF','BMW','4395 cc',150,'BNCLRA60T08L219W','ASSR003C'),('GG101HH','Audi','3979 cc',140,'FNTGPP90S15B963H','ASSR004D'),('II112JJ','Toyota','2339',90,'PLSMNL70P22C351R','ASSR005E');
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autocoinvolte`
--

DROP TABLE IF EXISTS `autocoinvolte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autocoinvolte` (
  `ImportoDelDenaro` int DEFAULT NULL,
  `CodS` varchar(20) NOT NULL,
  `targa` varchar(20) DEFAULT NULL,
  KEY `CodS` (`CodS`),
  KEY `targa` (`targa`),
  CONSTRAINT `autocoinvolte_ibfk_1` FOREIGN KEY (`CodS`) REFERENCES `sinistro` (`CodS`),
  CONSTRAINT `autocoinvolte_ibfk_2` FOREIGN KEY (`targa`) REFERENCES `auto` (`targa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autocoinvolte`
--

LOCK TABLES `autocoinvolte` WRITE;
/*!40000 ALTER TABLE `autocoinvolte` DISABLE KEYS */;
INSERT INTO `autocoinvolte` VALUES (150,'SIN001A202','AA123BB'),(1200,'SIN002B304','CC456DD'),(350,'SIN003C406','EE789FF'),(500,'SIN004D508','GG101HH'),(1000,'SIN005E610','II112JJ');
/*!40000 ALTER TABLE `autocoinvolte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proprietari`
--

DROP TABLE IF EXISTS `proprietari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proprietari` (
  `CodF` varchar(20) NOT NULL,
  `nomePropr` varchar(20) NOT NULL,
  `residenza` varchar(40) NOT NULL,
  PRIMARY KEY (`CodF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proprietari`
--

LOCK TABLES `proprietari` WRITE;
/*!40000 ALTER TABLE `proprietari` DISABLE KEYS */;
INSERT INTO `proprietari` VALUES ('BNCLRA60T08L219W','Laura Bianchi','Firenze'),('FNTGPP90S15B963H','Giuseppe Fontana','Torino'),('PLSMNL70P22C351R','Manuela Palestra','Roma'),('RSSMRA85M01H501Z','Mario Rossi','Milano'),('VRDLGI75C12F205K','Luigi Verdi','Napoli');
/*!40000 ALTER TABLE `proprietari` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinistro`
--

DROP TABLE IF EXISTS `sinistro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinistro` (
  `CodS` varchar(20) NOT NULL,
  `localita` varchar(20) DEFAULT NULL,
  `dataSinistro` date DEFAULT NULL,
  PRIMARY KEY (`CodS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinistro`
--

LOCK TABLES `sinistro` WRITE;
/*!40000 ALTER TABLE `sinistro` DISABLE KEYS */;
INSERT INTO `sinistro` VALUES ('SIN001A202','Milano','2012-01-12'),('SIN002B304','Roma','2023-06-18'),('SIN003C406','Napoli','2023-07-22'),('SIN004D508','Torino','2023-08-15'),('SIN005E610','Firenze','2023-09-10');
/*!40000 ALTER TABLE `sinistro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'Assicurazioni'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-13 15:39:28
