package negocio.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import negocio.dto.Choferes;

public interface ChoferesDAO {
	
	public Boolean addChofer(Choferes o) throws SQLException, IOException;

	public Boolean modifyChofer(Choferes o) throws SQLException, IOException;
	
	public Boolean deleteChofer(int id) throws SQLException, IOException;

	public Choferes searchChofer(Choferes o) throws SQLException, IOException;
	
	public List<Choferes> getChoferes() throws SQLException, IOException;

}
