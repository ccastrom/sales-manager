
package TableModel;

import classes.Customer;
import controller.Controller;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TMGeneral extends AbstractTableModel {
    private List<Customer> customer;
    private Controller c;

    public TMGeneral(List<Customer> customer) {
        this.customer = customer;
        c=new Controller();
    }
    
    

    @Override
    public int getRowCount() {
        return customer.size();
       
    }

    @Override
    public int getColumnCount() {
        return 3;
       
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer cu= (Customer) customer.get(rowIndex);
        switch(columnIndex){
            case 0:
                return cu.getCustomerName();
            case 1:
                return cu.getPhone();
            default:
                return cu.getAddress();
            
        }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "Nombre";
            case 1:
                return "Celular";
            default:
                return "Direccion";
            
        }
    }
    
    
}
