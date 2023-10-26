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
            System.out.println("Error en Producto listar" + e.getMessage());
        }

        return numeroSerie;
    }
}
