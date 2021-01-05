package controller;

import classes.Customer;
import classes.EasterBread;
import classes.Sale;
import classes.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

    public List<Sale> getSales() {
        List<Sale> lista = new ArrayList<>();

        String sql = "SELECT customer.id,ebType.id,easterBread.id,fechaVenta "
                + "FROM sale "
                + "INNER JOIN customer ON sale.fk_id_customer=customer.id "
                + "INNER JOIN ebType ON sale.fk_id_type=ebType.id "
                + "INNER JOIN easterBread ON sale.fk_id_easterBread=easterBread.id ";
               

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            Sale s;
            while (rs.next()) {
                s = new Sale();
           

                s.setFk_id_customer(rs.getInt(1));
                s.setFk_id_type(rs.getInt(2));
                s.setFk_id_easterBread(rs.getInt(3));
                s.setSaleDate(rs.getString(4));

                lista.add(s);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;

    }

    public Customer getCustomerByID(int id) {
        Customer c = null;
        String sql = "SELECT customerName FROM customer WHERE id='" + id + "';";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                c = new Customer();
                
                c.setCustomerName(rs.getString(1));
               

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;

    }

    public EasterBread getEasterBreadByID(int id) {
        EasterBread eb = null;
        String sql = "SELECT * FROM easterBread WHERE id='" + id + "';";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                eb = new EasterBread();
                eb.setId(rs.getInt(1));
                eb.setBreadValue(rs.getInt(2));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return eb;

    }

    public Type getTypeByID(int id) {
        Type t = null;
        String sql = "SELECT * FROM ebType WHERE id='" + id + "';";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                t = new Type();
                t.setId(rs.getInt(1));
                t.setTypeBread(rs.getString(2));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return t;

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
        public void createCustomer(Customer c) {

        String sql = "INSERT INTO customer VALUES(NULL,'"+c.getCustomerName()+"',"
                + "'"+c.getPhone()+"','"+c.getAddress()+"');";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println("INSERT COMPLETE");

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

}
