package negocio.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import negocio.dto.Provincias;

public interface ProvinciasDAO {
	
	public Boolean addProvincia(Provincias o)throws SQLException;
	public Boolean modifyProvincia(Provincias o)throws SQLException;
	public Provincias searchProvincia(Provincias o)throws SQLException, IOException;
	public List<Provincias> getProvincias() throws SQLException, IOException;

}
