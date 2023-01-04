create database examen3;
use examen3;


create table clinicas(
	idClinica int not null auto_increment primary key,
    nombClinica varchar (30 )not null,
    empleados int not null,
    encargado varchar(50) not null    
);


create table citas(
	codigo int not null auto_increment primary key,
    nombresPaciente varchar (30)  not null,
    apellidosPaciente varchar (30) not null,
    genero char,
    edad int,
	fechCita date,
    horaCita varchar(6) not null,
    idClinica int not null,    
	foreign key (idClinica) references clinicas (idClinica)
);

-- REGISTROS PARA LA TABLA CLINICAS
insert into clinicas (nombClinica,empleados,encargado) values ('Medicina Natural', 8,'Humberto Gonzalez');
insert into clinicas (nombClinica,empleados,encargado) values ('Pediatría', 5,'Marta Gonzalez');
insert into clinicas (nombClinica,empleados,encargado) values ('Ginecología', 3,'Julissa Flores');
insert into clinicas (nombClinica,empleados,encargado) values ('Odontología', 9,'Mario Quintanilla');
