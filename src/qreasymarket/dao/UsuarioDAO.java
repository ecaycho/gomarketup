package qreasymarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.security.auth.login.LoginException;
import javax.servlet.jsp.tagext.TryCatchFinally;

import qreasymarket.excepcion.DAOExcepcion;
import qreasymarket.excepcion.LoginExcepcion;
import qreasymarket.util.ConexionBD;

import qreasymarket.modelo.Rol;
import qreasymarket.modelo.Usuario;
//import qreasymarket.modelo.UsuarioRol;
//import qreasymarket.modelo.Rol;

public class UsuarioDAO extends BaseDAO {

	public Usuario Validar(String correo, String clave) throws DAOExcepcion,
			LoginExcepcion {
		String query = "select usuario.id_usuario,usuario.nombres,usuario.paterno,usuario.materno,usuario.clave,usuario.dni,usuario.correo,usuario.fecha_nacimiento,usuario.sexo,usuario.direccion,usuario_rol.rol_nombre from usuario left join usuario_rol on usuario_rol.id_usuario=usuario.id_usuario where usuario.correo=? and usuario.clave=?";
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;

		Usuario vo = new Usuario();

		try {

			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, correo);
			stmt.setString(2, clave);
			// stmt.setString(3,rolNombre);

			rs = stmt.executeQuery();

			if (rs.next()) {
				vo.setIdUsuario(rs.getInt("id_usuario"));
				vo.setNombres(rs.getString("nombres"));
				vo.setPaterno(rs.getString("paterno"));
				vo.setMaterno(rs.getString("materno"));
				vo.setClave(rs.getString("clave"));
				vo.setDni(rs.getInt("dni"));
				vo.setCorreo(rs.getString("correo"));
				vo.setFecha_nac(rs.getDate("fecha_nacimiento"));
				vo.setSexo(rs.getString("sexo"));
				vo.setDireccion(rs.getString("direccion"));
				vo.setRolNombre(rs.getString("rol_nombre"));

			} else {
				throw new LoginExcepcion(
						"USUARIO DEL SISTEMA NO EXISTE O ES INCORRECTO, INTENTE OTRA VEZ");
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
}
