package qreasymarket.servlet.Cajera;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qreasymarket.dao.ProductoDAO;
import qreasymarket.modelo.Producto;
import qreasymarket.excepcion.DAOExcepcion;

@WebServlet("/CajeraEditarProductoServlet")
public class CajeraEditarProductoServlet extends javax.servlet.http.HttpServlet
implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	public CajeraEditarProductoServlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ProductoDAO dao = new ProductoDAO();
		
		int id = Integer.parseInt(request.getParameter("IdProducto"));
		Producto vo;
	try {
		
		vo=dao.obtener(id);
		System.out.println(vo);
		request.setAttribute("Producto", vo);
		request.getRequestDispatcher("productos_editar.jsp").forward(request, response);
		
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
