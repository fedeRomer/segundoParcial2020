package negocio.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import negocio.dao.interfaces.ViajesDAO;
import negocio.dto.Viajes;

public class ViajesDAOImpl implements ViajesDAO{
	
	private PreparedStatement preparedStatement;
	private CallableStatement callableStatement;
	private String query;
	private Connection connection;
	private Statement statement;
	
	
	@Override
	public Boolean addViaje(Viajes o) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean modifyViaje(Viajes o) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Viajes searchViaje(Viajes o) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Viajes> getViajes() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
