package model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import DAO.TransporteDAO;

public class Roteiro implements Serializable {
	private static final long serialVersionUID = -7121797199679360740L;
	Integer id;
	Integer nCidades;
	Cliente cliente;
	Cidade cidadeNatal;
	List<Cidade> cidades;
	List<Hotel> hoteis;
	List<String> cidadeIds;
	List<Transporte> transportes;
	HashMap<Cidade, Hotel> hospedagem;
	String name;
	int formaPagamento;
	
	public Roteiro(){
		this.cidades = new ArrayList<>();
		this.hoteis = new ArrayList<>();
		this.cidadeIds = new ArrayList<>();
		this.transportes = new ArrayList<>();
	}
	
	public Roteiro(int id, String nome, int nCidades){
		this();
		this.setId(id);
		this.setName(nome);
		this.setnCidades(nCidades);
	}
	
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	public void setTransportes(List<Transporte> transportes) {
		this.transportes = transportes;
	}
	public int getId() {
		return id;
	}
	
	public Integer getnCidades() {
		return nCidades;
	}

	public void setnCidades(Integer nCidades) {
		this.nCidades = nCidades;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}
	public List<Transporte> getTransportes() {
		return transportes;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public List<String> getCidadeIds() {
		return cidadeIds;
	}

	public void setCidadeIds(String[] cidadeIds) {
		this.cidadeIds = Arrays.asList(cidadeIds);
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public HashMap<Cidade, Hotel> getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(HashMap<Cidade, Hotel> hospedagem) {
		this.hospedagem = hospedagem;
	}

	public List<Hotel> getHoteis() {
		return hoteis;
	}

	public void setHoteis(List<Hotel> hoteis) {
		this.hoteis = hoteis;
	}
	
	public Cidade getCidadeNatal() {
		return cidadeNatal;
	}

	public void setCidadeNatal(Cidade cidadeNatal) {
		this.cidadeNatal = cidadeNatal;
	}

	public Cidade getCidadeById(int k){
		for(Cidade cidade: cidades)
			if(cidade.getId() == k)
				return cidade;
		return null;
	}
	
	public Hotel getHotelById(int k){
		for(Hotel hotel: hoteis)
			if(hotel.getId() == k)
				return hotel;
		return null;
	}
	
	public void setTransporte(int[] ids, int valor) throws SQLException{
		Transporte transporte = (new TransporteDAO()).getTransporteById(valor);
		transporte.setFrom(cidades.get(ids[0]));
		transporte.setTo(cidades.get(ids[1]));
		cidades.get(ids[0]).setPartida(transporte);
		cidades.get(ids[1]).setChegada(transporte);
		
		transportes.add(transporte);
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPreco(){
		int i, preco = 0;
		Cidade cidade;
		for(i = 0; i < cidades.size(); i++){
			cidade = cidades.get(i);
			if (cidade.getHotel() != null)
				preco += cidade.getHotel().getPreco() * cidade.getHotel().getNdias();
			if (cidade.getPartida() != null)
				preco += cidade.getPartida().getPreco();
		} return preco;
	}

	public int getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(int formaPagamento) {
		this.formaPagamento = formaPagamento;
	}	
}
