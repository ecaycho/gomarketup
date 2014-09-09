<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
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
<script languaje="javascript" type="text/javascript">
	window.history.go(1);
</script>
</head>

<body>
<form action="LoginUsuarioServlet" method="post">
<table  bgcolor="#E8F2FF" width="880" border="0" align="center" cellpadding="0" cellspacing="0">
<%@page import="java.util.*"%>
  <tr>
    <td height="162" colspan="10"><img src="images/logo_n.png" width="948" height="162" /></td>
  </tr>
  <tr>
    <td width="25" height="25">&nbsp;</td>
    <td colspan="2"><img src="images/bienvenido.png" width="82" height="12"></td>
    <td height="25" colspan="2"><p> ${sessionScope.USUARIO_ACTUAL.nombres} ${sessionScope.USUARIO_ACTUAL.paterno} ${sessionScope.USUARIO_ACTUAL.materno}</p></td>
    <td height="25" colspan="2">&nbsp;</td>
    <td width="180" class="principal">&nbsp;</td>
    <td colspan="2" class="principal"><img src="images/CRS.png" width="95" height="12" align="left"></td>
  </tr>
  <tr>
    <td height="19" colspan="10">&nbsp;</td>
    </tr>
  <tr>
    <td height="98">&nbsp;</td>
    <td width="90" rowspan="7">&nbsp;</td>
    <td height="98" colspan="2"><img src="images/menu1_supervisor.png" width="368" height="98" border="0" usemap="#Map"></td>
    <td width="4" height="98">&nbsp;</td>
    <td height="98">&nbsp;</td>
    <td height="98">&nbsp;</td>
    <td height="98">&nbsp;</td>
    <td height="98">&nbsp;</td>
    <td width="111" rowspan="7">&nbsp;</td>
    </tr>
  <tr>
    <td height="19">&nbsp;</td>
    <td colspan="2">&nbsp;</td>
    <td rowspan="6">&nbsp;</td>
    <td width="29" rowspan="6">&nbsp;</td>
    <td colspan="3" rowspan="5">&nbsp;</td>
    </tr>
  <tr>
    <td height="94">&nbsp;</td>
    <td height="94" colspan="2"><img src="images/menu2_supervisor.png" width="368" height="98" border="0" usemap="#Map2"></td>
    </tr>
  <tr>
    <td height="19">&nbsp;</td>
    <td width="4" height="19">&nbsp;</td>
    <td width="364">&nbsp;</td>
    </tr>
  <tr>
    <td height="104">&nbsp;</td>
    <td height="104" colspan="2"><img src="images/menu3_supervisor.png" width="368" height="98" border="0" usemap="#Map3"></td>
    </tr>
  <tr>
    <td height="19">&nbsp;</td>
    <td height="19">&nbsp;</td>
    <td width="364">&nbsp;</td>
    </tr>
  <tr>
    <td height="31">&nbsp;</td>
    <td height="31" colspan="2">&nbsp;</td>
    <td width="123">&nbsp;</td>
    <td>&nbsp;</td>
    <td width="18">&nbsp;</td>
    </tr>
  <tr>
    <td height="19" colspan="3">&nbsp;</td>
    <td height="19" colspan="2">&nbsp;</td>
    <td colspan="5">&nbsp;</td>
  </tr>
  <tr>
    <td height="26" colspan="10"><img src="images/panel_down.png" width="948" height="26" /></td>
  </tr>
</table>
</form>

<map name="Map">
  <area shape="rect" coords="12,2,359,97" href="tarifa_buscar.jsp">
</map>

<map name="Map2">
  <area shape="rect" coords="13,2,359,99" href="horario_buscar.jsp">
</map>

<map name="Map3">
  <area shape="rect" coords="14,4,357,94" href="#">
</map>
</body>
</html>