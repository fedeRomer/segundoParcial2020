package negocio.dao.impl;

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
	public Provincias searchProvincia(Provincias o) throws SQLException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "SELECT * FROM provincias WHERE provincia LIKE ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, o.getProvincia());
		ResultSet resultSet = preparedStatement.executeQuery();
		Provincias provincia = new Provincias();
		while (resultSet.next()) {
			provincia.setIdProvincia(resultSet.getInt(0));
			provincia.setProvincia(resultSet.getString(1));
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return provincia;
	}

	@Override
	public List<Provincias> getProvincias() throws SQLException {
		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "SELECT * FROM provincias";
		preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Provincias> provinciasList = new ArrayList<>();
		while (resultSet.next()) {
			Provincias p = new Provincias();
			p.setIdProvincia(resultSet.getInt(0));
			p.setProvincia(resultSet.getString(1));
			provinciasList.add(p);
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		return provinciasList;
	}

}
