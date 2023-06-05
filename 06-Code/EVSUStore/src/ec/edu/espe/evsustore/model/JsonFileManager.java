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
public class JsonFileManager {
    private String fileName;
    private String path = "";

    public JsonFileManager() {
    }

    public JsonFileManager(String fileName) {
        this.fileName = fileName;
    }
    
    public void createInventoryFile(){
        try {
            File file = new File(path + fileName + ".json");
            
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
        File file = new File(path + fileName + ".json");
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
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + fileName + ".json"));
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
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + fileName + ".json"));
            Gson gson = new Gson();
            Type Inventory = new TypeToken<Inventory>(){}.getType();
            Inventory savedInventory = gson.fromJson(dataReaded, Inventory);
            
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
    
    public void createSalesRegisterFile(){
        try {
            File file = new File(path +fileName + ".json");
            
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
    
    public void writeSalesRegisterFile(SalesRegister salesRegister){
        File file = new File(path + fileName + ".json");
        String dataReaded;
        if (file.exists()){
            dataReaded = readData();
            writeIfSalesRegisterFileExists(salesRegister, dataReaded);
        }
        else{
            createSalesRegisterFile();
            writeIfSalesRegisterFileDoesntExists(salesRegister);
        }
        
    }
    public void writeIfSalesRegisterFileDoesntExists(SalesRegister salesRegister){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + fileName + ".json"));
            Gson gson = new Gson();
            
            writer.write(gson.toJson(salesRegister));
            writer.flush();
        } 
        catch (IOException ex) {
            System.out.println("Hubo un error al escribir el archivo");
        }
    }
    
    public void writeIfSalesRegisterFileExists(SalesRegister salesRegister, String dataReaded){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + fileName + ".json"));
            Gson gson = new Gson();
            Type SalesRegister = new TypeToken<SalesRegister>(){}.getType();
            SalesRegister savedSalesRegister = gson.fromJson(dataReaded, SalesRegister);
            
            for(int i=salesRegister.getSales().size()-1; i<salesRegister.getSales().size();i++){
                Sale sale = salesRegister.getSales().get(i);
                int j = savedSalesRegister.getSales().size();
                savedSalesRegister.getSales().add(j, sale);
            }

            writer.write(gson.toJson(savedSalesRegister));
            writer.flush();
        } 
        catch (IOException ex) {
            System.out.println("Hubo un error al escribir el archivo");
        }
        
    }
    
    public void writePurchaseRegisterFile(PurchaseRegister purchaseRegister){
        File file = new File(path + fileName + ".json");
        String dataReaded;
        if (file.exists()){
            dataReaded = readData();
            writeIfPurchaseRegisterFileExists(purchaseRegister, dataReaded);
        }
        else{
            createPurchaseRegisterFile();
            writeIfPurchaseRegisterFileDoesntExists(purchaseRegister);
        }
        
    }
    public void writeIfPurchaseRegisterFileDoesntExists(PurchaseRegister purchaseRegister){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + fileName + ".json"));
            Gson gson = new Gson();
            writer.write(gson.toJson(purchaseRegister));
            writer.flush();
        } 
        catch (IOException ex) {
            System.out.println("Hubo un error al escribir el archivo");
        }
    }
    
    public void writeIfPurchaseRegisterFileExists(PurchaseRegister purchaseRegister, String dataReaded){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + fileName + ".json"));
            Gson gson = new Gson();
            Type PurchaseRegister = new TypeToken<PurchaseRegister>(){}.getType();
            PurchaseRegister savedPurchaseRegister = gson.fromJson(dataReaded, PurchaseRegister);
            
            for(int i=purchaseRegister.getPurchases().size()-1; i<purchaseRegister.getPurchases().size();i++){
                Purchase purchase = purchaseRegister.getPurchases().get(i);
                int j = savedPurchaseRegister.getPurchases().size();
                savedPurchaseRegister.getPurchases().add(j, purchase);
            }

            writer.write(gson.toJson(savedPurchaseRegister));
            writer.flush();
        } 
        catch (IOException ex) {
            System.out.println("Hubo un error al escribir el archivo");
        }
        
    }
    
    public void createPurchaseRegisterFile(){
        try {
            File file = new File(path + fileName + ".json");
            
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
    
    public void updateInventory(Inventory inventory){
        File file = new File(path + fileName + ".json");
        String dataReaded;
        if (file.exists()){
            dataReaded = readData();
            uptdateInventoryWithFile(inventory, dataReaded);
           
        }
        else{
            
        }
        
    }
    public void uptdateInventoryWithFile(Inventory inventory, String dataReaded){
        Gson gson = new Gson();
        Type Inventory = new TypeToken<Inventory>(){}.getType();
        Inventory savedInventory = gson.fromJson(dataReaded, Inventory);
        if(savedInventory!=null){
            inventory.setClothes(savedInventory.getClothes());
            inventory.setHardwareComponents(savedInventory.getHardwareComponents());
        }
    }
    
    
    public void viewInventory(Inventory inventory){
        File file = new File(path + fileName + ".json");
        String dataReaded;
        if (file.exists()){
            dataReaded = readData();
            showInventory(dataReaded);
        }
        else{
            
        }
        
    }
    
    
    public void showInventory(String dataReaded){
        Gson gson = new Gson();
        Type Inventory = new TypeToken<Inventory>(){}.getType();
        Inventory savedInventory = gson.fromJson(dataReaded, Inventory);
        System.out.println(savedInventory);
    }
    
    public void viewPurchaseRegister(PurchaseRegister purchaseRegister){
        File file = new File(path + fileName + ".json");
        String dataReaded;
        if (file.exists()){
            dataReaded = readData();
            showPurchaseRegister(dataReaded);
        }
        else{
            
        }
        
    }
    
    public void showPurchaseRegister(String dataReaded){
        Gson gson = new Gson();
        Type PurchaseRegister = new TypeToken<PurchaseRegister>(){}.getType();
        PurchaseRegister savedPurchaseRegister = gson.fromJson(dataReaded, PurchaseRegister);
        System.out.println(savedPurchaseRegister.getPurchases());
    }
    
    public int searchComponentId(){
        File file = new File(path + fileName + ".json");
        String dataReaded;
        int id;
        
        if (file.exists()){
            dataReaded = readData();
            return readId(dataReaded);
        }
        else{
            return 0;
        }
    }
    
    public int readId(String dataReaded){
        Gson gson = new Gson();
        Type Inventory = new TypeToken<Inventory>(){}.getType();
        Inventory savedInventory = gson.fromJson(dataReaded, Inventory);
        int LastId;
        LastId = savedInventory.getHardwareComponents().size();
        
        return LastId;
    }
    
    public String readData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path + fileName + ".json"))) {
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
