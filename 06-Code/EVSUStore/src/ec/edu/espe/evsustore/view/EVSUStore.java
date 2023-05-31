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
        
        System.out.println("Inventario antes de comprar");
        
        System.out.println(inventory);
        
        purchase.toPurchaseHardwareComponents(hardwareComponents);
        
        System.out.println("Inventario despues de comprar hc");
        
        System.out.println(inventory);
        
        System.out.println("Inventario despues de comprar hc y ropa");
        
        purchase.toPurchaseClothing(clothes);
        
        System.out.println(inventory);
    }
    
}
