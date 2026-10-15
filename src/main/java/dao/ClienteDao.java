package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Cliente;

public class ClienteDao implements IClienteDao {

	@Override
	public boolean agregar(Cliente cliente) throws SQLException {
		String sql = "INSERT INTO clientes (dni, cuil, nombre, apellido, sexo, fecha_nacimiento, "
				+ "direccion, nacionalidad, localidad, provincia, correo_electronico, telefono) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection cn = Conexion.getConexion();
				PreparedStatement ps = cn.prepareStatement(sql)) {
			ps.setString(1, cliente.getDni());
			ps.setString(2, cliente.getCuil());
			ps.setString(3, cliente.getNombre());
			ps.setString(4, cliente.getApellido());
			ps.setString(5, cliente.getSexo());
			ps.setString(6, cliente.getFecha_nacimiento());
			ps.setString(7, cliente.getDireccion());
			ps.setString(8, cliente.getNacionalidad());
			ps.setString(9, cliente.getLocalidad());
			ps.setString(10, cliente.getProvincia());
			ps.setString(11, cliente.getCorreo_electronico());
			ps.setString(12, cliente.getTelefono());

			return ps.executeUpdate() == 1;
		}
	}

	@Override
	public boolean existeCorreo(String correoElectronico) throws SQLException {
		String sql = "SELECT 1 FROM clientes WHERE correo_electronico = ? LIMIT 1";

		try (Connection cn = Conexion.getConexion();
				PreparedStatement ps = cn.prepareStatement(sql)) {
			ps.setString(1, correoElectronico);

			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		}
	}

	@Override
	public List<Cliente> listar() throws SQLException {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT id_cliente, dni, cuil, nombre, apellido, sexo, fecha_nacimiento, "
				+ "direccion, nacionalidad, localidad, provincia, correo_electronico, telefono "
				+ "FROM clientes ORDER BY id_cliente";

		try (Connection cn = Conexion.getConexion();
				PreparedStatement ps = cn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Cliente cliente = new Cliente(
						rs.getInt("id_cliente"),
						rs.getString("dni"),
						rs.getString("cuil"),
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getString("sexo"),
						rs.getString("fecha_nacimiento"),
						rs.getString("direccion"),
						rs.getString("nacionalidad"),
						rs.getString("localidad"),
						rs.getString("provincia"),
						rs.getString("correo_electronico"),
						rs.getString("telefono"));
				clientes.add(cliente);
			}
		}

		return clientes;
	}
}
