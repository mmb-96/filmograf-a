create database cine;
use cine;

create table pelicula (director VARCHAR(128), titulo VARCHAR(128) ,fecha DATETIME);
alter table pelicula add constraint PK_Pelicula primary key (titulo, fecha);
insert pelicula value ('Manuel','Hola', '1996-02-06');
insert pelicula value ('Pepe','mundo', sysdate());

create table usuarios (users VARCHAR(128) primary key, pass VARCHAR(128));
insert usuarios value ('admin','admin');

commit;