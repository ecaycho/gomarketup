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
 * Servlet implementation class RegistroTarifaServlet
 */
@WebServlet("/RegistroTarifaServlet")
public class RegistroTarifaServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	public RegistroTarifaServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String distrito = request.getParameter("distrito");
		String monto = request.getParameter("monto");
		double montos = Double.parseDouble(monto);

		try {
			TarifaNegocio negocio = new TarifaNegocio();
			negocio.insertarTarifa(distrito, montos);
			// response.sendRedirect(request.getContextPath()+"/BuscarTarifaServlet");

			RequestDispatcher rd = request
					.getRequestDispatcher("tarifa_buscar.jsp");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response);
		}

	}

}
