package qreasymarket.servlet.Cajera;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qreasymarket.modelo.Producto;
import qreasymarket.negocio.ProductoNegocio;
import qreasymarket.excepcion.DAOExcepcion;

@WebServlet("/CajeraBuscaProductosServlet")
public class CajeraBuscaProductosServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	public CajeraBuscaProductosServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// processRequest(request, response);
		System.out
				.println("Dentro de doPost del servlet CajeraBuscaProductosServlet");
		String nombreP = request.getParameter("nombreProducto");
		ProductoNegocio negocio = new ProductoNegocio();

		try {

			Collection<Producto> lproductosNombre = negocio.buscarPorProducto(nombreP);
			request.setAttribute("ProductoNombre", lproductosNombre);
			RequestDispatcher rd = request
					.getRequestDispatcher("productos_buscar.jsp");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response);
		}

	}

}
