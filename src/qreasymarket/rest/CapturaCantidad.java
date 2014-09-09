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
import qreasymarket.modelo.DetallePedido;
import qreasymarket.modelo.ListaCompra;
import qreasymarket.negocio.ClienteNegocio;
import qreasymarket.negocio.DetalleListaCompraNegocio;
import qreasymarket.negocio.ListaCompraNegocio;

@Path("/cantidad_producto")
public class CapturaCantidad {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String obtener(@QueryParam("id_lista_compra") int idlistacompra,@QueryParam("id_producto") int idproducto) {

		JSONArray arrayObj = new JSONArray();

		try {
			DetalleListaCompraNegocio negocio = new DetalleListaCompraNegocio();
			Collection<DetallePedido> cantidadd = negocio.ObtenerCantidad(idlistacompra, idproducto);
			System.out.println(cantidadd.size());
			arrayObj.addAll(cantidadd);

		} catch (DAOExcepcion e) {
			System.out.println("DAOExcepcion" + " " + e.getMessage());

		}
		return arrayObj.toString();

	}

}
