package es.jcyl.eclap.colapp.ot;

import java.sql.Timestamp;

public class Nota {
	
	private Long id;
	private Timestamp creado;
	private String titulo;
	private String contenido;
	private Boolean notaPublica;
	private Integer usuarioId;
	private Long cervezaId;
	
	
	private String autor;
	
	
	public Nota() {
		super();
	}


	public Nota(Long id, Timestamp creado, String titulo, String contenido, Boolean notaPublica, Integer usuarioId,
			Long cervezaId) {
		super();
		this.id = id;
		this.creado = creado;
		this.titulo = titulo;
		this.contenido = contenido;
		this.notaPublica = notaPublica;
		this.usuarioId = usuarioId;
		this.cervezaId = cervezaId;
	}
	
	
	
	public boolean esValida() {
		//validacion de chichinabo
		return (this.getTitulo().length() > 0 && 
				this.getContenido().length() > 0 );
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Timestamp getCreado() {
		return creado;
	}


	public void setCreado(Timestamp creado) {
		this.creado = creado;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getContenido() {
		return contenido;
	}


	public void setContenido(String contenido) {
		this.contenido = contenido;
	}


	public Boolean getNotaPublica() {
		return notaPublica;
	}


	public void setNotaPublica(Boolean notaPublica) {
		this.notaPublica = notaPublica;
	}


	public Integer getUsuarioId() {
		return usuarioId;
	}


	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}


	public Long getCervezaId() {
		return cervezaId;
	}


	public void setCervezaId(Long cervezaId) {
		this.cervezaId = cervezaId;
	}


	@Override
	public String toString() {
		return "Nota [id=" + id + ", creado=" + creado + ", titulo=" + titulo + ", contenido=" + contenido
				+ ", notaPublica=" + notaPublica + ", usuarioId=" + usuarioId + ", cervezaId=" + cervezaId + "]";
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	
	
	
	
	

}
