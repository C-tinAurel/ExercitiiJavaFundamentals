package persistence.entities;
import javax.persistence.*;
import java.util.Set;

@NamedQueries({@NamedQuery(name = "selectContinent",query = "select continent from Continent continent where name=:name")})

@Entity
@Table(name = "continents")
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "continent",cascade = CascadeType.ALL)
    private Set<Country> countrySet;

    public Continent() {
    }

    public Continent(String name) {
        this.name = name;
    }

    public Continent(String name, Set<Country> countrySet) {
        this.name = name;
        this.countrySet = countrySet;
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

    public Set<Country> getCountrySet() {
        return countrySet;
    }

    public void setCountrySet(Set<Country> countrySet) {
        this.countrySet = countrySet;
    }

    @Override
    public String toString() {
        return "Continent{" +
                "name='" + name + '\'' +
                '}';
    }
}
