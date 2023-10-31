<%-- 
    Document   : registrarVenta
    Created on : 18/10/2023, 11:58:03 p. m.
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
        <title>Ventas</title>
        <style>
            @media print {
                .title, .parteDatos, .btn, .accion {
                    display: none;
                }
            }
        </style>
    </head>
    <body>
        <h2 class="ml-3 title">Registrar venta</h2>
        <div class="d-xl-flex">
            <div class="col-12 col-xl-5 parteDatos">
                <div class="card border-primary shadow">
                    <form action="Controlador?menu=registrarVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label class="ml-3">Datos del cliente</label>
                            </div>
                            <div class="form-group d-sm-flex">
                                <div class="col-12 col-sm-6 d-flex">
                                    <input type="text" name="codigoCliente" value="${c.getDni()}" class="form-control" placeholder="Codigo"></<input>
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info" ></<input>
                                </div>
                                <div class="col-12 col-sm-6 mt-3 mt-sm-0">
                                    <input type="text" name="nombreCliente" value="${c.getNom()}" class="form-control" placeholder="Datos cliente" disabled></<input>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="ml-3">Datos del producto</label>
                            </div>
                            <div class="form-group d-sm-flex">
                                <div class="col-12  col-sm-6 d-flex">
                                    <input type="text" name="codigoProducto" value="${prod.getId()}" class="form-control" placeholder="Codigo"></<input>
                                    <input type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info" ></<input>
                                </div>
                                <div class="col-12 col-sm-6 mt-3 mt-sm-0">
                                    <input type="text" name="nombreProducto" value="${prod.getNom()}" class="form-control" placeholder="Datos producto" readonly></<input>
                                </div>
                            </div>
                            <div class="form-group d-sm-flex">
                                <div class="col-12 col-sm-6">
                                    <input type="text" name="precio" value="${prod.getPrecio()}" class="form-control" placeholder="$0.0"></<input>
                                </div>
                                <div  class="col-12 col-sm-3">
                                    <input type="number" name="cantidad" value="1" class="form-control" placeholder=""></<input>
                                </div>
                                <div  class="col-12 col-sm-3">
                                    <input type="text" name="stock" value="${prod.getStock()}" class="form-control" placeholder="stock" disabled></<input>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm">
                                    <input type="submit" name="accion"  value="Agregar" class="btn btn-outline-primary">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div  class="col-12 col-xl-7 mt-5 mt-xl-0">
                <div  class="card border-primary shadow">
                    <div  class="card-body">
                        <div class="d-flex col-sm-5 ml-auto">
                            <label class="mt-1 mr-2">No.serie: </label>
                            <input type="text" name="NroSerie" value="${numSerie}"  class="form-control" readonly>
                        </div>
                        <br>
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Nro</th>
                                        <th>Codigo</th>
                                        <th>Descripción</th>
                                        <th>Precio</th>
                                        <th>Cantidad</th>
                                        <th>SubTotal</th>
                                        <th class="accion">Accion</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var = "list" items = "${lista}">
                                        <tr>
                                            <td>${list.getItem()}</td>
                                            <td>${list.getIdProducto()}</td>
                                            <td>${list.getDescripcion()}</td>
                                            <td>${list.getMonto()}</td>
                                            <td>${list.getCantidad ()}</td>
                                            <td>${list.getSubTotal()}</td>
                                            <td class="d-flex">
                                                <a class="btn btn-outline-danger" style="margin-left: 10px" href="Controlador?menu=registrarVenta&accion=Eliminar&idProducto=${list.getIdProducto()}"><i class="fa-solid fa-trash-can"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="card-footer d-sm-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=registrarVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar venta</a>
                            <a href="Controlador?menu=registrarVenta&accion=Cancelar" class="btn btn-danger">Cancelar</a>
                        </div>
                        <div class="col-sm-3 ml-auto mt-3 mt-sm-0">
                            <input type="text" name="txtTotal" value="$ ${totalPagar}" class="form-control" readonly>
                        </div>
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
