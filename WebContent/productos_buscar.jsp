<%@page import="java.util.Collection"%>
<%@page import="qreasymarket.dao.ProductoDAO"%>
<%@page import="java.util.*,qreasymarket.modelo.Producto"%>
<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>::QR-EasyMarket::</title>
<style type="text/css">
.principal {
	text-align: right;
}
</style>
</head>

<body>
	<form id="form" name="form" method="post"
		action="CajeraBuscaProductosServlet">
		<table bgcolor="#E8F2FF" width="947" border="0" align="center"
			cellpadding="0" cellspacing="0">
			<tr>
				<td width="947" height="19" colspan="3"><table
						bgcolor="#E8F2FF" width="947" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<%@page import="java.util.*"%>
						<tr>
							<td height="162" colspan="6"><img src="images/logo_n.png"
								width="948" height="162" /></td>
						</tr>
						<tr>
							<td width="13" height="57">&nbsp;</td>
							<td width="82"><img src="images/bienvenido.png" width="82"
								height="12"></td>
							<td width="682" height="57"><p>
									${sessionScope.USUARIO_ACTUAL.nombres}
									${sessionScope.USUARIO_ACTUAL.paterno}
									${sessionScope.USUARIO_ACTUAL.materno}</p></td>
							<td width="181" height="57" colspan="3"><img src="images/RMI.png" width="177" height="29" border="0" usemap="#Map"></td>
						</tr>
						<tr>
							<td height="19" colspan="6">&nbsp;</td>
						</tr>
						<tr>
							<td height="19" colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td height="19">&nbsp;</td>
							<td height="19" colspan="2">Buscar por nombre: <input
								type="text" name="nombreProducto" id="nombreProducto"> <input
								type="submit" name="button" id="button" value="Buscar">
							</td>

							<td height="19">&nbsp;</td>
						</tr>
						<tr>
							<td height="19">&nbsp;</td>
							<td height="19">&nbsp;</td>
							<td height="19">&nbsp;</td>
							<td height="19">&nbsp;</td>
						</tr>
						<tr>
							<td height="19" colspan="4">
								<table bgcolor="#FFFFFF" width="948" border="1" cellspacing="1" cellpadding="1">
									<tr>
										<th width="30" height="26" scope="col">Nro.</th>
										<th width="172" scope="col">Nombre de Producto</th>
										<th width="114" scope="col">Nombre de Marca</th>
										<th width="100" scope="col">Nombre de Categoria</th>
										<th width="88" scope="col">Precio</th>
										<th width="57" scope="col">Unidad</th>
										<!-- <th width="108" scope="col">Fecha Vencimiento</th> -->
										<th width="84" scope="col">Promocion</th>
										<th width="71" scope="col">Descuento</th>
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
										<td align="center"><%
											out.print(p.getUnidad());
										%>
										</td>
										<!-- <td align="center">
											<%out.print(p.getFechaVencimiento());%>
										</td> -->
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
										<td width="71" align="center"><a
											href="CajeraEditarProductoServlet?IdProducto=<%=p.getIdProducto()%>">Editar</a>
										</td>

										<%
											}
											}
										%>

									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td height="99" colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td height="19" colspan="6">&nbsp;</td>
						</tr>
						<tr>
							<td height="26" colspan="6"><img src="images/panel_down.png"
								width="948" height="26" /></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>

<map name="Map">
  <area shape="rect" coords="3,1,175,42" href="autentica_cajeras.jsp">
</map>
</body>
</html>