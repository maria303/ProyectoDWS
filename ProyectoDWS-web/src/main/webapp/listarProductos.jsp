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
        
        <table border="1">
            <tr>
                <th>Nombre</th>
                <th>Unidades</th>
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
            </tr>
                <%}%>
        </table>
    </body>
</html>
