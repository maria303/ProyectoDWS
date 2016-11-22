<%-- 
    Document   : modificarProductoProveedor
    Created on : 22-nov-2016, 21:16:18
    Author     : Maria
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
        
        <form action="ModificarProductoProveedor?accion=modificar&id=${producto.id}" method="POST">
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" value="${producto.nombre}" style="display: block"/>
            <label for="descripcion">Descripción:</label>
            <input type="text" name="descripcion" value="${producto.descripcion}" style="display: block"/>
            <label for="stock">Stock:</label>
            <input type="text" name="stock" value="${producto.stock}" style="display: block"/>
            <label for="precio">Precio:</label>
            <input type="text" name="precio" value="${producto.precio}" style="display: block"/>
            
            <input type="submit" value="Modificar"/>
        </form>
    </body>
</html>
