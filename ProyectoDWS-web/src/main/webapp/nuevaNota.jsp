<%-- 
    Document   : nuevaNota
    Created on : 30-nov-2016, 9:19:13
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
            <div class="col-md-4 col-md-offset-4">
                <form class="form-horizontal" role="form" action="NotaNueva" method="POST">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Añadir Nueva Nota</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="numMesa">Num. Mesa:</label>
                            <div class="col-sm-6">
                                <input type="number" name="numMesa" class="form-control">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="fecha">Fecha:</label>
                            <div class="col-sm-6">
                                <input type="text" name="fecha" placeholder="YYYY-MM-dd" class="form-control">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="hora">Hora:</label>
                            <div class="col-sm-6">
                                <input type="text" name="hora" placeholder="00:00" class="form-control">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="cuenta">Cuenta:</label>
                            <div class="col-sm-6">
                                <input type="number" step="any" name="cuenta" value="0.0" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="pull-right">
                                    <a href="listaNotas.jsp" class="btn btn-default">Cancelar</a>
                                    <input type="submit" class="btn btn-primary" value="Añadir"/>
                                </div>
                            </div>
                        </div>

                    </fieldset>
                </form>
            </div><!-- /.col-lg-12 -->
        </div><!-- /.row -->
    </body>
</html>
