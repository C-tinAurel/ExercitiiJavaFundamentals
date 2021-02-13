package persistence.entities;


import persistence.entities.product.Cement;
import persistence.entities.product.Drill;
import persistence.entities.product.Paint;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "departments")
@NamedQueries({@NamedQuery(name = "findDepartmentByName", query = "select department from Department department where department.name=:name"),
        @NamedQuery(name = "DeleteDepartmentByName", query = "delete Department where name=:name")}
)

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private Set<Employee> employeeSet;
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private Set<Cement> cements;
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private Set<Drill> drills;
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private Set<Paint> paints;
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Valve> valves;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public Department(String name, Set<Employee> employeeSet) {
        this.name = name;
        this.employeeSet = employeeSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Set<Drill> getDrills() {
        return drills;
    }

    public void setDrills(Set<Drill> drills) {
        this.drills = drills;
    }

    public Set<Paint> getPaints() {
        return paints;
    }

    public void setPaints(Set<Paint> paints) {
        this.paints = paints;
    }

    public Set<Valve> getValves() {
        return valves;
    }

    public void setValves(Set<Valve> valves) {
        this.valves = valves;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}
