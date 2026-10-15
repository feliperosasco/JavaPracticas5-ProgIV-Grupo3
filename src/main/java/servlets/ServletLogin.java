package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
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
		String user = request.getParameter("txtUsuario");
		String pass = request.getParameter("txtContra");
		
		UsuarioDao udao = new UsuarioDao();
		
		Usuario usuarioEncontrado = udao.validarCredenciales(user, pass);
		
		
		if(usuarioEncontrado != null) {
			
			request.getSession().setAttribute("usuarioLogueado", user);
			response.sendRedirect(request.getContextPath() + "/Test.jsp");
			
		}else {
			request.setAttribute("error", "Usuario o contraseña incorrectos");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}	
		
	}

}
