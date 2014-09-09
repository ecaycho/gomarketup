<%@page import="java.util.Collection"%>
<%@page import="qreasymarket.dao.TarifasDAO"%>

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
	<form id="form" name="form" method="post" action="BuscarTarifaServlet">
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
							<td height="19" colspan="2">Buscar por distrito: 
							  <input
								type="text" name="distrito" id="distrito"> <input
								type="submit" name="button" id="button" value="Buscar">
								 <input type="button" name="button2" id="button2" value="Nuevo" onclick="window.location='tarifa_nueva.jsp' ">
								
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
								<table width="618" border="1" align="center" cellpadding="1" cellspacing="1">
									<tr>
										<th width="77" height="26" scope="col">Nro.</th>
										<th width="223" scope="col">Distrito</th>
										<th width="139" scope="col">Monto</th>
										<%@page import="java.util.*,qreasymarket.modelo.Tarifa"%>
										<%
											Collection<Tarifa> listarifa = (ArrayList<Tarifa>) request.getAttribute("tarifalista");
											if (listarifa != null) {
												int i = 1;
												for (Tarifa t : listarifa) {
										%>
									
									<tr>
										<td align="center"><%=i++%></td>
										<!--  <td align="center">
					<%out.print(i);%>
				</td>-->
										
										<td align="center">
											<%
												out.print(t.getDistrito());
											%>
										</td>
										<td align="center">
											<%
												out.print(t.getMonto());
											
											%>
										</td>

										<td width="156" align="center"><a
											href="EditarTarifaServlet?idtarifa=<%=t.getIdTarifa()%>">Editar</a>
										 - <a href="EliminarTarifaServlet?idtarifa=<%= t.getIdTarifa()%>" onclick="return confirm('¿Está seguro que desea eliminar');">Eliminar</a>
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
</body>
</html>