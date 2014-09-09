package qreasymarket.servlet.SupervisorEnvio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.negocio.TarifaNegocio;

/**
 * Servlet implementation class EliminarTarifaServlet
 */
@WebServlet("/EliminarTarifaServlet")
public class EliminarTarifaServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	public EliminarTarifaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("idtarifa");
		int tarifa = Integer.parseInt(id);

		TarifaNegocio modelo = new TarifaNegocio();
		try {
			modelo.eliminarTarifa(tarifa);

			RequestDispatcher rd = request
					.getRequestDispatcher("tarifa_buscar.jsp");
			rd.forward(request, response);
			
			
		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
