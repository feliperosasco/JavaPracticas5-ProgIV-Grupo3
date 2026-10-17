package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import negocio.ClienteNegocio;

import java.io.IOException;
import java.sql.SQLException;

import dao.ClienteDao;
import entidades.Cliente;

/**
 * Servlet implementation class ServletAltaCliente
 */
@WebServlet("/ServletAltaCliente")
public class ServletAltaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAltaCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dni = request.getParameter("dni");
		String cuil = request.getParameter("cuil");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String sexo = request.getParameter("sexo");
		String nacionalidad = request.getParameter("nacionalidad");
		String fechaNacimiento = request.getParameter("fechaNacimiento");
		String direccion = request.getParameter("direccion");
		String localidad = request.getParameter("localidad");
		String provincia = request.getParameter("provincia");
		String correo = request.getParameter("correo");
		String telefono = request.getParameter("telefono");
		
		ClienteNegocio cneg = new ClienteNegocio();
		
		Cliente clienteNuevo = new Cliente();
		
		clienteNuevo.setDni(dni);
		clienteNuevo.setCuil(cuil);
		clienteNuevo.setNombre(nombre);
		clienteNuevo.setApellido(apellido);
		clienteNuevo.setSexo(sexo);
		clienteNuevo.setFecha_nacimiento(fechaNacimiento);
		clienteNuevo.setDireccion(direccion);
		clienteNuevo.setNacionalidad(nacionalidad);
		clienteNuevo.setLocalidad(localidad);
		clienteNuevo.setProvincia(provincia);
		clienteNuevo.setCorreo_electronico(correo);
		clienteNuevo.setTelefono(telefono);		
		
		String resultado = cneg.agregarCliente(clienteNuevo);
			
		if(resultado != null) {
			request.setAttribute("mensajeError", resultado);
		}else {
			request.setAttribute("mensajeExito", "Cliente agregado con éxito");
		}
			
		request.getRequestDispatcher("/altaCliente.jsp")
	       .forward(request, response);
	}

}
