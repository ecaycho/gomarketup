package qreasymarket.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONArray;
import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Cliente;
import qreasymarket.modelo.ListaCompra;
import qreasymarket.negocio.ClienteNegocio;
import qreasymarket.negocio.DetalleListaCompraNegocio;
import qreasymarket.negocio.ListaCompraNegocio;

@Path("/captura_idlistacompra")
public class DatosAdicionales {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String obtener(@QueryParam("email") String UserActual,@QueryParam("estado") String EstadoL) {

		JSONArray arrayObj = new JSONArray();

		try {
			ListaCompraNegocio negocio = new ListaCompraNegocio();
			Collection<ListaCompra> uactual = negocio.buscarPorEmailActual(UserActual,EstadoL);
			System.out.println(uactual.size());
			arrayObj.addAll(uactual);

		} catch (DAOExcepcion e) {
			System.out.println("DAOExcepcion" + " " + e.getMessage());

		}
		return arrayObj.toString();

	}

}
