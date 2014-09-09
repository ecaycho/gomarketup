package qreasymarket.modelo;

import java.sql.Date;
import java.util.Collection;

public class DetallePedido {
	private int IdListaCompra;
	private int IdProducto;
	private String FechaCreacion;
	private double Cantidad;
	private double Subtotal;
	private String Estado;
	

	public String NombreProducto;
	public double Precio;

	public String getNombreProducto() {
		return NombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public int getIdListaCompra() {
		return IdListaCompra;
	}

	public void setIdListaCompra(int idListaCompra) {
		IdListaCompra = idListaCompra;
	}

	public int getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}

	public String getFechaCreacion() {
		return FechaCreacion;
	}

	public void setFechaCreacion(String                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}
                                                                                                                                                                                                                                                                      
	public double getCantidad() {
		return Cantidad;
	}

	public void setCantidad(double cantidad) {
		Cantidad = cantidad;
	}

	public double getSubtotal() {
		return Subtotal;
	}

	public void setSubtotal(double subtotal) {
		Subtotal = subtotal;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

}
