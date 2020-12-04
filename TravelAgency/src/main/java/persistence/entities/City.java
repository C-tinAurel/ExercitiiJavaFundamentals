package persistence.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({@NamedQuery(name = "selectCity", query = "select city from City city where name=:name"),
        @NamedQuery(name = "deleteCity", query = "delete from City where name=:name")})

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "countries_id")
    private Country country;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private Set<Airport> airportSet;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private Set<Hotel> hotelSet;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    public City(String name, Country country, Set<Airport> airportSet, Set<Hotel> hotelSet) {
        this.name = name;
        this.country = country;
        this.airportSet = airportSet;
        this.hotelSet = hotelSet;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Airport> getAirportSet() {
        return airportSet;
    }

    public void setAirportSet(Set<Airport> airportSet) {
        this.airportSet = airportSet;
    }

    public Set<Hotel> getHotelSet() {
        return hotelSet;
    }

    public void setHotelSet(Set<Hotel> hotelSet) {
        this.hotelSet = hotelSet;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                '}';
    }
}
