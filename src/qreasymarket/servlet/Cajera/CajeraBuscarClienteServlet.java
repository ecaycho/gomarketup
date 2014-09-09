package qreasymarket.servlet.Cajera;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qreasymarket.dao.ClienteDAO;
import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Cliente;


@WebServlet("/CajeraBuscarClienteServlet")
public class CajeraBuscarClienteServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	public CajeraBuscarClienteServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Dentro de doPost del Servlet CajeraBuscarClienteServlet");

		String DNI = request.getParameter("dni");

		ClienteDAO dao = new ClienteDAO();

		try {

			Collection<Cliente> dnicliente = dao.BuscarPorDNI(DNI);
			
			request.setAttribute("DniCliente", dnicliente);
			RequestDispatcher rd = request.getRequestDispatcher("buscar_clientes.jsp");
			rd.forward(request,response);
			
		}catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

}
