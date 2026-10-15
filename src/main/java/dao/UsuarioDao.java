package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Usuario;

public class UsuarioDao implements IUsuarioDao {

	@Override
	public Usuario validarCredenciales(String usuario, String contrasena) {

		Usuario encontrado = null;
		String sql = "SELECT id_usuario, usuario, contrasena FROM usuarios WHERE usuario = ? AND contrasena = ?";
		
		try(Connection cn = Conexion.getConexion();
				PreparedStatement ps = cn.prepareStatement(sql)){
			
			ps.setString(1, usuario);
			ps.setString(2, contrasena);
			
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					encontrado = new Usuario(
						rs.getInt("id_usuario"),
						rs.getString("usuario"),
						rs.getString("contrasena"));
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return encontrado;
	}

}
