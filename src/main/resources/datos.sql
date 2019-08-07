

INSERT INTO Usuarios VALUES (1, "administrador-colapp@jcyl.es", "supersecreto", "Administrador");
INSERT INTO Usuarios VALUES (2, "TorGomRo@jcyl.es", "TorGomRo", "Roberto Torres");
INSERT INTO Usuarios VALUES (3, "NecSotGa@jcyl.es", "NecSotGa", "Gabriel Necedes");
INSERT INTO Usuarios VALUES (4, "LopGarIo@jcyl.es", "LopGarIo", "Iovani Lopez");

commit;

INSERT INTO `Cervezas` VALUES (1,'Duvel','duvel.png',8.5,'Rubia','Strong Blond','Cerveza especial belga de alta fermentación, con segunda fermentación en botella. Aromas afrutados, evocando el olor a pera y manzana.');
INSERT INTO `Cervezas` VALUES (2,'Chimay Triple','chimay_triple.png',8,'Rubia','Triple Trappist','La cerveza de Triple de Chimay es la más reciente de la abadía de un color dorado, la cerveza trapense combina el sabor dulce y amargo en un equilibrio poco común. ');
INSERT INTO `Cervezas` VALUES (3,'Cornet','cornet.png',8.5,'Rubia','Strong Blond','De color dorado y sutil sabor a madera, refinado y peculiar. Sensación en boca como un vino de crianza roble. Con cuerpo, toque a roble, equilibrio entre la frutosidad de la levadura y la dulzura de la vainilla.');
INSERT INTO `Cervezas` VALUES (4,'Montaraz','montaraz.jpg',5.3,'Rubia','Weizen-Weissbier','La primera creación de cervezas Montaraz, una cerveza rubia de trigo, suave, refrescante y con ligero aroma a plátano. Una cerveza artesana, elaborada en el Bierzo.');
INSERT INTO `Cervezas` VALUES (5,'Ruda', 'ruda.jpg', 5.0, 'Tostada', 'Pale Ale' ,'Color ámbar y densa espuma, ligeramente amarga y notas dulces maltosas.');
commit;



INSERT INTO `Notas` VALUES ( 1, NOW(), 'Bastante buena', 'Esta cerveza es una referencia.',1, 1, 5); 