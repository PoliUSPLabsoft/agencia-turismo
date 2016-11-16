package model;

public class Hotel {
	int id;
	String cidade;
	int cidadeId;
	String nome;
	float avaliacao;
	int preco;
	String descricao;
	
	public Hotel(int id,String cidade,int cidadeId, int preco, String nome, float avaliacao, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.avaliacao = avaliacao;
		this.descricao = descricao;
		this.cidade = cidade;
		this.cidadeId = cidadeId;
		this.preco = preco;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the avaliacao
	 */
	public float getAvaliacao() {
		return avaliacao;
	}

	/**
	 * @return the preco
	 */
	public int getPreco() {
		return preco;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	
	
}
