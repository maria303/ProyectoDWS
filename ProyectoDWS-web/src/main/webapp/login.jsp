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
                <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
                <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
                <p id="profile-name" class="profile-name-card"></p>
                <form action="Login" method="POST" class="form-signin">
                    <span id="reauth-email" class="reauth-email"></span>
                    <input name="usuario" type="text" id="inputEmail" class="form-control" placeholder="Usuario" required autofocus>
                    <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required>
                    <div id="remember" class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me"> Recordarme
                        </label>
                    </div>
                    <button class="btn btn-lg btn-success btn-block btn-signin" type="submit">Acceder</button>
                </form><!-- /form -->
                <a href="#" class="forgot-password">
                    Forgot the password?
                </a>
            </div><!-- /card-container -->
        </div><!-- /container -->
    </body>
</html>
