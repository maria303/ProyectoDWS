<%-- 
    Document   : listaPedidos
    Created on : 30-nov-2016, 9:57:39
    Author     : alumno
--%>

<%@page import="com.fpmislata.domain.PedidosProd"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Pedidos</title>
    </head>
    <body>
        <h1>Listado de Pedidos</h1>

        <a href="nuevoPedido.jsp">Añadir Pedido</a>
        <br/>
        <br/>

        <table border="1">
            <tr>
                <th>ID Producto</th>
                <th>Cantidad</th>
                <th></th>
                <th></th>

            </tr>

            <%
                ArrayList<PedidosProd> listaPedidos = (ArrayList) session.getAttribute("pedidos");
                for (PedidosProd pedido : listaPedidos) {
                    
                    int id = pedido.getId();
                    int idProducto = pedido.getIdProducto();
                    int cantidad = pedido.getCantidad();
            %>                
            <tr>
                <td><%=idProducto%></td>
                <td><%=cantidad%></td>
                <td><a href="PedidoMod?accion=editar&id=<%=id%>">Modificar</a></td>
                <td><a href="EliminarPedido?id=<%=id%>">Eliminar</a></td>
            </tr>
            <% }%>
        </table>
    </body>
</html>
