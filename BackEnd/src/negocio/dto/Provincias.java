package negocio.dto;

public class Provincias {

	private int idProvincia;
	private String provincia;
	private int caba;
	private int cordoba;
	private int corrientes;
	private int formosa;
	private int la_plata;
	private int la_rioja;
	private int mendoza;
	private int neuquen;

	public Provincias(int idProvincia, String provincia, int caba, int cordoba, int corrientes, int formosa,
			int la_plata, int la_rioja, int mendoza, int neuquen) {
		super();
		this.idProvincia = idProvincia;
		this.provincia = provincia;
		this.caba = caba;
		this.cordoba = cordoba;
		this.corrientes = corrientes;
		this.formosa = formosa;
		this.la_plata = la_plata;
		this.la_rioja = la_rioja;
		this.mendoza = mendoza;
		this.neuquen = neuquen;
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

	public int getCaba() {
		return caba;
	}

	public void setCaba(int caba) {
		this.caba = caba;
	}

	public int getCordoba() {
		return cordoba;
	}

	public void setCordoba(int cordoba) {
		this.cordoba = cordoba;
	}

	public int getCorrientes() {
		return corrientes;
	}

	public void setCorrientes(int corrientes) {
		this.corrientes = corrientes;
	}

	public int getFormosa() {
		return formosa;
	}

	public void setFormosa(int formosa) {
		this.formosa = formosa;
	}

	public int getLa_plata() {
		return la_plata;
	}

	public void setLa_plata(int la_plata) {
		this.la_plata = la_plata;
	}

	public int getLa_rioja() {
		return la_rioja;
	}

	public void setLa_rioja(int la_rioja) {
		this.la_rioja = la_rioja;
	}

	public int getMendoza() {
		return mendoza;
	}

	public void setMendoza(int mendoza) {
		this.mendoza = mendoza;
	}

	public int getNeuquen() {
		return neuquen;
	}

	public void setNeuquen(int neuquen) {
		this.neuquen = neuquen;
	}

}
