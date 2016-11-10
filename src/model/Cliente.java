package model;


public class Cliente {
	private int id, cidadeId;
	private String  nome, cpf, endereco, telefone, genero;
	
	public Cliente(int id, String nome, int cidadeId, String cpf, String endereco, String telefone, String genero) {
		this.id = id;
		this.nome = nome;
		this.cidadeId = cidadeId;
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
	
	public int getCidadeId() {
		return cidadeId;
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