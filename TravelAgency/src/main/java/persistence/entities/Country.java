package persistence.entities;

import javax.persistence.*;
import java.util.Set;

 @NamedQueries({@NamedQuery(name = "selectCountry", query = "select country from Country country  where name=:name")})

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "continents_id")
    private Continent continent;
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<City> citySet;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public Country(String name, Continent continent, Set<City> citySet) {
        this.name = name;
        this.continent = continent;
        this.citySet = citySet;
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

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public Set<City> getCitySet() {
        return citySet;
    }

    public void setCitySet(Set<City> citySet) {
        this.citySet = citySet;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }
}
