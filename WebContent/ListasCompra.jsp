<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SISTEMA CAJERA</title>
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
				action="CajeraBuscarListaCompraServlet">

				<p>
					Buscar por correo de clientes: <label> <input type="text"
						name="correoLista" id="correoLista" />
					</label> <label> <input type="submit" name="button2" id="button2"
						value="Buscar" />
					</label>
				</p>
			</form></td>
		<table width="703" height="60" border="1" cellpadding="0"
			cellspacing="0">
			<tr>
				<th width="45" height="26" scope="col">Nro.</th>
				<th width="159" scope="col">Lista de Compra</th>
				<th width="173" scope="col">Fecha de Creacion</th>
				<th width="173" scope="col">Nombre</th>
				<th width="173" scope="col">Apellido Paterno</th>
				<th width="173" scope="col">Apellido Materno</th>
				<th width="173" scope="col">Correo</th>
				<th width="173" scope="col">Ver Detalles</th>

				<%@page import="java.util.*,qreasymarket.modelo.ListaCompra"%>
				<%
					Collection<ListaCompra> listacompra = (ArrayList<ListaCompra>) request
							.getAttribute("ListaCompra");
					if (listacompra != null) {
						int i = 1;
						for (ListaCompra x : listacompra) {
				%>
			
			<tr>
				<td align="center"><%=i++%></td>
				<!--  <td align="center">
					<%out.print(i);%>
				</td>-->
				<td align="center">
					<%
						out.print(x.getNombreCompra());
					%>
				</td>
				<td align="center">
					<%
						out.print(x.getFechaCreacion());
					%>
				</td>
				<td align="center">
					<%
						out.print(x.getNombres());
					%>
				</td>
				<td align="center">
					<%
						out.print(x.getApaterno());
					%>
				</td>
				<td align="center">
					<%
						out.print(x.getAmaterno());
					%>
				</td>
				<td align="center">
					<%
						out.print(x.getEmail());
					%>
				</td>
				<td align="center"><a
					href="CajeraVerDetallesServlet?IdListaCompra=<%=x.getIdListaCompra()%>">Ver
						productos</a></td>
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