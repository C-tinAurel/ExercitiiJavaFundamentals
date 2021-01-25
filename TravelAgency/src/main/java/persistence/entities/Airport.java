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
    @OneToMany(mappedBy = "airportDeparture")
    private Set<Trip> tripDepartureSet;
    @OneToMany(mappedBy = "airportArriving")
    private Set<Trip> tripArrivingSet;
    @OneToMany(mappedBy = "airportDeparture",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Flight> flightDepartureSet;
    @OneToMany(mappedBy = "airportArriving",cascade = CascadeType.ALL)
    private Set<Flight> flightArrivingSet;

    public Airport() {
    }

    public Airport(String name) {
        this.name = name;
    }

    public Airport(String name, City city, Set<Trip> tripDepartureSet, Set<Trip> tripArrivingSet) {
        this.name = name;
        this.city = city;
        this.tripDepartureSet = tripDepartureSet;
        this.tripArrivingSet = tripArrivingSet;
    }

    public Airport(String name, City city, Set<Trip> tripDepartureSet, Set<Trip> tripArrivingSet, Set<Flight> flightDepartureSet, Set<Flight> flightArrivingSet) {
        this.name = name;
        this.city = city;
        this.tripDepartureSet = tripDepartureSet;
        this.tripArrivingSet = tripArrivingSet;
        this.flightDepartureSet = flightDepartureSet;
        this.flightArrivingSet = flightArrivingSet;
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

    public Set<Trip> getTripDepartureSet() {
        return tripDepartureSet;
    }

    public void setTripDepartureSet(Set<Trip> tripDepartureSet) {
        this.tripDepartureSet = tripDepartureSet;
    }

    public Set<Trip> getTripArrivingSet() {
        return tripArrivingSet;
    }

    public void setTripArrivingSet(Set<Trip> tripArrivingSet) {
        this.tripArrivingSet = tripArrivingSet;
    }

    public Set<Flight> getFlightDepartureSet() {
        return flightDepartureSet;
    }

    public void setFlightDepartureSet(Set<Flight> flightDepartureSet) {
        this.flightDepartureSet = flightDepartureSet;
    }

    public Set<Flight> getFlightArrivingSet() {
        return flightArrivingSet;
    }

    public void setFlightArrivingSet(Set<Flight> flightArrivingSet) {
        this.flightArrivingSet = flightArrivingSet;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                '}';
    }
}
