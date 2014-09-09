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
<form id="form" name="form" method="post" action="CajeraVerDetallesServlet">
  <table  bgcolor="#E8F2FF" width="947" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="947" height="19" colspan="3">
    <table  bgcolor="#E8F2FF" width="947" border="0" align="center" cellpadding="0" cellspacing="0">
      <%@page import="java.util.*"%>
      <tr>
        <td height="162" colspan="6"><img src="images/logo_n.png" width="948" height="162" /></td>
      </tr>
      <tr>
        <td width="21" height="57">&nbsp;</td>
        <td width="82"><img src="images/bienvenido.png" width="82" height="12"></td>
        <td width="666" height="57"><p> ${sessionScope.USUARIO_ACTUAL.nombres} ${sessionScope.USUARIO_ACTUAL.paterno} ${sessionScope.USUARIO_ACTUAL.materno}</p></td>
        <td width="179" height="57" colspan="3"><img src="images/RMI.png" width="177" height="29" border="0" usemap="#Map"></td>
      </tr>
      <tr>
        <td height="19" colspan="6">&nbsp;</td>
      </tr>
      <tr>
       
      </tr>
      <tr>
      </tr>
   <tr>
        <td height="99" colspan="4">
        
        <table bgcolor="#FFFFFF" width="722" height="60" border="1" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<th width="43" height="26" scope="col">Nro.</th>
				<!-- <th width="159" scope="col">Lista de Compra</th> -->
				<th width="277" scope="col">Producto</th>
				<th width="130" scope="col">Precio</th>
				<th width="130" scope="col">Cantidad</th>
				<th width="130" scope="col">Subtotal</th>

				<%@page import="java.util.*,qreasymarket.modelo.DetallePedido"%>
				<%
					Collection<DetallePedido> detallepedido = (ArrayList<DetallePedido>) request.getAttribute("DetallePedido");
					if (detallepedido != null) {
						int i = 1;
						for (DetallePedido x : detallepedido) {
				%>
			
			<tr>
				<td align="center"><%=i++%></td>
				<!--  <td align="center">
					<%out.print(i);%>
				</td>-->
				<!-- <td align="center">
					<%out.print(x.getIdListaCompra());%>
				</td> -->
				<td align="center">
					<%
						out.print(x.getNombreProducto());
					%>
				</td>
				<td align="center">
					<%
						out.print("S./" + " " + x.getPrecio());
					%>
				</td>
				<td align="center">
					<%
						out.print((int)x.getCantidad());
					%>
				</td>
				<td align="center">
					<%
						out.print("S./" + " " + x.getSubtotal());
					%>
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
        <td height="19" colspan="6">&nbsp;</td>
      </tr>
      <tr>
        <td height="26" colspan="6"><img src="images/panel_down.png" width="948" height="26" /></td>
      </tr>
     </table>
</form>

<map name="Map">
  <area shape="rect" coords="1,1,173,27" href="autentica_cajeras.jsp">
</map>
</body>
</html>