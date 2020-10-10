package business.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class CementDTO {
    @NotEmpty
    @NotBlank
    @NotNull
    @Pattern(regexp = "([a-zA-Z])*")
    private String name;
    @NotEmpty
    @NotBlank
    @NotNull
    @Pattern(regexp = "([a-zA-Z])*")
    private String granulation;
    private int price;
    private int stock;
    private DepartmentDTO departmentDTO;
    private Set<DepositDTO> depositDTOSet;

    public CementDTO() {
    }

    public CementDTO(@NotEmpty @NotBlank @NotNull @Pattern(regexp = "([a-zA-Z])*") String name, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([a-zA-Z])*") String granulation, int price, int stock) {
        this.name = name;
        this.granulation = granulation;
        this.price = price;
        this.stock = stock;
    }

    public CementDTO(@NotEmpty @NotBlank @NotNull @Pattern(regexp = "([a-zA-Z])*") String name, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([a-zA-Z])*") String granulation, int price, int stock, DepartmentDTO departmentDTO, Set<DepositDTO> depositDTOSet) {
        this.name = name;
        this.granulation = granulation;
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

    public String getGranulation() {
        return granulation;
    }

    public void setGranulation(String granulation) {
        this.granulation = granulation;
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
        return "CementDTO{" +
                "name='" + name + '\'' +
                ", granulation='" + granulation + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
