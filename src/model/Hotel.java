package model;

public class Hotel{
	Integer id;
	String cidade;
	Integer cidadeId;
	String nome;
	Float avaliacao;
	Integer ndias;
	
	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	Integer preco;
	String descricao;
	
	public Hotel(int id,String cidade,int cidadeId, int preco, String nome, float avaliacao, String descricao, Integer ndias) {
		super();
		this.id = id;
		this.nome = nome;
		this.avaliacao = avaliacao;
		this.descricao = descricao;
		this.cidade = cidade;
		this.cidadeId = cidadeId;
		this.preco = preco;
		this.ndias = ndias;
	}

	public int getId() {
		return id;
	}

	public String getCidade() {
		return cidade;
	}

	public String getNome() {
		return nome;
	}

	/**
	 * @return the avaliacao
	 */
	public float getAvaliacao() {
		return avaliacao;
	}

	public int getPreco() {
		return preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getNdias() {
		return ndias;
	}
	
}
