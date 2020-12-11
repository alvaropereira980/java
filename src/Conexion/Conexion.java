/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sergio
 */
public class Conexion {

    Connection con;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Searching for connection class");
        } catch (ClassNotFoundException cnf) {
            System.out.println("Class not found and unable to connect" + cnf.getLocalizedMessage());
        }
        try {
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_administrador", "root", "");
        } catch (SQLException e) {
            System.out.println("Error en la conexion local" + e);
        }
    }

    public Connection getConnection() {
        return con;
    }
}

