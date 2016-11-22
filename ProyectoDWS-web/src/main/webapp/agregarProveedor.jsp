<%-- 
    Document   : agregarProveedor
    Created on : 16-nov-2016, 16:37:28
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
        <h1>Agregar proveedor</h1>
        <form action="AltaProveedor" method="POST">
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" style="display: block"/>
            <label for="direccion">Dirección:</label>
            <input type="text" name="direccion" style="display: block"/>
            <label for="ciudad">Ciudad:</label>
            <input type="text" name="ciudad" style="display: block"/>
            <label for="provincia">Provincia:</label>
            <input type="text" name="provincia" style="display: block"/>
            <label for="cp">Código Postal:</label>
            <input type="text" name="cp" style="display: block"/>
            <label for="telefono">Teléfono:</label>
            <input type="text" name="telefono" style="display: block"/>
            <label for="email">Email:</label>
            <input type="text" name="email" style="display: block"/>
            
            <input type="submit" value="Añadir"/>
        </form>
    </body>
</html>
