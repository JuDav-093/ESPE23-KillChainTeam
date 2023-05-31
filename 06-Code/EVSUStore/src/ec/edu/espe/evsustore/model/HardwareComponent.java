
package ec.edu.espe.evsustore.model;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class HardwareComponent {
    private int id;
    private double individualPrice;
    private double totalPrice;
    private double individualCost;
    private double totalCost;
    private int quantity;
    private String name;
    private String model;

    @Override
    public String toString() {
        return id + " // " + name + " " + model + " //Cantidad: " + quantity + 
                " //Costo de cada unidad: " + individualCost + 
                " //Precio a vender cada unidad: " + individualPrice +"\n";
    }
    
    public HardwareComponent() {
    }
    
    public HardwareComponent(int id, double price, int quantity, String model) {
        this.id = id;
        this.individualPrice = price;
        this.quantity = quantity;
        this.model = model;
        setTotalPrice();
    }
    
    public void setTotalPrice() {
        totalPrice = individualPrice*quantity;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId() {
        this.id = generateId();
    }
    
    public int generateId() {
        int i = 0;
        i++;
        return i;
    }

    public double getIndividualPrice() {
        return individualPrice;
    }

    public void setIndividualPrice(double individualPrice) {
        this.individualPrice = individualPrice;
        setTotalPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    
}
