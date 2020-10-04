package negocio.dto;

public class Provincias {

	private int idProvincia;
	private String provincia;

	public Provincias(int idProvincia, String provincia) {
		super();
		this.idProvincia = idProvincia;
		this.provincia = provincia;
	}
	
	public Provincias() {
		super();
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
