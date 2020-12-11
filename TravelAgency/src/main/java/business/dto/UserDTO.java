package business.dto;


import org.hibernate.validator.constraints.UniqueElements;
import persistence.entities.Client;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserDTO {
    @NotEmpty
    @NotBlank
    @NotNull
    @UniqueElements
    @Pattern(regexp = "([a-z-A-Z])*")
    private String userName;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private boolean loggedIn;
    private boolean adminRole;
    @NotNull
    private ClientDTO clientDTO;

    public UserDTO() {
    }

    public UserDTO(@NotEmpty @NotBlank @NotNull @UniqueElements @Pattern(regexp = "([a-z-A-Z])*") String userName, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([a-z-A-Z])*") String email, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([a-z-A-Z-0-9])*") String password, @NotNull boolean loggedIn, boolean adminRole) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.loggedIn = loggedIn;
        this.adminRole = adminRole;
    }

    public UserDTO(@NotEmpty @NotBlank @NotNull @UniqueElements @Pattern(regexp = "([a-z-A-Z])*") String userName, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([a-z-A-Z])*") String email, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([a-z-A-Z-0-9])*") String password, @NotNull boolean loggedIn, boolean adminRole, @NotNull ClientDTO clientDTO) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.loggedIn = loggedIn;
        this.adminRole = adminRole;
        this.clientDTO = clientDTO;
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

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", loggedIn=" + loggedIn +
                ", adminRole=" + adminRole +
                '}';
    }
}
