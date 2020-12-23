
package controller;

import classes.Customer;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Controller {
    public java.sql.Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\sqlite\\db\\bdPacientes.db";
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
   
  
    
   
    
    
    
}

