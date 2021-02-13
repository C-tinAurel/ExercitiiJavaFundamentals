package persistence.entities;

import javax.persistence.*;

@NamedQueries({@NamedQuery(name = "SelectUserByName", query = "select userRegistration from UserRegistration userRegistration where userRegistration.name=:name"),
        @NamedQuery(name = "DeleteUserByEmail", query = "delete UserRegistration where email=:email"),
        @NamedQuery(name = "UpdatedUserSurname", query = "update UserRegistration set surname=:surname where name=:name")})

@Entity
@Table(name = "users_registration")
public class UserRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "orders_number")
    private String orderNumber;

    public UserRegistration() {
    }

    public UserRegistration(String name, String surname, String phoneNumber, String email, String password, String orderNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.orderNumber = orderNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "UserRegistration{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", orderNumber=" + orderNumber +
                '}';
    }
}
