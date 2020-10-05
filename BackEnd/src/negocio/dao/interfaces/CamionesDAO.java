package negocio.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import negocio.dto.Camiones;


public interface CamionesDAO {
	
	public Boolean addCamion(Camiones o) throws SQLException;

	public Boolean modifyCamion(Camiones o) throws SQLException;

	public Camiones searchCamion(Camiones o) throws SQLException;

	public List<Camiones> getCamiones() throws SQLException;

}
