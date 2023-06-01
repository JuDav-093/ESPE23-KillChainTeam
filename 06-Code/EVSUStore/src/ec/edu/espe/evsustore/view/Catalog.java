
package ec.edu.espe.evsustore.view;

/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */

import ec.edu.espe.evsustore.model.HardwareComponent;
import ec.edu.espe.evsustore.model.Clothing;

import java.util.ArrayList;

import ec.edu.espe.evsustore.model.Inventory;

public class Catalog {
    private Inventory inventory;
    private ArrayList<HardwareComponent> hardwareComponents;
    private ArrayList<Clothing>  clothes;

    
    
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Catalog(Inventory inventory, ArrayList<HardwareComponent> hardwareComponents, ArrayList<Clothing> clothes) {
        this.inventory = inventory;
        this.hardwareComponents = hardwareComponents;
        this.clothes = clothes;
    }

    public void displayProducts() {

        System.out.println("\nComponentes de Hardware: ");
        for (HardwareComponent hardwareComponent : hardwareComponents) {
            System.out.println(hardwareComponent);
        }

        System.out.println("\nRopa: ");
        for (Clothing clothing : clothes) {
            System.out.println(clothing);
        }
    }
}

