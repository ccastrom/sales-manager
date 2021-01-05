
package classes;


public class Customer {
    private int id;
    private String customerName;
    private int phone;
    private String address;

    public Customer() {
    }

    public Customer(String customerName, int phone, String address) {
        this.customerName = customerName;
        this.phone = phone;
        this.address = address;
    }

    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}
