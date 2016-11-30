<%-- 
    Document   : modificarNota
    Created on : 30-nov-2016, 9:18:16
    Author     : alumno
--%>

<%@page import="java.util.Date"%>
<%@page import="com.fpmislata.domain.NotasPedido"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            NotasPedido nota = (NotasPedido) session.getAttribute("notaP");
            Date fechaNuev = nota.getFecha();
            String fechaFormateada = formatoFecha.format(fechaNuev);
            int id = nota.getId();
            String hora = nota.getHora();
            double cuenta = nota.getCuenta();
            int numMesa = nota.getNum_mesa();
        %>
        <h1>Modificar Nota</h1>

        <form action="NotaMod?accion=modificar&id=<%=id%>" method="post">

            <label for="numMesa">Numero Mesa: </label>
            <input type="text" name="numMesa" value="<%=numMesa%>" style="display: block;" />

            <label for="fecha">Fecha: </label>
            <input type="text" name="fecha" value="<%=fechaFormateada%>" style="display: block;"/>

            <label for="hora">Hora: </label>
            <input type="text" name="hora" value="<%=hora%>" style="display: block;"/>

            <label for="cuenta">Cuenta: </label>
            <input type="text" name="cuenta" value="<%=cuenta%>" style="display: block;"/>

            <input type="submit" name="guardar" value="Modificar">
        </form>
        <a href="listaNotas.jsp">Atras</a>
    </body>
</html>
