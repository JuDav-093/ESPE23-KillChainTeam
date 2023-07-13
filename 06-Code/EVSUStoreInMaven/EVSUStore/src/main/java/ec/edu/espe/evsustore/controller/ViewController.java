
package ec.edu.espe.evsustore.controller;

import ec.edu.espe.evsustore.model.HardwareComponent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

    public static DefaultTableModel writeTable(ArrayList<HardwareComponent> components, JTable tblComponents) {
        DefaultTableModel catlaogTableModel = new DefaultTableModel();
        
        Object[] componentData = new Object[tblComponents.getColumnCount()];
        
        String[] header = {"ID","Cantidad","Nombre","Modelo","Costo","Precio"};
        
        catlaogTableModel.setColumnIdentifiers(header);
        
        for(HardwareComponent component: components){
            
            componentData[0] = component.getId();
            componentData[1] = component.getQuantity();
            componentData[2] = component.getName();
            componentData[3]= component.getModel();
            componentData[4] = component.getCost();
            componentData[5] = component.getPrice();
            
            catlaogTableModel.addRow(componentData);
            
        }
        return catlaogTableModel;
    }
    
    public static void saveComponentInDB(HardwareComponent component) {
        DatabaseController database = new DatabaseController();
        database.connectDatabase();
        database.insertComponent(component);
    }
}
