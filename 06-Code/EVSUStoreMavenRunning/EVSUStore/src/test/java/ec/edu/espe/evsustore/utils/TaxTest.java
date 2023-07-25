
package ec.edu.espe.evsustore.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class TaxTest {
    
    public TaxTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of roundToTwoTenths method, of class DecimalsControl.
     */
    @Test
    public void testRoundToTwoTenths() {
        System.out.println("roundToTwoTenths");
        Double amountToRound = 125.24768;
        Double expResult = 125.25;
        Double result = DecimalsControl.roundToTwoTenths(amountToRound);
        assertEquals(expResult, result);
        
    }
    
}
