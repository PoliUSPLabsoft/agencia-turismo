CREATE TABLE cidade(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(64) NOT NULL,
	avaliacao DECIMAL(3, 2),
	descricao TEXT
);

INSERT INTO cidade (nome, avaliacao, descricao) VALUES ("S�o Paulo", 6.2, "A capital paulista � um dos poucos lugares capazes de mesclar harmoniosamente modernidade e hist�ria. J� foi palco de acontecimentos marcantes que envolvem desde as margens do Ipiranga, passando por revolu��es pol�ticas, culturais e protestos em favor da democracia. Abriga centenas de cinemas, museus, teatros, �reas de patrim�nio hist�rico-cultural, parques, casas de espet�culos, parques tem�ticos, restaurantes, bares, hot�is, espa�os para eventos, feiras, shopping centers, ruas de com�rcio especializado.");
INSERT INTO cidade (nome, avaliacao, descricao) VALUES ("Rio de Janeiro", 8.2, "O Rio � uma cidade de contrastes: a arquitetura colonial lembra o passado enquanto que os vistosos edif�cios modernos d�o uma vis�o do futuro. Dois marcos, verdadeiros cart�es postais, s�o conhecidos no mundo inteiro: o P�o de A��car e a est�tua do Cristo Redentor. Como destino tur�stico, o Rio n�o depende das esta��es, uma vez que o clima � temperado o ano todo e suas atra��es podem ser apreciadas praticamente em qualquer �poca do ano.");
INSERT INTO cidade (nome, avaliacao, descricao) VALUES ("Nova York", 9.0, "Nova York, a mais rica e influente cidade do planeta pulsa dinamismo e agito cultural. Voc� j� viu essas ruas, pra�as e edif�cios em dezenas de filmes, mas uma visita in loco � sempre um encontro com o inusitado e o fascinante. � impressionante perceber que a verticalidade de seus arranha-c�us, como o Empire State Building, combina perfeitamente com as linhas horizontais da Brooklyn Bridge ou os gramados do Central Park. Os musicais nas casas ao longo da Broadway complementam a grandiosidade de super-museus como o MoMA, o Metropolitan e o New Museum ou os disputados eventos esportivos em templos sagrados como o Yankee Stadium e o Madison Square Garden.");
INSERT INTO cidade (nome, avaliacao, descricao) VALUES ("Amsterd�", 9.5, "Para os tradicionais, um passeio de bicicleta por entre os mais de cem canais e milhares de pequenas pontes; para os agitados, uma vida noturna intensa e diversificada, reunindo pessoas de todos os cantos do mundo; para os culturais, museus de todos os tipos, de todos os gostos, se espalham pela cidade; para os mais curiosos, a possibilidade de experimentar legalmente liberdades restritas na maioria dos pa�ses; j� os ecl�ticos podem aproveitar um pouco disso tudo e muito mais da capital holandesa, muitas vezes apontada como exemplo de sociedade evolu�da.");
INSERT INTO cidade (nome, avaliacao, descricao) VALUES ("Caracas", 7.6, "Uma das coisas que chamam a aten��o, visualmente, ao chegar em Bogot� � o contraste entre os tijolos vermelhos predominantes nas constru��es e o verde das montanhas que cercam a capital. Tamb�m se destaca o fato de a cidade fundada em 1538 por espanh�is n�o ter tantos pr�dios altos, sendo poss�vel admirar, de praticamente qualquer ponto, as cordilheiras em seu entorno. � um centro urbano, mas sua geografia o ajuda a parecer mais generoso que a maioria deles.");

DROP TABLE cliente;

CREATE TABLE cliente(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	password VARCHAR(16),
	cidade_id INT,
	nome VARCHAR(128),
	cpf VARCHAR(16),
	endereco VARCHAR(128),
	telefone VARCHAR(16),
	genero VARCHAR(16)
);

ALTER TABLE cliente ADD CONSTRAINT cpf_check CHECK (cpf LIKE "[0-9]{9}-[0-9]{2}");
ALTER TABLE cliente ADD CONSTRAINT cpf_telefone CHECK (telefone LIKE "(\+\d{1,3})?(\(\d{2}\))?\d{4,5}-\d{4}");

INSERT INTO cliente(nome, password, cidade_id, cpf, endereco, telefone, genero) VALUES ("Julio Prestes", "123", 1, "2465432155-00", "Av. Ang�lica, 1299", "(41)92013-1200", "Masculino");
INSERT INTO cliente(nome, password, cidade_id, cpf, endereco, telefone, genero) VALUES ("Camila Dolores", "123", 2, "395201192-56", "Av. Dr. Arnaldo, 425", "(11)4968-2345", "Feminino");
INSERT INTO cliente(nome, password, cidade_id, cpf, endereco, telefone, genero) VALUES ("Robson Caetano", "123", 3, "593212974-44", "Av. Almeida Prado, 66", "(11)9038-3948", "Masculino");
INSERT INTO cliente(nome, password, cidade_id, cpf, endereco, telefone, genero) VALUES ("Marcela Gimenez", "123", 1, "050686409-34", "Rua Eng. Oscar Baidu, 877", "(90)2939-4566", "Feminino");
INSERT INTO cliente(nome, password, cidade_id, cpf, endereco, telefone, genero) VALUES ("Ruan Crispaldo", "123", 2, "050.686.409-34", "Rua Eng. Oscar Baidu, 877", "(90)2939-4566", "Feminino");

CREATE TABLE transporte(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	cidade_from_id INT,
	cidade_to_id INT,
	nome VARCHAR(128),
	tipo VARCHAR(16),
	chegada DATETIME,
	partida DATETIME,
	preco INT
);

INSERT INTO transporte(cidade_from_id, cidade_to_id, nome, tipo, chegada, partida, preco) VALUES (1, 2, "STL-500", "Avi�o", "2016-11-13 13:54:00", "2016-11-14 13:54:00", 350);
INSERT INTO transporte(cidade_from_id, cidade_to_id, nome, tipo, chegada, partida, preco) VALUES (2, 3, "Scania 900", "�nibus", "2016-11-13 17:34:00", "2016-12-14 13:54:00", 400);
INSERT INTO transporte(cidade_from_id, cidade_to_id, nome, tipo, chegada, partida, preco) VALUES (3, 1, "MSC-437", "Navio", "2016-11-13 12:00:00", "2016-12-15 13:00:00", 400);

CREATE TABLE hotel( 
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	cidade_id INT NOT NULL,
	preco INT,
	nome varchar(64),
	avaliacao DECIMAL(3, 2),
	descricao TEXT
	);

INSERT INTO hotel(cidade_id, preco, nome, avaliacao, descricao) VALUES (1, 500, "Itamar Franco", 9.7, "Hotel maravilhoso");
INSERT INTO hotel(cidade_id, preco, nome, avaliacao, descricao) VALUES (1, 90, "Ibiramar", 4.7, "Hotel razo�vel");
INSERT INTO hotel(cidade_id, preco, nome, avaliacao, descricao) VALUES (2, 300, "Ubirajara", 7.6, "Lindo despertar");
INSERT INTO hotel(cidade_id, preco, nome, avaliacao, descricao) VALUES (2, 150, "Canto do p�ssaro", 6.9, "Caf� da manh� maravilhoso");
INSERT INTO hotel(cidade_id, preco, nome, avaliacao, descricao) VALUES (3, 520, "Estalero", 9.6, "Extremamente receptivo");
INSERT INTO hotel(cidade_id, preco, nome, avaliacao, descricao) VALUES (3, 400, "Cruzeiro do Sul", 5.0, "Sempre recomendado");

CREATE TABLE roteiro(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	cliente_id int,
	nome varchar (128)
	);

INSERT INTO roteiro (cliente_id) VALUES (1);
INSERT INTO roteiro (cliente_id) VALUES (10);

CREATE TABLE estadia(
	roteiro_id int,
	cidade_id int,
	posicao int
	);

INSERT INTO estadia (roteiro_id, cidade_id, posicao) VALUES(1, 1, 0);
INSERT INTO estadia (roteiro_id, cidade_id, posicao) VALUES(1, 2, 1);
INSERT INTO estadia (roteiro_id, cidade_id, posicao) VALUES(1, 3, 2);
INSERT INTO estadia (roteiro_id, cidade_id, posicao) VALUES(1, 4, 3);

CREATE TABLE viagem(
	roteiro_id int,
	cidade_from int,
	cidade_to int,
	transporte_id int
	);

CREATE TABLE hospedagem(
	roteiro_id int,
	posicao int,
	hotel_id int,
	ndias int
	);
