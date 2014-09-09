package qreasymarket.modelo;

import java.sql.Date;
import java.util.Collection;

public class Usuario {

	private int IdUsuario;
	private String Nombres;
	private String Paterno;
	private String Materno;
	private String Clave;
	private int Dni;
	private String Correo;
	private Date Fecha_nac;
	private String Sexo;
	public String RolNombre;
	private String Direccion;
	
	private Collection myControlInventario;
	private Collection myUsuarioRol;
	private Collection myOrdenEnvio;
	private Collection myFactura;

	
	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public int getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getPaterno() {
		return Paterno;
	}

	public void setPaterno(String paterno) {
		Paterno = paterno;
	}

	public String getMaterno() {
		return Materno;
	}

	public void setMaterno(String materno) {
		Materno = materno;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

	public int getDni() {
		return Dni;
	}

	public void setDni(int dni) {
		Dni = dni;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public Date getFecha_nac() {
		return Fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		Fecha_nac = fecha_nac;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public String getRolNombre() {
		return RolNombre;
	}

	public void setRolNombre(String rolNombre) {
		RolNombre = rolNombre;
	}

	public Collection getMyControlInventario() {
		return myControlInventario;
	}

	public void setMyControlInventario(Collection myControlInventario) {
		this.myControlInventario = myControlInventario;
	}

	public Collection getMyUsuarioRol() {
		return myUsuarioRol;
	}

	public void setMyUsuarioRol(Collection myUsuarioRol) {
		this.myUsuarioRol = myUsuarioRol;
	}

	public Collection getMyOrdenEnvio() {
		return myOrdenEnvio;
	}

	public void setMyOrdenEnvio(Collection myOrdenEnvio) {
		this.myOrdenEnvio = myOrdenEnvio;
	}

	public Collection getMyFactura() {
		return myFactura;
	}

	public void setMyFactura(Collection myFactura) {
		this.myFactura = myFactura;
	}

}
