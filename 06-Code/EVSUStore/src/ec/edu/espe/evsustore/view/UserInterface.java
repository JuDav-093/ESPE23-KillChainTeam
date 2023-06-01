package ec.edu.espe.evsustore.view;

import ec.edu.espe.evsustore.model.Clothing;
import ec.edu.espe.evsustore.model.JsonFileManager;
import ec.edu.espe.evsustore.model.HardwareComponent;
import ec.edu.espe.evsustore.model.Inventory;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */
public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    ArrayList<HardwareComponent> hardwareComponents = new ArrayList<>();
    ArrayList<Clothing> clothes = new ArrayList<>();
    Inventory inventory = new Inventory(hardwareComponents, clothes);
    
    Catalog catalog = new Catalog(inventory);
    public void showMenu() {
        
        System.out.println("*********************************************************");
        System.out.println("                      EVSU STORE                         ");
        System.out.println("*********************************************************");
        System.out.println("");
        System.out.println("1.Hacer compra ");
        System.out.println("2.Ver productos ");
        System.out.println("3.Realizar venta");
        System.out.println("4.Ver registors de compras");
        System.out.println("5.Salir");
        System.out.println("");
        System.out.println("Escoja una opcion");
        System.out.println("");
        System.out.println("*********************************************************");
    }
    
    
<<<<<<< HEAD
=======
    public HardwareComponent createPurchase(){
        HardwareComponent purchasedHardwareComponents = new HardwareComponent();
        purchasedHardwareComponents.setId();
        System.out.println("Ingrese el nombre del componente: ");
        purchasedHardwareComponents.setName(keyboardInput.nextLine());
        System.out.println("Ingrese el modelo del componente: ");
        purchasedHardwareComponents.setModel(keyboardInput.nextLine());
        System.out.println("Ingrese el cantidad del componente: ");
        purchasedHardwareComponents.setQuantity(keyboardInput.nextInt());
        System.out.println("Ingrese el costo del componente: ");
        purchasedHardwareComponents.setIndividualCost(keyboardInput.nextDouble());
        System.out.println("Ingrese el precio de venta del componte: ");
        purchasedHardwareComponents.setIndividualPrice(keyboardInput.nextDouble());
        
        System.out.println("Se ha añadido al inventario: \n"+purchasedHardwareComponents);
        
        
        return purchasedHardwareComponents; 
          
    }
    
    public Clothing createPurchaseClothing(){
        Clothing purchaseClothings = new Clothing();
        purchaseClothings.setId();
        System.out.println("Ingrese el nombre del componente: ");
        purchaseClothings.setName(keyboardInput.nextLine());
        System.out.println("Ingrese el modelo del componente: ");
        purchaseClothings.setModel(keyboardInput.nextLine());
        System.out.println("Ingrese la cantidad del componente: ");
        purchaseClothings.setQuantity(keyboardInput.nextInt());
        System.out.println("Ingrese el costo del componente por unidad: ");
        purchaseClothings.setIndividualCost(keyboardInput.nextDouble());
        System.out.println("Ingrese el precio de venta del componente por unidad: ");
        purchaseClothings.setIndividualPrice(keyboardInput.nextDouble());
        
        System.out.println(purchaseClothings);
        
        
        return purchaseClothings; 
          
    }
    
    public void menuPurchase(){
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
    
    public void handlePurchase() {
        while (true) {
            menuPurchase();
            Purchase purchase = new Purchase(hardwareComponents,clothings);
            int purchaseOption = keyboardInput.nextInt();
            switch (purchaseOption) {
                case 1 -> {
                    purchase.toPurchaseHardwareComponents(hardwareComponents,createPurchase());
                    System.out.println(purchase);
                }
                case 2 -> {
                    purchase.toPurchaseClothing(clothings,createPurchaseClothing());
                    System.out.println(purchase);
                }
                case 3 -> {
                    selecOption();
                }
                default -> {
                    System.out.println("Opción invalida");
                }
            }
            System.out.println("¿Deseas hacer otra compra? (S/N)");
            String continueShopping = keyboardInput.next().toLowerCase();
>>>>>>> refs/remotes/origin/main

    
    public void selecOption(){
        while (true) {
<<<<<<< HEAD
            PurchaseInterface purchaseInterface = new PurchaseInterface();

            FileManager jsonFile = new FileManager();
            jsonFile.setFileName("TEST1JSON");
=======
            JsonFileManager inventoryFile = new JsonFileManager("Inventory");
            JsonFileManager purchaseRegister = new JsonFileManager("PurchaseRegister");
>>>>>>> refs/remotes/origin/main
            showMenu();
            
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> {
<<<<<<< HEAD
                    purchaseInterface.handlePurchase();
                   
=======

                    
                    

                    handlePurchase();
                    inventoryFile.writeInventoryFile(inventory);
>>>>>>> refs/remotes/origin/main
                }
                case 2 -> {
                    
                   catalog.displayProducts();
                   
                }
                case 3 -> {
                    
                    System.out.println("Hacer compra");
                }
                case 4 -> {
                    System.out.println("Ver registro");
                }
                case 5 -> {
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opción inválida");
            }
        }
    }
    
    
    public void messagePurchase(){
        System.out.println("Se realizo la compra del siguiente producto: ");
    }
   
}
