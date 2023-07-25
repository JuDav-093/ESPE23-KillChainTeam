package ec.edu.espe.evsustore.model;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Salesman {
    private int id;
    private String name;
    private String lastName;
    private int idCardNumber;
    private int phoneNumber;
    private Order orders[];

    public Salesman() {
    }
    
    public Salesman(int id, String name, String lastName, int idCardNumber, int phoneNumber, Order[] orders) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.idCardNumber = idCardNumber;
        this.phoneNumber = phoneNumber;
        this.orders = orders;
    }

    
    
    
}
