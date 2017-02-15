<%-- 
    Document   : prueba1
    Created on : 17-dic-2016, 19:18:51
    Author     : Maria
--%>

<%@page import="com.fpmislata.domain.Usuario"%>
<%@page import="com.fpmislata.domain.Producto"%>
<%@page import="com.fpmislata.domain.Proveedor"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--<link href="css/main.css" rel="stylesheet" type="text/css"/>-->

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
                    <a class="navbar-brand" href="index.html">SB Admin v2.0</a>
                </div>
                <!-- /.navbar-header -->
                <% Usuario usuarioSesion = (Usuario) session.getAttribute("usuario");
                String nombreUsuario = usuarioSesion.getNombre(); %>
                <ul class="nav navbar-top-links navbar-right">
                    <!-- /.dropdown -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i> <%=nombreUsuario%> <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                            </li>
                            <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                            </li>
                            <li class="divider"></li>
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
                                <a href="PedidosProductos"><i class="fa fa-table fa-fw"></i> Pedidos</a>
                            </li>
                            <li>
                                <a href="ListarUsuarios"><i class="fa fa-edit fa-fw"></i> Usuarios</a>
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
                        <h1 class="page-header">Proveedores y sus productos</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Proveedores
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive"  style="height: 160px;">
                                     <table class="table table-striped">
                                        <tr>
                                            <th>Nombre</th>
                                            <th>Dirección</th>
                                            <th>Ciudad</th>
                                            <th>Província</th>
                                            <th>Código Postal</th>
                                            <th>Teléfono</th>
                                            <th>Email</th>
                                            <th>
                                                <a href="agregarProveedor.jsp" class="boton">
                                                    <i class="fa fa-plus-square" aria-hidden="true"></i>
                                                </a>
                                            </th>
                                        </tr>
                                        <%
                                            ArrayList<Proveedor> lista = (ArrayList) session.getAttribute("proveedores");
                                            for (Proveedor proveedor : lista) {
                                                int id = proveedor.getId();
                                                String nombre = proveedor.getNombre();
                                                String direccion = proveedor.getDireccion();
                                                String ciudad = proveedor.getCiudad();
                                                String provincia = proveedor.getProvincia();
                                                int cp = proveedor.getCodigoPostal();
                                                int telefono = proveedor.getTelefono();
                                                String email = proveedor.getEmail();
                                                

                                        %>
                                        <tr>
                                            <td><a href="ListarProductosPorProveedores?id=<%=id%>"><%=nombre%></a></td>
                                            <td><%=direccion%></td>
                                            <td><%=ciudad%></td>
                                            <td><%=provincia%></td>
                                            <td><%=cp%></td>
                                            <td><%=telefono%></td>
                                            <td><%=email%></td>
                                            <td>
                                                <a href="EliminarProveedor?id=<%=id%>" class="boton">
                                                    <i class="fa fa-trash" aria-hidden="true"></i>
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
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <% String nombreProveedor = (String) session.getAttribute("nombreProveedor");
                                    if (nombreProveedor.equals("null")) {
                                        nombreProveedor = "Productos";
                                    } else {
                                        nombreProveedor = "Productos de " + nombreProveedor;
                                    }
                                %>
                                <%=nombreProveedor%>
                            </div>
                            <div class="panel-body table-responsive" style="height: 160px;">
                                <table class="table table-striped">
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Descripción</th>
                                        <th>Stock</th>
                                        <th>Precio</th>
                                        <th>
                                            <% if(!nombreProveedor.equals("Productos")){%>
                                            <a href="agregarProducto.jsp" class="boton">
                                                <i class="fa fa-plus-square" aria-hidden="true"></i>
                                            </a><%}%>
                                        </th>
                                    </tr>
                                    <%
                                        ArrayList<Producto> listaProductos = (ArrayList) session.getAttribute("productos");
                                        for (Producto producto : listaProductos) {
                                            int id = producto.getId();
                                            String nombre = producto.getNombre();
                                            String descripcion = producto.getDescripcion();
                                            int stock = producto.getStock();
                                            double precio = producto.getPrecio();
                                    %>
                                    <tr>
                                        <td><%=nombre%></td>
                                        <td><%=descripcion%></td>
                                        <td><%=stock%></td>
                                        <td><%=precio%></td>
                                        <td>
                                            <a href="ModificarProductoProveedor?accion=editar&id=<%=id%>" class="boton">
                                                <i class="fa fa-pencil" aria-hidden="true"></i>
                                            </a>
                                            <a href="EliminarProducto?id=<%=id%>" class="boton">
                                                <i class="fa fa-trash" aria-hidden="true"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <%}%>
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
