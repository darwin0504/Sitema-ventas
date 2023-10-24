<%-- 
    Document   : registrarVenta
    Created on : 18/10/2023, 11:58:03 p. m.
    Author     : Darwi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <title>Registrar venta</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-5">
                <div class="card">
                    <form action="Controlador?menu=registrarVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoCliente" value="${c.getDni()}" class="form-control" placeholder="Codigo"></<input>
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info ml-3" ></<input>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombreCliente" value="${c.getNom()}" class="form-control" placeholder="Datos cliente"></<input>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Datos del producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoProducto" class="form-control" placeholder="Codigo"></<input>
                                    <input type="submit" name="accion" value="Buscar" class="btn btn-outline-info ml-3" ></<input>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombreCliente" class="form-control" placeholder="Datos producto"></<input>
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" class="form-control" placeholder="$0.0"></<input>
                                </div>
                                <div  class="col-sm-3">
                                    <input type="number" name="cantidad" class="form-control" placeholder=""></<input>
                                </div>
                                <div  class="col-sm-3">
                                    <input type="text" name="stock" class="form-control" placeholder="stock"></<input>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="submit" name="accion"  value="Agregar" class="btn btn-outline-info">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div  class="col-sm-7">
                <div  class="card">
                    <div  class="card-body">
                        <div class="d-flex col-sm-5 ml-auto">
                            <label class="mt-1 mr-2">No.serie: </label>
                            <input type="text" name="NroSerie"  placeholder="Agregar" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripción</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer">
                        <div>  
                            <input type="submit" name="accion"  value="Generar venta" class="btn btn-success"><!-- comment -->
                            <input type="submit" name="accion"  value="Cancelar" class="btn btn-danger"><!-- comment -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>    
    </body>
</html>
