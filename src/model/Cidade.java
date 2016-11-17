package model;

import java.io.Serializable;

public class Cidade implements Serializable{
	
	Integer id;
	String nome;
	Float avaliacao;
	String descricao;
	Transporte chegada, partida;
	Hotel hotel;
	Integer nDias;
	
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
	
	public Transporte getChegada() {
		return chegada;
	}

	public void setChegada(Transporte chegada) {
		this.chegada = chegada;
	}

	public Transporte getPartida() {
		return partida;
	}

	public void setPartida(Transporte partida) {
		this.partida = partida;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAvaliacao(float avaliacao) {
		this.avaliacao = avaliacao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setnDias(int nDias) {
		this.nDias = nDias;
	}
	
	
}
