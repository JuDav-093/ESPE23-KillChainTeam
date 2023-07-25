
package ec.edu.espe.evsustore.model;

/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */


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
        String catalogInfo = ("ID:" + hardwareComponent.getId() + " \t|| " +
                hardwareComponent.getName() + " " + 
                hardwareComponent.getModel() + 
                " \t|| PVP: " + hardwareComponent.getIndividualPrice() +
                " \t|| Unidades disponibles: " + hardwareComponent.getQuantity());
        
        return catalogInfo;    
    }
    public String infoForClient(Clothing clothing){
        String catalogInfo = ("ID:" + clothing.getId() + " \t|| " +
                clothing.getName() + " " + 
                clothing.getModel() + 
                " \t|| PVP: " + clothing.getIndividualPrice() +
                " \t|| Unidades disponibles: " + clothing.getQuantity());
        
        return catalogInfo;
    }
}

