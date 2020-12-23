
package classes;

import java.sql.Date;



public class EasterBread {
     private int id;
     private int breadValue;
     private Date elabDate;

    public EasterBread() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBreadValue() {
        return breadValue;
    }

    public void setBreadValue(int breadValue) {
        this.breadValue = breadValue;
    }

    public Date getElabDate() {
        return elabDate;
    }

    public void setElabDate(Date elabDate) {
        this.elabDate = elabDate;
    }
     
    
}
