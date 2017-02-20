<%-- 
    Document   : modificarProducto
    Created on : 11-nov-2016, 9:07:02
    Author     : alumno
--%>

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
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <form class="form-horizontal" role="form" action="ModificarProducto?accion=modificar&id=${producto.id}" method="POST">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Modificar producto</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="nombre">Nombre:</label>
                            <div class="col-sm-10">
                                <input type="text" name="nombre" value="${producto.nombre}" class="form-control" readonly>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="descripcion">Descripción:</label>
                            <div class="col-sm-10">
                                <input type="text" name="descripcion" value="${producto.descripcion}" class="form-control" readonly>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="stock">Stock:</label>
                            <div class="col-sm-4">
                                <input type="text" name="stock" value="${producto.stock}" class="form-control">
                            </div>
                        </div>

                        <input type="hidden" name="precio" value="${producto.precio}">
                        <input type="hidden" name="idProveedor" value="${producto.proveedor.id}"/>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="pull-right">
                                    <a href="listarProductos.jsp" class="btn btn-default">Cancelar</a>
                                    <input type="submit" class="btn btn-primary" value="Modificar"/>
                                </div>
                            </div>
                        </div>

                    </fieldset>
                </form>
            </div><!-- /.col-lg-12 -->
        </div><!-- /.row -->
    </body>
</html>
