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
		action="RegistroTarifaServlet">
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
							<td width="14" height="57">&nbsp;</td>
							<td width="86"><img src="images/bienvenido.png" width="82"
								height="12"></td>
							<td width="726" height="57"><p>
									${sessionScope.USUARIO_ACTUAL.nombres}
									${sessionScope.USUARIO_ACTUAL.paterno}
									${sessionScope.USUARIO_ACTUAL.materno}</p></td>
							<td width="122" height="57" colspan="3"><img
								src="images/RMI.png" width="122" height="15" border="0"
								usemap="#Map"></td>
						</tr>
						<tr>
							<td height="19" colspan="6">&nbsp;</td>
						</tr>
						<tr>
							<td height="19" colspan="4">&nbsp;</td>
						</tr>

						<tr>
							<td height="219" colspan="4"><table width="570" border="0"
									align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td width="66">&nbsp;</td>
										<td width="88">Distrito:</td>
										<td width="416"><label for="textfield"></label> <input
											type="text" name="distrito" id="distrito"></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>Monto:</td>
										<td><label for="textfield2"></label> <input type="text"
											name="monto" id="monto"></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td colspan="3" align="center"><label for="textfield2">
												<input type="submit" name="enviar" id="enviar"
												value="Enviar Datos">
										</label></td>
									</tr>
								</table></td>
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
		<area shape="rect" coords="3,1,127,15" href="autentica_cajeras.jsp">
	</map>
</body>
</html>