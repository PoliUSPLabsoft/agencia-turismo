package model;


public class Cliente {
	private int id;
	private String  nome, cpf, endereco, telefone, genero;
	
	public Cliente(int id, String nome, String cpf, String endereco, String telefone, String genero) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.genero = genero;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getGenero() {
		return genero;
	}

}