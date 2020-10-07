package negocio.dao.impl;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import negocio.dao.interfaces.CamionesDAO;
import negocio.dto.Camiones;
import util.MySQL;

public class CamionesDAOImpl implements CamionesDAO {
	private PreparedStatement preparedStatement;
	private CallableStatement callableStatement;
	private String query;
	private Connection connection;
	private Statement statement;

	@Override
	public Boolean addCamion(Camiones o) throws SQLException, IOException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "INSERT INTO camiones ("
				+ "marca,modelo,dominio,categoria,carga_maxima_tn,litros_tanque,consumo_litros_km" + ") " + "VALUES("
				+ "?,?,?,?,?,?,?" + ") ";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, o.getMarca());
		preparedStatement.setString(2, o.getModelo());
		preparedStatement.setString(3, o.getDominio());
		preparedStatement.setInt(4, o.getCategoria());
		preparedStatement.setInt(5, o.getCargaMaximaTn());
		preparedStatement.setInt(6, o.getLitrosTanque());
		preparedStatement.setInt(7, o.getConsumoLitrosKm());
		int resultSet = preparedStatement.executeUpdate();
		if (resultSet == 1) {
			preparedStatement.close();
			connection.close();
			return true;
		} else {
			preparedStatement.close();
			connection.close();
			return false;
		}
	}

	@Override
	public Boolean modifyCamion(Camiones o) throws SQLException, IOException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "UPDATE camiones SET marca = ? ,modelo = ? ,dominio = ? ,categoria = ? ,carga_maxima_tn = ? ,litros_tanque = ? ,consumo_litros_km = ? WHERE id_camiones = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, o.getMarca());
		preparedStatement.setString(2, o.getModelo());
		preparedStatement.setString(3, o.getDominio());
		preparedStatement.setInt(4, o.getCategoria());
		preparedStatement.setInt(5, o.getCargaMaximaTn());
		preparedStatement.setInt(6, o.getLitrosTanque());
		preparedStatement.setInt(7, o.getConsumoLitrosKm());
		preparedStatement.setInt(8, o.getIdCamiones());
		int resultSet = preparedStatement.executeUpdate();
		if (resultSet == 1) {
			preparedStatement.close();
			connection.close();
			return true;
		} else {
			preparedStatement.close();
			connection.close();
			return false;
		}
	}

	@Override
	public Camiones searchCamion(Camiones o) throws SQLException, IOException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "SELECT * FROM camiones WHERE id_camiones = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, o.getIdCamiones());
		ResultSet resultSet = preparedStatement.executeQuery();
		Camiones camion = new Camiones();
		while (resultSet.next()) {
			camion.setIdCamiones(resultSet.getInt(1));
			camion.setMarca(resultSet.getString(2));
			camion.setModelo(resultSet.getString(3));
			camion.setDominio(resultSet.getString(4));
			camion.setCategoria(resultSet.getInt(5));
			camion.setCargaMaximaTn(resultSet.getInt(6));
			camion.setLitrosTanque(resultSet.getInt(7));
			camion.setConsumoLitrosKm(resultSet.getInt(8));
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return camion;
	}

	@Override
	public List<Camiones> getCamiones() throws SQLException, IOException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "SELECT * FROM Camiones";
		preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Camiones> camionesList = new ArrayList<>();
		while (resultSet.next()) {
			Camiones camion = new Camiones();
			camion.setIdCamiones(resultSet.getInt(1));
			camion.setMarca(resultSet.getString(2));
			camion.setModelo(resultSet.getString(3));
			camion.setDominio(resultSet.getString(4));
			camion.setCategoria(resultSet.getInt(5));
			camion.setCargaMaximaTn(resultSet.getInt(6));
			camion.setLitrosTanque(resultSet.getInt(7));
			camion.setConsumoLitrosKm(resultSet.getInt(8));
			camionesList.add(camion);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return camionesList;
	}

	@Override
	public Boolean deleteCamion(int id) throws SQLException, IOException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "DELETE FROM Camiones WHERE id_camiones = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		int resultSet = preparedStatement.executeUpdate();
		if (resultSet == 1) {
			preparedStatement.close();
			connection.close();
			return true;
		} else {
			preparedStatement.close();
			connection.close();
			return false;
		}
	}

}
