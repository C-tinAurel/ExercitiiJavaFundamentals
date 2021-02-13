package business.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EmployeeDTO {
    @NotNull
    @NotEmpty(message = "name field cannot be empty")
    @NotBlank(message = "name field cannot be blank")
    @Pattern(regexp = "([a-zA-Z])*")
    private String name;
    @NotBlank(message = "surname field cannot be blank")
    @NotEmpty(message = "surname field cannot be empty")
    @Pattern(regexp = "([a-zA-Z])*")
    @NotNull
    private String surname;

    private int age;
    private DepartmentDTO departmentDTO;
    private DepositDTO depositDTO;

    public EmployeeDTO() {
    }

    public EmployeeDTO(@NotNull @NotEmpty(message = "name field cannot be empty") @NotBlank(message = "name field cannot be blank") @Pattern(regexp = "([a-zA-Z])*") String name, @NotBlank(message = "surname field cannot be blank") @NotEmpty(message = "surname field cannot be empty") @Pattern(regexp = "([a-zA-Z])*") @NotNull String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public EmployeeDTO(@NotNull @NotEmpty(message = "name field cannot be empty") @NotBlank(message = "name field cannot be blank") @Pattern(regexp = "([a-zA-Z])*") String name, @NotBlank(message = "surname field cannot be blank") @NotEmpty(message = "surname field cannot be empty") @Pattern(regexp = "([a-zA-Z])*") @NotNull String surname, int age, DepartmentDTO departmentDTO, DepositDTO depositDTO) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.departmentDTO = departmentDTO;
        this.depositDTO = depositDTO;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DepartmentDTO getDepartmentDTO() {
        return departmentDTO;
    }

    public void setDepartmentDTO(DepartmentDTO departmentDTO) {
        this.departmentDTO = departmentDTO;
    }

    public DepositDTO getDepositDTO() {
        return depositDTO;
    }

    public void setDepositDTO(DepositDTO depositDTO) {
        this.depositDTO = depositDTO;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
