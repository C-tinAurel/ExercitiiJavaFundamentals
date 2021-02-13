package business.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DepositDTO {
    @NotNull
    @NotEmpty(message = "city field can't be empty")
    @NotBlank(message = "city field can't be blank")
    @Pattern(regexp = "([a-zA-Z])*")
    private String city;
    @NotBlank(message = "address field can't be blank")
    @NotEmpty(message = "address field can't be empty")
    @NotNull
    private String address;

    public DepositDTO() {
    }

    public DepositDTO(@NotNull @NotEmpty(message = "city field can't be empty") @NotBlank(message = "city field can't be blank") @Pattern(regexp = "([a-zA-Z])*") String city, @NotBlank(message = "address field cant't be blank") @NotEmpty(message = "address field can't be empty") @NotNull String address) {
        this.city = city;
        this.address = address;
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

    @Override
    public String toString() {
        return "DepositDTO{" +
                "city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
