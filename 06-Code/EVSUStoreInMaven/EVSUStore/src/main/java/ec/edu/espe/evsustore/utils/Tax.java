
package ec.edu.espe.evsustore.utils;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Tax {
    public static Double roundToTwoTenths(Double amountToRound){
        Double amountRounded;
        Double cents = amountToRound%1;
        String amountAux = String.valueOf (amountToRound);
            if(cents == 0.0F){
                amountRounded = amountToRound;
            }
            else {
                int dollars = Integer.parseInt (amountAux.substring (0, amountAux.indexOf ('.')));
                while (cents < 10.0F){
                    cents = cents*10;
                }
                
                Double fractionCents = amountToRound%1;
                if (fractionCents >= 0.5F ){
                    cents = cents + 1;
                }
                
                String centstAux = String.valueOf (amountToRound);
                int roundedCents = Integer.parseInt (centstAux.substring (0, centstAux.indexOf ('.')));;
                
                amountRounded = dollars + (roundedCents/100.0);
            }
        
        return amountRounded;
        
    }
}
