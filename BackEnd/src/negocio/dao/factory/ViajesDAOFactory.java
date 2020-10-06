package negocio.dao.factory;

import negocio.dao.impl.ViajesDAOImpl;
import negocio.dao.interfaces.ViajesDAO;

public class ViajesDAOFactory {
	public static ViajesDAO get(String implementation) {
		if (implementation.equals("database")) {
			return new ViajesDAOImpl();
		} else {
			return null;
		}
	}

}
