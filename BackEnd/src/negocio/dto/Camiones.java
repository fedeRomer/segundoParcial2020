package negocio.dto;

public class Camiones {

	private int idCamiones;
	private String marca;
	private String modelo;
	private String dominio;
	private int categoria;
	private int cargaMaximaTn;
	private int litrosTanque;
	private int consumoLitrosKm;

	public Camiones(int idCamiones, String marca, String modelo, String dominio, int categoria, int cargaMaximaTn,
			int litrosTanque, int consumoLitrosKm) {
		super();
		this.idCamiones = idCamiones;
		this.marca = marca;
		this.modelo = modelo;
		this.dominio = dominio;
		this.categoria = categoria;
		this.cargaMaximaTn = cargaMaximaTn;
		this.litrosTanque = litrosTanque;
		this.consumoLitrosKm = consumoLitrosKm;
	}

	public Camiones() {
		super();
	}

	public int getIdCamiones() {
		return idCamiones;
	}

	public void setIdCamiones(int idCamiones) {
		this.idCamiones = idCamiones;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getCargaMaximaTn() {
		return cargaMaximaTn;
	}

	public void setCargaMaximaTn(int cargaMaximaTn) {
		this.cargaMaximaTn = cargaMaximaTn;
	}

	public int getLitrosTanque() {
		return litrosTanque;
	}

	public void setLitrosTanque(int litrosTanque) {
		this.litrosTanque = litrosTanque;
	}

	public int getConsumoLitrosKm() {
		return consumoLitrosKm;
	}

	public void setConsumoLitrosKm(int consumoLitrosKm) {
		this.consumoLitrosKm = consumoLitrosKm;
	}

}
