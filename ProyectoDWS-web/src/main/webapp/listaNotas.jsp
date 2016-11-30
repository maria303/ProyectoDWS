<%-- 
    Document   : listaNotas
    Created on : 30-nov-2016, 9:17:11
    Author     : alumno
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.fpmislata.domain.NotasPedido"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Notas</h1>

        <a href="nuevaNota.jsp">Añadir Nota</a>
        <br/>
        <br/>

        <table border="1">
            <tr>
                <th>Num. Mesa</th>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Cuenta</th>
                <th></th>
                <th></th>

            </tr>

            <%
                ArrayList<NotasPedido> listaNotas = (ArrayList) session.getAttribute("notas");
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                for (NotasPedido nota : listaNotas) {

                    int id = nota.getId();
                    int numMesa = nota.getNum_mesa();
                    Date fechaNuev = nota.getFecha();
                    String fechaFormateada = formatoFecha.format(fechaNuev);                    
                    String hora = nota.getHora();
                    double cuenta = nota.getCuenta();
            %>                
            <tr>
                <td><%=numMesa%></td>
                <td><%=fechaFormateada%></td>
                <td><%=hora%></td>
                <td><%=cuenta%></td>
                <td><a href="NotaMod?accion=editar&id=<%=id%>">Modificar</a></td>
                <td><a href="EliminarNota?id=<%=id%>">Eliminar</a></td>
            </tr>
            <% }%>
        </table>
        <br>
        <a href="productosynotas.jsp">Atras</a>
    </body>
</html>
