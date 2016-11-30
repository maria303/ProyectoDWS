<%-- 
    Document   : modificarPedido
    Created on : 30-nov-2016, 9:58:30
    Author     : alumno
--%>

<%@page import="com.fpmislata.domain.PedidosProd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            PedidosProd pedido = (PedidosProd) session.getAttribute("Pedido");
            int id = pedido.getId();
            int idProducto = pedido.getIdProducto();
            int cantidad = pedido.getCantidad();
        %>
        <h1>Modificar Nota</h1>

        <form action="PedidoMod?accion=modificar&id=<%=id%>" method="post">

            <label for="id">Id Pedido: </label>
            <input type="text" name="id" value="<%=id%>" style="display: block;" />

            <label for="idproducto">Id Producto: </label>
            <input type="text" name="idproducto" value="<%=idProducto%>" style="display: block;"/>

            <label for="cantidad">Cantidad: </label>
            <input type="text" name="cantidad" value="<%=cantidad%>" style="display: block;"/>

            <input type="submit" name="guardar" value="Modificar">
        </form>
        <a href="listaPedidos.jsp">Atras</a>
    </body>
</html>
