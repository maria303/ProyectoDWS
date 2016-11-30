<%-- 
    Document   : nuevoPedido
    Created on : 30-nov-2016, 9:59:02
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crear un pedido nuevo</h1>
	
	<form action="PedidoNuevo" method="post">
		<input type="hidden" name="accion" value="agregar"/>
	
		<label for="idproducto">Id del producto pedido:</label>
		<input type="text" name="idproducto" style="display: block;" />
                <br>
		<label for="cantidad">Cantidad:</label>
		<input type="text" name="cantidad" style="display: block;"/>
                <br>
		<input type="submit" value="Añadir" />
	</form>

	<a href="listaPedidos.jsp">Volver</a>
    </body>
</html>
