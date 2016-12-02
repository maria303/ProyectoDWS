<%-- 
    Document   : listarUsuarios
    Created on : 02-dic-2016, 9:43:00
    Author     : alumno
--%>

<%@page import="com.fpmislata.domain.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de usuarios</h1>
        
        <table>
            <tr>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>
                    <a href="agregarUsuario.jsp">
                        <i class="fa fa-plus-square" aria-hidden="true"></i>
                    </a>
                </th>
            </tr>
            <% ArrayList<Usuario> lista = (ArrayList) session.getAttribute("usuarios");
            for(Usuario usuario : lista){
                int id = usuario.getId();
                String nombre = usuario.getNombre();
                String apellidos = usuario.getApellidos();
            %>
            <tr>
                <td><%=nombre%></td>
                <td><%=apellidos%></td>
                <td>
                    <a href="EliminarUsuario?id=<%=id%>">
                        <i class="fa fa-trash" aria-hidden="true"></i>
                    </a>
                </td>
            </tr>
            <%}%>
        </table>
        <a href="index.jsp">Volver atrás</a>
    </body>
</html>
