-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: castordb
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id_cate` int(11) NOT NULL AUTO_INCREMENT,
  `tx_nomb_cate` varchar(20) NOT NULL,
  `tx_desc_cate` varchar(150) NOT NULL,
  `in_acti` char(1) NOT NULL,
  `tx_usua_crea` varchar(10) DEFAULT NULL,
  `fe_usua_crea` datetime DEFAULT NULL,
  `tx_usua_modi` varchar(10) DEFAULT NULL,
  `fe_usua_modi` datetime DEFAULT NULL,
  PRIMARY KEY (`id_cate`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Tableros','desc T','1','admin','2016-07-06 12:06:00','ADMIN','2016-07-15 10:22:34'),(2,'Maderas','desc M','1','admin','2016-07-06 12:06:00',NULL,NULL),(3,'Laminados','desc L','1','admin','2016-07-06 12:06:00','ADMIN','2016-07-15 15:21:17'),(4,'Cantos','desc C','1','admin','2016-07-06 12:06:00','ADMIN','2016-07-15 15:21:14'),(5,'Herrajes','desc H','1','admin','2016-07-06 12:06:00',NULL,NULL),(6,'Acabados','desc A','1','admin','2016-07-06 12:06:00',NULL,NULL),(7,'Pegamentos','desc P','1','admin','2016-07-06 12:06:00',NULL,NULL),(8,'Equipamientos','desc E','1','admin','2016-07-06 12:06:00',NULL,NULL),(9,'Herramientas','desc H','1','admin','2016-07-06 12:06:00',NULL,NULL),(13,'categoria a','descripcion aaafdsfds','0','ADMIN','2016-07-15 10:10:53','ADMIN','2016-07-15 15:21:24'),(14,'a','s','0','ADMIN','2016-07-15 10:23:04','ADMIN','2016-07-15 11:07:58');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-15 16:42:53
