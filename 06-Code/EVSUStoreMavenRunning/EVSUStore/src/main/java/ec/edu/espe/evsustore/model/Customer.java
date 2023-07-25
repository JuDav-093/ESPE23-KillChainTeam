
package ec.edu.espe.evsustore.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Customer implements Mapeable{
    private int id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String idCardNumber;
    private String email;
    private String location;
    
    
    private HashMap<Object, Object> data;

    @Override
    public String toString() {
        return  name + " " + lastName + " N°Cédula: " + idCardNumber ;
    }
    
    
    public Customer(int id, String name, String lastName, String phoneNumber, String idCardNumber, String email, String location) {
        data = new HashMap<>();
        data.put("id", id);
        data.put("name", name);
        data.put("lastName", lastName);
        data.put("phoneNumber", phoneNumber);
        data.put("idCardNumber", idCardNumber);
        data.put("email", email);
        data.put("location", location);
        
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.idCardNumber = idCardNumber;
        this.email = email;
        this.location = location;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    

    @Override
    public HashMap<Object, Object> getData() {
       return data;
    }
}
