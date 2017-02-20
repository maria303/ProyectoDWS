<%-- 
    Document   : login
    Created on : 03-ene-2017, 20:19:35
    Author     : Maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="dist/css/sb-admin-2.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="card card-container">
                <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
                <p id="profile-name" class="profile-name-card"></p>
                <form action="Login" method="POST" class="form-signin">
                    <span id="reauth-email" class="reauth-email"></span>
                    <input name="usuario" type="text" id="inputEmail" class="form-control" placeholder="Usuario" required autofocus>
                    <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required>
                    <button class="btn btn-lg btn-success btn-block btn-signin" type="submit">Acceder</button>
                </form><!-- /form -->
            </div><!-- /card-container -->
        </div><!-- /container -->
    </body>
</html>
