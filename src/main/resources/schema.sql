
drop table if exists usuarios;
drop table if exists roles;
drop table if exists usuarios_roles;

create table usuarios (
   id        integer not null,
   login     varchar(255) not null,
   password  varchar(255) not null,
   nombre    varchar(255) not null,
   primary key(id),
   unique key login_unique (login)
);


create table roles (
  id_rol    integer not null,
  nombre    VARCHAR(30) not null,
  primary key (id_rol),
  unique key rol_unique (nombre)
);


create table usuarios_roles (
  id           integer not null,
  id_usuario   integer not null,
  id_rol       integer not null,
  primary key ( id ),
  unique key rol_usuario_unique (id_usuario,id_rol) 
  
);

ALTER TABLE usuarios_roles
    ADD FOREIGN KEY (id_usuario) 
    REFERENCES usuarios(id);
	
ALTER TABLE usuarios_roles
    ADD FOREIGN KEY (id_rol) 
    REFERENCES roles(id_rol);	
	

