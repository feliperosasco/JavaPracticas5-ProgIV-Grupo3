package dao;
import entidades.Usuario;

public interface IUsuarioDao {
	Usuario validarCredenciales(String usuario, String contrasena);
}
