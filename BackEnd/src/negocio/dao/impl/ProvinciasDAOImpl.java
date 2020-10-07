package negocio.dao.impl;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import negocio.dao.interfaces.ProvinciasDAO;
import negocio.dto.Provincias;
import util.MySQL;

public class ProvinciasDAOImpl implements ProvinciasDAO {
	private PreparedStatement preparedStatement;
	private CallableStatement callableStatement;
	private String query;
	private Connection connection;
	private Statement statement;

	@Override
	public Boolean addProvincia(Provincias o) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean modifyProvincia(Provincias o) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Provincias searchProvincia(Provincias o) throws SQLException, IOException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "SELECT * FROM provincias WHERE id_provincia = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, o.getIdProvincia());
		ResultSet resultSet = preparedStatement.executeQuery();
		Provincias provincia = new Provincias();
		while (resultSet.next()) {
			provincia.setIdProvincia(resultSet.getInt(1));
			provincia.setProvincia(resultSet.getString(2));
			provincia.setCaba(resultSet.getInt(3));
			provincia.setCordoba(resultSet.getInt(4));
			provincia.setCorrientes(resultSet.getInt(5));
			provincia.setFormosa(resultSet.getInt(6));
			provincia.setLa_plata(resultSet.getInt(7));
			provincia.setLa_rioja(resultSet.getInt(8));
			provincia.setMendoza(resultSet.getInt(9));
			provincia.setNeuquen(resultSet.getInt(10));
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return provincia;
	}

	@Override
	public List<Provincias> getProvincias() throws SQLException, IOException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "SELECT * FROM provincias";
		preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Provincias> provinciasList = new ArrayList<>();
		while (resultSet.next()) {
			Provincias p = new Provincias();
			p.setIdProvincia(resultSet.getInt(1));
			p.setProvincia(resultSet.getString(2));
			provinciasList.add(p);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return provinciasList;
	}

}
