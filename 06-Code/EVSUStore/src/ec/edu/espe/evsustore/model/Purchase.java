package ec.edu.espe.evsustore.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Purchase {
    private ArrayList <HardwareComponent> hardwareComponents;
    private ArrayList <Clothing> clothes;
    private LocalDate purchaseDate;
    private double cost;

    public Purchase() {
        
    }

    public Purchase(ArrayList<HardwareComponent> hardwareComponents, ArrayList<Clothing> clothes) {
        this.hardwareComponents = hardwareComponents;
        this.clothes = clothes;
    }
    
    public void toPurchaseHardwareComponents(ArrayList <HardwareComponent> hardwareComponents, HardwareComponent purchasedHardwareComponent){
        setCost(purchasedHardwareComponent.getTotalPrice());
        hardwareComponents.add(purchasedHardwareComponent);
    }
    
    public void toPurchaseClothing(ArrayList <Clothing> clothes){
        Scanner keyboardInput = new Scanner(System.in);
        Clothing purchasedClothes = new Clothing();
        purchasedClothes.setId();
        purchasedClothes.setName(keyboardInput.nextLine());
        purchasedClothes.setModel(keyboardInput.nextLine());
        purchasedClothes.setQuantity(keyboardInput.nextInt());
        purchasedClothes.setIndividualCost(keyboardInput.nextDouble());
        setCost(purchasedClothes.getTotalPrice());
        clothes.add(purchasedClothes);
    }

    public ArrayList <HardwareComponent> getHardwareComponents(){
        return hardwareComponents;
    }

    public void setHardwareComponents(ArrayList <HardwareComponent> hardwareComponents) {
        this.hardwareComponents = hardwareComponents;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = LocalDate.now();
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double productCost) {
        this.cost += cost;
    }

}   