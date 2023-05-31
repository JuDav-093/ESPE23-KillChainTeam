package ec.edu.espe.evsustore.view;

import ec.edu.espe.evsustore.model.*;
import java.util.ArrayList;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class EVSUStore {

    public static void main(String[] args) {
        ArrayList <HardwareComponent> hardwareComponents = new ArrayList(); 
        ArrayList <Clothing> clothes = new ArrayList();
        Inventory inventory = new Inventory(hardwareComponents, clothes);
        Purchase purchase = new Purchase(hardwareComponents, clothes);
        
    }
    
}
