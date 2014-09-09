package qreasymarket.servlet.Cliente;

import java.io.IOException;

import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qreasymarket.excepcion.LoginExcepcion;

import qreasymarket.dao.ClienteDAO;
import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Cliente;
import qreasymarket.negocio.ClienteNegocio;

@WebServlet("/LoginClienteServlet")
public class LoginClienteServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	public LoginClienteServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String clave = request.getParameter("clave");

		// ClienteDAO dao = new ClienteDAO();
		ClienteNegocio negocio = new ClienteNegocio();

		try {

			// Cliente vo = dao.validar(email, clave);

			Cliente vo = negocio.validarCliente(email, clave);

			HttpSession session = request.getSession();
			session.setAttribute("USUARIO_ACTUAL", vo);
			response.sendRedirect("PortadaClienteServlet");
			return;
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		} catch (LoginExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request
					.getRequestDispatcher("/error_login.jsp");
			rd.forward(request, response);
		}
	}

}
