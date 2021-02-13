package persistence.entities.product;

import persistence.entities.Department;
import persistence.entities.Deposit;

import javax.persistence.*;
import java.util.Set;
@NamedQueries({@NamedQuery(name = "SelectPaintByColor",query = "select paint from Paint paint where color=:color"),
@NamedQuery(name = "UpdatePaintByMark",query = "update Paint set mark=:mark where name=:name"),
@NamedQuery(name="DeletePaintColor",query = "delete from Paint where color=:color")})
@Entity
@Table(name = "paints")
public class Paint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "name")
    private String name;
    @JoinColumn(name="mark")
    private String mark;
    @JoinColumn(name = "color")
    private String color;
    @JoinColumn(name="price")
    private int price;
    @JoinColumn(name="stock")
    private int stock;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "departments_id")
    private Department department;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "paints_deposits",joinColumns = {@JoinColumn(name="paints_id")},inverseJoinColumns = {@JoinColumn(name = "deposits_id")})
    private Set<Deposit> depositSet;

    public Paint() {
    }

    public Paint(String name, String mark, String color, int price, int stock) {
        this.name = name;
        this.mark = mark;
        this.color = color;
        this.price = price;
        this.stock = stock;
    }

    public Paint(String name, String mark, String color, int price, int stock, Department department, Set<Deposit> depositSet) {
        this.name = name;
        this.mark = mark;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        return "Paint{" +
                "name='" + name + '\'' +
                ", mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
