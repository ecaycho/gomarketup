<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema de empleados</title>
</head>
<body>
	<form action="LoginUsuarioServlet" method="post">
		<table>
			<tr>
				<td width="123">Ingresar email:</td>
				<td width="169"><input type="text" name="correo" /></td>
				<td width="10">&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Ingresar clave:</td>
				<td><input type="password" name="clave" /></td>
				<td>&nbsp;</td>
			</tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<tr>
				<td height="35" colspan="2" align="center"><input type="submit"
					name="button" id="button" value="Ingresar" /></td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>