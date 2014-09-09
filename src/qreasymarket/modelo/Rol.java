package qreasymarket.modelo;

import java.util.Collection;

public class Rol {
	private String RolNombre;
	private String Descripcion;
	private Collection myUsuarioRol;

	public String getRolNombre() {
		return RolNombre;
	}

	public void setRolNombre(String rolNombre) {
		RolNombre = rolNombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Collection getMyUsuarioRol() {
		return myUsuarioRol;
	}

	public void setMyUsuarioRol(Collection myUsuarioRol) {
		this.myUsuarioRol = myUsuarioRol;
	}

}
