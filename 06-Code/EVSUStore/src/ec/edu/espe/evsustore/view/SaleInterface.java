
package ec.edu.espe.evsustore.view;

import ec.edu.espe.evsustore.model.Catalog;
import ec.edu.espe.evsustore.model.Clothing;
import ec.edu.espe.evsustore.model.HardwareComponent;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */
public class SaleInterface {
    private Catalog catalog;
    private int currentIndex;

    public SaleInterface(Catalog catalog) {
        this.catalog = catalog;
        this.currentIndex = 0;
    }

    public void displayProducts() {
        ArrayList<HardwareComponent> hardwareComponents = catalog.getInventory().getHardwareComponents();
        ArrayList<Clothing> clothes = catalog.getInventory().getClothes();

        int numProducts = hardwareComponents.size() + clothes.size();
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
                if (i < hardwareComponents.size()) {
                    HardwareComponent hardwareComponent = hardwareComponents.get(i);
                    System.out.println(catalog.infoForClient(hardwareComponent));
                } else if (i - hardwareComponents.size() < clothes.size()) {
                    Clothing clothing = clothes.get(i - hardwareComponents.size());
                    System.out.println(catalog.infoForClient(clothing));
                } else {
                    break;
                }
            }

            if (currentIndex + 5 >= numProducts) {
                System.out.println("No hay más productos para mostrar.");
                break;
            }


            System.out.print("\nPresione ESPACIO para ver los siguientes productos (o 'Q' para salir): ");
            input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Q")) {
                exit = true;
            } else if (!input.equals(" ")) {
                System.out.println("Entrada inválida. Intente nuevamente.");
            }

            currentIndex += 5;
        }
    }

    public void purchaseProduct(int productIndex) {
        ArrayList<HardwareComponent> hardwareComponents = catalog.getInventory().getHardwareComponents();
        ArrayList<Clothing> clothes = catalog.getInventory().getClothes();

        int numProducts = hardwareComponents.size() + clothes.size();
        if (productIndex < 0 || productIndex >= numProducts) {
            System.out.println("Índice de producto inválido.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        if (productIndex < hardwareComponents.size()) {
            HardwareComponent hardwareComponent = hardwareComponents.get(productIndex);
            System.out.println("Ha seleccionado el siguiente componente de hardware:");
            System.out.println(catalog.infoForClient(hardwareComponent));
            System.out.print("Ingrese la cantidad a comprar: ");
            int quantity = scanner.nextInt();

            if (quantity <= 0 || quantity > hardwareComponent.getQuantity()) {
                System.out.println("Cantidad inválida o insuficiente.");
                return;
            }

            hardwareComponent.setQuantity(hardwareComponent.getQuantity() - quantity);
            System.out.println("Compra realizada exitosamente.");
        } else {
            Clothing clothing = clothes.get(productIndex - hardwareComponents.size());
            System.out.println("Ha seleccionado la siguiente prenda de ropa:");
            System.out.println(catalog.infoForClient(clothing));
            System.out.print("Ingrese la cantidad a comprar: ");
            int quantity = scanner.nextInt();

            if (quantity <= 0 || quantity > clothing.getQuantity()) {
                System.out.println("Cantidad inválida o insuficiente.");
                return;
            }

            clothing.setQuantity(clothing.getQuantity() - quantity);
            System.out.println("Compra realizada exitosamente.");
        }
    }
}