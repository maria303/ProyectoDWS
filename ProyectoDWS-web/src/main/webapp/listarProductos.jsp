<%-- 
    Document   : inicio
    Created on : 18-dic-2016, 17:56:41
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
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="dist/css/sb-admin-2.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Restaurante</a>
                </div>
                <!-- /.navbar-header -->

                <ul class="nav navbar-top-links navbar-right">
                    <!-- /.dropdown -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="login.jsp"><i class="fa fa-sign-in fa-fw"></i> Acceder</a>
                            </li>
                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <li>
                                <a href="ListarProductos"><i class="fa fa-dashboard fa-fw"></i> Productos</a>
                            </li>
                            <li>
                                <a href="Notas"><i class="fa fa-table fa-fw"></i> Notas</a>
                            </li>
                        </ul>
                    </div>
                    <!-- /.sidebar-collapse -->
                </div>

                <!-- /.navbar-static-side -->
            </nav>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Productos</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                    <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Productos
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive"  style="height: 160px;">
                                     <table class="table table-striped">
                                        <tr>
                                                <th>Nombre</th>
                                                <th>Descripción</th>
                                                <th>Stock</th>
                                                <th></th>
                                            </tr>
                                            <%
                                                ArrayList<Producto> lista = (ArrayList) session.getAttribute("productos");
                                                for (Producto producto : lista) {
                                                    int id = producto.getId();
                                                    String nombre = producto.getNombre();
                                                    String descripcion = producto.getDescripcion();
                                                    int stock = producto.getStock();
                                            %>
                                            <tr>
                                                <td><%=nombre%></td>
                                                <td><%=descripcion%></td>
                                                <td><%=stock%></td>
                                                <td>
                                                    <a href="ModificarProducto?accion=editar&id=<%=id%>" class="boton">
                                                        <i class="fa fa-pencil" aria-hidden="true"></i>
                                                    </a>
                                                </td>
                                            </tr>
                                            <%}%>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <script src="vendor/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="vendor/metisMenu/metisMenu.min.js" type="text/javascript"></script>
        <script src="dist/js/sb-admin-2.js" type="text/javascript"></script>
    </body>
</html>
