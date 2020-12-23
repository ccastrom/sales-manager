package controller;

import classes.Customer;
import classes.EasterBread;
import classes.Sale;
import classes.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    public java.sql.Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "jdbc:sqlite:/home/francisco/bdVentas.db";
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public List<Customer> getCustomers() {
        List<Customer> lista = new ArrayList<>();
       

        String sql = "SELECT * FROM customer";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            Customer c;
            while (rs.next()) {
                c = new Customer();
              
                c.setCustomerName(rs.getString(2));
                c.setPhone(rs.getInt(3));
                c.setAddress(rs.getString(4));
                

                lista.add(c);
                
              

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;

    }

}
