
package ec.edu.espe.evsustore.view;

import ec.edu.espe.evsustore.model.Clothing;
import ec.edu.espe.evsustore.model.HardwareComponent;
import ec.edu.espe.evsustore.model.Inventory;
import ec.edu.espe.evsustore.model.JsonFileManager;
import ec.edu.espe.evsustore.model.Purchase;
import ec.edu.espe.evsustore.model.PurchaseRegister;
import java.util.ArrayList;

/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */
public class PurchaseInterface {
    InputHandler keyboardInput = new InputHandler();
    private UserInterface ui;
    
    public PurchaseInterface(UserInterface ui) {
        this.ui = ui;
    }
    
    public void setUI(UserInterface ui) {
        this.ui = ui;
    }

    public UserInterface getUI() {
        return ui;
    }
    
    ArrayList<HardwareComponent> hardwareComponents = new ArrayList<>();
    ArrayList<Clothing> clothings = new ArrayList<>();

    ArrayList<Purchase> purchases = new ArrayList<>();
    
    PurchaseRegister purchaseRegister = new PurchaseRegister(purchases);
    JsonFileManager purchaseRegisterFile = new JsonFileManager("PurchaseRegister");
    
    public void handlePurchase() {
    ui.getInventory().setHardwareComponents(hardwareComponents);
    ui.getInventory().setClothes(clothings);
        while (true) {
            menuPurchase();
            int purchaseOption = keyboardInput.nextInt();
            keyboardInput.nextLine();
            switch (purchaseOption) {
                case 1 -> {
                    Purchase purchase = new Purchase(hardwareComponents,clothings);   
                    purchase.toPurchaseHardwareComponents(hardwareComponents,createPurchase());
                    purchases.add(purchase);
                    purchaseRegisterFile.writePurchaseRegisterFile(purchaseRegister);
                    ui.getInventoryFile().writeInventoryFile(ui.getInventory());
                    
                }
                case 2 -> {
                    Purchase purchase = new Purchase(hardwareComponents,clothings);
                    purchase.toPurchaseClothing(clothings,createPurchaseClothing());
                    purchases.add(purchase);
                    purchaseRegisterFile.writePurchaseRegisterFile(purchaseRegister);
                    
                    ui.getInventoryFile().writeInventoryFile(ui.getInventory());
                
                }
                case 3 -> {
                    ui.selecOption();
                }
                default -> {
                    System.out.println("Opción invalida");
                }
            }
            System.out.println("¿Deseas hacer otra compra? (S/N)");
            String continueShopping;
            while (true) {
                continueShopping = keyboardInput.next().toLowerCase();
                if (continueShopping.equals("s") || continueShopping.equals("n")) {
                    break;
                } else {
                    System.out.println("Entrada no válida. Por favor, ingrese S o N.");
                }
            }

            if (continueShopping.equals("n")) {
                ui.selecOption();
                break;
            }
        }
    }
    
    public void menuPurchase(){
        ui.getInventoryFile().updateInventory(ui.getInventory());
        
        System.out.println("*********************************************************");
        System.out.println("                    EVSU STORE-COMPRAS                         ");
        System.out.println("*********************************************************");
        System.out.println("");
        System.out.println("1.Componentes de Hardware ");
        System.out.println("2.Ropa ");
        System.out.println("3.Menu Principal");
        System.out.println("");
        System.out.println("Escoja una opcion");
        System.out.println("");
        System.out.println("*********************************************************");
    }
    
    public HardwareComponent createPurchase(){
        HardwareComponent purchasedHardwareComponents = new HardwareComponent();
        purchasedHardwareComponents.setId();
        System.out.println("Ingrese el nombre del componente: ");
        purchasedHardwareComponents.setName(keyboardInput.nextLine());
        System.out.println("Ingrese el modelo del componente: ");
        purchasedHardwareComponents.setModel(keyboardInput.nextLine());
        System.out.println("Ingrese el cantidad del componente: ");
        purchasedHardwareComponents.setQuantity(keyboardInput.nextInt());
        keyboardInput.nextLine(); 
        System.out.println("Ingrese el costo del componente: ");
        purchasedHardwareComponents.setIndividualCost(keyboardInput.nextDouble());
        keyboardInput.nextLine(); 
        System.out.println("Ingrese el precio de venta del componte: ");
        purchasedHardwareComponents.setIndividualPrice(keyboardInput.nextDouble());
        keyboardInput.nextLine(); 
        System.out.println("");
        ui.messagePurchase();
        System.out.println(purchasedHardwareComponents);
        return purchasedHardwareComponents;   
    }

    public Clothing createPurchaseClothing(){
        Clothing purchaseClothings = new Clothing();
        purchaseClothings.setId();
        System.out.println("Ingrese el nombre del componente: ");
        purchaseClothings.setName(keyboardInput.nextLine());
        System.out.println("Ingrese el modelo del componente: ");
        purchaseClothings.setModel(keyboardInput.nextLine());
        System.out.println("Ingrese el cantidad del componente: ");
        purchaseClothings.setQuantity(keyboardInput.nextInt());
        keyboardInput.nextLine(); 
        System.out.println("Ingrese el costo del componente: ");
        purchaseClothings.setIndividualCost(keyboardInput.nextDouble());
        keyboardInput.nextLine(); 
        System.out.println("Ingrese el precio de venta del componte: ");
        purchaseClothings.setIndividualPrice(keyboardInput.nextDouble());
        keyboardInput.nextLine();
        System.out.println("");
        ui.messagePurchase();
        System.out.println(purchaseClothings);
        return purchaseClothings;   
    }
    
    public void showRegisterOfPurchases(){
        purchaseRegisterFile.viewPurchaseRegister(purchaseRegister);
    }
}
