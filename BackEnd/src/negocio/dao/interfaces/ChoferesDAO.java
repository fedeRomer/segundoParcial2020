package negocio.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import negocio.dto.Choferes;

public interface ChoferesDAO {
	
	public Boolean addChofer(Choferes o) throws SQLException;

	public Boolean modifyChofer(Choferes o) throws SQLException;

	public Choferes searchChofer(Choferes o) throws SQLException;

	public List<Choferes> getChoferes() throws SQLException;

}
