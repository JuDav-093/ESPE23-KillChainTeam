
package ec.edu.espe.evsustore.model;

import java.util.ArrayList;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Inventory {
    ArrayList <HardwareComponent> hardwareComponents;
    ArrayList <Clothing> clothes;

    @Override
    public String toString() {
        return "INVENTARIO \n Componentes de Hardware: \n" + hardwareComponents 
                + "\n Ropa: \n" + clothes;
    }

    public Inventory(ArrayList <HardwareComponent> hardwareComponents, ArrayList <Clothing> clothes) {
        this.hardwareComponents = hardwareComponents;
        this.clothes = clothes;
    }

    public ArrayList <HardwareComponent> getHardwareComponents() {
        return hardwareComponents;
    }

    public void setHardwareComponents(ArrayList <HardwareComponent> hardwareComponents) {
        this.hardwareComponents = hardwareComponents;
    }

    public ArrayList <Clothing> getClothes() {
        return clothes;
    }

    public void setClothes(ArrayList <Clothing> clothes) {
        this.clothes = clothes;
    }
    
}
