<%-- 
    Document   : empleado
    Created on : 19/10/2023, 12:04:00 a. m.
    Author     : Darwi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <link rel="stylesheet" href="css/styles.css">
        <title>Empleados</title>
    </head>
    <body>
        <h2>Empleados</h2>
        <div class="d-lg-flex">
            <div class="card border-primary shadow col-lg-4">
                <div class="card-body">
                    <form action="Controlador?menu=empleado" method="POST">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" value="${getEmpleado.getDni()}" name="txtDni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${getEmpleado.getNom()}"  name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" value="${getEmpleado.getTel()}"  name="txtTel" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${getEmpleado.getEstado()}"  name="txtEstado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" value="${getEmpleado.getUser()}"  name="txtUsuario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" value="${getEmpleado.getClave()}"  name="txtPass" class="form-control" <c:if test="${isEditing}">readonly</c:if>>
                            </div>
                            <input type="submit" name="accion"  value="Agregar" class="btn btn-info">
                            <input type="submit" name="accion"  value="Actualizar" class="btn btn-success">
                        </form>
                    </div>
                </div>
                <div class="col-12 col-lg-8 mt-5 mt-lg-0">
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Dni</th>
                                    <th>Nombres</th>
                                    <th>Telefono</th>
                                    <th>Estado</th>
                                    <th>Usuario</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var = "em" items = "${empleado}">
                                <tr>
                                    <td>${em.getId()}</td>
                                    <td>${em.getDni()}</td>
                                    <td>${em.getNom()}</td>
                                    <td>${em.getTel()}</td>
                                    <td>${em.getEstado()}</td>
                                    <td>${em.getUser()}</td>
                                    <td>
                                        <a class="btn btn-outline-warning" href="Controlador?menu=empleado&accion=Editar&id=${em.getId()}"><i class="fa-solid fa-pen-to-square"></i></a>
                                        <a class="btn btn-outline-danger" href="Controlador?menu=empleado&accion=Eliminar&id=${em.getId()}"><i class="fa-solid fa-trash-can"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody> 
                    </table>
                </div>
            </div>
        </div>
        <script src="https://kit.fontawesome.com/7d0f323c82.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>    
    </body>
</html>
