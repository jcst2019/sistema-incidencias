
package sunat.gob.pe.sistema_incidencias.model.entities;

public class Usuario {
    private Integer idUsuario;
    private String dni;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasenha;
    private String correo;
    private String estado;
    
	public Usuario(Integer idUsuario, String dni, String nombre, String apellido, String usuario, String contrasenha,
			String correo, String estado) {
		super();
		this.idUsuario = idUsuario;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.contrasenha = contrasenha;
		this.correo = correo;
		this.estado = estado;
	}
	

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenha() {
		return contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", usuario=" + usuario + ", contrasenha=" + contrasenha + ", correo=" + correo + ", estado=" + estado
				+ "]";
	}
	
	
}
