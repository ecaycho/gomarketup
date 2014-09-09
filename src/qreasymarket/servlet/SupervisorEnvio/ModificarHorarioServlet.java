package qreasymarket.servlet.SupervisorEnvio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.negocio.HorarioNegocio;

/**
 * Servlet implementation class ModificarHorarioServlet
 */
@WebServlet("/ModificarHorarioServlet")
public class ModificarHorarioServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarHorarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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

		String id = request.getParameter("idhorario");
		String turno1 = request.getParameter("turno1");
		String turno2 = request.getParameter("turno2");
		String turno3 = request.getParameter("turno3");
		String turno4 = request.getParameter("turno4");

		HorarioNegocio negocio = new HorarioNegocio();

		try {
			negocio.actualizarHorario(id, turno1, turno2, turno3, turno4);
			RequestDispatcher rd = request
					.getRequestDispatcher("horario_buscar.jsp");

			rd.forward(request, response);
		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);

		}

	}

}
