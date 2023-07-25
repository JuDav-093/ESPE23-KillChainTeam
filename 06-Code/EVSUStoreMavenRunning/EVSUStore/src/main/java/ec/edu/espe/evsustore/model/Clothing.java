
package ec.edu.espe.evsustore.model;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Clothing {
    private int id;
    private int quantity;
    private double cost;
    private double price;
    private String name;
    private int size;

    public Clothing(int id, int quantity, double cost, double price, String name, int size) {
        this.id = id;
        this.quantity = quantity;
        this.cost = cost;
        this.price = price;
        this.name = name;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Clothing{" + "id=" + id + ", quantity=" + quantity + ", cost=" + cost + ", price=" + price + ", name=" + name + ", size=" + size + '}';
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
}
