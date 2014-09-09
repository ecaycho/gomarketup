package qreasymarket.modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

public class ListaCompra {
	private int IdListaCompra;
	private String NombreCompra;
	private String ServicioDelivery;
	private double MontoReferencial;
	private int myUsuario;
	private int IdCliente;
	private String Nombres;
	private String Apaterno;
	private String Amaterno;
	private String Email;
	private Date FechaCreacion;
	private String Fecha;
	private String Estado;
	public Double Cantidad;
	
	

	public Double getCantidad() {
		return Cantidad;
	}

	public void setCantidad(Double cantidad) {
		Cantidad = cantidad;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	private Collection<DetallePedido> detallepedido = new ArrayList<DetallePedido>();

	public int getIdListaCompra() {
		return IdListaCompra;
	}

	public void setIdListaCompra(int idListaCompra) {
		IdListaCompra = idListaCompra;
	}

	public String getNombreCompra() {
		return NombreCompra;
	}

	public void setNombreCompra(String nombreCompra) {
		NombreCompra = nombreCompra;
	}

	public String getServicioDelivery() {
		return ServicioDelivery;
	}

	public void setServicioDelivery(String servicioDelivery) {
		ServicioDelivery = servicioDelivery;
	}

	public double getMontoReferencial() {
		return MontoReferencial;
	}

	public void setMontoReferencial(double montoReferencial) {
		MontoReferencial = montoReferencial;
	}

	public int getMyUsuario() {
		return myUsuario;
	}

	public void setMyUsuario(int myUsuario) {
		this.myUsuario = myUsuario;
	}

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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Date getFechaCreacion() {
		return FechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}

	public Collection<DetallePedido> getDetallepedido() {
		return detallepedido;
	}

	public void setDetallepedido(Collection<DetallePedido> detallepedido) {
		this.detallepedido = detallepedido;
	}

}
