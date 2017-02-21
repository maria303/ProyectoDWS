<%-- 
    Document   : consultas
    Created on : 21-feb-2017, 0:16:22
    Author     : Maria
--%>

<%@page import="com.fpmislata.domain.Usuario"%>
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
                    <a class="navbar-brand" href="#">Administración Restaurante</a>
                </div>
                <!-- /.navbar-header -->
                <% Usuario usuarioSesion = (Usuario) session.getAttribute("usuario");
                    String nombreUsuario = usuarioSesion.getNombre();%>
                <ul class="nav navbar-top-links navbar-right">
                    <!-- /.dropdown -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i> <%=nombreUsuario%> <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="Logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
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
                                <a href="ListarProveedores"><i class="fa fa-dashboard fa-fw"></i> Proveedores y Productos</a>
                            </li>
                            <li>
                                <a href="ListarUsuarios"><i class="fa fa-edit fa-fw"></i> Usuarios</a>
                            </li>
                            <li>
                                <form action="BuscarProductoPorNombre" method="POST">
                                        <div class="col-lg-12">
                                            <div id="custom-search-input">
                                                <div class="input-group ">
                                                    <input type="text" name="nombre" class="search-query form-control" placeholder="Producto" />
                                                    <span class="input-group-btn">
                                                        <button class="btn btn-primary" type="submit">
                                                            <span class=" glyphicon glyphicon-search"></span>
                                                        </button>
                                                    </span>

                                                </div>
                                            </div>
                                        </div>
                                    </form>
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
                        <h1 class="page-header">Producto</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Producto
                            </div>
                            <div class="panel-body table-responsive" style="height: 160px;">
                                <table class="table table-striped">
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Descripción</th>
                                        <th>Stock</th>
                                        <th>Precio</th>
                                    </tr>
                                    <tr>
                                        <td>${producto.nombre}</td>
                                        <td>${producto.descripcion}</td>
                                        <td>${producto.stock}</td>
                                        <td>${producto.precio}</td>
                                    </tr>
                                </table>
                            </div>
                        </div>

                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /#page-wrapper -->

        </div>

        <script src="vendor/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="vendor/metisMenu/metisMenu.min.js" type="text/javascript"></script>
        <script src="dist/js/sb-admin-2.js" type="text/javascript"></script>
    </body>
</html>
