
package ec.edu.espe.evsustore.controller;

import ec.edu.espe.evsustore.model.HardwareComponent;
import java.util.ArrayList;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class ViewController {
    
    
    public static HardwareComponent obtainComponent(int id){
        DatabaseController database = new DatabaseController();
        database.connectDatabase();
        
        HardwareComponent selectedComponent = database.obtainComponent(id);
        
        return selectedComponent;
    }
    
    public static ArrayList<HardwareComponent> obtainAllComponents(){
        DatabaseController database = new DatabaseController();
        database.connectDatabase();
        
        ArrayList<HardwareComponent> components = database.obtainAllComponents();
        
        return components;
    }
    
    public static ArrayList<HardwareComponent> obtainComponentsCoincidences(String field){
        DatabaseController database = new DatabaseController();
        database.connectDatabase();
        
        ArrayList<HardwareComponent> components = database.obtainComponentsCoincidence(field);
        
        return components;
    }
}
