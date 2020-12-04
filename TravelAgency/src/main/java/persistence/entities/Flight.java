package persistence.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

 /*@NamedQueries({@NamedQuery(name = "selectAllFlightsFromAirport", query = "select flight from Flight flight inner join flight.airport airport " +
        "where airport.name=:name "),
        @NamedQuery(name = "updateFlightHour", query = "update Flight set flightHour=:flightHour where flightTo=:flightTo"),
        @NamedQuery(name = "updateFlightData", query = "update Flight set flightData=:flightData where flightTo=:flightTo"),
        @NamedQuery(name = "updateFlightPrice", query = "update Flight set price=:price where flightTo=:flightTo"),
        @NamedQuery(name = "deleteFlight",query = "delete Flight where flightTo=:flightTo")})*/

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "flight_date")
    private String flightData;
    @Column(name = "flight_hour")
    private String flightHour;
    @Column(name = "flight_to")
    private String flightTo;
    @Column(name = "price")
    private double price;
    @Column(name = "available_seats")
    private int availableSeat;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airports_id")
    private Airport airport;

    public Flight() {
    }

    public Flight(String flightData, String flightHour, String flightTo, double price) {
        this.flightData = flightData;
        this.flightHour = flightHour;
        this.flightTo = flightTo;
        this.price = price;
    }

    public Flight(String flightData, String flightHour, String flightTo, double price, int availableSeat, Airport airport) {
        this.flightData = flightData;
        this.flightHour = flightHour;
        this.flightTo = flightTo;
        this.price = price;
        this.availableSeat = availableSeat;
        this.airport = airport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightData() {
        return flightData;
    }

    public void setFlightData(String flightData) {
        this.flightData = flightData;
    }

    public String getFlightHour() {
        return flightHour;
    }

    public void setFlightHour(String flightHour) {
        this.flightHour = flightHour;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightData=" + flightData +
                ", flightHour=" + flightHour +
                ", flightTo='" + flightTo + '\'' +
                ", price=" + price +
                ", availableSeat=" + availableSeat +
                '}';
    }
}
