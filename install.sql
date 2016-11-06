
CREATE TABLE cliente(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(128),
	cpf VARCHAR(16),
	endereco VARCHAR(128),
	telefone VARCHAR(16),
	genero VARCHAR(16),
	
	CONSTRAINT cpf_check CHECK (cpf LIKE "[0-9]{9}-[0-9]{2}"),
	CONSTRAINT cpf_telefone CHECK (telefone LIKE "(\+\d{1,3})?(\(\d{2}\))?\d{4,5}-\d{4}")
);

INSERT INTO cliente(nome, cpf, endereco, telefone, genero) VALUES ("Julio Prestes", "2465432155-00", "Av. Angélica, 1299", "(41)92013-1200", "Masculino")
INSERT INTO cliente(nome, cpf, endereco, telefone, genero) VALUES ("Camila Dolores", "395201192-56", "Av. Dr. Arnaldo, 425", "(11)4968-2345", "Feminino")
INSERT INTO cliente(nome, cpf, endereco, telefone, genero) VALUES ("Robson Caetano", "593212974-44", "Av. Almeida Prado, 66", "(11)9038-3948", "Masculino")
INSERT INTO cliente(nome, cpf, endereco, telefone, genero) VALUES ("Marcela Gimenez", "050686409-34", "Rua Eng. Oscar Baidu, 877", "(90)2939-4566", "Feminino")




