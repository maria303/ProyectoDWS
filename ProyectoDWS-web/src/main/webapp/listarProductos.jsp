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
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <table>
            <thead>
            <tr>
                <th>Nombre</th>
                <th>Unidades</th>
                <th></th>
                <th>
                    <a href="agregarProducto.jsp" class="boton">
                        <i class="fa fa-plus" aria-hidden="true"></i>
                    </a></th>
            </tr>
            </thead><tbody>
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
                <td><a href="ModificarProducto?accion=editar&id=<%=id%>" class="boton">
                        <i class="fa fa-pencil" aria-hidden="true"></i>
                    </a></td>
                <td><a href="EliminarProducto?id=<%=id%>" class="boton">
                        <i class="fa fa-trash" aria-hidden="true"></i>
                    </a></td>
                </tr>
                <%}%></tbody>
        </table>
    </body>
</html>
