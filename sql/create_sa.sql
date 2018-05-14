create database sistema_academico;

use sistema_academico;

create table aluno (
	loginUsuario varchar(150) not null primary key,
	loginSenha varchar(150) not null,
	nome varchar(150) not null,
	turma_fk int not null);	
	
create table professor (
	loginUsuario varchar(150) not null primary key,
	loginSenha varchar(150) not null,
	nome varchar(150));
	
create table coordenador (
	professor_fk varchar(150) not null,
	curso_fk varchar(50) not null);
	
create table administrador (
	loginUsuario varchar(150) not null primary key,
	loginSenha varchar(150) not null,
	nome varchar(150) not null);
	
create table curso (
	nome varchar(50) primary key not null);
	
create table disciplina (
	idDisciplina int not null primary key,
	nome varchar(50) not null,
	cargaHoraria int not null,
	semestre int not null,
	curso_fk varchar(50) not null);
	
create table turma (
	idTurma int not null primary key,
	semestre int not null,
	curso_fk varchar(50) not null);
	
create table professorDisciplina (
	professor_fk varchar(150) not null,
	disciplina_fk int not null);
	
create table usuario (
	loginUsuario varchar(150) not null,
	tipoUsuario_fk varchar(20) not null);
	
create table tipoUsuario (
	tipo varchar(20) not null primary key);

create table tarefa (
	idTarefa int primary key not null,
	nome varchar(100) not null,
	concluida boolean not null,
	professor_fk varchar(150) not null,
	turma_fk int not null,
	disciplina_fk int not null);
	
create table tarefaAluno (
	tarefaAluno bigint primary key auto_increment,
	aluno_fk varchar(150) not null,
	tarefa_fk int not null);
	
alter table aluno add foreign key (turma_fk) references turma (idTurma);
alter table usuario add foreign key (tipoUsuario_fk) references tipoUsuario(tipo);
alter table coordenador add foreign key (professor_fk) references professor (loginUsuario);
alter table coordenador add foreign key (curso_fk) references curso (nome);
alter table disciplina add foreign key (curso_fk) references curso (nome);
alter table turma add foreign key (curso_fk) references curso (nome);
alter table professorDisciplina add foreign key (professor_fk) references professor (loginUsuario);
alter table professorDisciplina add foreign key (disciplina_fk) references disciplina (idDisciplina);
alter table tarefa add foreign key (turma_fk) references turma (idTurma);
alter table tarefa add foreign key (disciplina_fk) references disciplina (idDisciplina);
alter table tarefa add foreign key (professor_fk) references professor (loginUsuario);