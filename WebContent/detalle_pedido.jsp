<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table width="800" border="0" cellspacing="0" cellpadding="0">
		<%@page import="java.util.*"%>
		<td align="right"><a href="index.jsp">Cerrar sesión</a></td>
		<tr>
			<td>CAJERA: <b>${sessionScope.USUARIO_ACTUAL.nombres }</b> <b>${sessionScope.USUARIO_ACTUAL.paterno
					}</b> <b>${sessionScope.USUARIO_ACTUAL.materno }</b></td>
		</tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>

		<td align="right"><a href="autentica_cajera.jsp">Regresar al
				menu anterior</a></td>

		<td>&nbsp;</td>
		<td width="17" height="19" align="right"><a href="empleados.jsp"></a>
		</td>
		<td><form id="form" name="form" method="post"
				action="CajeraVerDetallesServlet"></form></td>
		<table width="703" height="60" border="1" cellpadding="0"
			cellspacing="0">
			<tr>
				<th width="45" height="26" scope="col">Nro.</th>
				<!-- <th width="159" scope="col">Lista de Compra</th> -->
				<th width="173" scope="col">Producto</th>
				<th width="173" scope="col">Precio</th>
				<th width="173" scope="col">Cantidad</th>
				<th width="173" scope="col">Subtotal</th>

				<%@page import="java.util.*,qreasymarket.modelo.DetallePedido"%>
				<%
					Collection<DetallePedido> detallepedido = (ArrayList<DetallePedido>) request.getAttribute("DetallePedido");
					if (detallepedido != null) {
						int i = 1;
						for (DetallePedido x : detallepedido) {
				%>
			
			<tr>
				<td align="center"><%=i++%></td>
				<!--  <td align="center">
					<%out.print(i);%>
				</td>-->
				<!-- <td align="center">
					<%out.print(x.getIdListaCompra());%>
				</td> -->
				<td align="center">
					<%
						out.print(x.getNombreProducto());
					%>
				</td>
				<td align="center">
					<%
						out.print(x.getPrecio());
					%>
				</td>
				<td align="center">
					<%
						out.print((int)x.getCantidad());
					%>
				</td>
				<td align="center">
					<%
						out.print("S./" + " " + x.getSubtotal());
					%>
				</td>

			</tr>
			<%
				}
				}
			%>
			</tr>
		</table>
	</table>
</body>
</html>