package negocio.dto;

import java.util.List;

public class Categorias {
	private int Categoria;
	private String descripcion;
	private String chabilitado;
	public Categorias(int categoria, String descripcion, String chabilitado) {
		super();
		Categoria = categoria;
		this.descripcion = descripcion;
		this.chabilitado = chabilitado;
	}
	public Categorias() {
		super();
	}
	public int getCategoria() {
		return Categoria;
	}
	public void setCategoria(int categoria) {
		Categoria = categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getChabilitado() {
		return chabilitado;
	}
	public void setChabilitado(String chabilitado) {
		this.chabilitado = chabilitado;
	}
	
	
}
