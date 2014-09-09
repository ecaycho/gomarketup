<%@page import="java.util.Collection"%>
<%@page import="qreasymarket.dao.ProductoDAO"%>
<%@page import="java.util.*,qreasymarket.modelo.Producto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::Sistema::</title>
</head>
<body>
	<form id="form" name="form" method="post"
				action="CajeraBuscarListaCompraServlet">


		<p>Buscar Por nombre:</p>
		<label> <input type="text" name="nombreProducto"
			id="nombreProducto" /> </label> <label><input type="submit"
			name="button1" id="button1" value="Buscar" /> </label>

		<table width="703" height="60" border="1" cellpadding="0"
			cellspacing="0">
			<tr>
				<th width="45" height="26" scope="col">Nro.</th>
				<th width="159" scope="col">Nombre de Producto</th>
				<th width="173" scope="col">Nombre de Marca</th>
				<th width="173" scope="col">Nombre de Categoria</th>
				<th width="173" scope="col">Precio</th>
				<th width="173" scope="col">Unidad</th>
				<th width="173" scope="col">Fecha Vencimiento</th>
				<th width="173" scope="col">Promocion</th>
				<th width="173" scope="col">Descuento</th>

				<%
					Collection<Producto> lproductosNombre = (ArrayList<Producto>) request.getAttribute("ProductoNombre");
					if (lproductosNombre != null) {
						int i = 1;
						for (Producto p : lproductosNombre) {
				%>
			
			<tr>
				<td align="center"><%=i++%></td>
				<!--  <td align="center">
					<%out.print(i);%>
				</td>-->
				<td align="center">
					<%
						out.print(p.getNombreProducto());
					%>
				</td>
				<td align="center">
					<%
						out.print(p.getNombreMarca());
					%>
				</td>
				<td align="center">
					<%
						out.print(p.getNombreCategoria());
					%>
				</td>
				<td align="center">
					<%
						out.print(p.getPrecio());
					%>
				</td>
				<td align="center">
					<%
						out.print(p.getUnidad());
					%>
				</td>
				<td align="center">
					<%
						out.print(p.getFechaVencimiento());
					%>
				</td>
				<td align="center">
					<%
						out.print(p.getPromocionProducto());
					%>
				</td>
				
				<td align="center">
					<%
						out.print(p.getDescuento());
					%>
				</td>
				<td align="center">
					<a href="CajeraEditarProductoServlet?IdProducto=<%=p.getIdProducto()%>">Editar</a>
				</td>
			</tr>
			<%
				}
				}
			%>

			</tr>

		</table>


	</form>

</body>
</html>