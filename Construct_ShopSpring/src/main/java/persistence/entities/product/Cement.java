package persistence.entities.product;

import persistence.entities.Department;
import persistence.entities.Deposit;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({@NamedQuery(name = "SelectCementByName", query = "select cement from Cement cement where cement.name=:name"),
        @NamedQuery(name = "DeleteCementByGranulation", query = "delete from Cement where granulation=:granulation"),
        @NamedQuery(name = "UpdateCementGranulation", query = "update from Cement set granulation=:granulation where name=:name")})

@Entity
@Table(name = "cements")
public class Cement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "granulation")
    private String granulation;
    @Column(name = "price")
    private int price;
    @Column(name = "stock")
    private int stock;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "departments_id")
    private Department department;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "cements_deposits", joinColumns = {@JoinColumn(name = "cements_id")}, inverseJoinColumns = {@JoinColumn(name = "deposits_id")})
    private Set<Deposit> depositSet;

    public Cement() {
    }

    public Cement(String name, String granulation, int price, int stock) {
        this.name = name;
        this.granulation = granulation;
        this.price = price;
        this.stock = stock;
    }

    public Cement(String name, String granulation, int price, int stock, Department department, Set<Deposit> depositSet) {
        this.name = name;
        this.granulation = granulation;
        this.price = price;
        this.stock = stock;
        this.department = department;
        this.depositSet = depositSet;
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

    public String getGranulation() {
        return granulation;
    }

    public void setGranulation(String granulation) {
        this.granulation = granulation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Deposit> getDepositSet() {
        return depositSet;
    }

    public void setDepositSet(Set<Deposit> depositSet) {
        this.depositSet = depositSet;
    }

    @Override
    public String toString() {
        return "Cement{" +
                "name='" + name + '\'' +
                ", granulation='" + granulation + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
