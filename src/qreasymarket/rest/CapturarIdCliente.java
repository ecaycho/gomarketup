package qreasymarket.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Cliente;
import qreasymarket.negocio.ClienteNegocio;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Path("/capturar_idcliente")
public class CapturarIdCliente {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	
	public String obtener(@QueryParam("email") String UsuarioActual){
	
		
		//PRIMERA SOLUCION 
		JSONArray arrayObj = new JSONArray();
		
		try {
			ClienteNegocio negocio = new ClienteNegocio();
			Collection<Cliente> clientes = negocio.buscarPorEmail(UsuarioActual);
			System.out.println(clientes.size());
			arrayObj.addAll(clientes);
			
			
		} catch (DAOExcepcion e) {
			System.out.println("DAOExcepcion"+" "+ e.getMessage());
			
		}
		return arrayObj.toString();
		
	}
	
}
