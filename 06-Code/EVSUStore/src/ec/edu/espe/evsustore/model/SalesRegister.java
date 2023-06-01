
package ec.edu.espe.evsustore.model;

import java.util.ArrayList;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class SalesRegister {
    ArrayList <Sale> sales;

    public SalesRegister() {
    }

    public SalesRegister(ArrayList<Sale> sales) {
        this.sales = sales;
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Sale> sales) {
        this.sales = sales;
    }
}
