package persistence.entities;

import persistence.entities.product.Cement;
import persistence.entities.product.Drill;
import persistence.entities.product.Paint;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "SelectDepositByCity", query = "select deposit from Deposit deposit where deposit.city=:city"),
        @NamedQuery(name = "DeleteDepositByAddress", query = "delete from Deposit where address=:address"),
        @NamedQuery(name = "UpdateDepositAddress", query = "update from Deposit set address=:address where city=:city")
})
@Entity
@Table(name = "deposits")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "deposit",cascade = CascadeType.ALL)
    private Set<Employee> employeeSet;
    @ManyToMany(mappedBy = "depositSet",cascade = CascadeType.ALL)
    private Set<Cement> cementSet;
    @ManyToMany(mappedBy = "depositSet",cascade = CascadeType.ALL)
    private Set<Drill> drillSet;
    @ManyToMany(mappedBy = "depositSet",cascade = CascadeType.ALL)
    private Set<Paint> paintSet;
    @ManyToMany(mappedBy = "depositSet",cascade = CascadeType.ALL)
    private Set<Valve> valveSet;


    public Deposit() {
    }

    public Deposit(String city, String address) {
        this.city = city;
        this.address = address;
    }

    public Deposit(String city, String address, Set<Employee> employeeSet, Set<Cement> cementSet, Set<Drill> drillSet, Set<Paint> paintSet, Set<Valve> valveSet) {
        this.city = city;
        this.address = address;
        this.employeeSet = employeeSet;
        this.cementSet = cementSet;
        this.drillSet = drillSet;
        this.paintSet = paintSet;
        this.valveSet = valveSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Set<Cement> getCementSet() {
        return cementSet;
    }

    public void setCementSet(Set<Cement> cementSet) {
        this.cementSet = cementSet;
    }

    public Set<Drill> getDrillSet() {
        return drillSet;
    }

    public void setDrillSet(Set<Drill> drillSet) {
        this.drillSet = drillSet;
    }

    public Set<Paint> getPaintSet() {
        return paintSet;
    }

    public void setPaintSet(Set<Paint> paintSet) {
        this.paintSet = paintSet;
    }

    public Set<Valve> getValveSet() {
        return valveSet;
    }

    public void setValveSet(Set<Valve> valveSet) {
        this.valveSet = valveSet;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
