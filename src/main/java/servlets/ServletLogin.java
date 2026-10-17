package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import negocio.UsuarioNegocio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.Conexion;
import dao.UsuarioDao;
import entidades.Usuario;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("txtUsuario");
		String pass = request.getParameter("txtContra");
		
		UsuarioNegocio uneg = new UsuarioNegocio();
		
		Usuario usuarioEncontrado = uneg.validarCredenciales(user, pass);
		
		
		if(usuarioEncontrado != null) {
			
			request.getSession().setAttribute("usuarioLogueado", user);
			response.sendRedirect(request.getContextPath() + "/menu.jsp");
			
		}else {
			request.setAttribute("error", "Usuario o contraseña incorrectos");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}	
		
	}

}
