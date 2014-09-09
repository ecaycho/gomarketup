package qreasymarket.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import net.sf.json.JSONObject;
import qreasymarket.dao.UsuarioDAO;
import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.excepcion.LoginExcepcion;
import qreasymarket.modelo.Cliente;
import qreasymarket.modelo.Usuario;
import qreasymarket.negocio.ClienteNegocio;

@Path("/cliente_logueo")
public class ClienteLogueo {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String validar(@QueryParam("email") String EmailUsuario,@QueryParam("clave") String ClaveUsuario) throws LoginExcepcion {
		
		JSONObject arrayObj = new JSONObject();

		try {
			ClienteNegocio negocio = new ClienteNegocio();
			negocio.validarCliente(EmailUsuario, ClaveUsuario);
			return "listo";

		} catch (LoginExcepcion e) {
			System.out.println("LoginExcepcion"+" "+ e.getMessage());
			return "error";

		} catch (DAOExcepcion e) {
			System.out.println("DAOExcepcion"+" "+ e.getMessage());
			return "error";
		}

	}

}
