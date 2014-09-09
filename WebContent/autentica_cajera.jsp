<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema de Cajeras</title>
<script languaje="javascript" type="text/javascript">
	window.history.go(1);
</script>
</head>
<head>

</head>
<body>

	<table width="800" border="0" cellspacing="0" cellpadding="0">
		<%@page import="java.util.*"%>
		<td align="right"><a href="index.jsp">Cerrar sesión</a></td>

		<tr>
			<td>bienvenido: <b>${sessionScope.USUARIO_ACTUAL.nombres }</b> <b>${sessionScope.USUARIO_ACTUAL.paterno
					}</b> <b>${sessionScope.USUARIO_ACTUAL.materno }</b></td>
		</tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<tr>
			<td>Funcion: <b>${sessionScope.USUARIO_ACTUAL.rolNombre}</b></td>
		</tr>
		<td align="right"><a href="ListasCompra.jsp">Listas de Compras de Clientes</a>
		</td>

		<td>&nbsp;</td>
		<td width="17" height="19" align="right"><a href="empleados.jsp"></a>
		</td>
	</table>

</body>
</html>