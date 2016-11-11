<%-- 
    Document   : listarProductos
    Created on : 10-nov-2016, 19:38:18
    Author     : Maria
--%>

<%@page import="com.fpmislata.domain.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <table>
            <tr>
                <th>Nombre</th>
                <th>Unidades</th>
                <th></th>
                <th></th>
            </tr>
            
            <%
                ArrayList<Producto> lista = (ArrayList) session.getAttribute("productos");
                for(Producto producto : lista){
                    int id = producto.getId();
                    String nombre = producto.getNombre();
                    int unidades = producto.getUnidades();
            %>
            
            <tr>
                <td><%=nombre%></td>
                <td><%=unidades%></td>
                <td><a href="ModificarProducto?accion=editar&id=<%=id%>">Mod</a></td>
                <td><a href="EliminarProducto?id=<%=id%>">Del</a></td>
            </tr>
                <%}%>
        </table>
        <a href="agregarProducto.jsp">Add</a>
    </body>
</html>
