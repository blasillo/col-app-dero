package es.jcyl.eclap.colapp.ot;

public class Cerveza {
	
	private Long id;
	private String nombre;
	private String imagen;
	private Double alcohol;
	private String color;
	private String categoria;
	private String descripcion;
	
	
	public Cerveza() {
		super();
	}


	public Cerveza(Long id, String nombre, String imagen, Double alcohol, String color, String categoria,
			String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.alcohol = alcohol;
		this.color = color;
		this.categoria = categoria;
		this.descripcion = descripcion;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Double getAlcohol() {
		return alcohol;
	}


	public void setAlcohol(Double alcohol) {
		this.alcohol = alcohol;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return "Cerveza [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", alcohol=" + alcohol + ", color="
				+ color + ", categoria=" + categoria + ", descripcion=" + descripcion + "]";
	}
	
	
	
	

}
