package qreasymarket.modelo;

import java.util.Date;

public class Cliente {
	private int IdCliente;
	private String Nombres;
	private String Apaterno;
	private String Amaterno;
	private String Dni;
	private int Telefono;
	private String Email;
	private String Clave;
	private String Direccion;
	private String FechaNac;
	private int Celular;

	public int getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApaterno() {
		return Apaterno;
	}

	public void setApaterno(String apaterno) {
		Apaterno = apaterno;
	}

	public String getAmaterno() {
		return Amaterno;
	}

	public void setAmaterno(String amaterno) {
		Amaterno = amaterno;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public int getTelefono() {
		return Telefono;
	}

	public void setTelefono(int telefono) {
		Telefono = telefono;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getFechaNac() {
		return FechaNac;
	}

	public void setFechaNac(String fechaNac) {
		FechaNac = fechaNac;
	}

	public int getCelular() {
		return Celular;
	}

	public void setCelular(int celular) {
		Celular = celular;
	}

}
