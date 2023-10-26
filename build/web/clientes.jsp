<%-- 
    Document   : clientes
    Created on : 18/10/2023, 11:56:58 p. m.
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
        <title>Clientes</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card border-primary shadow col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=clientes" method="POST">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" value="${getCliente.getDni()}" name="txtDni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${getCliente.getNom()}"  name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Dirección</label>
                            <input type="text" value="${getCliente.getDireccion()}"  name="txtDireccion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${getCliente.getEstado()}"  name="txtEstado" class="form-control">
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
                            <th>Dni</th>
                            <th>Nombres</th>
                            <th>Dirección</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var = "cl" items = "${cliente}">
                        <tr>
                            <td>${cl.getId()}</td>
                            <td>${cl.getDni()}</td>
                            <td>${cl.getNom()}</td>
                            <td>${cl.getDireccion()}</td>
                            <td>${cl.getEstado()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=clientes&accion=Editar&id=${cl.getId()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=clientes&accion=Eliminar&id=${cl.getId()}">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody> 
                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>    
    </body>
</html>
