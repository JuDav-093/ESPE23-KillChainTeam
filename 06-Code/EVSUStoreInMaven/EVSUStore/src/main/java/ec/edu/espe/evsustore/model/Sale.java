
package ec.edu.espe.evsustore.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Sale {
    private ArrayList <HardwareComponent> soldComponents;
    private ArrayList <Clothing> soldClothing;
    private int saleId;
    private Customer customer;
    private double salePrice;
    private Date date;


    
    public Sale(ArrayList<HardwareComponent> soldComponents, 
        ArrayList<Clothing> soldClothing, Customer customer, double salePrice, Date date) {
        this.soldComponents = soldComponents;
        this.soldClothing = soldClothing;
        this.saleId = generateId();
        this.customer = customer;
        this.salePrice = salePrice;
        this.date = date;
    }
    
    public int generateId() {
        //TODOIId generation based in bills
        return 0;
    }

    public Date getDate() {
        return date;
    }
    
    public ArrayList<Clothing> getSoldClothing() {
        return soldClothing;
    }

    public void setSoldClothing(ArrayList<Clothing> soldClothing) {
        this.soldClothing = soldClothing;
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

    public ArrayList<HardwareComponent> getSoldComponents() {
        return soldComponents;
    }

    public void setSoldComponents(ArrayList<HardwareComponent> soldComponents) {
        this.soldComponents = soldComponents;
    }
    
    
}
