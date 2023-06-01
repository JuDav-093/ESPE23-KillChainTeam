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
    
    public void createInventoryFile(){
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
    
    public void writeInventoryFile(Inventory inventory){
        File file = new File(fileName + ".json");
        String dataReaded;
        if (file.exists()){
            dataReaded = readData();
            writeIfInventoryFileExists(inventory, dataReaded);
        }
        else{
            createInventoryFile();
            writeIfInventoryFileDoesntExists(inventory);
        }
        
    }
    public void writeIfInventoryFileDoesntExists(Inventory inventory){
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
    
    public void writeIfInventoryFileExists(Inventory currentInventory, String dataReaded){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".json"));
            Gson gson = new Gson();
            Type Inventory = new TypeToken<Inventory>(){}.getType();
            Inventory savedInventory = gson.fromJson(dataReaded, Inventory);
            HardwareComponent hardwareComp = new HardwareComponent();
            
            for(int i=currentInventory.getHardwareComponents().size()-1; i<currentInventory.getHardwareComponents().size();i++){
                HardwareComponent component = currentInventory.getHardwareComponents().get(i);
                int j = savedInventory.getHardwareComponents().size();
                savedInventory.getHardwareComponents().add(j, component);
            }

            writer.write(gson.toJson(savedInventory));
            writer.flush();
        } 
        catch (IOException ex) {
            System.out.println("Hubo un error al escribir el archivo");
        }
        
    }
    /*
    public void writeSalesRegisterFile(SalesRegister salesRegister){
        File file = new File(fileName + ".json");
        String dataReaded;
        if (file.exists()){
            dataReaded = readData();
            writeIfSalesRegisterFileExists(salesRegister, dataReaded);
        }
        else{
            createInventoryFile();
            writeIfSalesRegisterFileDoesntExists(salesRegister);
        }
        
    }
    public void writeIfSalesRegisterDoesntExists(SalesRegister salesRegister){
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
    
    public void writeIfSalesRegisterExists(SalesRegister salesRegister, String dataReaded){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".json"));
            Gson gson = new Gson();
            Type Inventory = new TypeToken<Inventory>(){}.getType();
            Inventory savedInventory = gson.fromJson(dataReaded, Inventory);
            HardwareComponent hardwareComp = new HardwareComponent();
            
            for(int i=currentInventory.getHardwareComponents().size()-1; i<currentInventory.getHardwareComponents().size();i++){
                HardwareComponent component = currentInventory.getHardwareComponents().get(i);
                int j = savedInventory.getHardwareComponents().size();
                savedInventory.getHardwareComponents().add(j, component);
            }

            writer.write(gson.toJson(savedInventory));
            writer.flush();
        } 
        catch (IOException ex) {
            System.out.println("Hubo un error al escribir el archivo");
        }
        
    }
    */
    
    
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
