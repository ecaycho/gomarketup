package qreasymarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.excepcion.LoginExcepcion;
import qreasymarket.modelo.Cliente;
import qreasymarket.util.ConexionBD;

public class ClienteDAO extends BaseDAO {

	public Collection<Cliente> BuscarPorDNI(String Dni) throws DAOExcepcion {
		System.out.println("ClienteDAO: Buscar Cliente por DNI:");

		String query = "SELECT id_cliente,nombres,apaterno,amaterno,email,telefono,celular,direccion,dni,fecha_nac from cliente WHERE dni like ?";
		Collection<Cliente> cliente = new ArrayList<Cliente>();

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + Dni + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente vo = new Cliente();

				vo.setIdCliente(rs.getInt("id_cliente"));
				vo.setNombres(rs.getString("nombres"));
				vo.setApaterno(rs.getString("apaterno"));
				vo.setAmaterno(rs.getString("amaterno"));
				vo.setEmail(rs.getString("email"));
				vo.setTelefono(rs.getInt("telefono"));
				vo.setCelular(rs.getInt("celular"));
				vo.setDireccion(rs.getString("direccion"));
				vo.setDni(rs.getString("dni"));
				vo.setFechaNac(rs.getString("fecha_nac"));

				cliente.add(vo);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return cliente;
	}

	
	public Collection<Cliente>BuscarPorEmail(String email)throws DAOExcepcion{
		
		String query = "SELECT id_cliente,nombres,apaterno,amaterno from cliente WHERE email like ?";
		Collection<Cliente> cliente = new ArrayList<Cliente>();
		
		Connection con = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + email + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente vo = new Cliente();

				vo.setIdCliente(rs.getInt("id_cliente"));
				vo.setNombres(rs.getString("nombres"));
				vo.setApaterno(rs.getString("apaterno"));
				vo.setAmaterno(rs.getString("amaterno"));
				
				cliente.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return cliente;
	}
	
		
	public Collection<Cliente> BuscarPorNombre(String Nombres)
			throws DAOExcepcion {
		System.out.println("ClienteDAO: BuscarPorNombre(String Nombres)");

		String query = "SELECT id_cliente,nombres,apaterno,amaterno,dni,telefono,celular,email,clave,direccion,fecha_nac from cliente WHERE nombres like ?";
		Collection<Cliente> cliente = new ArrayList<Cliente>();

		Connection con = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, "%" + Nombres + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente vo = new Cliente();

				vo.setIdCliente(rs.getInt("id_cliente"));
				vo.setNombres(rs.getString("nombres"));
				vo.setApaterno(rs.getString("apaterno"));
				vo.setAmaterno(rs.getString("amaterno"));
				vo.setDni(rs.getString("dni"));
				vo.setTelefono(rs.getInt("telefono"));
				vo.setCelular(rs.getInt("celular"));
				vo.setEmail(rs.getString("email"));
				vo.setClave(rs.getString("clave"));
				vo.setDireccion(rs.getString("direccion"));
				vo.setFechaNac(rs.getString("fecha_nac"));

				cliente.add(vo);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return cliente;
	}

	public Cliente validar(String email, String clave) throws DAOExcepcion,
			LoginExcepcion {
		String query = "select id_cliente,nombres,apaterno,amaterno,dni,telefono,celular,email,clave,direccion,fecha_nac from cliente where  email=? and clave=?";
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;

		Cliente vo = new Cliente();
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, email);
			stmt.setString(2, clave);

			rs = stmt.executeQuery();

			if (rs.next()) {
				vo.setIdCliente(rs.getInt("id_cliente"));
				vo.setNombres(rs.getString("nombres"));
				vo.setApaterno(rs.getString("apaterno"));
				vo.setAmaterno(rs.getString("amaterno"));
				vo.setDni(rs.getString("dni"));
				vo.setTelefono(rs.getInt("telefono"));
				vo.setCelular(rs.getInt("celular"));
				vo.setEmail(rs.getString("email"));
				vo.setClave(rs.getString("clave"));
				vo.setDireccion(rs.getString("direccion"));
				vo.setFechaNac(rs.getString("fecha_nac"));

			} else {
				throw new LoginExcepcion("USUARIO NO EXISTE O ES INCORRECTO");
			}
		} catch (LoginExcepcion e) {
			System.err.println(e.getMessage());
			throw new LoginExcepcion();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}

	public Cliente obtenerEmail(String email) throws DAOExcepcion {

		Cliente vo = new Cliente();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select id_cliente,email from cliente where email=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, email);

			rs = stmt.executeQuery();
			if (rs.next()) {
				vo.setIdCliente(rs.getInt(1));
				vo.setEmail(rs.getString(2));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;

	}

	public void insertarCliente(Cliente vo) throws DAOExcepcion {
		
		System.out.println("ClienteDAO:insertar cliente");
		String query="INSERT INTO cliente(id_cliente,nombres,apaterno,amaterno,dni,telefono,email,clave,direccion,fecha_nac,celular) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		Connection con=null;
		PreparedStatement stmt=null;

		try {
			con = ConexionBD.obtenerConexion();
			stmt=con.prepareStatement(query);
			stmt.setInt(1, vo.getIdCliente());
			stmt.setString(2, vo.getNombres());
			stmt.setString(3, vo.getApaterno());
			stmt.setString(4, vo.getAmaterno());
			stmt.setString(5, vo.getDni());
			stmt.setInt(6, vo.getTelefono());
			stmt.setString(7, vo.getEmail());
			stmt.setString(8, vo.getClave());
			stmt.setString(9, vo.getDireccion());
			stmt.setString(10, vo.getFechaNac());
			stmt.setInt(11, vo.getCelular());
			
		int i = stmt.executeUpdate();
		if(i !=1){
			throw new SQLException("No se puedo insertar");
		}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}
}
