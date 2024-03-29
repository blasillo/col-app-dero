-- MySQL dump 10.17  Distrib 10.3.11-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: colapp
-- ------------------------------------------------------
-- Server version	10.3.11-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cervezas`
--

DROP TABLE IF EXISTS `cervezas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cervezas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `imagen` text DEFAULT NULL,
  `alcohol` float DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `categoria` text DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cervezas`
--

LOCK TABLES `cervezas` WRITE;
/*!40000 ALTER TABLE `cervezas` DISABLE KEYS */;
INSERT INTO `cervezas` VALUES (1,'Duvel','duvel.png',8.5,'Rubia','Strong Blond','Cerveza especial belga de alta fermentaci┬ón, con segunda fermentaci┬ón en botella. Aromas afrutados, evocando el olor a pera y manzana.'),(2,'Chimay Triple','chimay_triple.png',8,'Rubia','Triple Trappist','La cerveza de Triple de Chimay es la m┬ás reciente de la abad┬ía de un color dorado, la cerveza trapense combina el sabor dulce y amargo en un equilibrio poco com┬ún. '),(3,'Cornet','cornet.png',8.5,'Rubia','Strong Blond','De color dorado y sutil sabor a madera, refinado y peculiar. Sensaci┬ón en boca como un vino de crianza roble. Con cuerpo, toque a roble, equilibrio entre la frutosidad de la levadura y la dulzura de la vainilla.'),(4,'Montaraz','montaraz.png',5.3,'Rubia','Weizen-Weissbier','La primera creaci┬ón de cervezas Montaraz, una cerveza rubia de trigo, suave, refrescante y con ligero aroma a pl┬átano. Una cerveza artesana, elaborada en el Bierzo.'),(5,'Ruda','ruda.jpg',5,'Tostada','Pale Ale','Color ┬ámbar y densa espuma, ligeramente amarga y notas dulces maltosas.'),(6,'3 Cumbres','3cumbres.png',4.5,'Rubia','Lager','De color claro, es ligera, suave y muy refrescante que est┬á elaborada siguiendo la Ley de la Pureza Alemana. Una cerveza ideal para cualquier momento y ocasi┬ón.'),(7,'Berzaga','berzaga.jpg',5,'Tostada','Amber Ale','Cerveza artesana tostada al estilo InglÔÇÜs. F┬ácil de beber y baja carbonataci┬ón. Elaborada con una selecci┬ón de cuatro maltas, muestra cierto dulzor inicial seguido de un sabor caramelizado que finaliza con toques tostados y un suave amargor en boca, fruto de los l┬úpulos balanceados en tiempo de cocci┬ón.'),(8,'Tormenta Solar','baixer-tormenta-solar.jpg',6.5,'Naranja p┬álido','Saison','Cerveza de estilo Saison con autÔÇÜntica levadura Saison. Estilo tipicamente belga de granja, en este caso con l┬úpulo neozelandÔÇÜs Nelson Sauv┬ín, una combinaci┬ón interesante de los sabores afrutados aportados por la levadura y los sabores y aromas tropicales y de vino blanco de este l┬úpulo, a┬ñadido en whirpool.'),(9,'Perraborracha','perraborracha.png',4.6,'Ambar','American Pale Ale','American Pale Ale fresquita y sin complicaciones, amarga poco y es muy f┬ácil de beber..'),(10,'Barreno','barreno.png',8.8,'Negra','Stout','Cerveza negra, con aromas y sabor a cafÔÇÜ, regaliz, chocolate toque licoroso que da paso a ligero l┬úpulo. Cuerpo medio-completo. Amarga.');
/*!40000 ALTER TABLE `cervezas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notas`
--

DROP TABLE IF EXISTS `notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creado` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `titulo` text DEFAULT NULL,
  `contenido` text DEFAULT NULL,
  `publico` tinyint(1) DEFAULT NULL,
  `usuarioid` int(11) NOT NULL,
  `cervezaid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `usuarioid` (`usuarioid`),
  KEY `cervezaid` (`cervezaid`),
  CONSTRAINT `Notas_ibfk_1` FOREIGN KEY (`usuarioid`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `Notas_ibfk_2` FOREIGN KEY (`cervezaid`) REFERENCES `cervezas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notas`
--

LOCK TABLES `notas` WRITE;
/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
INSERT INTO `notas` VALUES (1,'2019-08-07 10:00:07','Bastante buena','Esta cerveza es una referencia.',1,1,5),(5,'2019-08-08 13:22:48','Muy buena','Duvel es una de las cervezas m├ís especiales en el mundo',1,1,1),(6,'2019-08-13 12:37:28','Un cl├ísico','Realmente muy buena cerveza.',1,1,2),(7,'2019-08-13 12:52:50','No est├í mal','Para ser de El Bierzo no est├í tan mal.',1,1,4);
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` text DEFAULT NULL,
  `password` text DEFAULT NULL,
  `password_hash` text DEFAULT NULL,
  `nombre` text DEFAULT NULL,
  `rol` text DEFAULT 'USUARIO',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'administrador-colapp@jcyl.es','supersecreto','737c04bbf91056509f2fd3e25b7b3dc8','Administrador','ADMINISTRADOR'),(2,'TorGomRo@jcyl.es','TorGomRo','3667595faf6d198b3779e4b00861479c','Roberto Torres','USUARIO'),(3,'NecSotGa@jcyl.es','NecSotGa','fd6cc745e863b7aea1a1e2cccb5e146a','Gabriel Necedes','USUARIO'),(4,'LopGarIo@jcyl.es','LopGarIo','ba7683bccd2e227099090701fd98be42','Iovani Lopez','USUARIO');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-14 10:47:55
