package negocio.dao.impl;

import negocio.dao.interfaces.UsuarioDAO;
import negocio.dto.Usuario;
import util.MySQL;

import java.sql.*;

public class UsuarioDAOImpl implements UsuarioDAO {
	private PreparedStatement preparedStatement;
	private CallableStatement callableStatement;
	private String query;
	private Connection connection;
	private Statement statement;

	@Override
	public Usuario getUsuario(String username, String password) throws SQLException {

		MySQL mySQL = new MySQL();
		this.connection = mySQL.getConnection();
		query = "select * from USUARIO where username=? and password=?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		ResultSet set = preparedStatement.executeQuery();
		Usuario usuario = new Usuario();
		while (set.next()) {
			usuario.setId(set.getInt(1));
			usuario.setUsername(set.getString(2));
			usuario.setPassword(set.getString(3));
			usuario.setPerfil(set.getString(4));
		}
		set.close();
		preparedStatement.close();
		connection.close();
		return usuario;
	}
}
