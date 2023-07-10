package ec.edu.espe.evsustore.model;

import ec.edu.espe.evsustore.controller.HardwareComponentController;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class HardwareComponent {
    private int id;
    private int quantity;
    private double cost;
    private double price;
    private String name;
    private String model;
    
    @Override
    public String toString() {
        return "ID" + id + " || " + name + " " + model + " || Cantidad: " + quantity + 
                " || Costo: $" + cost + 
                " || Precio: $" + price;
    }

    public HardwareComponent(int id, int quantity, double cost, double price, String name, String model) {
        this.id = id;
        this.quantity = quantity;
        this.cost = cost;
        this.price = price;
        this.name = name;
        this.model = model;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    public static int generateId(){
        //TODO generateId algorithm
        return 0;
    }
}
