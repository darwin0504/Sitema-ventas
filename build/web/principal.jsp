<%-- 
    Document   : principal
    Created on : 18/10/2023, 10:18:33 p. m.
    Author     : Darwi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "modelo.Empleado" %>
<% 
    HttpSession sesion = request.getSession();  
    Empleado emp = (Empleado) sesion.getAttribute("usuario");
    System.out.println(emp);
   
    if(emp != null) {
%>
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
        <nav class="navbar navbar-expand-lg navbar-light bg-primary">
            <a class="navbar-brand" href="Controlador?menu=principal"><img src="img/logo.jpg" width="30"  class="img-fluid rounded-circle"/></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=productos&accion=Listar" target="myFrame"><i class="fa-brands fa-product-hunt mr-2"></i>Productos</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=empleado&accion=Listar"  target="myFrame"><i class="fa-solid fa-briefcase mr-2"></i>Empleados</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=clientes&accion=Listar"  target="myFrame"><i class="fa-solid fa-users-line mr-2"></i>Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a  style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=registrarVenta&accion=default"  target="myFrame"><i class="fa-solid fa-cart-shopping mr-2"></i>Nueva Venta</a>
                    </li>
                </ul>
                <div class="dropdown">
                    <button style=" border: none"  class="btn btn-outline-light dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
                        <i class="fa-solid fa-user mr-2"></i>${usuario.getNom()}
                    </button>
                    <div class="dropdown-menu text-center">
                        <a class="dropdown-item" href="#">
                            <img src="img/perfil.jpg" width="60"  class="img-fluid rounded-circle"/>
                        </a>
                        <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                        <a class="dropdown-item" href="#">Usuario@db.com</a>
                        <div class="dropdown-divider"></div>
                        <form action="Validar" method="POST">
                            <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                        </form>
                    </div>
                </div>
            </div>
        </nav>
        <div class="m-4" style="height: 550px;">
            <iframe name="myFrame" style="height: 100%; width: 100%; border: none"></iframe>
        </div>
        <script src="https://kit.fontawesome.com/7d0f323c82.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>    
    </body>
</html>
<%  
    } else {
        System.out.println("Llega else");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
