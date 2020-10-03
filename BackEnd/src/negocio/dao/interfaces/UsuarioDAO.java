package negocio.dao.interfaces;

import negocio.dto.Usuario;

import java.sql.SQLException;

public interface UsuarioDAO {

    public Usuario getUsuario(String user, String contrasena) throws SQLException;

}
