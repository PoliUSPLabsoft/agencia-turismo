package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Cidade;
import model.Hotel;
import model.Roteiro;
import model.Transporte;

public class RoteiroDAO extends DAO {
	
	
	public Roteiro getRoteiroById(int id) throws SQLException {
		CidadeDAO cidadeDAO = new CidadeDAO();
		TransporteDAO transporteDAO = new TransporteDAO();
		HotelDAO hotelDAO = new HotelDAO();
		Roteiro roteiro = new Roteiro();
		
		roteiro.setId(id);
		String roteiroSql = "SELECT * FROM roteiro WHERE id = " + id;
		ResultSet resultSet = execute(roteiroSql);
		String roteiroName = null;
		if (resultSet.next())
			roteiroName = resultSet.getString("nome");
		
		roteiro.setName(roteiroName);
		
		String estadiaSql = "SELECT cidade_id FROM estadia WHERE roteiro_id = " + id + " ORDER BY posicao ASC";
		resultSet = execute(estadiaSql);
		List<String> cidadesIds = new ArrayList<String>();
		
		//get cidades
		while(resultSet.next()) {
			cidadesIds.add(resultSet.getString("cidade_id"));
		}
		String[] cidadesStringIds = new String[cidadesIds.size()];
		List<Cidade> cidades = cidadeDAO.getCidades(cidadesIds.toArray(cidadesStringIds));
		roteiro.setCidades(cidades);
		
		//get transportes
		String viagemSql = "SELECT * FROM viagem WHERE roteiro_id = " + id +  " ORDER BY cidade_from";
		ResultSet resultSetViagem = execute(viagemSql);
		List<Transporte> transportes = new ArrayList<Transporte>();
		while (resultSetViagem.next()) {
			String transporteId = resultSetViagem.getString("transporte_id");
			Transporte transporte = transporteDAO.getTransporteById(new Integer(transporteId));
			transportes.add(transporte);
		}
		
		//get hoteis
		String hotelSql = "SELECT * FROM hospedagem WHERE roteiro_id = " + id + " ORDER BY posicao"; 
		ResultSet resultSetHotel = execute(hotelSql);
		List<Hotel> hoteis = new ArrayList<Hotel>();
		while(resultSetHotel.next()) {
			String hotelIdString = resultSetHotel.getString("hotel_id");
			int hotelId = new Integer(hotelIdString);
			Hotel hotel = hotelDAO.getHotelById(hotelId);
			hoteis.add(hotel);
		}
		roteiro.setHoteis(hoteis);
		
		return roteiro;
		}

	public Map<Integer, Roteiro> getRoteiros() throws SQLException {
		Map<Integer, Cidade> cidades = new HashMap<Integer, Cidade>();
		Map<Integer, Hotel> hoteis = new HashMap<Integer, Hotel>();
		Map<Integer, Transporte> transportes = new HashMap<Integer, Transporte>();
		Map<Integer, Integer> idPosicao = new HashMap<Integer, Integer>();
		
		Map<Integer, Roteiro> roteiros = new HashMap<>();
		Cidade cidade;
		Hotel hotel;
		Transporte transporte;
		
		//Coleta dos roteiros
		String sql = "SELECT r.id, r.nome, r.preco, COUNT(e.roteiro_id) AS n_cidades "
				+ " FROM roteiro r"				
				+ " INNER JOIN estadia e ON e.roteiro_id = r.id"
				+ " GROUP BY e.roteiro_id"
				+ " ORDER BY preco asc";
		ResultSet resultSet = execute(sql);
		
		Integer i = 0;
		while(resultSet.next()) {
			Integer id = resultSet.getInt("id");
			String nome = resultSet.getString("nome");
			Integer nCidades = resultSet.getInt("n_cidades");
			roteiros.put(i, new Roteiro(id, nome, nCidades));
			idPosicao.put(id, i);
			i++;
		}
		
		//Colocação das cidades
		sql = "SELECT e.roteiro_id, e.posicao, e.cidade_id"
				+ " FROM estadia e"
				+ " INNER JOIN roteiro r ON r.id = e.roteiro_id"
				+ " ORDER BY roteiro_id, posicao";
		resultSet = execute(sql);
		
		int roteiroId, posicao, cidadeId; i = 0;
		while(resultSet.next()) {
			roteiroId = resultSet.getInt("roteiro_id");
			posicao = resultSet.getInt("posicao");
			cidadeId = resultSet.getInt("cidade_id");
				
			if (!cidades.containsKey(cidadeId))
				cidades.put(cidadeId, (new CidadeDAO()).getCidadeById(cidadeId));
			
			cidade = cidades.get(cidadeId);
			roteiros.get(idPosicao.get(roteiroId)).getCidades().add(posicao, cidade);
			i++;
		}
		
		/*//Colocação dos hotéis
		sql = "SELECT h.roteiro_id, h.posicao, h.hotel_id"
				+ " FROM hospedagem h"
				+ " INNER JOIN roteiro r ON r.id = h.roteiro_id"
				+ " ORDER BY h.roteiro_id, h.posicao";
		resultSet = execute(sql);
		
		int id = -1;
		int hotelId;
		while(resultSet.next()) {
			roteiroId = resultSet.getInt("roteiro_id");
			posicao = resultSet.getInt("posicao");
			hotelId = resultSet.getInt("hotel_id");
			
			if (!hoteis.containsKey(hotelId))
				hoteis.put(hotelId, (new HotelDAO()).getHotelById(hotelId));
			hotel = hoteis.get(hotelId);
			roteiros.get(roteiroId).getCidades().get(posicao).setHotel(hotel);
		}
			
			//Colocação dos transportes
			sql = "SELECT v.roteiro_id, v.cidade_from, v.cidade_to, v.transporte_id"
					+ " FROM viagem v"
					+ " INNER JOIN roteiro r ON r.id = v.roteiro_id"
					+ " ORDER BY v.roteiro_id, v.cidade_from, v.cidade_to";
			resultSet = execute(sql);
			
			id = -1;
			int transporteId, from, to;
			while(resultSet.next()) {
				roteiroId = resultSet.getInt("roteiro_id");
				from = resultSet.getInt("cidade_from");
				to = resultSet.getInt("cidade_to");
				transporteId = resultSet.getInt("transporte_id");
				
				if (!transportes.containsKey(transporteId))
					transportes.put(transporteId, (new TransporteDAO()).getTransporteById(transporteId));
				transporte = transportes.get(transporteId);
				
				transporte.setFrom(cidades.get(from));
				transporte.setTo(cidades.get(to));
				roteiros.get(roteiroId).getCidades().get(from).setPartida(transporte);
				roteiros.get(roteiroId).getCidades().get(to).setChegada(transporte);
			}
		*/
		return roteiros;
	}
	
	public void salvaRoteiro(Roteiro roteiro) throws SQLException{
		String sql;
		List<String> queries = new ArrayList<>();
		ResultSet resultSet;
		int id;
		
		sql = "INSERT INTO roteiro(cliente_id, nome, forma_pagamento, preco) "
				+ "VALUES(" + roteiro.getCliente().getId() + ", '"
				+ roteiro.getName() 
				+ "', null" + ", " 
				+ roteiro.getPreco()
				+ ");";
		
		execute(sql);
		
		sql = "SELECT MAX(id) AS id FROM roteiro WHERE cliente_id = " + roteiro.getCliente().getId()
				+ " AND nome = '" + roteiro.getName() + "';";
		
		resultSet = execute(sql);
		if(!resultSet.next())
			throw new SQLException("Erro na gravação na tabela 'roteiro'");
		
		id = resultSet.getInt("id");
		
		roteiro.setId(id);
		
		//Inserção na tabela 'estadia'
		sql = "";
		Cidade cidade = roteiro.getCidades().get(0);
		Transporte transporte;
		for (int i = 0; i < roteiro.getCidades().size(); i++){
			
			
			 queries.add("INSERT INTO estadia (roteiro_id, cidade_id, posicao)"
					+ " VALUES ( " + id 
					+ ", " + roteiro.getCidades().get(i).getId()
					+ ", " + i + ");\n");
			
			if (cidade.getId() != roteiro.getCidadeNatal().getId())
				queries.add("INSERT INTO hospedagem (roteiro_id, posicao, hotel_id, dias)"
						+ " VALUES ( " + id 
						+ ", " + i
						+ ", " + roteiro.getCidades().get(i).getHotel().getId()
						+ ", " + roteiro.getCidades().get(i).getHotel().getNdias().intValue()
						+ ");\n");
			
			transporte = cidade.getPartida();
			
			if (i != roteiro.getCidades().size() - 1)
				queries.add("INSERT INTO viagem (roteiro_id, cidade_from, cidade_to, transporte_id)"
						+ " VALUES ( " + id 
						+ ", " + i
						+ ", " + (i+1)
						+ ", " + transporte.getId()
						+ ");\n");
			
			cidade = transporte.getTo();
			
		} batch(queries);
		
	}
	
	public void setFormaPagamento(Roteiro roteiro) throws SQLException{
		String sql = "INSERT INTO venda(cliente_id, roteiro_id, forma_pagamento) "
				+ "values(" + roteiro.getCliente().getId()
				+ ", "  + roteiro.getFormaPagamento()
				+ ", " + roteiro.getId() + ");";
		execute(sql);
	}
}