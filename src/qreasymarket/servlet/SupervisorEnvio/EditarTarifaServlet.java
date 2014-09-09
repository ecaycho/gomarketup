package qreasymarket.servlet.SupervisorEnvio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Tarifa;
import qreasymarket.negocio.TarifaNegocio;

@WebServlet("/EditarTarifaServlet")
public class EditarTarifaServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
static final long serialVersionUID = 1L;

	public EditarTarifaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("idtarifa");
		int tarifa = Integer.parseInt(id);

		//int id = Integer.parseInt(request.getParameter("IdTarifa"));
	
		TarifaNegocio modelo = new TarifaNegocio();
		
		try {
			Tarifa vo = modelo.obtenerTarifa(tarifa);
			request.setAttribute("Tarifa", vo);
			request.getRequestDispatcher("tarifa_editar.jsp").forward(request, response);
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
