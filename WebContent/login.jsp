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
<script language="javascript" type="text/javascript">
function validar(){
	if(document.fvalida.correo.value.length==0){
		alert("Datos incorrectos,intente de nuevo")
		document.fvalida.nombre.focus()
		return 0;
	}
	if(document.fvalida.clave.value.length==0){
		alert("Datos incorrectos,intente de nuevo")
		document.fvalida.nombre.focus()
		return 0;
		
		}	
	}


</script>
</head>

<body>
<form action="LoginUsuarioServlet" method="post" name="fvalida">

<table width="880" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="162" colspan="6"><img src="images/logo_n.png" width="948" height="162" /></td>
  </tr>
</table>
<table width="948" border="0" align="center" cellpadding="0" background="images/fondo_logeo.png" style="background-repeat:repeat-y !important">
<tr>
<td colspan="3"><img src="images/RINICIO.png" width="135" height="29" border="0" align="right" usemap="#Map"></td>
</tr>
<tr>
<td></td>
</tr>
<tr>
<td height="363">
<table bgcolor="#FFFFFF" border="0" align="center" cellpadding="0" cellspacing="0"><tr>
  <td><img src="images/Encabezado_login.png" width="354" height="22"></td></tr><tr><td>
<table border="0" align="center">
<tr>
<td colspan="2" rowspan="5" class="principal"><img src="images/clientes_login.png" width="128" height="128"></td><td class="principal">Usuario:</td><td><label for="correo"></label>
      <input type="text" name="correo"></td>
</tr>
<tr>
  <td>&nbsp;</td><td>&nbsp;</td>
</tr>
<tr><td>Clave:</td><td><label for="clave"></label>
      <input type="password" name="clave"></td>
</tr>
<tr>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
</tr>
<tr>
  <td colspan="2" align="center"><input type="submit" name="button" id="button" value="Ingresar" onClick="validar()"></td>
  </tr>
</table>
</td></tr></table>
</td></tr>
<tr>
<td>&nbsp;</td>
</tr>
</table>
<table width="880" border="0" align="center" cellpadding="0" cellspacing="0">
 	<tr>
    <td colspan="3" align="center"><img src="images/panel_down.png" width="948" height="26" /></td>
    </tr>
</table>

</form>

<map name="Map">
  <area shape="rect" coords="2,1,134,29" href="index.html">
</map>
</body>
</html>