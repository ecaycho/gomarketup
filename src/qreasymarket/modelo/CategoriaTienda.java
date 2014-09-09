package qreasymarket.modelo;

public class CategoriaTienda {
	private int IdCategoria;
	private String NombreCategoria;
	private String Descripcion;
	private int IdTipoTienda;

	public int getIdCategoria() {
		return IdCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return NombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		NombreCategoria = nombreCategoria;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getIdTipoTienda() {
		return IdTipoTienda;
	}

	public void setIdTipoTienda(int idTipoTienda) {
		IdTipoTienda = idTipoTienda;
	}

}
