package ec.edu.espe.evsustore.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.evsustore.model.HardwareComponent;
import ec.edu.espe.evsustore.utils.DatabaseManager;
import java.util.ArrayList;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class DatabaseController {
    String clientURL = "mongodb+srv://jcobena:<password>@cluster0.mhpiaao.mongodb.net/";
    String databaseName = "EVSUStore";
    String selectedCollectionName;
    MongoDatabase database;
    MongoCollection collection;
    
    public void connectDatabase(){
        database = DatabaseManager.connectToDatabase(clientURL, databaseName);
    }
    
    public void connectToComponentsCollection(){
        selectedCollectionName = "HardwareComponents";
        collection = DatabaseManager.connectToCollection(database, clientURL);
    }
    
    public HardwareComponent obatinComponent(int id){
        connectToComponentsCollection();
        
        HardwareComponent componentInDB = DatabaseManager.obtainComponent(collection, id);
        
        return componentInDB;
    }
    
    public ArrayList<HardwareComponent> obatinAllComponents(){
        connectToComponentsCollection();
        
        ArrayList<HardwareComponent> componentsInDB = DatabaseManager.obtainAllComponents(collection);
        
        return componentsInDB;
    }

    public String getSelectedCollectionName() {
        return selectedCollectionName;
    }

    public void setSelectedCollectionName(String selectedCollectionName) {
        this.selectedCollectionName = selectedCollectionName;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void setDatabase(MongoDatabase database) {
        this.database = database;
    }

    public MongoCollection getCollection() {
        return collection;
    }

    public void setCollection(MongoCollection collection) {
        this.collection = collection;
    }
    
    
}
