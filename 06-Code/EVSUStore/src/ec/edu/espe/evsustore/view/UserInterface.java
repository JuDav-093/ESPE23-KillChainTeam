package ec.edu.espe.evsustore.view;

import ec.edu.espe.evsustore.model.HardwareComponent;
import ec.edu.espe.evsustore.model.Purchase;
import java.util.Scanner;

/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */
public class UserInterface {
    Scanner keyboardInput = new Scanner(System.in);
    public void showMenu() {
        
        System.out.println("*********************************************************");
        System.out.println("                      EVSU STORE                         ");
        System.out.println("*********************************************************");
        System.out.println("");
        System.out.println("1.Hacer compra ");
        System.out.println("2.Ver productos ");
        System.out.println("3.Realizar venta");
        System.out.println("4.Ver registors de compras");
        System.out.println("");
        System.out.println("Escoja una opcion: ");
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
        System.out.println("Ingrese el costo del componente: ");
        purchasedHardwareComponents.setIndividualCost(keyboardInput.nextDouble());
        
        
        return purchasedHardwareComponents; 

    }
    
    
   
}
