package ec.edu.espe.evsustore.controller;


import com.mongodb.client.MongoDatabase;
import ec.edu.espe.evsustore.model.HardwareComponent;
import ec.edu.espe.evsustore.utils.DatabaseManager;
import java.util.ArrayList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.mindrot.jbcrypt.BCrypt;


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
    

    public boolean checkCredentials(String username, String password) {
       MongoCollection<Document> collection = DatabaseManager.connectToCollection(database, "Users");

       BasicDBObject query = new BasicDBObject();
       query.put("username", username);

       Document result = collection.find(query).first();
       if (result != null) {
           String storedPassword = result.getString("password");

           // Verificar si la contraseña está encriptada con BCrypt
           if (storedPassword.startsWith("$2a$")) {
               return BCrypt.checkpw(password, storedPassword);
           } else {
               // Verificar si la contraseña coincide sin encriptar
               if (password.equals(storedPassword)) {
                   // Si la contraseña coincide sin encriptar, actualizar la contraseña en la base de datos a su versión encriptada
                   String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
                   result.put("password", hashedPassword);
                   collection.replaceOne(new Document("_id", result.get("_id")), result);
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

            // Verificar si la contraseña ya está encriptada con BCrypt
            if (!oldPassword.startsWith("$2a$")) {
                String newPassword = BCrypt.hashpw(oldPassword, BCrypt.gensalt());
                document.put("password", newPassword);
                collection.replaceOne(new Document("_id", document.get("_id")), document);
            }
        }
    }
    
    public boolean createUser(String name, String lastName, String username, String password) {
        MongoCollection<Document> collection = DatabaseManager.connectToCollection(database, "Users");

        // Verificar si el nombre de usuario ya existe en la base de datos
        BasicDBObject query = new BasicDBObject();
        query.put("username", username);

        Document existingUser = collection.find(query).first();
        if (existingUser != null) {
            // El nombre de usuario ya está en uso
            return false;
        }

        // Encriptar la contraseña antes de guardarla en la base de datos
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        // Crear un nuevo documento para el usuario
        Document newUser = new Document();
        newUser.append("name", name)
                .append("lastName", lastName)
                .append("username", username)
                .append("password", hashedPassword);

        collection.insertOne(newUser);

        return true;
    }



    
}
