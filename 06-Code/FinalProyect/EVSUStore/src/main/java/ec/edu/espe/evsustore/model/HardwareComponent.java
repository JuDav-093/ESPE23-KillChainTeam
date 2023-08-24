package ec.edu.espe.evsustore.model;

import java.util.HashMap;



/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class HardwareComponent implements Mapeable{
    private int id;
    private int quantity;
    private double cost;
    private double price;
    private String name;
    private String model;
    
    private HashMap<Object, Object> data;
    
    @Override
    public String toString() {
        return  id + "\t|| " + name + "\t|| " + model + "\t|| " + quantity + 
                "\t|| " + cost + 
                "\t|| " + price + "\n";
    }

    public HardwareComponent(int id, int quantity, double cost, double price, String name, String model) {
        data = new HashMap<>();
        data.put("id", id);
        data.put("quantity", quantity);
        data.put("cost", cost);
        data.put("price", price);
        data.put("name", name);
        data.put("model", model);
        
        this.id = id;
        this.quantity = quantity;
        this.cost = cost;
        this.price = price;
        this.name = name;
        this.model = model;
    }

    public HardwareComponent() {
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

    @Override
    public HashMap<Object, Object> getData() {
        
        return data;
    }
    
}
