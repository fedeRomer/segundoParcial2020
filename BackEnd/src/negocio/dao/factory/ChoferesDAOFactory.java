package negocio.dao.factory;

import negocio.dao.impl.ChoferesDAOImpl;
import negocio.dao.interfaces.ChoferesDAO;

public class ChoferesDAOFactory {
	public static ChoferesDAO get(String implementation) {
		if (implementation.equals("database")) {
			return new ChoferesDAOImpl();
		} else {
			return null;
		}
	}

}
