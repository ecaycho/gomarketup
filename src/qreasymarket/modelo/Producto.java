package qreasymarket.modelo;

import java.util.Collection;

public class Producto {

	private int IdProducto;
	private String NombreProducto;
	private String CodigoQr;
	private double Precio;
	private String Unidad;
	private String PromocionProducto;
	private double Descuento;
	private double Subtotal;
	private double Cantidad;
	private double Total;
	private double MontoReferente;
	private String Estado;
	
	
	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public double getMontoReferente() {
		return MontoReferente;
	}

	public void setMontoReferente(double montoReferente) {
		MontoReferente = montoReferente;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}

	private String FechaVencimiento;

	private String Imagen;
	private Collection myDetallePedido;
	private int myProvedor;
	private int myMarca;

	public double getSubtotal() {
		return Subtotal;
	}

	public double getCantidad() {
		return Cantidad;
	}

	public void setCantidad(double cantidad) {
		Cantidad = cantidad;
	}

	public void setSubtotal(double subtotal) {
		Subtotal = subtotal;
	}

	public int getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}

	public String getNombreProducto() {
		return NombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		NombreProducto = nombreProducto;
	}

	public String getCodigoQr() {
		return CodigoQr;
	}

	public void setCodigoQr(String codigoQr) {
		CodigoQr = codigoQr;
	}

	public double getPrecio() {
		return Precio;
	}

	public void setPrecio(double precio) {
		Precio = precio;
	}

	public String getUnidad() {
		return Unidad;
	}

	public void setUnidad(String unidad) {
		Unidad = unidad;
	}

	public String getPromocionProducto() {
		return PromocionProducto;
	}

	public void setPromocionProducto(String promocionProducto) {
		PromocionProducto = promocionProducto;
	}

	public double getDescuento() {
		return Descuento;
	}

	public void setDescuento(double descuento) {
		Descuento = descuento;
	}

	public String getFechaVencimiento() {
		return FechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		FechaVencimiento = fechaVencimiento;
	}

	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}

	public Collection getMyDetallePedido() {
		return myDetallePedido;
	}

	public void setMyDetallePedido(Collection myDetallePedido) {
		this.myDetallePedido = myDetallePedido;
	}

	public int getMyProvedor() {
		return myProvedor;
	}

	public void setMyProvedor(int myProvedor) {
		this.myProvedor = myProvedor;
	}

	public int getMyMarca() {
		return myMarca;
	}

	public void setMyMarca(int myMarca) {
		this.myMarca = myMarca;
	}

	public int getMyCategoria() {
		return myCategoria;
	}

	public void setMyCategoria(int myCategoria) {
		this.myCategoria = myCategoria;
	}

	public String getNombreMarca() {
		return NombreMarca;
	}

	public void setNombreMarca(String nombreMarca) {
		NombreMarca = nombreMarca;
	}

	public String getNombreCategoria() {
		return NombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		NombreCategoria = nombreCategoria;
	}

	public int getIdMarca() {
		return IdMarca;
	}

	public void setIdMarca(int idMarca) {
		IdMarca = idMarca;
	}

	public int getIdCategoriaTc() {
		return IdCategoriaTc;
	}

	public void setIdCategoriaTc(int idCategoriaTc) {
		IdCategoriaTc = idCategoriaTc;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public Collection getMyControlInventario() {
		return myControlInventario;
	}

	public void setMyControlInventario(Collection myControlInventario) {
		this.myControlInventario = myControlInventario;
	}

	private int myCategoria;

	public String NombreMarca;
	public String NombreCategoria;

	public int IdMarca;
	public int IdCategoriaTc;
	public int idProveedor;

	private Collection myControlInventario;

}
