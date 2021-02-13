package persistence.entities.product;

import persistence.entities.Department;
import persistence.entities.Deposit;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({@NamedQuery(name = "SelectDrillByMark", query = "select drill from Drill drill where drill.mark=:mark"),
@NamedQuery(name = "UpdateDrillMark",query = "update from Drill set mark=:mark where name=:name"),
@NamedQuery(name = "DeleteDrillByMark",query = "delete from Drill where name=:name")})

@Entity
@Table(name = "drills")
public class Drill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "name")
    private String name;
    @JoinColumn(name = "mark")
    private String mark;
    @JoinColumn(name = "battery")
    private boolean battery;
    @JoinColumn(name = "price")
    private int price;
    @JoinColumn(name = "stock")
    private int stock;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "departments_id")
    private Department department;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "drills_deposits", joinColumns = {@JoinColumn(name = "drills_id")}, inverseJoinColumns = {@JoinColumn(name = "deposits_id")})
    private Set<Deposit> depositSet;

    public Drill() {
    }

    public Drill(String name, String mark, boolean battery, int price, int stock) {
        this.name = name;
        this.mark = mark;
        this.battery = battery;
        this.price = price;
        this.stock = stock;
    }

    public Drill(String name, String mark, boolean battery, int price, int stock, Department department, Set<Deposit> depositSet) {
        this.name = name;
        this.mark = mark;
        this.battery = battery;
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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public boolean isBattery() {
        return battery;
    }

    public void setBattery(boolean battery) {
        this.battery = battery;
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
        return "Drill{" +
                "name='" + name + '\'' +
                ", mark='" + mark + '\'' +
                ", battery=" + battery +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
