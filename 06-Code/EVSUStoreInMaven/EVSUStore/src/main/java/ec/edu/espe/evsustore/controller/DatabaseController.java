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
    String clientURL = "mongodb+srv://jcobena:jcobena@cluster0.mhpiaao.mongodb.net/";
    String databaseName = "EVSUStore";
    MongoDatabase database;
    
    public void connectDatabase(){
        database = DatabaseManager.connectToDatabase(clientURL, databaseName);
    }
    
    public void insertComponent(HardwareComponent hardwareComponent){
        MongoCollection collection = DatabaseManager.connectToCollection(database, "HardwareComponents");
        DatabaseManager.insertOne(collection, hardwareComponent);
    }
    
    public HardwareComponent obtainComponent(int id){
        MongoCollection collection = DatabaseManager.connectToCollection(database, "HardwareComponents");
        HardwareComponent componentInDB = DatabaseManager.obtainComponent(collection, id);
        
        return componentInDB;
    }
    
    public ArrayList<HardwareComponent> obtainAllComponents(){
        MongoCollection collection = DatabaseManager.connectToCollection(database, "HardwareComponents");
        ArrayList<HardwareComponent> componentsInDB = DatabaseManager.obtainAllComponents(collection);
        
        return componentsInDB;
    }
    
    public ArrayList<HardwareComponent> obtainComponentsCoincidence(String field){
        MongoCollection collection = DatabaseManager.connectToCollection(database, "HardwareComponents");
        ArrayList<HardwareComponent> componentsCoincidence = DatabaseManager.foundComponentCoincidences(collection, field);
        
        return componentsCoincidence;
    }
    
    public void save(HardwareComponent component) {
        MongoCollection collection = DatabaseManager.connectToCollection(database, "HardwareComponents");
        DatabaseManager.insertOne(collection, component);
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void setDatabase(MongoDatabase database) {
        this.database = database;
    }
    
    
}
