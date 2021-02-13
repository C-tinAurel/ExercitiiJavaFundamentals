package business.dto;

import javax.validation.constraints.*;

public class UserRegistrationDTO {
    @NotNull
    @NotEmpty(message = "name field cannot be empty")
    @NotBlank(message = "name field cannot be blank")
    @Pattern(regexp = "([a-zA-Z])*")
    private String name;
    @NotEmpty(message = "surname field cannot be empty")
    @NotBlank(message = "surname field cannot be blank")
    @NotBlank
    @Pattern(regexp = "([a-zA-Z])*")
    private String surname;
    private String phoneNumber;
    @NotNull
    @Email
    @Pattern(regexp=".+@.+\\.[a-z]+")
    @NotBlank(message = "email field cannot be blank")
    @NotEmpty(message = "email field cannot be empty")
    private String email;
    @Size(min = 8)
    private String password;
    private String orderNumber;

    public UserRegistrationDTO() {
    }

    public UserRegistrationDTO(@NotNull @NotEmpty(message = "name field cannot be empty") @NotBlank(message = "name field cannot be blank") @Pattern(regexp = "([a-zA-Z])*") String name, @NotEmpty(message = "surname field cannot be empty") @NotBlank(message = "surname field cannot be blank") @NotBlank @Pattern(regexp = "([a-zA-Z])*") String surname, String phoneNumber, @NotNull @Pattern(regexp = ".+@.+\\.[a-z]+") @NotBlank(message = "email field cannot be blank") @NotEmpty(message = "email field cannot be empty") String email, @Size(min = 8) String password, String orderNumber) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
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

    public String getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return "UserRegistrationDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
