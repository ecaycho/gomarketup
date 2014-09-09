package qreasymarket.servlet.Cajera;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PortadaCajeraServlet")
public class PortadaCajeraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PortadaCajeraServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/autentica_cajeras.jsp");
		rd.forward(request, response);
	}
}
