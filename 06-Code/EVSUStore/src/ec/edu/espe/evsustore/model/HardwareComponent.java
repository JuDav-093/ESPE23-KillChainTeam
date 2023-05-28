
package ec.edu.espe.evsustore.model;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class HardwareComponent {
    private int id;
    private double price;
    private int quantity;
    private String model;

    public HardwareComponent() {
    }
    
    public HardwareComponent(int id, double price, int quantity, String model) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.model = model;
    }
    
    
}
