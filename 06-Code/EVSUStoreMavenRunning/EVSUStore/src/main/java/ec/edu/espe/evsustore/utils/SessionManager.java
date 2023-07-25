/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.evsustore.utils;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import org.bson.Document;


/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */
public class SessionManager {

    private static String currentUser;

    public static boolean startSession(String username, MongoCollection<Document> collection) {
        if (userExist(username, collection)) {
            currentUser = username;
            System.out.println("Sesión iniciada para el usuario: " + currentUser);
            return true;
        } else {
            System.out.println("No se puede iniciar sesión. El usuario no está registrado.");
            return false;
        }
    }

    public static void closeSession() {
        System.out.println("Sesión cerrada para el usuario: " + currentUser);
        currentUser = null;
    }

    public static boolean sessionActive() {
        if (currentUser != null) {
            System.out.println("Sesión activa para el usuario: " + currentUser);
            return true;
        } else {
            System.out.println("No hay sesión activa.");
            return false;
        }
    }

    public static String getCurrentUser() {
        return currentUser;
    }


    private static boolean userExist(String username, MongoCollection<Document> collection) {
        BasicDBObject query = new BasicDBObject();
        query.put("username", username);

        Document result = collection.find(query).first();
        return result != null;
    }
   
}
