/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Darwi
 */
public class Conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/db_ventas";
    String user = "root";
    String password = "12345678";
    
    public Connection Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
        }
        return con;
    }
}
