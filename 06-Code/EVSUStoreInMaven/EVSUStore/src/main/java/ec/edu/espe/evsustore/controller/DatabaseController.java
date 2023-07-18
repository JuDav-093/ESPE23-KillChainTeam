package ec.edu.espe.evsustore.controller;


import com.mongodb.client.MongoDatabase;
import ec.edu.espe.evsustore.model.HardwareComponent;
import ec.edu.espe.evsustore.utils.DatabaseManager;
import java.util.ArrayList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import ec.edu.espe.evsustore.model.Clothing;
import org.bson.Document;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Random;
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
    public ArrayList<Clothing> obtainClothingsCoincidence(String field){
        MongoCollection collection = DatabaseManager.connectToCollection(database, "Clothins");
        ArrayList<Clothing> clothinsCoincidence = DatabaseManager.foundComponentCoincidences(collection, field);
        
        return clothinsCoincidence;
    }
    
    public void update(HardwareComponent component) {
        MongoCollection collection = DatabaseManager.connectToCollection(database, "HardwareComponents");
        DatabaseManager.update(collection, component);
    }
    
    public void delete(HardwareComponent component) {
        MongoCollection collection = DatabaseManager.connectToCollection(database, "HardwareComponents");
        DatabaseManager.delete(collection, component.getId());
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
    

    private String currentUsername;
    private String newPassword;

    public boolean checkCredentials(String username, String password) {
        MongoCollection<Document> collection = DatabaseManager.connectToCollection(database, "Users");

        BasicDBObject query = new BasicDBObject();
        query.put("username", username);

        Document result = collection.find(query).first();
        if (result != null) {
            String storedPassword = result.getString("password");
            if (storedPassword.startsWith("$2a$")) {
                if (BCrypt.checkpw(password, storedPassword)) {
                    currentUsername = username;
                    return true;
                }
            } else {
                
                if (password.equals(storedPassword)) {
              
                    String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
                    result.put("password", hashedPassword);
                    collection.replaceOne(new Document("_id", result.get("_id")), result);
                    currentUsername = username;
                    return true;
                }
            }
        }

        return false;
    }


    public void migratePasswordsToBCrypt() {
        MongoCollection<Document> collection = DatabaseManager.connectToCollection(database, "Users");

        BasicDBObject query = new BasicDBObject();
        query.put("password", new BasicDBObject("$exists", true));

        ArrayList<Document> documents = collection.find(query).into(new ArrayList<>());
        for (Document document : documents) {
            String oldPassword = document.getString("password");

            if (!oldPassword.startsWith("$2a$")) {
                String newPassword = BCrypt.hashpw(oldPassword, BCrypt.gensalt());
                document.put("password", newPassword);
                collection.replaceOne(new Document("_id", document.get("_id")), document);
            }
        }
    }
    
    public boolean createUser(String name, String lastName, String username, String password) {
        MongoCollection<Document> collection = DatabaseManager.connectToCollection(database, "Users");

       
        BasicDBObject query = new BasicDBObject();
        query.put("username", username);

        Document existingUser = collection.find(query).first();
        if (existingUser != null) {
           
            return false;
        }
 
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        
        Document newUser = new Document();
        newUser.append("name", name)
                .append("lastName", lastName)
                .append("username", username)
                .append("password", hashedPassword);

        collection.insertOne(newUser);

        return true;
    }
    
    public boolean changePassword(String confirmPassword) {
        if (!newPassword.equals(confirmPassword)) {
            return false;
        }
        MongoCollection<Document> collection = DatabaseManager.connectToCollection(database, "Users");

        BasicDBObject query = new BasicDBObject();
        query.put("username", currentUsername);

        Document user = collection.find(query).first();
        if (user != null) {
            String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
            user.put("password", hashedPassword);
            collection.replaceOne(new Document("_id", user.get("_id")), user);
            return true;
        }
        return false;
    }
    
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


    
    public String getPasswordByUsername(String username) {
        MongoCollection<Document> collection = DatabaseManager.connectToCollection(database, "Users");

        BasicDBObject query = new BasicDBObject();
        query.put("username", username);

        Document result = collection.find(query).first();
        if (result != null) {
            String hashedPassword = result.getString("password");

            
            if (hashedPassword.startsWith("$2a$")) {
               
                return BCrypt.checkpw("", hashedPassword) ? "" : null;
            } else {
                
                return hashedPassword;
            }
        }

        return null;
    }
    
    
    public String generateTemporaryPassword() {
        
        String temporaryPassword = generateRandomPassword();    
        String hashedPassword = BCrypt.hashpw(temporaryPassword, BCrypt.gensalt());
        return hashedPassword;
    }
    public String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = 8;

        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }
    
    public boolean updatePassword(String username, String newPassword, String temporaryPassword) {
        MongoCollection<Document> collection = DatabaseManager.connectToCollection(database, "Users");

        BasicDBObject query = new BasicDBObject();
        query.put("username", username);

        Document user = collection.find(query).first();
        if (user != null) {
           
            String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
            user.put("password", hashedPassword);
            user.put("temporaryPassword", temporaryPassword);

            // Reemplazar el documento en la base de datos
            collection.replaceOne(new Document("_id", user.get("_id")), user);

            return true;
        }

        return false;
    }
}
