package persistence.entities;

import javax.persistence.*;

 @NamedQueries({@NamedQuery(name = "selectUserName", query = "select user from User user where userName=:userName"),
        @NamedQuery(name = "selectUserEmail", query = "select user from User user where email=:email"),
        @NamedQuery(name = "updateUserName", query = "update User set userName=:userName where email=:email"),
        @NamedQuery(name = "deleteUserName", query = "delete User where userName=:userName")})
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "logged_in")
    private boolean loggedIn;
    @Column(name = "admin_role")
    private boolean adminRole;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clients_id")
    private Client client;

    public User() {
    }

    public User(String userName, String email, String password, boolean loggedIn, boolean adminRole) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.loggedIn = loggedIn;
        this.adminRole = adminRole;
    }

    public User(String userName, String email, String password, boolean loggedIn, boolean adminRole, Client client) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.loggedIn = loggedIn;
        this.adminRole = adminRole;
        this.client = client;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isAdminRole() {
        return adminRole;
    }

    public void setAdminRole(boolean adminRole) {
        this.adminRole = adminRole;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", loggedIn=" + loggedIn +
                ", adminRole=" + adminRole +
                '}';
    }
}
