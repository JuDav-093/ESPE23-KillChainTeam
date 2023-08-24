
package ec.edu.espe.evsustore.controller;

import ec.edu.espe.evsustore.model.Catalog;
import ec.edu.espe.evsustore.model.HardwareComponent;
import ec.edu.espe.evsustore.utils.HashMapManger;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class CatalogController {
    DatabaseController database;
    HardwareComponentController componentController;
    
    private static CatalogController instance;
    
    private CatalogController() {
        this.database = DatabaseController.getInstance();
        this.componentController = HardwareComponentController.getInstance();
    }
    
    public synchronized static CatalogController getInstance (){
        if (instance != null){
        
        } 
        else {
            instance = new CatalogController();
        }
        
        return instance;
    }
    
     public HashMap<Object, Object> obtain(int id) {
        
        Catalog catalogProduct;
        HashMap<Object, Object> component = componentController.obtainFromDb(id);
        catalogProduct = convertIntoCatalog(component);
        
        return catalogProduct.getData();
    }
    
    
    public ArrayList<HashMap<Object, Object>> obtainAll() {
        ArrayList<HashMap<Object, Object>> catalog = new ArrayList<>();
        Catalog catalogProduct;
        ArrayList<HashMap<Object, Object>> components = componentController.obtainAllFromDb();
        for(HashMap<Object, Object> component : components){
            
            catalogProduct = convertIntoCatalog(component);
            catalog.add(catalogProduct.getData());
            
        }
        return catalog;
    }
    
    public ArrayList<HashMap<Object, Object>> convertAllToHashMap(ArrayList<Catalog> catalog){
        ArrayList<HashMap<Object, Object>> convertedComponents = new ArrayList<>();
        for(Catalog catalogProduct : catalog){
            convertedComponents.add(catalogProduct.getData());
        }
        return convertedComponents;
    }
    
    public ArrayList<Catalog> convertAllIntoCatalogProducts( ArrayList<HashMap<Object, Object>> catalog) {
        ArrayList<Catalog> catalogProducts = new ArrayList<>();
        
        for(HashMap<Object, Object> catalogProductData : catalog){
            
            int id = Integer.parseInt(catalogProductData.get("id").toString());
            int quantity = Integer.parseInt(catalogProductData.get("quantity").toString());
            Double price = Double.valueOf(catalogProductData.get("price").toString());
            System.out.println("id"+id);
            String description = catalogProductData.get("productDescription").toString();
            
            Catalog catalogProduct = new Catalog(id, description, quantity, price);
            System.out.println("id"+catalogProduct.getId());
            catalogProducts.add(catalogProduct);
        }
        return catalogProducts;
    }
    
    public Catalog convertIntoCatalog(HashMap<Object, Object> component) {
        int id = Integer.parseInt(component.get("id").toString());
        int quantity = Integer.parseInt(component.get("quantity").toString());
        Double price = Double.valueOf(component.get("price").toString());
        String description1 = component.get("name").toString();
        String description2 = component.get("model").toString();
        String description = description1 + " " +description2;
    
        Catalog catalog = new Catalog(id, description, quantity, price);
        return catalog;
    }
}
