<%-- 
    Document   : index
    Created on : 18/10/2023, 10:17:07 p. m.
    Author     : Darwi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <link rel="stylesheet" href="css/styles.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="centered">
            <div class="col-md-4">
                <div class="card border-primary shadow-lg">
                    <div class="card-body">
                        <h3 class="card-title text-center">Iniciar Sesión</h3>
                        <form class="form-signin" action="Validar" method="POST">
                            <div class="form-group">
                                <label for="txtUser">Usuario:</label>
                                <input type="text" id="txtUser" name="txtUser" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="txtPass">Contraseña:</label>
                                <input type="password" id="txtPass" name="txtPass" class="form-control" required>
                            </div>
                            <button type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block">Ingresar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://kit.fontawesome.com/7d0f323c82.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>    
    </body>
</html>
