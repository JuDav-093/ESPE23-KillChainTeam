
package ec.edu.espe.evsustore.view;

import ec.edu.espe.evsustore.model.Clothing;
import ec.edu.espe.evsustore.model.HardwareComponent;
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
    UserInterface ui = new UserInterface();
    
    ArrayList<HardwareComponent> hardwareComponents = new ArrayList<>();
    ArrayList<Clothing> clothings = new ArrayList<>();

    ArrayList<Purchase> purchases = new ArrayList<>();
    
    PurchaseRegister purchaseRegister = new PurchaseRegister(purchases);
    JsonFileManager purchaseRegisterFile = new JsonFileManager("PurchaseRegister");
    
    public void handlePurchase() {
        while (true) {
            menuPurchase();
            int purchaseOption = keyboardInput.nextInt();
            keyboardInput.nextLine();
            switch (purchaseOption) {
                case 1 -> {
                    Purchase purchase = new Purchase(hardwareComponents,clothings);   
                    HardwareComponent purchasedComponent = createPurchase();
                    purchase.toPurchaseHardwareComponents(hardwareComponents,purchasedComponent);
                    purchases.add(purchase);
                    purchaseRegisterFile.writePurchaseRegisterFile(purchaseRegister);
                    
                    ui.getInventory().getHardwareComponents().add(purchasedComponent);
                    ui.getInventoryFile().writeInventoryFile(ui.getInventory());
                    
                }
                case 2 -> {
                    Purchase purchase = new Purchase(hardwareComponents,clothings);
                    Clothing purchasedClothing = createPurchaseClothing();
                    purchase.toPurchaseClothing(clothings, purchasedClothing);
                    purchases.add(purchase);
                    purchaseRegisterFile.writePurchaseRegisterFile(purchaseRegister);
                    
                    ui.getInventory().getClothes().add(purchasedClothing);
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
                    System.out.println("Entrada no valida. Por favor, ingrese S o N.");
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
        System.out.println("Ingrese el nombre de la prenda: ");
        purchaseClothings.setName(keyboardInput.nextLine());
        System.out.println("Ingrese el modelo de la prenda: ");
        purchaseClothings.setModel(keyboardInput.nextLine());
        System.out.println("Ingrese el cantidad de la prenda: ");
        purchaseClothings.setQuantity(keyboardInput.nextInt());
        keyboardInput.nextLine(); 
        System.out.println("Ingrese el costo de la prenda: ");
        purchaseClothings.setIndividualCost(keyboardInput.nextDouble());
        keyboardInput.nextLine(); 
        System.out.println("Ingrese el precio de venta de la prenda: ");
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
    
    public void setUI(UserInterface ui) {
        this.ui = ui;
    }

    public UserInterface getUI() {
        return ui;
    }
}
