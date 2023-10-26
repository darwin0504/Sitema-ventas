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
public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Cliente buscar(String dni) {
        Cliente c = new Cliente();
        String sql = "SELECT * FROM cliente WHERE Dni=" + dni;

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error en Cliente buscar: " + e.getMessage());
        }

        return c;
    }

    // CRUD
    public List listar() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> lista = new ArrayList<>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setNom(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setEstado(rs.getString(5));
                lista.add(cl);
            }
        } catch (Exception e) {
            System.out.println("Error en Cliente listar: " + e.getMessage());
        }

        return lista;
    }

    public Cliente listarId(int id) {
        Cliente cli = new Cliente();

        String sql = "SELECT * FROM cliente WHERE idCliente=" + id;

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cli.setDni(rs.getString(2));
                cli.setNom(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error en Cliente listarId: " + e.getMessage());
        }

        return cli;
    }

    public int agregar(Cliente c) {
        String sql = "INSERT INTO cliente(Dni, Nombres, Direccion, Estado) VALUES (?, ?, ?, ?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, c.getDni());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getEstado());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en Cliente agregar: " + e.getMessage());
        }

        return r;
    }

    public int actualizar(Cliente c) {
        String sql = "UPDATE cliente SET Dni=?, Nombres=?, Direccion=?, Estado=? WHERE idCliente=?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, c.getDni());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getEstado());
            ps.setInt(5, c.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en Cliente actualizar: " + e.getMessage());
        }

        return r;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM cliente WHERE idCliente=" + id;

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en Cliente eliminar: " + e.getMessage());
        }
    }
}
