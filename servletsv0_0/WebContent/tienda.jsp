<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; utf-8">
 <title>Mi Tienda!</title>
 </head>
 <body>
 <h1>Tienda Virtual</h1>
 <br>
 <form action="tienda.jsp" method="post">
	 <br>
	 <table align="center">
		 <tr>
			 <td align="center">escoja el artículo que desea:</td>
		 </tr>
		 <tr>
			 <td>
				 <select name="producto" size="1">
					 <option value="010">la trampa</option>
					 <option value="345">los pájaros</option>
					 <option value="554">matrix reloaded</option>
				 </select>
			 </td>
		 </tr>
		 <tr>
			 <td align="center">
				 <input type="submit" value="añadir al carrito...">
			 </td>
		 </tr>
	 </table>
 </form>
 <%
 @SuppressWarnings("unchecked")
 HashMap<String,Integer> carrito = 
		 (HashMap<String,Integer>)request.getSession().getAttribute("carrito");
 if (carrito == null) {
	 carrito = new HashMap<String, Integer>();
 }
 
 String producto = request.getParameter("producto");
 if (producto != null) {
	 Integer cantidad = (Integer) carrito.get(producto);
	 if (cantidad ==null)
		 cantidad = new Integer(1);
	 else 
		 cantidad = new Integer(cantidad.intValue() + 1);
	 carrito.put(producto, cantidad);
 }
 
 request.getSession().setAttribute("carrito", carrito);
 %>
 <br>
 <br>
 <center>
 	<H2>Carrito de la compra</h2>
 </center>
 <br>
 <center>
	 <%
		 Set<String> productos = carrito.keySet();
		 Iterator<String> iter = productos.iterator();
		 while ( iter.hasNext() ) {
		 String elemento = (String)iter.next();
	 %>
	 <br>Del producto <%=elemento%>, <%=(Integer)carrito.get(elemento)%> unidades.
	 <%
	 	}
	 %>
 </center>
 </body>
<html>
