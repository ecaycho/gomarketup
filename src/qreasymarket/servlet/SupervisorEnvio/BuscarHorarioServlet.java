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
import qreasymarket.modelo.Horario;
import qreasymarket.modelo.Tarifa;
import qreasymarket.negocio.HorarioNegocio;
import qreasymarket.negocio.TarifaNegocio;

@WebServlet("/BuscarHorarioServlet")
public class BuscarHorarioServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	public BuscarHorarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Dentro del Post del servlet BuscarHorario");

		String horario = request.getParameter("horario");
		HorarioNegocio negocio = new HorarioNegocio();

		try {
			Collection<Horario> listaHorario = negocio.Buscarhorario(horario);
			request.setAttribute("horariolista", listaHorario);
			RequestDispatcher rd = request.getRequestDispatcher("horario_buscar.jsp");
			rd.forward(request, response);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response);
		}

	}
	
	
	

}
