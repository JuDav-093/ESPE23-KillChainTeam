package ec.edu.espe.evsustore.view;

import ec.edu.espe.evsustore.model.Catalog;
import ec.edu.espe.evsustore.model.Clothing;
import ec.edu.espe.evsustore.model.HardwareComponent;
import ec.edu.espe.evsustore.model.Inventory;
import ec.edu.espe.evsustore.model.JsonFileManager;
import ec.edu.espe.evsustore.model.SalesRegister;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */
public class UserInterface {
    PurchaseInterface purchaseInterface;
    ArrayList<HardwareComponent> hardwareComponents = new ArrayList<>();
    ArrayList<Clothing> clothings = new ArrayList<>();

    Inventory inventory = new Inventory(hardwareComponents, clothings);
    JsonFileManager inventoryFile = new JsonFileManager("Inventory");
    Catalog catalog = new Catalog(inventory);
    SaleInterface saleInterface = new SaleInterface(catalog);

    
    Scanner scanner = new Scanner(System.in);
    InputHandler keyboardInput = new InputHandler();
    SalesRegister salesRegister = new SalesRegister();

    public UserInterface(PurchaseInterface purchaseInterface) {
        this.purchaseInterface = purchaseInterface;
    }
    public void setPurchaseInterface(PurchaseInterface purchaseInterface) {
        this.purchaseInterface = purchaseInterface;
    }
    
    public void selecOption(){
        
        while (true) {

            showMenu();

            String input = scanner.next();
            int option; 
            try{    
                option= option = Integer.parseInt(input);
            }catch(NumberFormatException e){
                System.out.println("Error: entrada inválida");
                scanner.nextLine();
                continue;
            }


            switch (option) {
                case 1 -> {
                    
                    purchaseInterface.handlePurchase();
                   
                }
                case 2 -> {
                    inventoryFile.updateInventory(inventory);
                    saleInterface.displayProducts();
                    catalog.displayProducts();

                }
                case 3 -> {
                    saleInterface.displayProducts();
                    System.out.print("Ingrese el índice del producto que desea comprar: ");
                    int productIndex = keyboardInput.nextInt();
                    saleInterface.purchaseProduct(productIndex);
                    System.out.println("Hacer compra");
                }
                case 4 -> {
                    purchaseInterface.showRegisterOfPurchases();
                            
                    System.out.println("Ver registro");
                }
                case 5 -> {
                    System.out.println("Gracias por usar EVSU STORE. ¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Opción inválida");
            }
        }
    }
    
    public void showMenu() {
        
        System.out.println("*********************************************************");
        System.out.println("                      EVSU STORE                         ");
        System.out.println("*********************************************************");
        System.out.println("");
        System.out.println("1.Hacer compra ");
        System.out.println("2.Ver productos ");
        System.out.println("3.Realizar venta");
        System.out.println("4.Ver registros de compras");
        System.out.println("5.Salir");
        System.out.println("");
        System.out.println("Escoja una opcion");
        System.out.println("");
        System.out.println("*********************************************************");
    }
    
    public void messagePurchase(){
        System.out.println("Se realizo la compra del siguiente producto: ");
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public JsonFileManager getInventoryFile() {
        return inventoryFile;
    }

    public void setInventoryFile(JsonFileManager inventoryFile) {
        this.inventoryFile = inventoryFile;
    }
}
