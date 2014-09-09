package qreasymarket.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONArray;
import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Producto;

import qreasymarket.negocio.ProductoNegocio;

@Path("/listar_producto")
public class ListarProducto {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String buscar
	(@QueryParam("id_lista_compra") int id_lista,
			@QueryParam("estado") String estado,@QueryParam("nombre_producto") String producto) {

		JSONArray arrayObj = new JSONArray();

		try {
			ProductoNegocio negocio = new ProductoNegocio();

			Collection<Producto> productos = negocio.BuscarNomProducto(
					id_lista, estado,producto);
			System.out.println(productos.size());
			arrayObj.addAll(productos);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
		}

		return arrayObj.toString();
	}

}
