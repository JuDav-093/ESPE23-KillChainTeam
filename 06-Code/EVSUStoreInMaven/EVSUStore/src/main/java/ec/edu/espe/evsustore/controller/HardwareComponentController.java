package ec.edu.espe.evsustore.controller;

import ec.edu.espe.evsustore.model.HardwareComponent;
import java.util.ArrayList;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class HardwareComponentController {
    public static int generateId(){
        
        DatabaseController database = new DatabaseController();
        database.connectDatabase();
        
        ArrayList<HardwareComponent> componentsInDB = database.obtainAllComponents();

        
        return componentsInDB.size()+1;
    }
}
