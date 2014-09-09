package qreasymarket.negocio;

import java.util.Collection;

import qreasymarket.dao.ClienteDAO;
import qreasymarket.modelo.Cliente;
import qreasymarket.excepcion.LoginExcepcion;
import qreasymarket.excepcion.DAOExcepcion;

public class ClienteNegocio {

	public Cliente validarCliente(String email, String clave)
			throws DAOExcepcion, LoginExcepcion {

		ClienteDAO dao = new ClienteDAO();
		return dao.validar(email, clave);

	}

	public Cliente obtenerCliente(String email) throws DAOExcepcion {
		ClienteDAO dao = new ClienteDAO();
		return dao.obtenerEmail(email);
	}

	public Collection<Cliente> buscarPorEmail(String email) throws DAOExcepcion {
		ClienteDAO dao = new ClienteDAO();
		return dao.BuscarPorEmail(email);
	}

	public void insertarCliente(String nombre, String apaterno,
			String amaterno, String dni, int telefono, String email,
			String clave, String direccion, String fecha, int celular)
			throws DAOExcepcion {

		Cliente modelo = new Cliente();
		
		modelo.setNombres(nombre);
		modelo.setApaterno(apaterno);
		modelo.setAmaterno(amaterno);
		modelo.setDni(dni);
		modelo.setTelefono(telefono);
		modelo.setEmail(email);
		modelo.setClave(clave);
		modelo.setDireccion(direccion);
		modelo.setFechaNac(fecha);
		modelo.setCelular(celular);

		ClienteDAO dao = new ClienteDAO();
		dao.insertarCliente(modelo);

	}

}
