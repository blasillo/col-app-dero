insert into usuarios values(10001,'admin', 'admin','Administrador');
insert into usuarios values(10002,'usuario', 'usuario', 'Usuario');


insert into roles values ( 101, 'ADMINISTRADOR');
insert into roles values ( 201, 'USUARIO');



insert into usuarios_roles values ( 1, 10001, 101 );
insert into usuarios_roles values ( 2, 10002, 201 );


