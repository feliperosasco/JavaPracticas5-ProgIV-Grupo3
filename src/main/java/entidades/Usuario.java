package entidades;

import java.util.Objects;

public class Usuario {
	private int id_usuario;
	private String usuario;
	private String contrasena;
	
	public Usuario()
	{
		
	}
	
	public Usuario(int id_usuario, String usuario, String contrasena)
	{
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", usuario=" + usuario + ", contrasena=" + contrasena + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contrasena, id_usuario, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(contrasena, other.contrasena) && id_usuario == other.id_usuario
				&& Objects.equals(usuario, other.usuario);
	}
	
	
}
