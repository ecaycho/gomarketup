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

@Path("/nuevo_listar_producto")
public class NuevoListaProducto {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String buscar(@QueryParam("id_lista_compra") int idlistacompra,
			@QueryParam("estado") String estado,
			@QueryParam("nombre_producto") String nombre) {

		JSONArray arrayObj = new JSONArray();

		try {
			ProductoNegocio negocio = new ProductoNegocio();

			Collection<Producto> productos = negocio.ListaNuevo(idlistacompra,
					estado, nombre);
			System.out.println(productos.size());
			arrayObj.addAll(productos);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
		}

		return arrayObj.toString();
	}

}
