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
</head>

<body>
<form id="form1" name="form1" method="post" action="CajeraActualizarProducto">
  <table  bgcolor="#E8F2FF" width="947" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="947" height="19" colspan="3"><table  bgcolor="#E8F2FF" width="947" border="0" align="center" cellpadding="0" cellspacing="0">
      <%@page import="java.util.*"%>
      <tr>
        <td height="162" colspan="7"><img src="images/logo_n.png" width="948" height="162" /></td>
      </tr>
      <tr>
        <td width="25" height="57">&nbsp;</td>
        <td width="94"><img src="images/bienvenido.png" width="82" height="12"></td>
        <td height="57" colspan="2"><p> ${sessionScope.USUARIO_ACTUAL.nombres} ${sessionScope.USUARIO_ACTUAL.paterno} ${sessionScope.USUARIO_ACTUAL.materno}</p></td>
        <td width="132" height="57" colspan="3"><img src="images/RMI.png" width="122" height="15" border="0" usemap="#Map"></td>
      </tr>
      <tr>
        <td height="19" colspan="7">&nbsp;</td>
      </tr>
      <tr>
        <td height="19" colspan="5">&nbsp;</td>
      </tr>
      <tr>
        <td height="190">&nbsp;</td>
        <td height="190">&nbsp;</td>
        <td width="398" rowspan="2"><%@page import = "qreasymarket.dao.ProductoDAO"%>
		<%@page import = "qreasymarket.modelo.Producto"%>
		<%Producto vo =(Producto)request.getAttribute("Producto"); %>
<table width="300" height="104" border="1" cellpadding="0" cellspacing="0">
    <tr>
      <td>ID:</td>
      <td><label>
        <input type="text" name="idproducto" id="idproducto" 
        value="<%=vo.getIdProducto() %>" />
      </label></td>
    </tr>
   
   
    <tr>
      <td>Precio:</td>
      <td><label>
        <input type="text" name="precio" id="precio" 
        value="<%=vo.getPrecio() %>" />
      </label></td>
    </tr>
    <tr>
      <td>Promocion:</td>
      <td><label>
        <input type="text" name="promocion" id="promocion" 
        value="<%=vo.getPromocionProducto() %>" />
      </label></td>
    </tr>
    
        <tr>
      <td>Descuento:</td>
      <td><label>
        <input type="text" name="descuento" id="descuento" 
        value="<%=vo.getDescuento()%>" />
      </label></td>
    </tr>
    
    <tr>
      <td colspan="2">
        <input type="submit" value="Guardar" />
        <input type="button" value="Regresar" onclick="window.location='productos_buscar.jsp' " />
	  </td>
    </tr>
  </table> 
 </td>
        <td width="299" rowspan="2">&nbsp;</td>
        <td height="190">&nbsp;</td>
      </tr>
      <tr>
        <td height="19">&nbsp;</td>
        <td height="19">&nbsp;</td>
        <td height="19">&nbsp;</td>
        </tr>
      <tr>
        <td height="42" colspan="5">&nbsp;</td>
      </tr>
      <tr>
        <td height="19" colspan="7">&nbsp;</td>
      </tr>
      <tr>
        <td height="26" colspan="7"><img src="images/panel_down.png" width="948" height="26" /></td>
      </tr>
    </table></td>
  </tr>
  </table>
</form>

<map name="Map">
  <area shape="rect" coords="0,-3,116,14" href="autentica_cajeras.jsp">
</map>
</body>
</html>