<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>::QR-EasyMarket::</title>
</head>
<body>
	<form action="LoginClienteServlet" method="post">
		<table bgcolor="#FFFFFF" width="880" border="0" align="center"
			cellpadding="0" cellspacing="0">
			<tr>
				<td height="162" colspan="6"><img src="images/logo_n.png"
					width="948" height="162" /></td>
			</tr>
			<tr>
				<td width="248" height="647" rowspan="10"><p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p></td>
				<td height="130" colspan="3" rowspan="2">&nbsp;</td>
				<td width="55" height="27" class="principal">&nbsp;</td>
				<td width="193" class="principal"><img src="images/RMI.png"
					width="161" height="25" border="0" usemap="#Map"></td>
			</tr>
			<tr>
				<td height="122" colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td height="25" colspan="3">&nbsp;</td>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td width="161" rowspan="6"><img
					src="images/cliente_logueo.png" width="157" height="132"></td>
				<td height="27">&nbsp;</td>
				<td height="27">&nbsp;</td>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td width="72">Usuario:</td>
				<td width="219"><label for="email"></label> <input type="text"
					name="email"></td>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td>Contraseña:</td>
				<td><label for="clave"></label> <input type="password"
					name="clave"></td>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td height="24">&nbsp;</td>
				<td><input type="submit" name="button" id="button"
					value="Ingresar"></td>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td height="155" colspan="3">&nbsp;</td>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td height="26" colspan="6"><img src="images/panel_down.png"
					width="948" height="26" /></td>
			</tr>
		</table>
	</form>
	
	<map name="Map">
		<area shape="rect" coords="1,2,158,24" href="index.html">
	</map>
</body>
</html>