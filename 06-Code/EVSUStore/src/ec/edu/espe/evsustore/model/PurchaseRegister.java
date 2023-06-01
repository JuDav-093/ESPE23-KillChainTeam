
package ec.edu.espe.evsustore.model;

import java.util.ArrayList;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class PurchaseRegister {
    private ArrayList <Purchase> purchases;

    @Override
    public String toString() {
        return "PURCHASES: \n " + purchases +"\n";
    }
    
    public PurchaseRegister() {
    }

    public PurchaseRegister(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<Purchase> purchases) {
        this.purchases = purchases;
    }
    
    public void makeAPurchaseRegister(ArrayList<Purchase> purchases) {
        
    }
}
