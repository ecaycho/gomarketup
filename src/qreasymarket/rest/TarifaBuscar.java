package qreasymarket.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Tarifa;
import qreasymarket.negocio.TarifaNegocio;

import net.sf.json.JSONArray;

@Path("/tarifa_buscar")
public class TarifaBuscar {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String buscar(@QueryParam("distrito") String distrito) {
		JSONArray arrayObj = new JSONArray();

		try {
			TarifaNegocio negocio = new TarifaNegocio();
			Collection<Tarifa> tarifas = negocio.buscarTarifa(distrito);
			System.out.println(tarifas.size());
			arrayObj.addAll(tarifas);

		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
		}

		return arrayObj.toString();
	}

}
