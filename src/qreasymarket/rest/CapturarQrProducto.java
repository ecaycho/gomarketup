package qreasymarket.rest;

import java.util.Collection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Producto;
import qreasymarket.negocio.ProductoNegocio;
import net.sf.json.JSONArray;

@Path("/qr_buscar")
public class CapturarQrProducto {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String obtener(@QueryParam("qr") String codigoQR) {

		JSONArray arrayObj = new JSONArray();

		try {
			ProductoNegocio negocio = new ProductoNegocio();

			Collection<Producto> productos = negocio.buscarPorQR(codigoQR);
			System.out.println(productos.size());
			arrayObj.addAll(productos);

		} catch (DAOExcepcion e) {
			System.out.println("DAOExcepcion" + " " + e.getMessage());

		}
		return arrayObj.toString();
	}
}
