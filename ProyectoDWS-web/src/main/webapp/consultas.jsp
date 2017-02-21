<%-- 
    Document   : consultas
    Created on : 21-feb-2017, 0:16:22
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
        <form action="BuscarProductoPorNombre" method="POST">
            <input type="text" name="nombre"/>
            <input type="submit" value="Buscar"/>
        </form>
    </body>
</html>
