
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
    
    public double getTotalPrice() {
        return totalPrice;
    }
    
    public void setTotalPrice() {
        totalPrice = individualPrice*quantity;
    }
    
    public void setIndividualCost(double individualCost) {
        this.individualCost = individualCost;
    }
    
    public double getIndividualCost() {
        return individualCost;
    }

    public void setTotalCost(double totalCost) {
        totalCost = individualCost*quantity;
    }
    
    public double getTotalCost() {
        return totalCost;
    }
    
    public void setId() {
        this.id = generateId();
    }
    
    public int getId() {
        return id;
    }
    
    public int generateId() {
        JsonFileManager idFile = new JsonFileManager();
        idFile.setFileName("Inventory");
        return idFile.searchComponentId();
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
    
}
