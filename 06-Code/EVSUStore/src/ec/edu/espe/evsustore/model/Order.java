package ec.edu.espe.evsustore.model;

import java.util.ArrayList;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Order {
    private ArrayList <HardwareComponent> orderedComponents;
    private ArrayList <Clothing> orderedClothing;
    private ArrayList <Sale> sales;
    private Customer customer;
    private int orderId;
    private double orderPrice;
    private boolean isPaid;

    @Override
    public String toString() {
        return "ESTE ES SU PEDIDO: \n Componentes de Hardware: \n" + orderedComponents 
                + "\n Ropa: \n" + orderedClothing;
    }
    
    public Order() {
    }

    public Order(ArrayList <HardwareComponent> orderedComponents, 
            ArrayList <Clothing> orderedClothing , ArrayList <Sale> sales, 
            int orderId, Customer customer, boolean isPaid) {
        
        this.orderId = orderId;
        this.customer = customer;
        this.orderPrice = calculateOrderPrice(orderedComponents, orderedClothing);
        this.isPaid = isPaid;
    }
    
    public double calculateOrderPrice(ArrayList <HardwareComponent> orderedComponents, 
            ArrayList <Clothing> orderedClothing){
        double price = 0;
        for(Clothing clothing: orderedClothing){
            price += clothing.getTotalPrice();
        }
        for(HardwareComponent component: orderedComponents){
            price += component.getTotalPrice();
        }
        return price;
    }
    
    public void generateASale(){
        if(isPaid){
            sales.add(new Sale(orderedComponents, orderedClothing, 
                    customer,orderPrice));
        }
    }
    
    public boolean verifyPayMethods(int payOption){
        if(payOption==1){
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<HardwareComponent> getOrderedComponents() {
        return orderedComponents;
    }

    public void setOrderedComponents(ArrayList<HardwareComponent> orderedComponents) {
        this.orderedComponents = orderedComponents;
    }

    public ArrayList<Clothing> getOrderedClothing() {
        return orderedClothing;
    }

    public void setOrderedClothing(ArrayList<Clothing> orderedClothing) {
        this.orderedClothing = orderedClothing;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
    
    
}
