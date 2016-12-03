package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<Roteiro> getRoteiros() throws SQLException {
		String sql = "SELECT id FROM roteiro";
		ResultSet resultSet = execute(sql);
		
		List<String> roteirosId = new ArrayList<>();
		List<Roteiro> roteiros = new ArrayList<>();
		while(resultSet.next()) {
			roteirosId.add(resultSet.getString("id"));
		}
		
		for(String roteiroId : roteirosId) {
			Roteiro roteiro = this.getRoteiroById(new Integer(roteiroId));
			roteiros.add(roteiro);
		}
		return roteiros;
	}
	
	public void salvaRoteiro(Roteiro roteiro) throws SQLException{
		String sql;
		List<String> queries = new ArrayList<>();
		ResultSet resultSet;
		int id;
		
		sql = "INSERT INTO roteiro(cliente_id, nome, forma_pagamento) "
				+ "VALUES(" + roteiro.getCliente().getId() + ", '"
				+ roteiro.getName() + "', null);";
		
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
		String sql = "UPDATE roteiro"
				+ " SET forma_pagamento = " + roteiro.getFormaPagamento()
				+ " WHERE id = " + roteiro.getId() + ";";
		execute(sql);
	}
}