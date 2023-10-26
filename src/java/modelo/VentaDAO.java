/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Darwi
 */
public class VentaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public String generarSerie() {
        String numeroSerie = "";
        String sql = "SELECT max(NumeroSerie) FROM ventas";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                numeroSerie = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Error en Venta generarSerie" + e.getMessage());
        }

        return numeroSerie;
    }

    public String idVenta() {
        String idVentas = "";
        String sql = "SELECT max(IdVentas) FROM ventas";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                idVentas = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Error en Venta idVentas" + e.getMessage());
        }

        return idVentas;
    }

    public int guardarVenta(Venta v) {
        String sql = "INSERT INTO ventas(IdCliente, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado) values(?, ?, ?, ?, ?, ?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, v.getIdCliente());
            ps.setInt(2, v.getIdEmpleado());
            ps.setString(3, v.getNumSerie());
            ps.setString(4, v.getFecha());
            ps.setDouble(5, v.getMonto());
            ps.setString(6, v.getEstado());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en Venta guardarVenta" + e.getMessage());
        }

        return r;
    }

    public int guardarDetalleVenta(Venta venta) {
        String sql = "INSERT INTO detalle_ventas(IdVentas, IdProducto, Cantidad, PrecioVenta) values(?, ?, ?, ?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdProducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getMonto());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en Venta guardarDetalleVenta" + e.getMessage());
        }

        return r;
    }
}
