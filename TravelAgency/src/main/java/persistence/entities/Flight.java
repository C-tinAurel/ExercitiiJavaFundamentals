package persistence.entities;
import javax.persistence.*;


@NamedQueries({@NamedQuery(name = "selectFlightsFromAirport", query = "select flight from Flight flight inner join flight.airport airport " +
        "where airport.name=:name "),
        @NamedQuery(name = "selectFlightByFlightNumber", query = "select flight from Flight flight where flightNumber=:flightNumber"),
})

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "flight_number")
    private String flightNumber;
    @Column(name = "flight_date_and_time_arriving")
    private String flightDataAndTimeArriving;
    @Column(name = "flight_date_and_time_departure")
    private String flightDataAndTimeDeparture;
    @Column(name = "price")
    private double price;
    @Column(name = "available_seats")
    private int availableSeat;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "airports_id")
    private Airport airport;

    public Flight() {
    }

    public Flight(String flightNumber, String flightDataAndTimeArriving, String flightDataAndTimeDeparture, double price, int availableSeat) {
        this.flightNumber = flightNumber;
        this.flightDataAndTimeArriving = flightDataAndTimeArriving;
        this.flightDataAndTimeDeparture = flightDataAndTimeDeparture;
        this.price = price;
        this.availableSeat = availableSeat;
    }

    public Flight(String flightNumber, String flightDataAndTimeArriving, String flightDataAndTimeDeparture, double price, int availableSeat, Airport airport) {
        this.flightNumber = flightNumber;
        this.flightDataAndTimeArriving = flightDataAndTimeArriving;
        this.flightDataAndTimeDeparture = flightDataAndTimeDeparture;
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

    public double getPrice() {
        return price;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public String getFlightDataAndTimeArriving() {
        return flightDataAndTimeArriving;
    }

    public void setFlightDataAndTimeArriving(String flightDataAndTimeArriving) {
        this.flightDataAndTimeArriving = flightDataAndTimeArriving;
    }

    public String getFlightDataAndTimeDeparture() {
        return flightDataAndTimeDeparture;
    }

    public void setFlightDataAndTimeDeparture(String flightDataAndTimeDeparture) {
        this.flightDataAndTimeDeparture = flightDataAndTimeDeparture;
    }

    public void setPrice(double price) {
        this.price = price;
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
                "flightNumber='" + flightNumber + '\'' +
                ", flightDataAndTimeArriving='" + flightDataAndTimeArriving + '\'' +
                ", flightDataAndTimeDeparture='" + flightDataAndTimeDeparture + '\'' +
                ", price=" + price +
                ", availableSeat=" + availableSeat +
                '}';
    }

}
