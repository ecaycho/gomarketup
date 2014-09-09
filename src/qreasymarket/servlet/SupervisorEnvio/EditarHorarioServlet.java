package qreasymarket.servlet.SupervisorEnvio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Horario;
import qreasymarket.negocio.HorarioNegocio;

/**
 * Servlet implementation class EditarHorarioServlet
 */
@WebServlet("/EditarHorarioServlet")
public class EditarHorarioServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarHorarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("idhorario");

		HorarioNegocio negocio = new HorarioNegocio();

		try {
		
			Horario vo= negocio.obtenerHorario(id);
			request.setAttribute("Horario", vo);
			request.getRequestDispatcher("horario_editar.jsp").forward(request,
					response);

		} catch (DAOExcepcion e) {
		
			System.out.println(e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
