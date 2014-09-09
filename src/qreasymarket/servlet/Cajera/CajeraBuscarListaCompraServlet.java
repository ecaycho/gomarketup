package qreasymarket.servlet.Cajera;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qreasymarket.modelo.ListaCompra;
import qreasymarket.dao.ListaCompraDAO;
import qreasymarket.excepcion.DAOExcepcion;

@WebServlet("/CajeraBuscarListaCompraServlet")
public class CajeraBuscarListaCompraServlet extends
		javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	public CajeraBuscarListaCompraServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.procesarPeticion(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.procesarPeticion(request, response);
	}

	protected void procesarPeticion(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Dentro de doPost del servlet CajeraBuscarListaCompraServlet");
		String x = request.getParameter("correoLista");
		
		ListaCompraDAO dao = new ListaCompraDAO();
		try {
			Collection<ListaCompra> listacompra = dao.BuscarClientePorEmail(x);

			request.setAttribute("ListaCompra", listacompra);
			RequestDispatcher rd = request.getRequestDispatcher("lista_compra.jsp");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}

	}

}
