package qreasymarket.servlet.SupervisorEnvio;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Tarifa;
import qreasymarket.negocio.TarifaNegocio;

/**
 * Servlet implementation class BuscarTarifaServlet
 */
@WebServlet("/BuscarTarifaServlet")
public class BuscarTarifaServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	public BuscarTarifaServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Dentro del Post del servlet BuscarTarifa");

		String distrito = request.getParameter("distrito");
		TarifaNegocio negocio = new TarifaNegocio();

		try {
			Collection<Tarifa> listarifa = negocio.buscarTarifa(distrito);
			request.setAttribute("tarifalista", listarifa);
			RequestDispatcher rd = request.getRequestDispatcher("tarifa_buscar.jsp");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response);
		}

	}

}
