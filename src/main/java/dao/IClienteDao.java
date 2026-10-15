package dao;

import java.sql.SQLException;
import java.util.List;

import entidades.Cliente;

public interface IClienteDao {

	boolean agregar(Cliente cliente) throws SQLException;

	boolean existeCorreo(String correoElectronico) throws SQLException;

	List<Cliente> listar() throws SQLException;
}
