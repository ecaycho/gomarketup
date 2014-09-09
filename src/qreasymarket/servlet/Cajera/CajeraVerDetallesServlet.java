package qreasymarket.servlet.Cajera;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qreasymarket.dao.DetallePedidoDAO;
import qreasymarket.modelo.DetallePedido;
import qreasymarket.excepcion.DAOExcepcion;

@WebServlet("/CajeraVerDetallesServlet")
public class CajeraVerDetallesServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	public CajeraVerDetallesServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		DetallePedidoDAO dao = new DetallePedidoDAO();
		int id = Integer.parseInt(request.getParameter("IdListaCompra"));
		DetallePedido vo;

		try {
			vo = dao.obtener(id);
			request.setAttribute("DetallePedido", vo);
			Collection<DetallePedido>detallepedido=dao.CapturarId(id);
			request.setAttribute("DetallePedido", detallepedido);
			RequestDispatcher rd = request.getRequestDispatcher("detalles_producto.jsp");
			rd.forward(request, response);

	
		} catch (DAOExcepcion e) {
			System.err.println("Error");
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
