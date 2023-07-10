
package ec.edu.espe.evsustore.model;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Customer {
    private int id;
    private String name;
    private String lastName;
    private int phoneNumber;
    private int idCardNumber;

    public Customer(String name, String lastName, int phoneNumber, int idCardNumber) {
        this.id = generateId();
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.idCardNumber = idCardNumber;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(int idCardNumber) {
        this.idCardNumber = idCardNumber;
    }
    
    public static int generateId(){
        //TODO generateId algorithm
        return 0;
    }
}
