
package ec.edu.espe.evsustore.controller;

import ec.edu.espe.evsustore.model.HardwareComponent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
    
    public static DefaultTableModel writeBillTable(ArrayList<HardwareComponent> components, JTable tblComponents) {
        DefaultTableModel catlaogTableModel = new DefaultTableModel();
        
        Object[] componentData = new Object[tblComponents.getColumnCount()];
        
        String[] header = {"ID","DESCRIPCIÓN","PRECIO UNIT.","DESCUENTO","PRECIO TOTAL"};
        
        catlaogTableModel.setColumnIdentifiers(header);
        
        for(HardwareComponent component: components){
            
            componentData[0] = component.getName()+component.getModel();
            componentData[1] = component.getPrice();
            componentData[2] = component.getQuantity();
            componentData[4] = component.getPrice() * component.getQuantity();
            
            catlaogTableModel.addRow(componentData);
            
        }
        
        return catlaogTableModel;
    }
    
    public static void deleteComponentInDB(HardwareComponent component) {
        DatabaseController database = new DatabaseController();
        database.connectDatabase();
        database.delete(component);
    }
    
    public static void saveComponentInDB(HardwareComponent component) {
        DatabaseController database = new DatabaseController();
        database.connectDatabase();
        int id = component.getId();
        if(database.obtainComponent(id)==null){
            database.insertComponent(component);
        }
        else{
            database.update(component);
        }
    }
    
    
    
}
