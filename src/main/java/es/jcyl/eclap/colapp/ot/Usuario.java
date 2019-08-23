package es.jcyl.eclap.colapp.ot;

public class Usuario {
	
	private Integer id;	
	private String email;	
	private String password;
	private String nombre;
	private String rol;
	
	
	public Usuario() {
		super();
	}

	public Usuario(Integer id, String email, String password, String nombre , String rol) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.rol = rol;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String getRol() {
		return rol;
	}

	private void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", nombre=" + nombre + ", rol=" + rol + "]";
	}

	
	
	
	
	
	
	
	
	
	

}
