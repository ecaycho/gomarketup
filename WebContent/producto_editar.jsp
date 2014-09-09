<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form id="form1" name="form1" method="post" action="CajeraActualizarProducto"></form>
<%@page import = "qreasymarket.dao.ProductoDAO"%>
<%@page import = "qreasymarket.modelo.Producto"%>


<%Producto vo =(Producto)request.getAttribute("Producto"); %>

<table width="300" height="104" border="1" cellpadding="0" cellspacing="0">
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
        <input type="button" value="Regresar" onclick="window.location='producto_buscar.jsp' " />
	  </td>
    </tr>
  </table> 






</body>
</html>