package ec.edu.espe.evsustore.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.evsustore.model.Catalog;
import ec.edu.espe.evsustore.model.HardwareComponent;
import ec.edu.espe.evsustore.utils.DatabaseManager;
import ec.edu.espe.evsustore.utils.DecimalsControl;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class HardwareComponentController {
    DatabaseController database;
    MongoCollection collection;
    
    private static HardwareComponentController instance;
    
    private HardwareComponentController() {
        this.database = DatabaseController.getInstance();
        this.collection = this.database.changeCollection("HardwareComponents");
    }
    
    public synchronized static HardwareComponentController getInstance (){
        if (instance != null){
        
        } 
        else {
            instance = new HardwareComponentController();
        }
        
        return instance;
    }
    
    public int generateId(){
        int lastId = 0;
        ArrayList<HashMap<Object, Object>> components =  obtainAllFromDb();
        if(!components.isEmpty()){
            lastId = Integer.parseInt(components.get(components.size()-1).get("id").toString());
        }
        
        return lastId+1;
    }
    
    public boolean isInDB(HardwareComponent component){
        boolean isInDB;
        isInDB = DatabaseManager.existsDocument(collection, "id", component.getId());
        return isInDB;
    }
    
    public boolean save(HardwareComponent component){
        boolean verification;
        verification = DatabaseManager.insertDocument(collection, component.getData());
        return verification;
    }
    
    public boolean update(HashMap<Object, Object> componentData){
        boolean verification;
        verification = DatabaseManager.updateDocument(collection, componentData);
        return verification;
    }
    
    public boolean update(HardwareComponent component){
        boolean verification;
        verification = DatabaseManager.updateDocument(collection, component.getData());
        return verification;
    }
    
    public void updateQuantities(ArrayList<Catalog> orderedInCatalog){
        for(Catalog catalogProduct : orderedInCatalog){
            HashMap<Object, Object> initialComponent = obtainFromDb(catalogProduct.getId());
            
            int initialQuantity = Integer.parseInt(initialComponent.get("quantity").toString());
            int newQuantity = initialQuantity - catalogProduct.getQuantity() ;
            
            initialComponent.replace("id", Integer.valueOf(initialComponent.get("id").toString()));
            initialComponent.replace("quantity", newQuantity);
            initialComponent.replace("cost", Double.valueOf(initialComponent.get("cost").toString()));
            initialComponent.replace("price", Double.valueOf(initialComponent.get("price").toString()));
            update(initialComponent);
           
        }
        
        
    }
    
    public boolean delete(HardwareComponent component){
        boolean verification;
        verification = DatabaseManager.deleteDocument(collection, component.getData());
        return verification;
    }
    
    public boolean delete(HashMap<Object, Object> componentData){
        boolean verification;
        verification = DatabaseManager.deleteDocument(collection, componentData);
        return verification;
    }
    
    public HashMap<Object, Object> obtainFromDb(int id){
        
        return DatabaseManager.obtain(collection, id);
    }
    
    public ArrayList<HashMap<Object, Object>> obtainAllFromDb(){
        
        return DatabaseManager.obtainAll(collection);
    }
    
    public ArrayList<HashMap<Object, Object>> convertAllToHashMap(ArrayList<HardwareComponent> components){
        ArrayList<HashMap<Object, Object>> convertedComponents = new ArrayList<>();
        for(HardwareComponent component : components){
            convertedComponents.add(component.getData());
        }
        return convertedComponents;
    }
    
    public Double calculatePrice(Double cost, Double gainPercentage){
        Double price = (1+(gainPercentage/100.0))*cost;
        
        return DecimalsControl.roundToTwoTenths(price);
    }
    
    public Double calculateGainPercentage(Double cost, Double price){
        Double gainPercentage = ((price/cost)-1)*100;
        
        return DecimalsControl.roundToTwoTenths(gainPercentage);
    }
    
}
