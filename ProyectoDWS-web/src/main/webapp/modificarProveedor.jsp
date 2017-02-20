<%-- 
    Document   : modificarProveedor
    Created on : 20-feb-2017, 16:23:13
    Author     : Maria
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
                <form class="form-horizontal" role="form" action="ModificarProveedor?accion=modificar&id=${proveedor.id}" method="POST">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Modificar proveedor</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="nombre">Nombre:</label>
                            <div class="col-sm-10">
                                <input type="text" name="nombre" value="${proveedor.nombre}" class="form-control">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="direccion">Dirección:</label>
                            <div class="col-sm-10">
                                <input type="text" name="direccion" value="${proveedor.direccion}" class="form-control">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="ciudad">Ciudad:</label>
                            <div class="col-sm-10">
                                <input type="text" name="ciudad" value="${proveedor.ciudad}" class="form-control">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="provincia">Provincia:</label>
                            <div class="col-sm-10">
                                <input type="text" name="provincia" value="${proveedor.provincia}" class="form-control">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="cp">Código Postal:</label>
                            <div class="col-sm-4">
                                <input type="text" name="cp" value="${proveedor.codigoPostal}" class="form-control">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="telefono">Teléfono:</label>
                            <div class="col-sm-10">
                                <input type="text" name="telefono" value="${proveedor.telefono}" class="form-control">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="email">Email:</label>
                            <div class="col-sm-10">
                                <input type="text" name="email" value="${proveedor.email}" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="pull-right">
                                    <a href="listarProveedoresProductos.jsp" class="btn btn-default">Cancelar</a>
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
