package business.dto;

import persistence.entities.Purchase;
import persistence.entities.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class ClientDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([a-z-A-Z])*")
    private String name;
    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([a-z-A-Z])*")
    private String surname;
    @NotNull
    private int yearOfBirth;
    @NotNull
    private String address;
    @NotNull
    private int phoneNumber;
    @NotNull
    private UserDTO userDTO;
    private Set<PurchaseDTO> purchaseDTOSetSet;

    public ClientDTO() {
    }

    public ClientDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") String name, @NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") String surname, @NotNull @NotEmpty @NotBlank @Pattern(regexp = "(0-9])*") int yearOfBirth, @NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z-0-9])*") String address, @NotNull @NotEmpty @NotBlank @Pattern(regexp = "(0-9])*") int phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public ClientDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") String name, @NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") String surname, @NotNull @NotEmpty @NotBlank @Pattern(regexp = "(0-9])*") int yearOfBirth, @NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z-0-9])*") String address, @NotNull @NotEmpty @NotBlank @Pattern(regexp = "(0-9])*") int phoneNumber, @NotNull UserDTO userDTO, @NotNull Set<PurchaseDTO> purchaseDTOSetSet) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userDTO = userDTO;
        this.purchaseDTOSetSet = purchaseDTOSetSet;
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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public Set<PurchaseDTO> getPurchaseDTOSetSet() {
        return purchaseDTOSetSet;
    }

    public void setPurchaseDTOSetSet(Set<PurchaseDTO> purchaseDTOSetSet) {
        this.purchaseDTOSetSet = purchaseDTOSetSet;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
