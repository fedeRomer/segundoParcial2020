package negocio.dto;

import java.util.Calendar;

public class Choferes extends Usuario {

	private int idChoferes;
	private String nombre;
	private String apellido;
	private int dni;
	private Calendar fechaDeNacimiento;
	private int categoria;
	private String telefono;

	public Choferes(int id, String username, String password, String perfil, int idChoferes, String nombre,
			String apellido, int dni, Calendar fechaDeNacimiento, int categoria, String telefono) {
		super(id, username, password, perfil);
		this.idChoferes = idChoferes;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.categoria = categoria;
		this.telefono = telefono;
	}
	
	public Choferes(int id, String username, String password, String perfil) {
		super(id, username, password, perfil);
	}
	
	public Choferes() {
		super();
	}


	public int getIdChoferes() {
		return idChoferes;
	}

	public void setIdChoferes(int idChoferes) {
		this.idChoferes = idChoferes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Calendar getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Calendar fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
