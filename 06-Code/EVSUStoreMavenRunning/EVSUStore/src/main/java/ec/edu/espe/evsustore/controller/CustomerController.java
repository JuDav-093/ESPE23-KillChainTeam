
package ec.edu.espe.evsustore.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.evsustore.model.Customer;
import ec.edu.espe.evsustore.utils.DatabaseManager;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class CustomerController {
    DatabaseController database;
    MongoCollection collection;
    
    private static CustomerController instance;
    
    private CustomerController() {
        this.database = DatabaseController.getInstance();
        this.collection = this.database.changeCollection("Customers");
    }
    
    public synchronized static CustomerController getInstance (){
        if (instance != null){
        
        } 
        else {
            instance = new CustomerController();
        }
        
        return instance;
    }
    
    public int generateId(){
        int lastId = 0;
        ArrayList<HashMap<Object, Object>> customers =  obtainAllFromDb();
        if(!customers.isEmpty()){
            lastId = Integer.parseInt(customers.get(customers.size()-1).get("id").toString());
        }
        return lastId+1;
    }
    
    public boolean isInDB(Customer customer){
        boolean isInDB;
        isInDB = DatabaseManager.existsDocument(collection, "id", customer.getId());
        return isInDB;
    }
    
    public boolean save(Customer customer){
        boolean verification;
        verification = DatabaseManager.insertDocument(collection, customer.getData());
        return verification;
    }
    
    public boolean update(HashMap<Object, Object> customerData){
        boolean verification;
        verification = DatabaseManager.updateDocument(collection, customerData);
        return verification;
    }
    
    public boolean update(Customer customer){
        boolean verification;
        verification = DatabaseManager.updateDocument(collection, customer.getData());
        return verification;
    }
    
    public boolean delete(Customer customer){
        boolean verification;
        verification = DatabaseManager.deleteDocument(collection, customer.getData());
        return verification;
    }
    
    public boolean delete(HashMap<Object, Object> customerData){
        boolean verification;
        verification = DatabaseManager.deleteDocument(collection, customerData);
        return verification;
    }
    
    public HashMap<Object, Object> obtainFromDb(int id){
        
        return DatabaseManager.obtain(collection, id);
    }
    
    
    public ArrayList<HashMap<Object, Object>> obtainAllFromDb(){
        return DatabaseManager.obtainAll(collection);
    }
}
