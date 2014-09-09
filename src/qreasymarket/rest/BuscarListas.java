package qreasymarket.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONArray;
import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.ListaCompra;
import qreasymarket.negocio.ListaCompraNegocio;

@Path("/buscar_lista")
public class BuscarListas {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String buscar
	(@QueryParam("nombre_compra") String nombre,@QueryParam("id_lista_compra") int idlistacompra,
			@QueryParam("estado") String estado) {

		JSONArray arrayObj = new JSONArray();

		try {
			ListaCompraNegocio negocio = new ListaCompraNegocio();

			Collection<ListaCompra> listas = negocio.buscarListas(nombre,idlistacompra, estado);
			System.out.println(listas.size());
			arrayObj.addAll(listas);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
		}

		return arrayObj.toString();
	}

}

