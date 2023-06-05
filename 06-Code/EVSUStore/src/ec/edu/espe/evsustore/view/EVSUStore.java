package ec.edu.espe.evsustore.view;



/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class EVSUStore {

    public static void main(String[] args) {
        PurchaseInterface purchaseInterface = new PurchaseInterface(null);
        UserInterface ui = new UserInterface(purchaseInterface);
        
        purchaseInterface.setUI(ui); 
        ui.setPurchaseInterface(purchaseInterface);
        ui.selecOption();
      
                
    }
    
}
