package negocio.dao.factory;

import negocio.dao.impl.ProvinciasDAOImpl;
import negocio.dao.interfaces.ProvinciasDAO;

public class ProvinciasDAOFactory {
	public static ProvinciasDAO get(String implementation) {
		if (implementation.equals("database")) {
			return new ProvinciasDAOImpl();
		} else {
			return null;
		}
	}

}
