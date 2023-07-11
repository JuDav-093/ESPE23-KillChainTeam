
package ec.edu.espe.evsustore.view;

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
public class PnelViewInfoTest {
    
    public PnelViewInfoTest() {
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

    @Test
    public void testGetIdOfComponentModel() {
        
        String componentModel = "12 || GTX 1650 ASUS ROG || 150 || 180 ";
        int expected = 12;
        int result = getIdOfComponentModel(componentModel);
        assertEquals(expected, result);
    }
    
    @Test
    public void testSplit() {
        
        String componentModel = "12 || GTX 1650 ASUS ROG || 150 || 180 ";
        String expected = "12";
        String[] result = componentModel.split(" ");
        assertEquals(expected, result[0]);
    }
    
    public int getIdOfComponentModel(String componentModel){
        int id;
        
        
        String[] partsOfModel = componentModel.split(" ");
        id = Integer.parseInt(partsOfModel[0]);
        
        return id;
    }
    
}
