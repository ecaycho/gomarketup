package qreasymarket.servlet.JefeAlmacen;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PortadaJefeAlmacenServlet")
public class PortadaJefeAlmacenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PortadaJefeAlmacenServlet() {
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
				.getRequestDispatcher("/autentica_jefealmacen.jsp");
		rd.forward(request, response);
	}
}
