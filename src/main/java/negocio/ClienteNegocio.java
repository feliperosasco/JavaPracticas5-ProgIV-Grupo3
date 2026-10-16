package negocio;


import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import dao.IClienteDao;
import entidades.Cliente;

public class ClienteNegocio {
	
	private IClienteDao clienteDao = new ClienteDao();
	
	public String agregarCliente(Cliente cliente) {
		if(cliente == null || hayCamposVacios(cliente))
			return "Debe ingresar todos los campos para porder continuar.";
					
		LocalDate fechaNacimiento;
		try {
			fechaNacimiento = LocalDate.parse(cliente.getFecha_nacimiento().trim());
		}catch(DateTimeParseException e) {
			return "La fecha de nacimiento no es válida";
		}
		if (fechaNacimiento.isAfter(LocalDate.now())) {
			return "La fecha de nacimiento no puede ser futura.";
		}
		
		try {
			if(clienteDao.existeCorreo(cliente.getCorreo_electronico().trim())) {
				return "El correo electrónico ya está registrado.";
			}
			if(!clienteDao.agregar(cliente)) {
				return "No se pudo guardar el cliente.";
			}
		} catch (SQLIntegrityConstraintViolationException e){
			return "El DNI o el CUIL ya están registrados";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error al acceder a la base de datos.";
		}
		return null;
	}
	
	public List<Cliente> listarClientes(){
		try {
			return clienteDao.listar();
		}catch(SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	private boolean hayCamposVacios(Cliente c) {
		return vacio(c.getDni()) || vacio(c.getCuil()) || vacio(c.getNombre())
				|| vacio(c.getApellido()) || vacio(c.getSexo())
				|| vacio(c.getFecha_nacimiento()) || vacio(c.getDireccion())
				|| vacio(c.getNacionalidad()) || vacio(c.getLocalidad())
				|| vacio(c.getProvincia()) || vacio(c.getCorreo_electronico())
				|| vacio(c.getTelefono());
	}
	
	private boolean vacio(String valor) {
		return valor == null || valor.trim().isEmpty();
	}
	
}
