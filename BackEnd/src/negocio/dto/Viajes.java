package negocio.dto;

public class Viajes {
	// pk
	private int idViaje;
	// fk
	private int idChofer;
	private int idCamion;
	private int idOrigen;
	private int idDestino;

	public Viajes(int idViaje, int idChofer, int idCamion, int idOrigen, int idDestino) {
		super();
		this.idViaje = idViaje;
		this.idChofer = idChofer;
		this.idCamion = idCamion;
		this.idOrigen = idOrigen;
		this.idDestino = idDestino;
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

	public int getIdChofer() {
		return idChofer;
	}

	public void setIdChofer(int idChofer) {
		this.idChofer = idChofer;
	}

	public int getIdCamion() {
		return idCamion;
	}

	public void setIdCamion(int idCamion) {
		this.idCamion = idCamion;
	}

	public int getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(int idOrigen) {
		this.idOrigen = idOrigen;
	}

	public int getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

}
