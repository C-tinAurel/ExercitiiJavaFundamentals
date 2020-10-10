package persistence.entities;

import jdk.jfr.Name;

import javax.persistence.*;
@NamedQueries({@NamedQuery(name="findDepartmentByName",query = "select department from Departement department where department.name=:name"),
@NamedQuery(name = "DeleteDepartmentByName",query = "delete Department where name=:name")}
)
@Entity
@Table(name = "departments")
public class Departament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    String name;

    public Departament() {
    }

    public Departament(String name) {
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
        return "Departament{" +
                "name='" + name + '\'' +
                '}';
    }
}
