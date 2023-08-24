
package ec.edu.espe.evsustore.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.evsustore.model.Purchase;
import ec.edu.espe.evsustore.utils.DatabaseManager;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class PurchaseController {
    DatabaseController database;
    MongoCollection collection;
    
    private static PurchaseController instance;
    
    private PurchaseController() {
        this.database = DatabaseController.getInstance();
        this.collection = this.database.changeCollection("Purchases");
    }
    
    public synchronized static PurchaseController getInstance (){
        if (instance != null){
        
        } 
        else {
            instance = new PurchaseController();
        }
        
        return instance;
    }
    
    public int generateId(){
        int lastId = 0;
        ArrayList<HashMap<Object, Object>> purchases =  obtainAllFromDb();
        if(!purchases.isEmpty()){
            lastId = Integer.parseInt(purchases.get(purchases.size()-1).get("id").toString());
        }
        return lastId+1;
    }
    
    public boolean isInDB(Purchase purchase){
        boolean isInDB;
        isInDB = DatabaseManager.existsDocument(collection, "id", purchase.getId());
        return isInDB;
    }
    
    public boolean save(Purchase purchase){
        boolean verification;
        verification = DatabaseManager.insertDocument(collection, purchase.getData());
        return verification;
    }
    
    public boolean update(HashMap<Object, Object> purchaseData){
        boolean verification;
        verification = DatabaseManager.updateDocument(collection, purchaseData);
        return verification;
    }
    
    public boolean update(Purchase purchase){
        boolean verification;
        verification = DatabaseManager.updateDocument(collection, purchase.getData());
        return verification;
    }
    
    public boolean delete(Purchase purchase){
        boolean verification;
        verification = DatabaseManager.deleteDocument(collection, purchase.getData());
        return verification;
    }
    
    public boolean delete(HashMap<Object, Object> purchaseData){
        boolean verification;
        verification = DatabaseManager.deleteDocument(collection, purchaseData);
        return verification;
    }
    
    public HashMap<Object, Object> obtainFromDb(int id){
        
        return DatabaseManager.obtain(collection, id);
    }
    
    public ArrayList<HashMap<Object, Object>> obtainAllFromDb(){
        return DatabaseManager.obtainAll(collection);
    }
}
