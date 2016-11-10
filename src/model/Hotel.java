package model;

public class Hotel {
	int id;
	int cidade_id;
	String nome;
	float avaliacao;
	int preco;
	String descricao;
	
	public Hotel(int id,int cidade_id,int preco, String nome, float avaliacao, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.avaliacao = avaliacao;
		this.descricao = descricao;
		this.cidade_id = cidade_id;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public int getCidade_id() {
		return cidade_id;
	}
	
	public int getPreco(){
		return preco;
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
