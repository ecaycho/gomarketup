package qreasymarket.servlet.Cliente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Cliente;
import qreasymarket.negocio.ClienteNegocio;

@WebServlet("/RegistroClienteServlet")
public class RegistroClienteServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	public RegistroClienteServlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String a = request.getParameter("nombre");
		String b = request.getParameter("apaterno");
		String c = request.getParameter("amaterno");
		String d = request.getParameter("dni");
		String e1 = request.getParameter("telefono");
		int tele = Integer.parseInt(e1);
		String f = request.getParameter("email");
		String g = request.getParameter("clave");
		String h = request.getParameter("direccion");
		String i = request.getParameter("fechanac");
		String j = request.getParameter("celular");
		int cel = Integer.parseInt(j);

		try {
			ClienteNegocio clinegocio = new ClienteNegocio();
			clinegocio.insertarCliente(a, b, c, d, tele, f, g, h, i, cel);
			
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
			
		} catch (DAOExcepcion e) {
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response);
		}

	}

}
