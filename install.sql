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

INSERT INTO cliente(nome, password, cpf, endereco, telefone, genero) VALUES ("Julio Prestes", "123", "2465432155-00", "Av. Angélica, 1299", "(41)92013-1200", "Masculino");
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

INSERT INTO cidade (nome, avaliacao, descricao) VALUES ("São Paulo", 6.2, "A capital paulista é um dos poucos lugares capazes de mesclar harmoniosamente modernidade e história. Já foi palco de acontecimentos marcantes que envolvem desde as margens do Ipiranga, passando por revoluções políticas, culturais e protestos em favor da democracia. Abriga centenas de cinemas, museus, teatros, áreas de patrimônio histórico-cultural, parques, casas de espetáculos, parques temáticos, restaurantes, bares, hotéis, espaços para eventos, feiras, shopping centers, ruas de comércio especializado.");
INSERT INTO cidade (nome, avaliacao, descricao) VALUES ("Rio de Janeiro", 8.2, "O Rio é uma cidade de contrastes: a arquitetura colonial lembra o passado enquanto que os vistosos edifícios modernos dão uma visão do futuro. Dois marcos, verdadeiros cartões postais, são conhecidos no mundo inteiro: o Pão de Açúcar e a estátua do Cristo Redentor.
Como destino turístico, o Rio não depende das estações, uma vez que o clima é temperado o ano todo e suas atrações podem ser apreciadas praticamente em qualquer época do ano.");
INSERT INTO cidade (nome, avaliacao, descricao) VALUES ("Nova York", 9.0, "Nova York, a mais rica e influente cidade do planeta pulsa dinamismo e agito cultural. Você já viu essas ruas, praças e edifícios em dezenas de filmes, mas uma visita in loco é sempre um encontro com o inusitado e o fascinante. É impressionante perceber que a verticalidade de seus arranha-céus, como o Empire State Building, combina perfeitamente com as linhas horizontais da Brooklyn Bridge ou os gramados do Central Park. Os musicais nas casas ao longo da Broadway complementam a grandiosidade de super-museus como o MoMA, o Metropolitan e o New Museum ou os disputados eventos esportivos em templos sagrados como o Yankee Stadium e o Madison Square Garden.");
INSERT INTO cidade (nome, avaliacao, descricao) VALUES ("Amsterdã", 9.5, "Para os tradicionais, um passeio de bicicleta por entre os mais de cem canais e milhares de pequenas pontes; para os agitados, uma vida noturna intensa e diversificada, reunindo pessoas de todos os cantos do mundo; para os culturais, museus de todos os tipos, de todos os gostos, se espalham pela cidade; para os mais curiosos, a possibilidade de experimentar legalmente liberdades restritas na maioria dos países; já os ecléticos podem aproveitar um pouco disso tudo e muito mais da capital holandesa, muitas vezes apontada como exemplo de sociedade evoluída.");
INSERT INTO cidade (nome, avaliacao, descricao) VALUES ("Caracas", 7.6, "Uma das coisas que chamam a atenção, visualmente, ao chegar em Bogotá é o contraste entre os tijolos vermelhos predominantes nas construções e o verde das montanhas que cercam a capital. Também se destaca o fato de a cidade fundada em 1538 por espanhóis não ter tantos prédios altos, sendo possível admirar, de praticamente qualquer ponto, as cordilheiras em seu entorno. É um centro urbano, mas sua geografia o ajuda a parecer mais generoso que a maioria deles.");

