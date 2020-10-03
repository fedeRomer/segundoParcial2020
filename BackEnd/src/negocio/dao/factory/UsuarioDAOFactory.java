package negocio.dao.factory;

import negocio.dao.impl.UsuarioDAOImpl;
import negocio.dao.interfaces.UsuarioDAO;

public class UsuarioDAOFactory {
	public static UsuarioDAO get(String implementation) {
		if (implementation.equals("database")) {
			return new UsuarioDAOImpl();
		} else {
			return null;
		}
	}

}
