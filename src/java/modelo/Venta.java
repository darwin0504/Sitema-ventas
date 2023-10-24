/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Darwi
 */
public class Venta {

    Integer id;
    Integer item;
    Integer idCliente;
    Integer idEmpleado;
    Integer idProducto;
    Integer cantidad;
    String NumSerie;
    String Descripcion;
    String fecha;
    String estado;
    Double subTotal;
    Double monto;

    public Venta() {
    }

    public Venta(Integer id, Integer item, Integer idCliente, Integer idEmpleado, Integer idProducto, Integer cantidad, String NumSerie, String Descripcion, String fecha, String estado, Double subTotal, Double monto) {
        this.id = id;
        this.item = item;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.NumSerie = NumSerie;
        this.Descripcion = Descripcion;
        this.fecha = fecha;
        this.estado = estado;
        this.subTotal = subTotal;
        this.monto = monto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNumSerie() {
        return NumSerie;
    }

    public void setNumSerie(String NumSerie) {
        this.NumSerie = NumSerie;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

}
