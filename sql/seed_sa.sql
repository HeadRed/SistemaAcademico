use sistema_academico;
insert into curso values
	(0, 'Engenharia da Computação'),
	(1, 'Rede de Computadores'),
	(2, 'Sistemas para Internet');
	
insert into professor values 
	('lucas@professor', 'lucas', 'Lucas Cruz'),
	('quele@professor', 'quele', 'Quele Rodrigues'),
	('thiago@professor', 'thiago', 'Thigo Alguma Coisa'),
	('ronedo@professor', 'ronedo', 'Ronedo Sa'),
	('allan@professor', 'allan', 'Allan David'),
	('marco@professor', 'marco', 'Marco Antônio'),
	('bacana@professor', 'bacana', 'Bacana Alguma Coisa');
	
insert into disciplina values
	(0,	'Logica Matematica',		60, 5, 0, 'quele@professor'),
	(1,	'Sistemas Operacionais',	60, 5, 0, 'lucas@professor'),
	(2, 'Rede de Computadores I',	60, 5, 0, 'marco@professor'),	
	(3, 'Banco de Dados I',			60, 5, 0, 'allan@professor'),
	(4, 'Circuitos Eletricos I',	60, 5, 0, 'thiago@professor'),
	(5, 'Economia',					60, 5, 0, 'bacana@professor'),
	(6, 'Rede de Computadores I',	60, 1, 1, 'marco@professor'),
	(7, 'Logica de programacao I',	60, 1, 1, 'marco@professor'),
	(8, 'Rede de Computadores I',	60, 1, 1, 'marco@professor'),
	(9, 'Banco de dados I',			60, 1, 2, 'marco@professor'),
	(10, 'Rede de Computadores I',	60, 1, 2, 'marco@professor'),
	(11, '"Programação" WEB',		60, 1, 2, 'marco@professor');
	
insert into turma values
	(0, 1, 0),
	(1, 2, 0),
	(2, 3, 0),
	(3, 4, 0),
	(4, 5, 0),
	(5, 1, 1),
	(6, 1, 2);
	
insert into aluno values
	('paulo@aluno', 'paulo', 'Paulo Henrique', 4),
	('matheus@aluno', 'matheus', 'Matheus Mendes', 4),
	('lucas@aluno', 'lucas', 'Lucas Almeida', 4),
	('argerio@aluno', 'argerio', 'Argerio Queiroz', 4),
	('renan@aluno', 'renan', 'Renan Albuquerque', 4),
	('lohran@aluno', 'lohran', 'Lohran Albuquerque', 4),
	('jose@aluno', 'jose', 'Jose Augusto', 4);
	
insert into tarefa values
	(0, 'Calcular a massa do Sol', false, 'thiago@professor', 4, 4),
	(1, 'Engenharia reversa do windows', false, 'lucas@professor', 4, 1);