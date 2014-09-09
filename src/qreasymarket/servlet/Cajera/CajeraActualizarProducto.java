package qreasymarket.servlet.Cajera;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qreasymarket.dao.ProductoDAO;
import qreasymarket.modelo.Producto;
import qreasymarket.negocio.ProductoNegocio;
import qreasymarket.excepcion.DAOExcepcion;

@WebServlet("/CajeraActualizarProducto")
public class CajeraActualizarProducto extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	public CajeraActualizarProducto() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("idproducto");
		int idp = Integer.parseInt(id);

		String precio = request.getParameter("precio");
		double precios = Double.parseDouble(precio);

		String promocion = request.getParameter("promocion");

		String descuento = request.getParameter("descuento");
		double descuentos = Double.parseDouble(descuento);

		ProductoNegocio negocio = new ProductoNegocio();

		try {
			negocio.actualizarProducto(idp, precios, promocion, descuentos);
			RequestDispatcher rd = request
					.getRequestDispatcher("productos_buscar.jsp");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}

	}
}
