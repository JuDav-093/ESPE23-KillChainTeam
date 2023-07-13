
package ec.edu.espe.evsustore.utils;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.evsustore.model.Clothing;
import ec.edu.espe.evsustore.model.HardwareComponent;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class DatabaseManager {
    
    public static MongoDatabase connectToDatabase(String url, String dataBase){
        MongoClient mongoClient = MongoClients.create(url);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(dataBase);
        System.out.println("-> Connected successfully to server " + dataBase);  
        return mongoDatabase;
    }
    
    public static MongoCollection connectToCollection(MongoDatabase database, String collection){
        MongoCollection<Document> mongoCollection = database.getCollection(collection);
        return mongoCollection; 
    }
    
    
    public static boolean insertOne(MongoCollection<Document> collection, HardwareComponent component){
        Document document = createDocument(component);
        if(!document.isEmpty()){
            try {
                collection.insertOne(document);
                System.out.println("-> Inserted successfully");
                return true;
            } catch (Exception e) {
                System.out.println("-> Insertion failed");
                return false;
            }
        }else{
            System.out.println("-> Insertion failed");
            return false;
        }
    }
    
    public static boolean insertOne(MongoCollection<Document> collection, Clothing clothing){
        Document document = createDocument(clothing);
        if(!document.isEmpty()){
            try {
                collection.insertOne(document);
                System.out.println("-> Inserted successfully");
                return true;
            } catch (Exception e) {
                System.out.println("-> Insertion failed");
                return false;
            }
        }else{
            System.out.println("-> Insertion failed");
            return false;
        }
    }
    
    public static Document createDocument(HardwareComponent component){
        Document document = new Document();
        
        int id = component.getId();
        int quantity = component.getQuantity();
        double cost = component.getCost();
        double price = component.getPrice();
        String name = component.getName();
        String model = component.getModel();
        
        document.append("id", id);
        document.append("quantity", quantity);
        document.append("cost", cost);
        document.append("price", price);
        document.append("name", name);
        document.append("model", model);
                
        return document; 
    }
    
    public static Document createDocument(Clothing clothing){
        Document document = new Document();
        //TODO Code for document with clothing
        
        return document;
    }
    
    public static HardwareComponent obtainComponent(MongoCollection<Document> collection, int id){
        Document obtainedDocument = search(collection, id);
        if(obtainedDocument != null){
            int componentId = obtainedDocument.getInteger("id");
            int quantity = obtainedDocument.getInteger("quantity");
            double cost = obtainedDocument.getDouble("cost");
            double price = obtainedDocument.getDouble("price");
            String name = obtainedDocument.getString("name");
            String model = obtainedDocument.getString("model");
        
            HardwareComponent obtainedComponent = new HardwareComponent(id, quantity, cost, price, name, model);
            return obtainedComponent;
        }
        else{
            return null;
        }
        
    }
    
    public static ArrayList<HardwareComponent> obtainAllComponents(MongoCollection<Document> collection){
        MongoCursor<Document> cursor = collection.find().iterator();
        ArrayList<HardwareComponent> obtainedComponents = new ArrayList<>();
        
        while(cursor.hasNext()){
            Document obtainedDocument = cursor.next();
            if(obtainedDocument != null){
                int componentId = obtainedDocument.getInteger("id");
                int quantity = obtainedDocument.getInteger("quantity");
                double cost = obtainedDocument.getDouble("cost");
                double price = obtainedDocument.getDouble("price");
                String name = obtainedDocument.getString("name");
                String model = obtainedDocument.getString("model");

                HardwareComponent obtainedComponent = new HardwareComponent(componentId, quantity, cost, price, name, model);
                
                obtainedComponents.add(obtainedComponent);
            }
            else{
                
            }
        }
        return obtainedComponents;
    }
    
    public static void update(MongoCollection<Document> collection, HardwareComponent component){
        int id = component.getId();
        Document documentToUpdate = search(collection, id);
        Document updatedDocument = createDocument(component);
        collection.updateOne(documentToUpdate, updatedDocument);
    }
    
    public static void delete(MongoCollection<Document> collection, int id){
        Document documentToDelete = search(collection, id);
        collection.deleteOne(documentToDelete);
    }
    
    public static Document search(MongoCollection<Document> collection, int id){
        Document query = new Document("id", id);
        FindIterable<Document> documents = collection.find(query);
        Document foundedDocument = documents.first();
        
        return foundedDocument;
    }

    
    public static ArrayList<HardwareComponent> foundComponentCoincidences(MongoCollection<Document> collection, String anyField){
        ArrayList<Document> foundedCoincidences = searchAllCoincidences(collection, anyField);
        ArrayList<HardwareComponent> componentCoincidences = new ArrayList<>();
                
        for(Document document: foundedCoincidences){
            if(document != null){
                int componentId = document.getInteger("id");
                int quantity = document.getInteger("quantity");
                double cost = document.getDouble("cost");
                double price = document.getDouble("price");
                String name = document.getString("name");
                String model = document.getString("model");

                HardwareComponent obtainedComponent = new HardwareComponent(componentId, quantity, cost, price, name, model);
                
                componentCoincidences.add(obtainedComponent);
            }
        }
        return componentCoincidences;
    }
    
    public static ArrayList<Document> searchAllCoincidences(MongoCollection<Document> collection, String anyField){
        ArrayList<Document> foundedCoincidences = new ArrayList<>();
        Document query = new Document();
        try{
            int id = Integer.parseInt(anyField);
            query = new Document("id", id);
            FindIterable<Document> documents = collection.find(query);
            for(Document document: documents){
                foundedCoincidences.add(document);
            }
        }
        catch(Exception e){
                
        }

        try{
            int quantity = Integer.parseInt(anyField);
            query = new Document("quantity", quantity);
            FindIterable<Document> documents = collection.find(query);
            for(Document document: documents){
                foundedCoincidences.add(document);
            }
        }
        catch(Exception e){
                
        }
            
        try{
            String name = anyField;
            query = new Document("name", name);
            FindIterable<Document> documents = collection.find(query);
            for(Document document: documents){
                foundedCoincidences.add(document);
            }
        }
        catch(Exception e){
                
        }  
        
        try{
            String model = anyField;
            query = new Document("model", model);
            FindIterable<Document> documents = collection.find(query);
            for(Document document: documents){
                foundedCoincidences.add(document);
            }
        }
        catch(Exception e){
                
        }
        
        try{
            double cost = Double.parseDouble(anyField);
            query = new Document("cost", cost);
            FindIterable<Document> documents = collection.find(query);
            for(Document document: documents){
                foundedCoincidences.add(document);
            }
        }
        catch(Exception e){
                
        }
        
        try{
            double price = Double.parseDouble(anyField);
            query = new Document("price", price);
            FindIterable<Document> documents = collection.find(query);
            for(Document document: documents){
                foundedCoincidences.add(document);
            }
        }
        catch(Exception e){
                
        }
        
        return foundedCoincidences;
    }
   
}

