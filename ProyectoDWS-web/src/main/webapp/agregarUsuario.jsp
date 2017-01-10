<%-- 
    Document   : agregarUsuario
    Created on : 02-dic-2016, 9:31:16
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
        <h1>Agregar usuario</h1>
        <form action="AltaUsuario" method="POST">
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" style="display: block"/>
            <label for="apellidos">Apellidos:</label>
            <input type="text" name="apellidos" style="display: block"/>
            <label for="password">Contraseña:</label>
            <input type="text" name="password" style="display: block"/>
            
            <input type="submit" value="Añadir"/>
        </form>
    </body>
</html>
