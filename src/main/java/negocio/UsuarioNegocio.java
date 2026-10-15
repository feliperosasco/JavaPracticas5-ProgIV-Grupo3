package negocio;

import dao.IUsuarioDao;
import dao.UsuarioDao;
import entidades.Usuario;

public class UsuarioNegocio {
	
	private IUsuarioDao usuarioDao = new UsuarioDao();
	
	public Usuario validarCredenciales(String usuario, String contrasena) {
		if(usuario == null || contrasena == null || usuario.trim().isEmpty() || contrasena.trim().isEmpty()) {
			return null;
		}
		return usuarioDao.validarCredenciales(usuario.trim(), contrasena);
	}
}
