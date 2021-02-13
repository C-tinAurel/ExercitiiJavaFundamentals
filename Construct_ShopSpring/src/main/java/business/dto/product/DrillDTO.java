package business.dto.product;

import business.dto.DepartmentDTO;
import business.dto.DepositDTO;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class DrillDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;
    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([a-zA-Z])*")
    private String mark;
    private boolean battery;
    private int price;
    private int stock;
    private DepartmentDTO departmentDTO;
    private Set<DepositDTO> depositDTOSet;

    public DrillDTO() {
    }

    public DrillDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-zA-Z])*") String name, @NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-zA-Z])*") String mark, boolean battery, int price, int stock) {
        this.name = name;
        this.mark = mark;
        this.battery = battery;
        this.price = price;
        this.stock = stock;
    }

    public DrillDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-zA-Z])*") String name, @NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-zA-Z])*") String mark, boolean battery, int price, int stock, DepartmentDTO departmentDTO, Set<DepositDTO> depositDTOSet) {
        this.name = name;
        this.mark = mark;
        this.battery = battery;
        this.price = price;
        this.stock = stock;
        this.departmentDTO = departmentDTO;
        this.depositDTOSet = depositDTOSet;
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

    public DepartmentDTO getDepartmentDTO() {
        return departmentDTO;
    }

    public void setDepartmentDTO(DepartmentDTO departmentDTO) {
        this.departmentDTO = departmentDTO;
    }

    public Set<DepositDTO> getDepositDTOSet() {
        return depositDTOSet;
    }

    public void setDepositDTOSet(Set<DepositDTO> depositDTOSet) {
        this.depositDTOSet = depositDTOSet;
    }

    @Override
    public String toString() {
        return "DrillDTO{" +
                "name='" + name + '\'' +
                ", mark='" + mark + '\'' +
                ", battery=" + battery +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
