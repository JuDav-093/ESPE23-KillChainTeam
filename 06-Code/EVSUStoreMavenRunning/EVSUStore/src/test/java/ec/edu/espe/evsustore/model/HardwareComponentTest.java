/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.espe.evsustore.model;

import java.util.HashMap;
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
public class HardwareComponentTest {
    
    public HardwareComponentTest() {
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
     * Test of getData method, of class HardwareComponent.
     */
    @Test
    public void testGetData() {
        System.out.println("getData");
        HardwareComponent instance = new HardwareComponent(1, 2, 123, 334, "sdsa", "dsds");
        HashMap<Object, Object> xdd = new HashMap<>();
        xdd.put("quantity", 2);
        xdd.put("cost", 123.0);
        xdd.put("price", 334.0);
        xdd.put("name", "sdsa");
        xdd.put("model", "dsds");
        xdd.put("id", 1);
        
        HashMap<Object, Object> expResult = xdd;
        HashMap<Object, Object> result = instance.getData();
        assertEquals(expResult, result);
        
    }
    
}
