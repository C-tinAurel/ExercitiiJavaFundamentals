package persistence.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({@NamedQuery(name = "selectAirport", query = "select airport from Airport airport where  name=:name"),
        @NamedQuery(name = "selectAirportByCity", query = "select airport from Airport airport inner join airport.city city where city.name=:name "),
        @NamedQuery(name = "updateAirportName", query = "update from Airport set name=:newName where name=:name")})

@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cities_id")
    private City city;
    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL)
    private Set<Trip> tripSet;
    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL)
    private Set<Flight> flightSet;

    public Airport() {
    }

    public Airport(String name) {
        this.name = name;
    }

    public Airport(String name, City city, Set<Trip> tripSet) {
        this.name = name;
        this.city = city;
        this.tripSet = tripSet;
    }

    public Airport(String name, City city, Set<Trip> tripSet, Set<Flight> flightSet) {
        this.name = name;
        this.city = city;
        this.tripSet = tripSet;
        this.flightSet = flightSet;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Trip> getTripSet() {
        return tripSet;
    }

    public void setTripSet(Set<Trip> tripSet) {
        this.tripSet = tripSet;
    }

    public Set<Flight> getFlightSet() {
        return flightSet;
    }

    public void setFlightSet(Set<Flight> flightSet) {
        this.flightSet = flightSet;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                '}';
    }
}
