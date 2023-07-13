package ec.edu.espe.evsustore.controller;

import ec.edu.espe.evsustore.model.HardwareComponent;
import java.util.ArrayList;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class HardwareComponentController {
    public static int generateId(){
        int id = 0;
        
        DatabaseController database = new DatabaseController();
        database.connectDatabase();
        
        ArrayList<HardwareComponent> componentsInDB = database.obtainAllComponents();
        for(HardwareComponent component : componentsInDB){
            id = component.getId();
        }
        
        int newId = id+1;
        
        return newId;
    }
}
