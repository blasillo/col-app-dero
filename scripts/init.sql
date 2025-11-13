-- Crear base de datos y usuario
CREATE DATABASE IF NOT EXISTS colappdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE colappdb;

CREATE USER IF NOT EXISTS 'colapp'@'%' IDENTIFIED BY 'c0lapp!p4$$wd';
GRANT ALL PRIVILEGES ON colappdb.* TO 'colapp'@'%';
FLUSH PRIVILEGES;

-- Tabla Cervezas
CREATE TABLE Cervezas (
                          id INT AUTO_INCREMENT,
                          nombre VARCHAR(50) NOT NULL,
                          imagen VARCHAR(200),
                          alcohol FLOAT,
                          color VARCHAR(50),
                          categoria VARCHAR(200),
                          descripcion VARCHAR(1024),
                          PRIMARY KEY (id)
);

-- Tabla Usuarios
CREATE TABLE Usuarios (
                          id INT AUTO_INCREMENT,
                          email VARCHAR(200) NOT NULL,
                          password VARCHAR(200) NOT NULL,
                          password_hash VARCHAR(200),
                          nombre VARCHAR(200) NOT NULL,
                          rol VARCHAR(64) DEFAULT 'USUARIO',
                          PRIMARY KEY (id)
);

-- Tabla Notas
CREATE TABLE Notas (
                       id INT AUTO_INCREMENT,
                       creado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       titulo VARCHAR(200) NOT NULL,
                       contenido VARCHAR(200) NOT NULL,
                       publico TINYINT(1) DEFAULT NULL,
                       usuarioid INT NOT NULL,
                       cervezaid INT NOT NULL,
                       PRIMARY KEY (id),
                       CONSTRAINT fk_usuarioid FOREIGN KEY (usuarioid) REFERENCES Usuarios(id) ON DELETE CASCADE,
                       CONSTRAINT fk_cervezaid FOREIGN KEY (cervezaid) REFERENCES Cervezas(id) ON DELETE CASCADE
);

-- Trigger para generar hash MD5 (equivalente al de Oracle)
DELIMITER //
CREATE TRIGGER trg_calcular_password_hash
    BEFORE INSERT ON Usuarios
    FOR EACH ROW
BEGIN
    SET NEW.password_hash = LOWER(MD5(NEW.password));
END;
//
DELIMITER ;

-- Inserciones iniciales

INSERT INTO Usuarios (id, email, password, password_hash, nombre, rol) VALUES
                                                                           (1, 'administrador-colapp@jcyl.es', 'supersecreto', MD5('supersecreto'), 'Administrador', 'ADMINISTRADOR'),
                                                                           (2, 'TorGomRo@jcyl.es', 'TorGomRo', MD5('TorGomRo'), 'Roberto Torres', 'USUARIO'),
                                                                           (3, 'NecSotGa@jcyl.es', 'NecSotGa', MD5('NecSotGa'), 'Gabriel Necedes', 'USUARIO'),
                                                                           (4, 'LopGarIo@jcyl.es', 'LopGarIo', MD5('LopGarIo'), 'Iovani Lopez', 'USUARIO');

INSERT INTO Cervezas (id, nombre, imagen, alcohol, color, categoria, descripcion) VALUES
                                                                                      (1,'Duvel','duvel.png',8.5,'Rubia','Strong Blond','Cerveza especial belga de alta fermentación, con segunda fermentación en botella. Aromas afrutados, evocando el olor a pera y manzana.'),
                                                                                      (2,'Chimay Triple','chimay_triple.png',8,'Rubia','Triple Trappist','La cerveza de Triple de Chimay es la más reciente de la abadía de un color dorado, la cerveza trapense combina el sabor dulce y amargo en un equilibrio poco común.'),
                                                                                      (3,'Cornet','cornet.png',8.5,'Rubia','Strong Blond','De color dorado y sutil sabor a madera, refinado y peculiar. Sensación en boca como un vino de crianza roble. Con cuerpo, toque a roble, equilibrio entre la frutosidad de la levadura y la dulzura de la vainilla.'),
                                                                                      (4,'Montaraz','montaraz.png',5.3,'Rubia','Weizen-Weissbier','La primera creación de cervezas Montaraz, una cerveza rubia de trigo, suave, refrescante y con ligero aroma a plátano. Una cerveza artesana, elaborada en el Bierzo.'),
                                                                                      (5,'Ruda', 'ruda.jpg', 5.0, 'Tostada', 'Pale Ale' ,'Color ámbar y densa espuma, ligeramente amarga y notas dulces maltosas.'),
                                                                                      (6,'3 Cumbres', '3cumbres.png', 4.5, 'Rubia', 'Lager' ,'De color claro, es ligera, suave y muy refrescante que está elaborada siguiendo la Ley de la Pureza Alemana. Una cerveza ideal para cualquier momento y ocasión.'),
                                                                                      (7,'Berzaga', 'berzaga.jpg', 5.0, 'Tostada', 'Amber Ale' ,'Cerveza artesana tostada al estilo Inglés. Fácil de beber y baja carbonatación. Elaborada con una selección de cuatro maltas, muestra cierto dulzor inicial seguido de un sabor caramelizado que finaliza con toques tostados y un suave amargor en boca, fruto de los lúpulos balanceados en tiempo de cocción.'),
                                                                                      (8,'Tormenta Solar', 'baixer-tormenta-solar.jpg', 6.5 , 'Naranja pálido', 'Saison' ,'Cerveza de estilo Saison con auténtica levadura Saison. Estilo típicamente belga de granja, con lúpulo neozelandés Nelson Sauvín.'),
                                                                                      (9,'Perraborracha', 'perraborracha.png', 4.6 , 'Ámbar', 'American Pale Ale' ,'American Pale Ale fresquita y sin complicaciones, amarga poco y es muy fácil de beber.'),
                                                                                      (10,'Barreno', 'barreno.png', 8.8 , 'Negra', 'Stout' ,'Cerveza negra, con aromas y sabor a café, regaliz y chocolate con toque licoroso.');

INSERT INTO Notas (id, creado, titulo, contenido, publico, usuarioid, cervezaid)
VALUES (1, NOW(), 'Bastante buena', 'Esta cerveza es una referencia.', 1, 1, 1);

INSERT INTO Usuarios (id, email, password, password_hash, nombre, rol)
VALUES (99, 'flag@local', '1234567890', MD5('1234567890'), 'FLAG{inYecCi0n_de5Q1_ENMy5q1_mycomplicada}', 'USUARIO');

