<%@page import="java.util.Collection"%>
<%@page import="qreasymarket.dao.ClienteDAO"%>
<%@page import="java.util.*,qreasymarket.modelo.Cliente"%>
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
<form id="form" name="form" method="post" action="CajeraBuscarClienteServlet">
  <table  bgcolor="#E8F2FF" width="947" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="947" height="19" colspan="3"><table  bgcolor="#E8F2FF" width="947" border="0" align="center" cellpadding="0" cellspacing="0">
      <%@page import="java.util.*"%>
      <tr>
        <td height="162" colspan="6"><img src="images/logo_n.png" width="948" height="162" /></td>
      </tr>
      <tr>
        <td width="13" height="57">&nbsp;</td>
        <td width="82"><img src="images/bienvenido.png" width="82" height="12"></td>
        <td width="674" height="57"><p> ${sessionScope.USUARIO_ACTUAL.nombres} ${sessionScope.USUARIO_ACTUAL.paterno} ${sessionScope.USUARIO_ACTUAL.materno}</p></td>
        <td width="189" height="57" colspan="3"><img src="images/RMI.png" width="177" height="29" border="0" usemap="#Map"></td>
      </tr>
      <tr>
        <td height="19" colspan="6">&nbsp;</td>
      </tr>
      <tr>
        <td height="19" colspan="4">&nbsp;</td>
      </tr>
      <tr>
        <td height="19">&nbsp;</td>
        <td height="19" colspan="2">Buscar cliente por DNI: 
          <input type="text" name="dni" id="dni" />
         <input type="submit"
			name="button1" id="button1" value="Buscar" /></td>
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
        <table bgcolor="#FFFFFF" width="948" border="1" cellspacing="1" cellpadding="1">
          <tr>
				<th width="30" height="26" scope="col">Nro.</th>
				<th width="124" scope="col">Nombres</th>
				<th width="106" scope="col">Apellido Paterno</th>
				<th width="106" scope="col">Apellido Materno</th>
				<th width="81" scope="col">Email</th>
				<th width="74" scope="col">Telefono</th>
				<th width="82" scope="col">Celular</th>
				<th width="112" scope="col">Direccion</th>
				<th width="80" scope="col">DNI</th>
                <th width="100" scope="col">Fecha Nac.</th>
                
 			<%
					Collection<Cliente> dniCliente = (ArrayList<Cliente>) request.getAttribute("DniCliente");
					if (dniCliente != null) {
						int i = 1;
						for (Cliente c : dniCliente) {
				%> 
		<tr>
							<td align="center"><%=i++%></td>
				<!--  <td align="center">
					<%out.print(i);%>
				</td>-->
				<td align="center">
					<%
						out.print(c.getNombres());
					%>
				</td>
				<td align="center">
					<%
						out.print(c.getApaterno());
					%>
				</td>
				<td align="center">
					<%
						out.print(c.getAmaterno());
					%>
				</td>
				<td align="center">
					<%
						out.print(c.getEmail());
					%>
				</td>
				<td align="center">
					<%
						out.print(c.getTelefono());
					%>
				</td>
				<td align="center">
					<%
						out.print(c.getCelular());
					%>
				</td>
				<td align="center">
					<%
						out.print(c.getDireccion());
					%>
				</td>
				<td align="center">
					<%
						out.print(c.getDni());
					%>
				</td>
				<td align="center">
					<%
						out.print(c.getFechaNac());
					%>
				</td>
				<!--  <td align="center">
					<a href="CajeraEditarProductoServlet?IdProducto=<%=c.getIdCliente()%>">Editar Productos</a>
				</td>-->
	
			<%
				}
				}
			%>

			</tr>
        </table></td>
        </tr>
      <tr>
        <td height="99" colspan="4">&nbsp;</td>
      </tr>
      <tr>
        <td height="19" colspan="6">&nbsp;</td>
      </tr>
      <tr>
        <td height="26" colspan="6"><img src="images/panel_down.png" width="948" height="26" /></td>
      </tr>
    </table></td>
  </tr>
  </table>
</form>

<map name="Map">
  <area shape="rect" coords="2,1,178,28" href="autentica_cajeras.jsp">
</map>
</body>
</html>