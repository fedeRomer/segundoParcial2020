package negocio.dto;

import java.sql.Date;
import java.util.Calendar;

public class Choferes {

	private int idChoferes;
	private String nombre;
	private String apellido;
	private int dni;
	private Date fechaDeNacimiento;
	private int categoria;
	private String telefono;

	public Choferes(int idChoferes, String nombre,
			String apellido, int dni, Date fechaDeNacimiento, int categoria, String telefono) {
		super();
		this.idChoferes = idChoferes;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.categoria = categoria;
		this.telefono = telefono;
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

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date date) {
		this.fechaDeNacimiento = date;
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
