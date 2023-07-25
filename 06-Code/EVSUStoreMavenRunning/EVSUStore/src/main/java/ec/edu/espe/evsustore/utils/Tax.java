
package ec.edu.espe.evsustore.utils;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Tax {
    public static Double computeIVA (Double totalPrice, Double ivaPercentage) {
        Double IVA = totalPrice * (ivaPercentage/100.0);
        return DecimalsControl.roundToTwoTenths(IVA);
    }
    
    public static Double getPriceFromIVAIncluded (Double priceIVAIncluded, Double ivaPercentage) {
        Double totalPrice = priceIVAIncluded / (1+(ivaPercentage/100.0));
        return totalPrice;
    }
    
    public static Double changeMoney(double cashReceived,double saleTotal){
        double totalChange=cashReceived-saleTotal;
        return totalChange;
    }
}
