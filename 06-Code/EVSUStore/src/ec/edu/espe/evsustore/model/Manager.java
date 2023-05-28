package ec.edu.espe.evsustore.model;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class Manager {
    private int id;
    private String name;
    private String lastName;
    private Sale sales[];
    private Salesman salesmans[];

    public Manager() {
    }
    
    public Manager(int id, String name, String lastName, Sale[] sales, Salesman[] salesmans) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.sales = sales;
        this.salesmans = salesmans;
    }

    
}
