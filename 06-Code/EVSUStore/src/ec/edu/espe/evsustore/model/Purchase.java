package ec.edu.espe.evsustore.model;

import java.util.Date;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Purchase {
    private HardwareComponent hardwareComponents[];
    private Date purchaseDate;
    private double cost;

    public Purchase() {
    }

    public Purchase(HardwareComponent[] hardwareComponents, Date purchaseDate, double cost) {
        this.hardwareComponents = hardwareComponents;
        this.purchaseDate = purchaseDate;
        this.cost = cost;
    }
    
}   
