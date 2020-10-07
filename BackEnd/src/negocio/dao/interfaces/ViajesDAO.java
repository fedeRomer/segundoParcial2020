package negocio.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import negocio.dto.Viajes;

public interface ViajesDAO {

	public Boolean addViaje(Viajes o) throws SQLException, IOException;

	public Boolean modifyViaje(Viajes o) throws SQLException;
	
	public Boolean deleteViaje(int id) throws SQLException, IOException;

	public Viajes searchViaje(Viajes o) throws SQLException;

	public List<Viajes> getViajes() throws SQLException, IOException;

}
