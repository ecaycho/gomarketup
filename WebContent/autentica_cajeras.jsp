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
<table width="604" border="0" align="center" cellpadding="0" background="images/fondo_logeo.png" style="background-repeat:repeat-y !important">
<%@page import="java.util.*"%>
  <tr>
    <td height="162" colspan="6"><img src="images/logo_n.png" width="948" height="162" /></td>
  </tr>
  <tr>
    <td width="18" height="25">&nbsp;</td>
    <td colspan="2"><img src="images/bienvenido.png" width="82" height="12"></td>
    <td width="520" height="25"><p> ${sessionScope.USUARIO_ACTUAL.nombres} ${sessionScope.USUARIO_ACTUAL.paterno} ${sessionScope.USUARIO_ACTUAL.materno}</p></td>
    <td width="369" colspan="2" class="principal"><img src="images/CRS.png" width="108" height="29" border="0" usemap="#Map"></td>
  </tr>
  <tr>
    <td height="19" colspan="6">&nbsp;</td>
    </tr>
  <tr>
    <td height="290" colspan="6">
    <table align="center" bgcolor="">
    <tr><td><img src="images/menu1_cajera.png" width="368" height="98" border="0" usemap="#Map2"></td>
      <td width="90" rowspan="3">&nbsp;</td>
    <td><img src="images/menu3_cajera.png" width="368" height="98" border="0" usemap="#Map4"></td></tr>
    <tr>
      <td>&nbsp;</td><td>&nbsp;</td></tr>
    <tr>
      <td><img src="images/menu2_cajera.png" width="368" height="98" border="0" usemap="#Map5"></td><td><img src="images/menu4_cajera.png" width="368" height="98" border="0" usemap="#Map6"></td></tr>
    </table>
	</td>
  </tr>
  <tr>
    <td height="19" colspan="6"></td>
  </tr>
  <tr>
    <td height="26" colspan="6"><img src="images/panel_down.png" width="948" height="26" /></td>
  </tr>
</table>
</form>
<map name="Map3">
  <area shape="rect" coords="5,1,368,102" href="lista_compra.jsp">
</map>

<map name="Map2">
  <area shape="rect" coords="2,3,366,97" href="productos_buscar.jsp">
</map>

<map name="Map4">
  <area shape="rect" coords="3,2,368,101" href="buscar_clientes.jsp">
</map>

<map name="Map5">
  <area shape="rect" coords="2,1,368,99" href="lista_compra.jsp">
</map>

<map name="Map6">
  <area shape="rect" coords="2,2,367,100" href="#">
</map>

<map name="Map">
  <area shape="rect" coords="2,0,111,33" href="login.jsp">
</map>
</body>
</html>