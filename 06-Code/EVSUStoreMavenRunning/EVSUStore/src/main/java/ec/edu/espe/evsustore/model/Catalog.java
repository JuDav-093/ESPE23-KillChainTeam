
package ec.edu.espe.evsustore.model;

import java.util.HashMap;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Catalog implements Mapeable{
    String productDescription;
    int id;
    int quantity;
    Double price;
    HashMap<Object, Object> data;

    @Override
    public String toString() {
        return productDescription + " Cantidad" + quantity + " Precio" + price + "\t";
    }

    
    
    public Catalog(int id, String productDescription, int quantity, Double price) {
        data = new HashMap<>();
        data.put("id", id);
        data.put("productDescription", productDescription);
        data.put("quantity", quantity);
        data.put("price", price);
        
        this.id = id;
        this.productDescription = productDescription;
        this.quantity = quantity;
        this.price = price;
    }

    

    @Override
    public HashMap<Object, Object> getData() {
        return data;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    
}
