
package ec.edu.espe.evsustore.model;

import java.util.ArrayList;

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


    
    public Sale(ArrayList<HardwareComponent> soldComponents, 
        ArrayList<Clothing> soldClothing, Customer customer, double salePrice) {
        this.soldComponents = soldComponents;
        this.soldClothing = soldClothing;
        this.saleId = generateId();
        this.customer = customer;
        this.salePrice = salePrice;
    }
    
    public String doABill(){
        String bill;
        bill = (saleId + " EVSU Store \n" + soldComponents + " \n" + soldClothing 
                + " \nTotal: " + salePrice); 
        
        return bill;
    }
    
    public int generateId() {
        return 0;
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
}
