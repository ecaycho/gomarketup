package qreasymarket.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.modelo.Horario;
import qreasymarket.negocio.HorarioNegocio;

import net.sf.json.JSONArray;

@Path("/horario_buscar")
public class HorarioBuscar {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String buscar(@QueryParam("idhorario") String idhorario) {

		JSONArray arrayObj = new JSONArray();
		
		try {
			HorarioNegocio negocio = new HorarioNegocio();
			Collection<Horario> horarios = negocio.Buscarhorario(idhorario);
			System.out.println(horarios.size());
			arrayObj.addAll(horarios);
						
		} catch (DAOExcepcion e) {
			System.out.println(e.getMessage());
		}

		return arrayObj.toString();
	}

}
