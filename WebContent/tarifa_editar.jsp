<%@page import="java.util.Collection"%>


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
		action="ModificarTarifaServlet">
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
								src="images/RMI.png" width="122" height="15"></td>
						</tr>
						<tr>
							<td height="19" colspan="6">&nbsp;</td>
						</tr>
						<tr>
							<td height="19" colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td height="19">&nbsp;</td>
							<td height="19" colspan="2">&nbsp;</td>
							<td height="19">&nbsp;</td>
						</tr>
						<tr>
							<td height="19">&nbsp;</td>
							<td height="19">&nbsp;</td>
							<td height="19"><%@page import="qreasymarket.dao.TarifasDAO"%>
								<%@page import="qreasymarket.modelo.Tarifa;"%>
								<%
									Tarifa vo = (Tarifa) request.getAttribute("Tarifa");
								%>

								<table width="300" height="104" border="1" cellpadding="0"
									cellspacing="0">
									<tr>
										<td>ID:</td>
										<td><label> <input type="text" name="idtarifa"
												id="idtarifa" value="<%=vo.getIdTarifa()%>"
												readonly="readonly" />
										</label></td>
									</tr>




									<tr>
										<td width="82">Distrito:</td>
										<td width="212"><label> <input type="text"
												name="distrito" id="distrito" value="<%=vo.getDistrito()%>" />
										</label></td>
									</tr>
									<tr>
										<td>Monto:</td>
										<td><label> <input type="text" name="monto"
												id="monto" value="<%=vo.getMonto()%>" />
										</label></td>
									</tr>
									<tr>
										<td colspan="2"><input type="submit" value="Guardar" />
											<input type="button" value="Regresar"
											onclick="window.location='tarifa_buscar.jsp' " /></td>
									</tr>
								</table></td>
							<td height="19">&nbsp;</td>
						</tr>
						<tr>
							<td height="19" colspan="4">&nbsp;</td>
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
</body>
</html>