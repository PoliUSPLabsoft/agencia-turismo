package model;

public class Cidade {
	
	int id;
	String nome;
	float avaliacao;
	String descricao;
	
	public Cidade(int id, String nome, float avaliacao, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.avaliacao = avaliacao;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public float getAvaliacao() {
		return avaliacao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
