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
<form id="form" name="form" method="post"
				action="CajeraBuscarListaCompraServlet">
  <table  bgcolor="#E8F2FF" width="947" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="947" height="19" colspan="3"><table  bgcolor="#E8F2FF" width="947" border="0" align="center" cellpadding="0" cellspacing="0">
      <%@page import="java.util.*"%>
      <tr>
        <td height="162" colspan="6"><img src="images/logo_n.png" width="948" height="162" /></td>
      </tr>
      <tr>
        <td width="20" height="57">&nbsp;</td>
        <td width="82"><img src="images/bienvenido.png" width="82" height="12"></td>
        <td width="668" height="57"><p> ${sessionScope.USUARIO_ACTUAL.nombres} ${sessionScope.USUARIO_ACTUAL.paterno} ${sessionScope.USUARIO_ACTUAL.materno}</p></td>
        <td width="181" height="57" colspan="3"><img src="images/RMI.png" width="177" height="29" border="0" usemap="#Map"></td>
      </tr>
      <tr>
        <td height="19" colspan="6">&nbsp;</td>
      </tr>
      <tr>
        <td height="19" colspan="4">&nbsp;</td>
      </tr>
      <tr>
        <td height="19">&nbsp;</td>
        <td height="19" colspan="2">Buscar por correo de clientes: 
          <input type="text"
						name="correoLista" id="correoLista">
         <input type="submit" name="button2" id="button2"
						value="Buscar"></td>
        <td height="19">&nbsp;</td>
        </tr>
      <tr>
        <td height="19" colspan="4">&nbsp;</td>
      </tr>
   <tr>
        <td height="99" colspan="4">
        
        <table bgcolor="#FFFFFF" width="950" height="60" border="1" cellpadding="0"
			cellspacing="0">
          <tr>
            <th width="33" height="26" scope="col">Nro.</th>
            <th width="145" scope="col">Lista de Compra</th>
            <th width="116" scope="col">Nombre</th>
            <th width="119" scope="col">Apellido Paterno</th>
            <th width="124" scope="col">Apellido Materno</th>
            <th width="185" scope="col">Correo</th>
            <th width="111" scope="col">Ver Detalles</th>
            <%@page import="java.util.*,qreasymarket.modelo.ListaCompra"%>
            <%
					Collection<ListaCompra> listacompra = (ArrayList<ListaCompra>) request
							.getAttribute("ListaCompra");
					if (listacompra != null) {
						int i = 1;
						for (ListaCompra x : listacompra) {
				%>
            <tr>
              <td align="center"><%=i++%></td>
              <!--  <td align="center">
					<%out.print(i);%>
				</td>-->
              <td align="center"><%
						out.print(x.getNombreCompra());
					%></td>
            <!--  <td align="center"><%
						out.print(x.getFechaCreacion());
					%></td> -->
              <td align="center"><%
						out.print(x.getNombres());
					%></td>
              <td align="center"><%
						out.print(x.getApaterno());
					%></td>
              <td align="center"><%
						out.print(x.getAmaterno());
					%></td>
              <td align="center"><%
						out.print(x.getEmail());
					%></td>
              <td align="center"><a
					href="CajeraVerDetallesServlet?IdListaCompra=<%=x.getIdListaCompra()%>">Ver
                productos</a></td>
              </tr>
          <%
				}
				}
			%>
        </table></td>
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
  <area shape="rect" coords="2,0,175,30" href="autentica_cajeras.jsp">
</map>
</body>
</html>