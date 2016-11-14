<%-- 
    Document   : agregarProducto
    Created on : 10-nov-2016, 20:25:27
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
        
        <form action="AltaProducto" method="POST">
            
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" style="display: block"/>
            <label for="unidades">Unidades:</label>
            <input type="text" name="unidades" style="display: block"/>
            
            <input type="submit" value="Añadir"/>
        </form>
    </body>
</html>
