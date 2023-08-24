package ec.edu.espe.evsustore.controller;

import ec.edu.espe.evsustore.utils.DecimalsControl;
import java.util.HashMap;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class TransactionsController {
    public static Double calcTotal(HashMap<Object, Object> product) {
        Double price = Double.valueOf(product.get("price").toString());
        int quantity = Integer.parseInt(product.get("quantity").toString());
        return DecimalsControl.roundToTwoTenths(price * quantity);
    }
    
    public static Double calcExchange(Double price, Double moneyReceived) {
        return DecimalsControl.roundToTwoTenths(moneyReceived - price);
    }
}
