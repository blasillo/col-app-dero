use colapp;


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




INSERT INTO usuarios (`id`,`email`,`password`,`password_hash`,`nombre`) VALUES (1, "administrador-colapp@jcyl.es", "supersecreto", "", "Administrador");
INSERT INTO usuarios (`id`,`email`,`password`,`password_hash`,`nombre`) VALUES (2, "TorGomRo@jcyl.es", "TorGomRo", "", "Roberto Torres" );
INSERT INTO usuarios (`id`,`email`,`password`,`password_hash`,`nombre`) VALUES (3, "NecSotGa@jcyl.es", "NecSotGa", "", "Gabriel Necedes");
INSERT INTO usuarios (`id`,`email`,`password`,`password_hash`,`nombre`) VALUES (4, "LopGarIo@jcyl.es", "LopGarIo", "", "Iovani Lopez");

update usuarios set rol='ADMINISTRADOR' where id =1;


update usuarios set password_hash = MD5(password);

commit;

INSERT INTO `cervezas` VALUES (1,'Duvel','duvel.png',8.5,'Rubia','Strong Blond','Cerveza especial belga de alta fermentación, con segunda fermentación en botella. Aromas afrutados, evocando el olor a pera y manzana.');
INSERT INTO `cervezas` VALUES (2,'Chimay Triple','chimay_triple.png',8,'Rubia','Triple Trappist','La cerveza de Triple de Chimay es la más reciente de la abadía de un color dorado, la cerveza trapense combina el sabor dulce y amargo en un equilibrio poco común. ');
INSERT INTO `cervezas` VALUES (3,'Cornet','cornet.png',8.5,'Rubia','Strong Blond','De color dorado y sutil sabor a madera, refinado y peculiar. Sensación en boca como un vino de crianza roble. Con cuerpo, toque a roble, equilibrio entre la frutosidad de la levadura y la dulzura de la vainilla.');
INSERT INTO `cervezas` VALUES (4,'Montaraz','montaraz.png',5.3,'Rubia','Weizen-Weissbier','La primera creación de cervezas Montaraz, una cerveza rubia de trigo, suave, refrescante y con ligero aroma a plátano. Una cerveza artesana, elaborada en el Bierzo.');
INSERT INTO `cervezas` VALUES (5,'Ruda', 'ruda.jpg', 5.0, 'Tostada', 'Pale Ale' ,'Color ámbar y densa espuma, ligeramente amarga y notas dulces maltosas.');
INSERT INTO `cervezas` VALUES (6,'3 Cumbres', '3cumbres.png', 4.5, 'Rubia', 'Lager' ,'De color claro, es ligera, suave y muy refrescante que está elaborada siguiendo la Ley de la Pureza Alemana. Una cerveza ideal para cualquier momento y ocasión.');
INSERT INTO `cervezas` VALUES (7,'Berzaga', 'berzaga.jpg', 5.0, 'Tostada', 'Amber Ale' ,'Cerveza artesana tostada al estilo Inglés. Fácil de beber y baja carbonatación. Elaborada con una selección de cuatro maltas, muestra cierto dulzor inicial seguido de un sabor caramelizado que finaliza con toques tostados y un suave amargor en boca, fruto de los lúpulos balanceados en tiempo de cocción.');
INSERT INTO `cervezas` VALUES (8,'Tormenta Solar', 'baixer-tormenta-solar.jpg', 6.5 , 'Naranja pálido', 'Saison' ,'Cerveza de estilo Saison con auténtica levadura Saison. Estilo tipicamente belga de granja, en este caso con lúpulo neozelandés Nelson Sauvín, una combinación interesante de los sabores afrutados aportados por la levadura y los sabores y aromas tropicales y de vino blanco de este lúpulo, añadido en whirpool.');
INSERT INTO `cervezas` VALUES (9,'Perraborracha', 'perraborracha.png', 4.6 , 'Ambar', 'American Pale Ale' ,'American Pale Ale fresquita y sin complicaciones, amarga poco y es muy fácil de beber.');
INSERT INTO `cervezas` VALUES (10,'Barreno', 'barreno.png', 8.8 , 'Negra', 'Stout' ,'Cerveza negra, con aromas y sabor a café, regaliz, chocolate toque licoroso que da paso a ligero lúpulo. Cuerpo medio-completo. Amarga.');



commit;



INSERT INTO `notas` VALUES ( 1, NOW(), 'Bastante buena', 'Esta cerveza es una referencia.',1, 1, 5);