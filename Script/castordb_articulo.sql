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
-- Table structure for table `articulo`
--

DROP TABLE IF EXISTS `articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articulo` (
  `id_cate` int(11) NOT NULL,
  `id_arti` int(11) NOT NULL AUTO_INCREMENT,
  `co_arti` varchar(20) NOT NULL,
  `tx_desc_arti` varchar(254) NOT NULL,
  `nu_peso_neto` decimal(28,8) NOT NULL,
  `nu_peso_brut` decimal(28,8) NOT NULL,
  `nu_volu` decimal(28,8) NOT NULL,
  `tx_unid_medi` varchar(6) NOT NULL,
  `nu_cost_prom_loca` decimal(28,8) NOT NULL,
  `nu_cost_prom_dola` decimal(28,8) NOT NULL,
  `nu_prec_base_loca` decimal(28,8) NOT NULL,
  `nu_prec_base_dola` decimal(28,8) NOT NULL,
  `in_acti` char(1) NOT NULL,
  `tx_usua_crea` varchar(10) DEFAULT NULL,
  `fe_usua_crea` datetime DEFAULT NULL,
  `tx_usua_modi` varchar(10) DEFAULT NULL,
  `fe_usua_modi` datetime DEFAULT NULL,
  PRIMARY KEY (`id_arti`),
  KEY `id_clas` (`id_cate`),
  CONSTRAINT `articulo_ibfk_1` FOREIGN KEY (`id_cate`) REFERENCES `categoria` (`id_cate`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulo`
--

LOCK TABLES `articulo` WRITE;
/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
INSERT INTO `articulo` VALUES (1,1,'ART001','Aglomerado Crudo',4.50000000,3.50000000,2.15000000,'mts',45.56000000,13.03000000,45.56000000,13.03000000,'1','admin','2016-07-06 12:12:00',NULL,NULL),(1,2,'ART002','Aglomerado Crudo 2',4.50000000,3.50000000,2.15000000,'mts',45.56000000,13.03000000,45.56000000,13.03000000,'1','admin','2016-07-06 12:12:00','ADMIN','2016-07-15 15:20:59'),(1,3,'ART931','pinocho',5.20000000,5.20000000,5.20000000,'metros',5.20000000,5.20000000,15.20000000,15.60000000,'1','ADMIN','2016-07-15 14:21:30','ADMIN','2016-07-15 15:21:04');
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;
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
