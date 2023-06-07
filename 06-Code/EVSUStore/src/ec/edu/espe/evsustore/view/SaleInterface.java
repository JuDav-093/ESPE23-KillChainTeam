
package ec.edu.espe.evsustore.view;

import ec.edu.espe.evsustore.model.Catalog;
import ec.edu.espe.evsustore.model.Clothing;
import ec.edu.espe.evsustore.model.HardwareComponent;
import ec.edu.espe.evsustore.model.JsonFileManager;
import java.util.Scanner;


/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */
public class SaleInterface {
    private Catalog catalog;
    private int currentIndex;
    JsonFileManager inventoryFile = new JsonFileManager("Inventory");
    
    
    public void displayProducts() {
        
        int numProducts = catalog.getInventory().getHardwareComponents().size() + catalog.getInventory().getClothes().size();
        if (numProducts == 0) {
            System.out.println("No hay productos disponibles en el inventario.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        String input;
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Productos disponibles ---");

            for (int i = currentIndex; i < currentIndex + 5; i++) {
                if (i < catalog.getInventory().getHardwareComponents().size()) {
                    HardwareComponent hardwareComponent = catalog.getInventory().getHardwareComponents().get(i);
                    System.out.println(catalog.infoForClient(hardwareComponent));
                } else if (i - catalog.getInventory().getHardwareComponents().size() < catalog.getInventory().getClothes().size()) {
                    Clothing clothing = catalog.getInventory().getClothes().get(i - catalog.getInventory().getHardwareComponents().size());
                    System.out.println(catalog.infoForClient(clothing));
                } else {
                    break;
                }
            }

            if (currentIndex + 5 >= numProducts) {
                System.out.println("No hay mas productos para mostrar.");
                break;
            }


            System.out.print("\nPresione ESPACIO para ver los siguientes productos (o 'Q' para salir): ");
            input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Q")) {
                exit = true;
            } else if (!input.equals(" ")) {
                System.out.println("Entrada invalida. Intente nuevamente.");
            }

            currentIndex += 5;
        }
    }

    public void purchaseProduct(int productIndex) {

        int numProducts = catalog.getInventory().getHardwareComponents().size() + catalog.getInventory().getClothes().size();
        if (productIndex < 0 || productIndex >= numProducts) {
            System.out.println("Índice de producto invalido.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        if (productIndex < catalog.getInventory().getHardwareComponents().size()) {
            HardwareComponent hardwareComponent = catalog.getInventory().getHardwareComponents().get(productIndex);
            System.out.println("Ha seleccionado el siguiente componente de hardware:");
            System.out.println(catalog.infoForClient(hardwareComponent));
            System.out.print("Ingrese la cantidad a comprar: ");
            int quantity = scanner.nextInt();

            if (quantity <= 0 || quantity > hardwareComponent.getQuantity()) {
                System.out.println("Cantidad invalida o insuficiente.");
                return;
            }

            hardwareComponent.setQuantity(hardwareComponent.getQuantity() - quantity);
            
            System.out.println("Compra realizada exitosamente.");
            
        } else {
            Clothing clothing = catalog.getInventory().getClothes().get(productIndex - catalog.getInventory().getHardwareComponents().size());
            System.out.println("Ha seleccionado la siguiente prenda de ropa:");
            System.out.println(catalog.infoForClient(clothing));
            System.out.print("Ingrese la cantidad a comprar: ");
            int quantity = scanner.nextInt();

            if (quantity <= 0 || quantity > clothing.getQuantity()) {
                System.out.println("Cantidad invalida o insuficiente.");
                return;
            }

            clothing.setQuantity(clothing.getQuantity() - quantity);
            System.out.println("Compra realizada exitosamente.");
            
        }
    }
    
    public SaleInterface(Catalog catalog) {
        this.catalog = catalog;
        this.currentIndex = 0;
    }
    
}