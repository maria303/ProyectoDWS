<%-- 
    Document   : listarProductosProveedores
    Created on : 18-nov-2016, 21:07:06
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
            <tr>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Stock</th>
                <th>Precio</th>
                <th>
                    <a href="agregarProducto.jsp" class="boton">
                        <i class="fa fa-plus-square" aria-hidden="true"></i>
                    </a>
                </th>
            </tr>
            <%
                ArrayList<Producto> lista = (ArrayList) session.getAttribute("productos");
                for(Producto producto : lista){
                    int id = producto.getId();
                    String nombre = producto.getNombre();
                    String descripcion = producto.getDescripcion();
                    int stock = producto.getStock();
                    double precio = producto.getPrecio();
            %>
            <tr>
                <td><%=nombre%></td>
                <td><%=descripcion%></td>
                <td><%=stock%></td>
                <td><%=precio%></td>
                <td><a href="ModificarProductoProveedor?accion=editar&id=<%=id%>" class="boton">
                        <i class="fa fa-pencil" aria-hidden="true"></i>
                    </a>
                    <a href="EliminarProducto?id=<%=id%>" class="boton">
                        <i class="fa fa-trash" aria-hidden="true"></i>
                    </a></td>
                </tr>
                <%}%>
        </table>
    </body>
</html>
