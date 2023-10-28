<%-- 
    Document   : productos
    Created on : 18/10/2023, 11:56:48 p. m.
    Author     : Darwi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <link rel="stylesheet" href="css/styles.css">
        <title>Productos</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card border-primary shadow col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=productos" method="POST">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${getProducto.getNom()}"  name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" value="${getProducto.getPrecio()}"  name="txtPrecio" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Stock</label>
                            <input type="text" value="${getProducto.getStock()}"  name="txtStock" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${getProducto.getEstado()}"  name="txtEstado" class="form-control">
                        </div>
                        <input type="submit" name="accion"  value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion"  value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Stock</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var = "pr" items = "${producto}">
                            <tr>
                                <td>${pr.getId()}</td>
                                <td>${pr.getNom()}</td>
                                <td>${pr.getPrecio()}</td>
                                <td>${pr.getStock()}</td>
                                <td>${pr.getEstado()}</td>
                                <td>
                                    <a class="btn btn-outline-warning" href="Controlador?menu=productos&accion=Editar&id=${pr.getId()}"><i class="fa-solid fa-pen-to-square"></i></a>
                                    <a class="btn btn-outline-danger" href="Controlador?menu=productos&accion=Eliminar&id=${pr.getId()}"><i class="fa-solid fa-trash-can"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody> 
                </table>
            </div>
        </div>
        <script src="https://kit.fontawesome.com/7d0f323c82.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>    
    </body>
</html>
