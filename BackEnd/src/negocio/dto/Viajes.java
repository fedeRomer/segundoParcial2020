package negocio.dto;

public class Viajes {
	// pk
	private int idViaje;

	private Choferes chofer;
	private Camiones camion;
	private Provincias origen;
	private Provincias destino;
	private int distancia;
	private int tiempoDeViaje;
	private int tanquesDeCombustible;

	public Viajes(int idViaje, Choferes chofer, Camiones camion, Provincias origen, Provincias destino, int distancia,
			int tiempoDeViaje, int tanquesDeCombustible) {
		super();
		this.idViaje = idViaje;
		this.chofer = chofer;
		this.camion = camion;
		this.origen = origen;
		this.destino = destino;
		this.distancia = distancia;
		this.tiempoDeViaje = tiempoDeViaje;
		this.tanquesDeCombustible = tanquesDeCombustible;
	}

	public Viajes() {
		super();
	}

	public int getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}

	public int getChofer() {
		return chofer.getIdChoferes();
	}

	public void setChofer(Choferes chofer) {
		this.chofer = chofer;
	}

	public int getCamion() {
		return camion.getIdCamiones();
	}

	public void setCamion(Camiones camion) {
		this.camion = camion;
	}

	public int getOrigen() {
		return origen.getIdProvincia();
	}

	public void setOrigen(Provincias origen) {
		this.origen = origen;
	}

	public int getDestino() {
		return destino.getIdProvincia();
	}

	public void setDestino(Provincias destino) {
		this.destino = destino;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getTiempoDeViaje() {
		return tiempoDeViaje;
	}

	public void setTiempoDeViaje(int tiempoDeViaje) {
		this.tiempoDeViaje = tiempoDeViaje;
	}

	public int getTanquesDeCombustible() {
		return tanquesDeCombustible;
	}

	public void setTanquesDeCombustible(int tanquesDeCombustible) {
		this.tanquesDeCombustible = tanquesDeCombustible;
	}

}
