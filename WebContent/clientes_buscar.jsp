<%@page import="java.util.Collection"%>
<%@page import="qreasymarket.dao.ClienteDAO"%>
<%@page import="java.util.*,qreasymarket.modelo.Cliente"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar Cliente</title>
</head>
<body>
<form id="form" name="form" method="post" action="CajeraBuscarClienteServlet">
<p>Buscar cliente por DNI:</p>
<label>
 <input type="text" name="dni"
			id="dni" /> </label> <label><input type="submit"
			name="button1" id="button1" value="Buscar" /> 
</label>

<table width="703" height="60" border="1" cellpadding="0"
			cellspacing="0">
			<tr>
				<th width="45" height="26" scope="col">Nro.</th>
				<th width="159" scope="col">Nombres</th>
				<th width="173" scope="col">Apellido Paterno</th>
				<th width="173" scope="col">Apellido Materno</th>
				<th width="173" scope="col">Email</th>
				<th width="173" scope="col">Telefono</th>
				<th width="173" scope="col">Celular</th>
				<th width="173" scope="col">Direccion</th>
				<th width="173" scope="col">DNI</th>
				<th width="173" scope="col">Fecha Nac.</th>

				<%
					Collection<Cliente> dniCliente = (ArrayList<Cliente>) request.getAttribute("DniCliente");
					if (dniCliente != null) {
						int i = 1;
						for (Cliente c : dniCliente) {
				%>
			
			<tr>
				<td align="center"><%=i++%></td>
				<!--  <td align="center">
					<%out.print(i);%>
				</td>-->
				<td align="center">
					<%
						out.print(c.getNombres());
					%>
				</td>
				<td align="center">
					<%
						out.print(c.getApaterno());
					%>
				</td>
				<td align="center">
					<%
						out.print(c.getAmaterno());
					%>
				</td>
				<td align="center">
					<%
						out.print(c.getEmail());
					%>
				</td>
				<td align="center">
					<%
						out.print(c.getTelefono());
					%>
				</td>
				<td align="center">
					<%
						out.print(c.getCelular());
					%>
				</td>
				<td align="center">
					<%
						out.print(c.getDireccion());
					%>
				</td>
				<td align="center">
					<%
						out.print(c.getDni());
					%>
				</td>
				<td align="center">
					<%
						out.print(c.getFechaNac());
					%>
				</td>
				<!--  <td align="center">
					<a href="CajeraEditarProductoServlet?IdProducto=<%=c.getIdCliente()%>">Editar Productos</a>
				</td>-->
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