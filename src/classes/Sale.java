
package classes;

import java.sql.Date;


public class Sale {
    private int id;
    private int fk_id_customer;
    private int fk_id_easterBread;
    private Date saleDate;

    public Sale() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_id_customer() {
        return fk_id_customer;
    }

    public void setFk_id_customer(int fk_id_customer) {
        this.fk_id_customer = fk_id_customer;
    }

    public int getFk_id_easterBread() {
        return fk_id_easterBread;
    }

    public void setFk_id_easterBread(int fk_id_easterBread) {
        this.fk_id_easterBread = fk_id_easterBread;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
    
    
    
    
}
