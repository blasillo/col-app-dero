-- MySQL dump 10.17  Distrib 10.3.11-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: colapp
-- ------------------------------------------------------
-- Server version	10.3.11-MariaDB



DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `email` text DEFAULT NULL,
                            `password` text DEFAULT NULL,
                            `password_hash` text DEFAULT NULL,
                            `nombre` text DEFAULT NULL,
                            `rol` text DEFAULT 'USUARIO',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

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

