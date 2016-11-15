<%-- 
    Document   : modificarProducto
    Created on : 11-nov-2016, 9:07:02
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
        <h1>Hello World!</h1>
        
        <form action="ModificarProducto?accion=modificar&id=${producto.id}" method="POST">
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" value="${producto.nombre}" style="display: block"/>
            <label for="descripcion">Descripción:</label>
            <input type="text" name="descripcion" value="${producto.descripcion}" style="display: block"/>
            <label for="stock">Stock:</label>
            <input type="text" name="stock" value="${producto.stock}" style="display: block"/>
            
            <input type="submit" value="Modificar"/>
        </form>
    </body>
</html>
