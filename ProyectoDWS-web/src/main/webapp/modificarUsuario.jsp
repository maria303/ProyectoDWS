<%-- 
    Document   : modificarUsuario
    Created on : 20-feb-2017, 18:18:40
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
                <form class="form-horizontal" role="form" action="ModificarUsuario?accion=modificar&id=${usuario.id}" method="POST">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Modificar usuario</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="nombre">Nombre:</label>
                            <div class="col-sm-10">
                                <input type="text" name="nombre" value="${usuario.nombre}" class="form-control">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="apellidos">Apellidos:</label>
                            <div class="col-sm-10">
                                <input type="text" name="apellidos" value="${usuario.apellidos}" class="form-control">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="password">Contraseña:</label>
                            <div class="col-sm-10">
                                <input type="text" name="password" value="${usuario.password}" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="pull-right">
                                    <a href="listarUsuarios.jsp" class="btn btn-default">Cancelar</a>
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
