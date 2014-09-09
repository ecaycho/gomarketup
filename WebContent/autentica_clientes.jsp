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
<form action="LoginClienteServlet" method="post">
<table  bgcolor="#FFFFFF" width="880" border="0" align="center" cellpadding="0" cellspacing="0">
<%@page import="java.util.*"%>
  <tr>
    <td height="162" colspan="8"><img src="images/logo_n.png" width="948" height="162" /></td>
  </tr>
  <tr>
    <td width="10" height="25">&nbsp;</td>
    <td colspan="2"><img src="images/bienvenido.png" width="82" height="12"></td>
    <td height="25" colspan="2"><p> ${sessionScope.USUARIO_ACTUAL.nombres} ${sessionScope.USUARIO_ACTUAL.apaterno} ${sessionScope.USUARIO_ACTUAL.amaterno}</p></td>
    <td width="369" height="25">&nbsp;</td>
    <td width="7" class="principal">&nbsp;</td>
    <td width="164" class="principal"><img src="images/RMI.png" width="161" height="25" border="0" usemap="#Map">
      <map name="Map">
        <area shape="rect" coords="-3,2,156,25" href="index.html">
      </map></td>
  </tr>
  <tr>
    <td height="19" colspan="8">&nbsp;</td>
    </tr>
  <tr>
    <td height="25" colspan="3">&nbsp;</td>
    <td height="25" colspan="5">&nbsp;</td>
    </tr>
  <tr>
    <td height="27">&nbsp;</td>
    <td width="15" height="27">&nbsp;</td>
    <td width="77">&nbsp;</td>
    <td width="311" rowspan="6">&nbsp;</td>
    <td colspan="4" rowspan="6">&nbsp;</td>
    </tr>
  <tr>
    <td height="56" colspan="3">&nbsp;</td>
    </tr>
  <tr>
    <td height="35" colspan="3">&nbsp;</td>
    </tr>
  <tr>
    <td height="68" colspan="3">&nbsp;</td>
    </tr>
  <tr>
    <td height="19" colspan="3">&nbsp;</td>
    </tr>
  <tr>
    <td height="19" colspan="3">&nbsp;</td>
    </tr>
  <tr>
    <td height="155" colspan="3">&nbsp;</td>
    <td height="155" colspan="2">&nbsp;</td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td height="26" colspan="8"><img src="images/panel_down.png" width="948" height="26" /></td>
  </tr>
</table>
</form>
</body>
</html>