package qreasymarket.servlet.Usuario;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qreasymarket.dao.UsuarioDAO;
import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.excepcion.LoginExcepcion;
import qreasymarket.modelo.Usuario;

@WebServlet("/LoginUsuarioServlet")
public class LoginUsuarioServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	public LoginUsuarioServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");

		UsuarioDAO dao = new UsuarioDAO();

		try {
			Usuario vo = dao.Validar(correo, clave);

			String nom = vo.RolNombre;

			System.out.println(correo+" "+clave+" "+nom);
	

			String usuario1 = "CAJERA";
			String usuario2 = "JEFE DE ALMACEN";
			String usuario3 = "SUPERVISOR DE ENVIOS";

			HttpSession session = request.getSession();
			session.setAttribute("USUARIO_ACTUAL", vo);

			if (usuario1.equalsIgnoreCase(nom)) {
				response.sendRedirect("PortadaCajeraServlet");
			} else if (usuario2.equalsIgnoreCase(nom)) {
				response.sendRedirect("PortadaJefeAlmacenServlet");
			} else if (usuario3.equalsIgnoreCase(nom)) {
				response.sendRedirect("PortadaSupervisorEnvioServlet");
			}
			return;
			
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/mensaje_error_1.jsp");
			rd.forward(request, response);
		} catch (LoginExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request
					.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	}
}
