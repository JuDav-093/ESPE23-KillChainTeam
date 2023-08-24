
package ec.edu.espe.evsustore.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.evsustore.model.Sale;
import ec.edu.espe.evsustore.utils.DatabaseManager;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class SaleController {
    DatabaseController database;
    MongoCollection collection;
    
    private static SaleController instance;
    
    private SaleController() {
        this.database = DatabaseController.getInstance();
        this.collection = this.database.changeCollection("Sales");
    }
    
    public synchronized static SaleController getInstance (){
        if (instance != null){
        
        } 
        else {
            instance = new SaleController();
        }
        
        return instance;
    }
    
    public int generateId(){
        int lastId = 0;
        ArrayList<HashMap<Object, Object>> sales =  obtainAllFromDb();
        if(!sales.isEmpty()){
            lastId = Integer.parseInt(sales.get(sales.size()-1).get("id").toString());
        }
        return lastId+1;
    }
    
    public boolean isInDB(Sale sale){
        boolean isInDB;
        isInDB = DatabaseManager.existsDocument(collection, "id", sale.getSaleId());
        return isInDB;
    }
    
    public boolean save(Sale sale){
        boolean verification;
        verification = DatabaseManager.insertDocument(collection, sale.getData());
        return verification;
    }
    
    public boolean update(HashMap<Object, Object> saleData){
        boolean verification;
        verification = DatabaseManager.updateDocument(collection, saleData);
        return verification;
    }
    
    public boolean update(Sale sale){
        boolean verification;
        verification = DatabaseManager.updateDocument(collection, sale.getData());
        return verification;
    }
    
    public boolean delete(Sale sale){
        boolean verification;
        verification = DatabaseManager.deleteDocument(collection, sale.getData());
        return verification;
    }
    
    public boolean delete(HashMap<Object, Object> saleData){
        boolean verification;
        verification = DatabaseManager.deleteDocument(collection, saleData);
        return verification;
    }
    
    public HashMap<Object, Object> obtainFromDb(int id){
        
        return DatabaseManager.obtain(collection, id);
    }
    
    public ArrayList<HashMap<Object, Object>> obtainAllFromDb(){
        return DatabaseManager.obtainAll(collection);
    }
}
