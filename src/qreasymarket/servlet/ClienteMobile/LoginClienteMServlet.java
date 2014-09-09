package qreasymarket.servlet.ClienteMobile;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.excepcion.LoginExcepcion;
import qreasymarket.modelo.Cliente;
import qreasymarket.negocio.ClienteNegocio;


@WebServlet("/LoginClienteMServlet")
public class LoginClienteMServlet extends javax.servlet.http.HttpServlet
implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	public LoginClienteMServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String clave = request.getParameter("clave");
	
		
		ClienteNegocio negocio = new ClienteNegocio();

		try {

			Cliente vo = negocio.validarCliente(email, clave);

			HttpSession session = request.getSession();
			session.setAttribute("USUARIO_ACTUAL", vo);
			response.sendRedirect("PortadaClienteMServlet");
			return;
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error_cm.jsp");
			rd.forward(request, response);
		} catch (LoginExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request
					.getRequestDispatcher("/error_cm.jsp");
			rd.forward(request, response);
		}
	
	}

}
