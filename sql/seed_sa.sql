use sistema_academico;
insert into curso values
	('Engenharia da Computação'),
	('Rede de Computadores'),
	('Sistemas para Internet');
	
insert into disciplina values
	(0,	'Logica Matematica',		60, 5, 'Engenharia da Computação'),
	(1,	'Sistemas Operacionais',	60, 5, 'Engenharia da Computação'),
	(2, 'Rede de Computadores I',	60, 5, 'Engenharia da Computação'),	
	(3, 'Banco de Dados I',			60, 5, 'Engenharia da Computação'),
	(4, 'Circuitos Eletricos I',	60, 5, 'Engenharia da Computação'),
	(5, 'Economia',					60, 5, 'Engenharia da Computação'),
	(6, 'Rede de Computadores I',	60, 1, 'Rede de Computadores'),
	(7, 'Logica de programacao I',	60, 1, 'Rede de Computadores'),
	(8, 'Rede de Computadores I',	60, 1, 'Rede de Computadores'),
	(9, 'Banco de dados I',			60, 1, 'Sistemas para Internet'),
	(10, 'Rede de Computadores I',	60, 1, 'Sistemas para Internet'),
	(11, '"Programação" WEB',		60, 1, 'Sistemas para Internet');
	
insert into tipoUsuario values 
	('aluno'),
	('professor'),
	('administrador');
	
insert into turma values
	(0, 1, 'Engenharia da Computação'),
	(1, 2, 'Engenharia da Computação'),
	(2, 3, 'Engenharia da Computação'),
	(3, 4, 'Engenharia da Computação'),
	(4, 5, 'Engenharia da Computação'),
	(5, 1, 'Rede de Computadores'),
	(6, 1, 'Sistemas para Internet');
	
insert into aluno values
	('paulo@aluno', 'paulo', 'Paulo Henrique', 4),
	('matheus@aluno', 'matheus', 'Matheus Mendes', 4),
	('lucas@aluno', 'lucas', 'Lucas Almeida', 4),
	('argerio@aluno', 'argerio', 'Argerio Queiroz', 4),
	('renan@aluno', 'renan', 'Renan Albuquerque', 4),
	('lohran@aluno', 'lohran', 'Lohran Albuquerque', 4),
	('jose@aluno', 'jose', 'Jose Augusto', 4);
	
insert into professor values 
	('lucas@professor', 'lucas', 'Lucas Cruz'),
	('quele@professor', 'quele', 'Quele Rodrigues'),
	('thiago@professor', 'thiago', 'Thigo Alguma Coisa'),
	('ronedo@professor', 'ronedo', 'Ronedo Sa'),
	('allan@professor', 'allan', 'Allan David'),
	('marco@professor', 'marco', 'Marco Antônio'),
	('bacana@professor', 'bacana', 'Bacana Alguma Coisa');
	
insert into professorDisciplina values
	('lucas@professor', 1),
	('marco@professor', 2),
	('allan@professor', 3),
	('thiago@professor', 4),
	('quele@professor', 0),
	('bacana@professor', 5);
	
insert into usuario values
	('paulo@aluno', 'aluno'),
	('matheus@aluno', 'aluno'),
	('lucas@aluno', 'aluno'),
	('argerio@aluno', 'aluno'),
	('renan@aluno', 'aluno'),
	('lohran@aluno', 'aluno'),
	('jose@aluno', 'aluno');
	
insert into tarefa values
	(0, 'Calcular a massa do Sol', false, 'thiago@professor', 4, 4),
	(1, 'Engenharia reversa do windows', false, 'lucas@professor', 4, 1);