package negocio.bll;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import negocio.dao.factory.CamionesDAOFactory;
import negocio.dao.factory.ChoferesDAOFactory;
import negocio.dao.factory.ProvinciasDAOFactory;
import negocio.dao.factory.ViajesDAOFactory;
import negocio.dao.interfaces.CamionesDAO;
import negocio.dao.interfaces.ChoferesDAO;
import negocio.dao.interfaces.ProvinciasDAO;
import negocio.dao.interfaces.ViajesDAO;
import negocio.dto.Camiones;
import negocio.dto.Choferes;
import negocio.dto.Provincias;
import negocio.dto.Viajes;

public class NuevoViaje {
	Choferes chofer = new Choferes();
	Camiones camion = new Camiones();

	ViajesDAO viajeDAO = ViajesDAOFactory.get("database");

	public Boolean addViaje(Viajes o) throws SQLException, IOException {

		if (this.validateCategoria(this.getChofer(o.getChofer()), this.getCamion(o.getCamion()))) {
			o.setDistancia(this.calcularDistancia(o.getOrigen(), o.getDestino()));
			o.setTiempoDeViaje(this.calcularTiempoDeViaje(o.getDistancia()));
			o.setTanquesDeCombustible(this.calcularTanquesDeCombustible(o.getDistancia(), this.camion.getLitrosTanque(),
					this.camion.getConsumoLitrosKm()));

			if (this.viajeDAO.addViaje(o)) {
				System.out.println("ok add viaje");
				return true;
			} else {
				System.out.println("no ok add viaje");
				return false;
			}

		} else {
			return false;
		}

	}

	public Choferes getChofer(int id) throws SQLException, IOException {
		ChoferesDAO choferDAO = ChoferesDAOFactory.get("database");

		this.chofer.setIdChoferes(id);
		this.chofer = choferDAO.searchChofer(this.chofer);
		return this.chofer;
	}

	public Camiones getCamion(int id) throws SQLException, IOException {
		CamionesDAO camionDAO = CamionesDAOFactory.get("database");

		this.camion.setIdCamiones(id);
		this.camion = camionDAO.searchCamion(this.camion);
		return this.camion;

	}

	public int calcularDistancia(int idOrigen, int idDestino) throws SQLException, IOException {
		ProvinciasDAO provinciaDAO = ProvinciasDAOFactory.get("database");
		Provincias origen = new Provincias();
		Provincias destino = new Provincias();
		origen.setIdProvincia(idOrigen);
		origen = provinciaDAO.searchProvincia(origen);

		destino.setIdProvincia(idDestino);
		destino = provinciaDAO.searchProvincia(destino);

		switch (destino.getProvincia()) {
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
			return origen.getNeuquen();
		default:
			return -1;
		}
	}

	public int calcularTiempoDeViaje(int km) {
		int dias = -1;
		if (km > 0) {
			dias = km / 200;
			return dias;
		} else {
			return -1;
		}

	}

	public double calcularTanquesDeCombustible(int distanciaKm, int tanqueLitros, int consumoL100km) {
		double tanquesAusar = 0;
		int litrosAconsumir = 0;
		// para 100km uso 24L
		// para 1800 uso 432
		litrosAconsumir = (distanciaKm * consumoL100km) / 100;
		tanquesAusar = litrosAconsumir / tanqueLitros;
		System.out.println("tanques a usar:"+tanquesAusar+"\nlitros a consumir: "+litrosAconsumir);
		return tanquesAusar;
	}

	public Boolean validateCategoria(Choferes o, Camiones z) {
		if (o.getCategoria() >= z.getCategoria()) {
			return true;
		} else {
			return false;
		}
	}

}
