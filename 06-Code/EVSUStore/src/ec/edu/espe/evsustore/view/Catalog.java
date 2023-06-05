
package ec.edu.espe.evsustore.view;

/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */

import ec.edu.espe.evsustore.model.HardwareComponent;
import ec.edu.espe.evsustore.model.Clothing;

import ec.edu.espe.evsustore.model.Inventory;

public class Catalog {
    private Inventory inventory;
    
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Catalog(Inventory inventory) {
        this.inventory = inventory;
    }

    public void displayProducts() {
        
        System.out.println("\nComponentes de Hardware: ");
        for (HardwareComponent hardwareComponent : inventory.getHardwareComponents()) {
            System.out.println(infoForClient(hardwareComponent));
        }

        System.out.println("\nRopa: ");
        for (Clothing clothing : inventory.getClothes()) {
            System.out.println(infoForClient(clothing));
        }
    }
    
    public String infoForClient(HardwareComponent hardwareComponent){
        String catalogInfo = (hardwareComponent.getName() + " " + 
                hardwareComponent.getModel() + 
                " || PVP: " + hardwareComponent.getIndividualPrice() +
                " || Unidades disponibles: " + hardwareComponent.getQuantity());
        
        return catalogInfo;    
    }
    public String infoForClient(Clothing clothing){
        String catalogInfo = (clothing.getName() + " " + 
                clothing.getModel() + 
                " PVP: " + clothing.getIndividualPrice() +
                " Unidades disponibles: " + clothing.getQuantity());
        
        return catalogInfo;
    }
}

