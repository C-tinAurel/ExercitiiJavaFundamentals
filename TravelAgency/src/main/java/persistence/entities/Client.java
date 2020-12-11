package persistence.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({@NamedQuery(name = "selectClient", query = "select client from Client client where name=:name and surname=:surname"),
        @NamedQuery(name = "updateAddress", query = "update Client set address=:address where name=:name and surname=:surname"),
        @NamedQuery(name = "updatePhoneNumber", query = "update Client set phoneNumber=:phoneNumber where name=:name and surname=:surname"),
        @NamedQuery(name = "deleteClient", query = "delete from Client where name=:name and surname=:surname")})

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "year_of_birth")
    private int yearOfBirth;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private int phoneNumber;
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private User user;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "clients_purchases", joinColumns = {@JoinColumn(name = "client_id")},
            inverseJoinColumns = {@JoinColumn(name = "purchase_id")})
    private Set<Purchase> purchaseSet;

    public Client() {
    }

    public Client(String name, String surname, int yearOfBirth, String address, int phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Client(String name, String surname, int yearOfBirth, String address, int phoneNumber, User user, Set<Purchase> purchaseSet) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.user = user;
        this.purchaseSet = purchaseSet;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Purchase> getPurchaseSet() {
        return purchaseSet;
    }

    public void setPurchaseSet(Set<Purchase> purchaseSet) {
        this.purchaseSet = purchaseSet;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
