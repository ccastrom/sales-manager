package TableModel;

import classes.Customer;
import classes.EasterBread;
import classes.Sale;
import classes.Type;
import controller.Controller;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableSales extends AbstractTableModel {

    private List<Sale> listaSales;
    private Controller con;

    public TableSales(List<Sale> listaSales) {
        this.listaSales = listaSales;
        con = new Controller();
    }

    @Override
    public int getRowCount() {
        return listaSales.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sale s = listaSales.get(rowIndex);
        switch (columnIndex) {
            
            case 0:
                Customer cus=con.getCustomerByID(s.getFk_id_customer());
                return cus.getCustomerName();
            case 1:
                Type t= con.getTypeByID(s.getFk_id_type());
                return t.getTypeBread();
            case 2:
                EasterBread eb=con.getEasterBreadByID(s.getFk_id_easterBread());
                return eb.getBreadValue();
            default:
                return s.getSaleDate();
                
                
                
                

        }
    }

    @Override
    public String getColumnName(int column) {
         switch(column){
             case 0:
                 return "Nombre";
             case 1:
                 return "Tipo";
             case 2:
                 return "Precio";
             default:
                 return "Fecha de venta";
                 
         }
    }
    

}
