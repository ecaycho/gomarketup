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
		action="ModificarHorarioServlet">
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
							<td height="19" colspan="2">&nbsp;</td>
							<td height="19">&nbsp;</td>
						</tr>
						<tr>
							<td height="19">&nbsp;</td>
							<td height="19">&nbsp;</td>
							<td height="19"><%@page import="qreasymarket.dao.HorarioDAO"%>
								<%@page import="qreasymarket.modelo.Horario;"%>
								<%
									Horario vo = (Horario) request.getAttribute("Horario");
								%>

								<table width="300" height="104" border="1" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td>ID:</td>
										<td><label> <input type="text" name="idhorario"
												id="idhorario" value="<%=vo.getIdHorario()%>"
												readonly="readonly" />
										</label></td>
									</tr>

									<tr>
										<td width="100">Turno Nro. 1:</td>
										<td width="194"><label> <input type="text"
												name="turno1" id="turno1" value="<%=vo.getTurno1()%>" />
										</label></td>
									</tr>

									<tr>
										<td width="100">Turno Nro. 2:</td>
										<td width="194"><label> <input type="text"
												name="turno2" id="turno2" value="<%=vo.getTurno2()%>" />
										</label></td>
									</tr>
									<tr>
										<td width="100">Turno Nro. 3:</td>
										<td width="194"><label> <input type="text"
												name="turno3" id="turno3" value="<%=vo.getTurno3()%>" />
										</label></td>
									</tr>
									<tr>
										<td width="100">Turno Nro. 4:</td>
										<td width="194"><label> <input type="text"
												name="turno4" id="turno4" value="<%=vo.getTurno4()%>" />
										</label></td>
									</tr>

									<tr>
										<td colspan="2"><input type="submit" value="Guardar" />
											<input type="button" value="Regresar"
											onclick="window.location='horario_buscar.jsp' " /></td>
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

<map name="Map">
  <area shape="rect" coords="3,1,121,14" href="autentica_supervisorenvios.jsp">
</map>
</body>
</html>