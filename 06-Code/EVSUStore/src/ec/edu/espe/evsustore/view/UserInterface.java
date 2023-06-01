package ec.edu.espe.evsustore.view;

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
    Scanner scanner = new Scanner(System.in);
    ArrayList<HardwareComponent> hardwareComponents = new ArrayList<>();
    ArrayList<Clothing> clothes = new ArrayList<>();
    SalesRegister salesRegister = new SalesRegister();
    
<<<<<<< HEAD
=======
   
>>>>>>> c87100ccf41e5d5a3a9d5ecb452df5d2f9b1d337
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
    
    

    
    public void selecOption(){
        PurchaseInterface purchaseInterface = new PurchaseInterface();
        while (true) {

            showMenu();
            
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    purchaseInterface.handlePurchase();
                   
                }
                case 2 -> {
                    
<<<<<<< HEAD
                    System.out.println(purchaseInterface.getInventory());
                   
=======
                    System.out.println("Ventas");
>>>>>>> c87100ccf41e5d5a3a9d5ecb452df5d2f9b1d337
                   
                }
                case 3 -> {
                    
                    System.out.println("Hacer compra");
                }
                case 4 -> {
                    purchaseInterface.showRegisterOfSales();
                            
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
