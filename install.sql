CREATE TABLE cliente(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	password VARCHAR(16),
	nome VARCHAR(128),
	cpf VARCHAR(16),
	endereco VARCHAR(128),
	telefone VARCHAR(16),
	genero VARCHAR(16)
);
	
ALTER TABLE cliente ADD CONSTRAINT cpf_check CHECK (cpf LIKE "[0-9]{9}-[0-9]{2}");
ALTER TABLE cliente ADD CONSTRAINT cpf_telefone CHECK (telefone LIKE "(\+\d{1,3})?(\(\d{2}\))?\d{4,5}-\d{4}");

INSERT INTO cliente(nome, password, cpf, endereco, telefone, genero) VALUES ("Julio Prestes", "123", "2465432155-00", "Av. Ang�lica, 1299", "(41)92013-1200", "Masculino");
INSERT INTO cliente(nome, password, cpf, endereco, telefone, genero) VALUES ("Camila Dolores", "123", "395201192-56", "Av. Dr. Arnaldo, 425", "(11)4968-2345", "Feminino");
INSERT INTO cliente(nome, password, cpf, endereco, telefone, genero) VALUES ("Robson Caetano", "123", "593212974-44", "Av. Almeida Prado, 66", "(11)9038-3948", "Masculino");
INSERT INTO cliente(nome, password, cpf, endereco, telefone, genero) VALUES ("Marcela Gimenez", "123", "050686409-34", "Rua Eng. Oscar Baidu, 877", "(90)2939-4566", "Feminino");
INSERT INTO cliente(nome, password, cpf, endereco, telefone, genero) VALUES ("Ruan Crispaldo", "123", "050.686.409-34", "Rua Eng. Oscar Baidu, 877", "(90)2939-4566", "Feminino");

drop table cidade;

CREATE TABLE cidade(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(64) NOT NULL,
	avaliacao DECIMAL(3, 2),
	descricao TEXT
);

INSERT INTO cidade (nome, avaliacao, descricao) VALUES ("S�o Paulo", 6.2, "A capital paulista � um dos poucos lugares capazes de mesclar harmoniosamente modernidade e hist�ria. J� foi palco de acontecimentos marcantes que envolvem desde as margens do Ipiranga, passando por revolu��es pol�ticas, culturais e protestos em favor da democracia. Abriga centenas de cinemas, museus, teatros, �reas de patrim�nio hist�rico-cultural, parques, casas de espet�culos, parques tem�ticos, restaurantes, bares, hot�is, espa�os para eventos, feiras, shopping centers, ruas de com�rcio especializado.");
INSERT INTO cidade (nome, avaliacao, descricao) VALUES ("Rio de Janeiro", 8.2, "O Rio � uma cidade de contrastes: a arquitetura colonial lembra o passado enquanto que os vistosos edif�cios modernos d�o uma vis�o do futuro. Dois marcos, verdadeiros cart�es postais, s�o conhecidos no mundo inteiro: o P�o de A��car e a est�tua do Cristo Redentor.
Como destino tur�stico, o Rio n�o depende das esta��es, uma vez que o clima � temperado o ano todo e suas atra��es podem ser apreciadas praticamente em qualquer �poca do ano.");
INSERT INTO cidade (nome, avaliacao, descricao) VALUES ("Nova York", 9.0, "Nova York, a mais rica e influente cidade do planeta pulsa dinamismo e agito cultural. Voc� j� viu essas ruas, pra�as e edif�cios em dezenas de filmes, mas uma visita in loco � sempre um encontro com o inusitado e o fascinante. � impressionante perceber que a verticalidade de seus arranha-c�us, como o Empire State Building, combina perfeitamente com as linhas horizontais da Brooklyn Bridge ou os gramados do Central Park. Os musicais nas casas ao longo da Broadway complementam a grandiosidade de super-museus como o MoMA, o Metropolitan e o New Museum ou os disputados eventos esportivos em templos sagrados como o Yankee Stadium e o Madison Square Garden.");
INSERT INTO cidade (nome, avaliacao, descricao) VALUES ("Amsterd�", 9.5, "Para os tradicionais, um passeio de bicicleta por entre os mais de cem canais e milhares de pequenas pontes; para os agitados, uma vida noturna intensa e diversificada, reunindo pessoas de todos os cantos do mundo; para os culturais, museus de todos os tipos, de todos os gostos, se espalham pela cidade; para os mais curiosos, a possibilidade de experimentar legalmente liberdades restritas na maioria dos pa�ses; j� os ecl�ticos podem aproveitar um pouco disso tudo e muito mais da capital holandesa, muitas vezes apontada como exemplo de sociedade evolu�da.");
INSERT INTO cidade (nome, avaliacao, descricao) VALUES ("Caracas", 7.6, "Uma das coisas que chamam a aten��o, visualmente, ao chegar em Bogot� � o contraste entre os tijolos vermelhos predominantes nas constru��es e o verde das montanhas que cercam a capital. Tamb�m se destaca o fato de a cidade fundada em 1538 por espanh�is n�o ter tantos pr�dios altos, sendo poss�vel admirar, de praticamente qualquer ponto, as cordilheiras em seu entorno. � um centro urbano, mas sua geografia o ajuda a parecer mais generoso que a maioria deles.");

