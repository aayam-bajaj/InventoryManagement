/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aayam
 */
public class db {
    public static Connection mycon() {
        Connection con = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connection parameters
            String url = "jdbc:mysql://localhost:3306/inventory?useSSL=false&allowPublicKeyRetrieval=true";
            String username = "root";
            String password = "";
            
            // Attempt to establish connection
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection successful!");
            return con;
            
        } catch(ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Please add the MySQL Connector/J to your project libraries.");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch(SQLException e) {
            System.err.println("Database connection failed!");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
