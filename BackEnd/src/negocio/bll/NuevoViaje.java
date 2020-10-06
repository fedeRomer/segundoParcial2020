package negocio.bll;

import java.lang.reflect.Method;
import java.sql.SQLException;

import negocio.dao.factory.CamionesDAOFactory;
import negocio.dao.factory.ChoferesDAOFactory;
import negocio.dao.factory.ProvinciasDAOFactory;
import negocio.dao.interfaces.CamionesDAO;
import negocio.dao.interfaces.ChoferesDAO;
import negocio.dao.interfaces.ProvinciasDAO;
import negocio.dto.Camiones;
import negocio.dto.Choferes;
import negocio.dto.Provincias;
import negocio.dto.Viajes;

public class NuevoViaje {

	public Boolean addViaje(Viajes o) {

		// TODO: invocar BLL y calcular distancia, tiempo de viaje, tanques de
		// combustible
		// pasando como parametro id camion, id origen, id destino
		// y retornando lista de parametros

		return null;

	}

	public Choferes getChofer(Choferes o) throws SQLException {
		ChoferesDAO choferDAO = ChoferesDAOFactory.get("database");
		Choferes chofer = new Choferes();
		chofer = choferDAO.searchChofer(o);
		return chofer;
	}

	public Camiones getCamion(Camiones o) throws SQLException {
		CamionesDAO camionDAO = CamionesDAOFactory.get("database");
		Camiones camion = new Camiones();
		camion = camionDAO.searchCamion(o);
		return camion;

	}

	public int calcularDistancia(int idOrigen, int idDestino) throws SQLException {
		ProvinciasDAO provinciaDAO = ProvinciasDAOFactory.get("database");
		Provincias origen = new Provincias();
		Provincias destino = new Provincias();
		origen.setIdProvincia(idOrigen);
		origen = provinciaDAO.searchProvincia(origen);

		destino.setIdProvincia(idDestino);
		destino = provinciaDAO.searchProvincia(destino);

		switch (destino.getProvincia()) 
		{
			case "Caba":
				return origen.getCaba();
			case "Cordoba":
				return origen.getCordoba();
			case "Corrientes":
				return origen.getCorrientes();
			case "Formosa":
				return origen.getFormosa();
			case "La Plata":
				return origen.getLa_plata();
			case "La Rioja":
				return origen.getLa_rioja();
			case "Mendoza":
				return origen.getMendoza();
			case "Neuquen":
				return 	origen.getNeuquen();
			default:
				return -1;
		}
	}

	public int calcularTiempoDeViaje(int km) {
		
		if(km>0) {
			km = km / 200;
			return km;
		}else {
			return -1;
		}

	}

	public int calcularTanquesDeCombustible() {
		return 0;

	}

}
