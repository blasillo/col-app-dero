/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


use colapp;



DROP TABLE IF EXISTS `Cervezas`;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cervezas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `imagen` text,
  `alcohol` float DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `categoria` text,
  `descripcion` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `Notas`;

/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Notas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `titulo` text,
  `contenido` text,
  `publico` tinyint(1) DEFAULT NULL,
  `usuarioid` int(11) NOT NULL,
  `cervezaid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `usuarioid` (`usuarioid`),
  KEY `cervezaid` (`cervezaid`),
  CONSTRAINT `Notas_ibfk_1` FOREIGN KEY (`usuarioid`) REFERENCES `Usuarios` (`id`),
  CONSTRAINT `Notas_ibfk_2` FOREIGN KEY (`cervezaid`) REFERENCES `Cervezas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `Usuarios`;

/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` text,
  `password` text,
  `nombre` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


alter table usuarios add column password_hash text after password;

alter table usuarios add column rol text DEFAULT 'USUARIO'; 