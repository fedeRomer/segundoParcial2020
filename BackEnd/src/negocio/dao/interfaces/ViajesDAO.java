package negocio.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import negocio.dto.Viajes;

public interface ViajesDAO {

	public Boolean addViaje(Viajes o) throws SQLException;

	public Boolean modifyViaje(Viajes o) throws SQLException;

	public Viajes searchViaje(Viajes o) throws SQLException;

	public List<Viajes> getViajes() throws SQLException;

}
