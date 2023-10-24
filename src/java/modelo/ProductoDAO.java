/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Darwi
 */
public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    // CRUD
    public List listar() {
        String sql = "SELECT * FROM producto";
        List<Producto> lista = new ArrayList<>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto pr = new Producto();
                pr.setId(rs.getInt(1));
                pr.setNom(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getString(5));
                lista.add(pr);
            }
        } catch (Exception e) {
        }

        return lista;
    }

    public Producto listarId(int id) {
        Producto pr = new Producto();

        String sql = "SELECT * FROM producto WHERE idProducto=" + id;

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                pr.setId(rs.getInt(1));
                pr.setNom(rs.getString(2));
                pr.setPrecio(rs.getDouble(3));
                pr.setStock(rs.getInt(4));
                pr.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }

        return pr;
    }

    public int agregar(Producto p) {
        String sql = "INSERT INTO producto(Nombres, Precio, Stock, Estado) VALUES (?, ?, ?, ?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());

            ps.executeUpdate();
        } catch (Exception e) {
        }

        return r;
    }

    public int actualizar(Producto p) {
        String sql = "UPDATE producto SET Nombres=?, Precio=?, Stock=?, Estado=?, User=? WHERE idProducto=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(2, p.getNom());
            ps.setDouble(1, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.setInt(6, p.getId());

            ps.executeUpdate();
        } catch (Exception e) {
        }

        return r;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM producto WHERE idProducto=" + id;

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
