
package ec.edu.espe.evsustore.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Sale implements Mapeable{
    private int id;
    private ArrayList <Catalog> soldComponents;
    private int saleId;
    private Customer customer;
    private double salePrice;
    private LocalDate date;

    private HashMap<Object, Object> data;
    
    public Sale(int id, ArrayList<Catalog> soldComponents, Customer customer, double salePrice, LocalDate date) {
        data = new HashMap<>();
        data.put("id", id);
        data.put("soldComponents", soldComponents.toString());
        data.put("customer", customer.toString());
        data.put("salePrice", salePrice);
        data.put("date", date);
        
        this.soldComponents = soldComponents;
        this.customer = customer;
        this.salePrice = salePrice;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public ArrayList<Catalog> getSoldComponents() {
        return soldComponents;
    }

    public void setSoldComponents(ArrayList<Catalog> soldComponents) {
        this.soldComponents = soldComponents;
    }

    @Override
    public HashMap<Object, Object> getData() {
        return data;
    }
    
    
}
