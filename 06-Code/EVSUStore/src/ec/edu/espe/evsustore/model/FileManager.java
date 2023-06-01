package ec.edu.espe.evsustore.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class FileManager {
    private String fileName;
    
    public void create(){
        try {
            File file = new File(fileName + ".json");
            
            if(file.exists()){
                
            }
            else if(file.createNewFile()){
                System.out.println("El archivo se creo correctamente");
            }
        } 
        catch (IOException ex) {
            System.out.println("Hubo un error al crear el archivo");
        }
    }
    
    public void write(ArrayList <Inventory> inventory){
        File file = new File(fileName + ".json");
        String dataReaded;
        if (file.exists()){
            dataReaded = readData();
            writeIfFileExists(inventory);
        }
        else{
            create();
            writeIfFileDoesntExists(inventory);
        }
        
    }
    public void writeIfFileDoesntExists(ArrayList <Inventory> inventory){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".json"));
            Gson gson = new Gson();
            
            writer.write(gson.toJson(inventory));
            writer.flush();
        } 
        catch (IOException ex) {
            System.out.println("Hubo un error al escribir el archivo");
        }
        
    }
    public void writeIfFileExists(ArrayList <Inventory> inventory, String dataReaded){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".json"));
            Gson gson = new Gson();
            Type inventoryListType = new TypeToken<ArrayList<Inventory>>(){}.getType();
            ArrayList<Inventory> stock = gson.fromJson(dataReaded, inventoryListType);
            
            

            writer.write(gson.toJson(stock));
            writer.flush();
            
        } 
        catch (IOException ex) {
            System.out.println("Hubo un error al escribir el archivo");
        }
        
    }
    }
    
    
    
    
}
