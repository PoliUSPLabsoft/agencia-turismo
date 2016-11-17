package model;

import java.io.Serializable;

public class Hotel implements Serializable{
	Integer id;
	String cidade;
	Integer cidadeId;
	String nome;
	Float avaliacao;
	Integer preco;
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
