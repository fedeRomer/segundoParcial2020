package negocio.dao.factory;

import negocio.dao.impl.CamionesDAOImpl;
import negocio.dao.interfaces.CamionesDAO;

public class CamionesDAOFactory {
	public static CamionesDAO get(String implementation) {
		if (implementation.equals("database")) {
			return new CamionesDAOImpl();
		} else {
			return null;
		}
	}

}

