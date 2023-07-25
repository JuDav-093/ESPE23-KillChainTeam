
package ec.edu.espe.evsustore.model;

import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Purchase implements Mapeable{

    private int id;
    private HardwareComponent component;
    private Double totalCost;
    private LocalDate date;
    
    private HashMap<Object, Object> data;

    public Purchase(int id, HardwareComponent component, Double totalCost, LocalDate date) {
        data = new HashMap<>();
        data.put("id", id);
        data.put("purchasedComponents", component.toString());
        data.put("totalCost", totalCost);
        data.put("date", date);
        
        this.id = id;
        this.component = component;
        this.totalCost = totalCost;
        this.date = date;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HardwareComponent getComponent() {
        return component;
    }

    public void setComponent(HardwareComponent component) {
        this.component = component;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public HashMap<Object, Object> getData() {
        return data;
    }
    
    
    
}
