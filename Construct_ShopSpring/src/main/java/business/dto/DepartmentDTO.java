package business.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DepartmentDTO {
   @NotBlank(message = "name field can't be blank ")
    @NotEmpty(message = "name field can't be empty")
    @Pattern(regexp = "([a-z-A-Z])*")
    @NotNull
    String name;

    public DepartmentDTO() {
    }

    public DepartmentDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
