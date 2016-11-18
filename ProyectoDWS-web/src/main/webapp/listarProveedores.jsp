<%-- 
    Document   : listarProveedores
    Created on : 17-nov-2016, 20:27:09
    Author     : Maria
--%>

<%@page import="com.fpmislata.domain.Proveedor"%>
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
                <th>Dirección</th>
                <th>Ciudad</th>
                <th>Província</th>
                <th>Código Postal</th>
                <th>Teléfono</th>
                <th>Email</th>
                <th>
                    <a href="agregarProveedor.jsp" class="boton">
                        <i class="fa fa-plus-square" aria-hidden="true"></i>
                    </a>
                </th>
            </tr>
            <%
                ArrayList<Proveedor> lista = (ArrayList) session.getAttribute("proveedores");
                for(Proveedor proveedor : lista){
                    int id = proveedor.getId();
                    String nombre = proveedor.getNombre();
                    String direccion = proveedor.getDireccion();
                    String ciudad = proveedor.getCiudad();
                    String provincia = proveedor.getProvincia();
                    int cp = proveedor.getCp();
                    int telefono = proveedor.getTelefono();
                    String email = proveedor.getEmail();
            %>
            <tr>
                <td><a href="ListarProductosProveedores?id=<%=id%>"><%=nombre%></a></td>
                <td><%=direccion%></td>
                <td><%=ciudad%></td>
                <td><%=provincia%></td>
                <td><%=cp%></td>
                <td><%=telefono%></td>
                <td><%=email%></td>
                <td><!--<a href="ModificarProducto?accion=editar&id=<%=id%>" class="boton">
                        <i class="fa fa-pencil" aria-hidden="true"></i>
                    </a>
                    <a href="EliminarProducto?id=<%=id%>" class="boton">
                        <i class="fa fa-trash" aria-hidden="true"></i>
                    </a>--></td>
                </tr>
                <%}%>
        </table>
    </body>
</html>
