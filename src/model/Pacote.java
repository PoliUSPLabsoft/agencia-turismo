package model;

import java.util.List;
import java.util.Map;

public class Pacote {
	private List<Cidade> cidades;
	private Map<Cidade, Integer> hospedagem;
	private Map<Cidade, Hotel> hoteis;
	private List<Transporte> transportes;
	
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	public Map<Cidade, Integer> getHospedagem() {
		return hospedagem;
	}
	public void setHospedagem(Map<Cidade, Integer> hospedagem) {
		this.hospedagem = hospedagem;
	}
	public Map<Cidade, Hotel> getHoteis() {
		return hoteis;
	}
	public void setHoteis(Map<Cidade, Hotel> hoteis) {
		this.hoteis = hoteis;
	}
	public List<Transporte> getTransportes() {
		return transportes;
	}
	public void setTransportes(List<Transporte> transportes) {
		this.transportes = transportes;
	}
}
