package ec.edu.espe.evsustore.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
    
    public void write(Inventory inventory){
        File file = new File(fileName + ".json");
        String dataReaded;
        if (file.exists()){
            dataReaded = readData();
            writeIfFileExists(inventory, dataReaded);
        }
        else{
            create();
            writeIfFileDoesntExists(inventory);
        }
        
    }
    public void writeIfFileDoesntExists(Inventory inventory){
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
    public void writeIfFileExists(Inventory currentInventory, String dataReaded){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".json"));
            Gson gson = new Gson();
            Type Inventory = new TypeToken<Inventory>(){}.getType();
            Inventory savedInventory = gson.fromJson(dataReaded, Inventory);
            HardwareComponent lastComponent = new HardwareComponent();
            Clothing lastClothing = new Clothing();
            int maxSavedIndex;
            int maxCurrentIndex;
            
            maxSavedIndex = savedInventory.getHardwareComponents().lastIndexOf(lastComponent);
            maxCurrentIndex = currentInventory.getHardwareComponents().size()-1;
                    
            for(HardwareComponent component: currentInventory.getHardwareComponents().subList(maxSavedIndex, maxCurrentIndex)){
                savedInventory.getHardwareComponents().add(component);
            }
            
            maxSavedIndex = savedInventory.getClothes().lastIndexOf(lastComponent);
            maxCurrentIndex = currentInventory.getClothes().size()-1;
            
            for(Clothing cloth: currentInventory.getClothes().subList(maxSavedIndex, maxCurrentIndex)){
                savedInventory.getClothes().add(cloth);
            }

            writer.write(gson.toJson(savedInventory));
            writer.flush();
            
        } 
        catch (IOException ex) {
            System.out.println("Hubo un error al escribir el archivo");
        }
        
    }
    
    public String readData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName + ".json"))) {
            String content = "";
            String line;
            while ((line = reader.readLine()) != null) {
                content += line;
            }
            return content;
        } catch (IOException e) {
                System.out.println("Hubo un error al leer el archivo");
            return "";
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
