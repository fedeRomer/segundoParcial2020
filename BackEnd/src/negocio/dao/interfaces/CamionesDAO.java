package negocio.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import negocio.dto.Camiones;


public interface CamionesDAO {
	
	public Boolean addCamion(Camiones o) throws SQLException, IOException;

	public Boolean modifyCamion(Camiones o) throws SQLException, IOException;
	
	public Boolean deleteCamion(int id) throws SQLException, IOException;

	public Camiones searchCamion(Camiones o) throws SQLException, IOException;

	public List<Camiones> getCamiones() throws SQLException, IOException;

}
