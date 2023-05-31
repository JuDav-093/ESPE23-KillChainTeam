package ec.edu.espe.evsustore.model;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Clothing {
    private int id;
    private double individualPrice;
    private double totalPrice;
    private int quantity;
    private String name;
    private String model;

    public Clothing() {
    }

    public Clothing(int id, double individualPrice, double totalPrice, int quantity, String model) {
        this.id = id;
        this.individualPrice = individualPrice;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.model = model;
    }
    
    @Override
    public String toString() {
        return id + " // " + name + " " + model + " //Cantidad: " + quantity + 
                " //Costo de cada unidad: " + individualPrice + 
                " //Costo total: " + totalPrice +"\n";
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
