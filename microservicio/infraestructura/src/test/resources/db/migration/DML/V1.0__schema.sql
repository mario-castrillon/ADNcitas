create table cita (
 id int(11) not null auto_increment,
 idPaciente int(11) not null,
 idEspecialista int(11) not null,
 fecha datetime null,
 primary key (id)
);

create table especialista(
    idEspecialista int(11) not null auto_increment,
    nombreEspecialista varchar(99) not null,
    especialidad varchar(99) not null,
    tarifa int(33) not null,
    maximoDiasAgendables int(33) not null,
    primary key (idEspecialista)

);

create table paciente(
    idPaciente int(11) not null auto_increment,
    nombrePaciente varchar(99) not null,
    cedula varchar(99) not null,
    primary key (idPaciente)
);