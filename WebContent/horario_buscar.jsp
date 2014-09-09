<%@page import="java.util.Collection"%>
<%@page import="qreasymarket.dao.HorarioDAO"%>

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
	<form id="form" name="form" method="post" action="BuscarHorarioServlet">
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
								src="images/RMI.png" width="122" height="15" border="0" usemap="#Map"></td>
						</tr>
						<tr>
							<td height="19" colspan="6">&nbsp;</td>
						</tr>
						<tr>
							<td height="19" colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td height="19">&nbsp;</td>
							<td height="19" colspan="2">Buscar por día: <input
								type="text" name="horario" id="horario"> <input
								type="submit" name="button" id="button" value="Buscar"></td>
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
								<table width="618" border="1" align="center" cellpadding="1"
									cellspacing="1">
									<tr>
										<th width="77" height="26" scope="col">Nro.</th>
										<th width="77" height="26" scope="col">Día.</th>
										<th width="223" scope="col">Turno 1</th>
										<th width="223" scope="col">Turno 2</th>
										<th width="223" scope="col">Turno 3</th>
										<th width="223" scope="col">Turno 4</th>
										<%@page import="java.util.*,qreasymarket.modelo.Horario"%>
										<%
											Collection<Horario> listaHorario = (ArrayList<Horario>) request
													.getAttribute("horariolista");
											if (listaHorario != null) {
												int i = 1;
												for (Horario h : listaHorario) {
										%>
									
									<tr>
										<td align="center"><%=i++%></td>
										<!--  <td align="center">
					<%out.print(i);%>
				</td>-->

										<td align="center">
											<%
												out.print(h.getIdHorario());
											%>
										</td>
										<td align="center">
											<%
												out.print(h.getTurno1());
											%>
										</td>

										<td align="center">
											<%
												out.print(h.getTurno2());
											%>
										</td>
										<td align="center">
											<%
												out.print(h.getTurno3());
											%>
										</td>
										<td align="center">
											<%
												out.print(h.getTurno4());
											%>
										</td>

										<td width="156" align="center"><a
											href="EditarHorarioServlet?idhorario=<%=h.getIdHorario()%>">Editar</a>
											
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
  <area shape="rect" coords="3,1,121,18" href="autentica_supervisorenvios.jsp">
</map>
</body>
</html>