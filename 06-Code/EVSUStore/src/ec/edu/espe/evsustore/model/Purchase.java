package ec.edu.espe.evsustore.model;

import java.util.ArrayList;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Purchase {
    private ArrayList <HardwareComponent> hardwareComponents;
    private ArrayList <Clothing> clothes;
    private double cost;

    @Override
    public String toString() {
        return "Componentes de Hardware: " + hardwareComponents + " || Ropa: " + clothes + " || Coste Total: " + cost + "\n";
    }
    
    public Purchase() {
        
    }

    public Purchase(ArrayList<HardwareComponent> hardwareComponents, ArrayList<Clothing> clothes) {
        this.hardwareComponents = hardwareComponents;
        this.clothes = clothes;
    }
    
    public void toPurchaseHardwareComponents(ArrayList <HardwareComponent> hardwareComponents, HardwareComponent purchasedHardwareComponent){
        hardwareComponents.add(purchasedHardwareComponent);
        setCost(purchasedHardwareComponent.getTotalCost());
        
    }
    

    public void toPurchaseClothing(ArrayList <Clothing> clothes, Clothing purchasedClothing){
        clothes.add(purchasedClothing);
        setCost(purchasedClothing.getTotalCost());
        
    }

    public ArrayList <HardwareComponent> getHardwareComponents(){
        return hardwareComponents;
    }

    public void setHardwareComponents(ArrayList <HardwareComponent> hardwareComponents) {
        this.hardwareComponents = hardwareComponents;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double costCalculated) {
        cost = costCalculated;
    }

}   
