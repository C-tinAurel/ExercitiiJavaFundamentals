package persistence.entities;

import business.dto.AirportDTO;

import javax.persistence.*;


 @NamedQueries({@NamedQuery(name = "selectFlightsFromAirport", query = "select flight from Flight flight inner join flight.airportDeparture airport " +
        "where airport.name=:name "),
         @NamedQuery(name = "selectFlightByFlightNumber",query = "select flight from Flight flight where flightNumber=:flightNumber"),
//        @NamedQuery(name = "updateFlightPrice", query = "update Flight set price=:price where airportDeparture=:airportDeparture")
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airports_arriving")
    private Airport airportArriving;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airports_departure")
    private Airport airportDeparture;

    public Flight() {
    }

     public Flight(String flightNumber, String flightDataAndTimeArriving, String flightDataAndTimeDeparture, double price, int availableSeat) {
         this.flightNumber = flightNumber;
         this.flightDataAndTimeArriving = flightDataAndTimeArriving;
         this.flightDataAndTimeDeparture = flightDataAndTimeDeparture;
         this.price = price;
         this.availableSeat = availableSeat;
     }

     public Flight(String flightNumber, String flightDataAndTimeArriving, String flightDataAndTimeDeparture, double price, int availableSeat, Airport airportArriving, Airport airportDeparture) {
         this.flightNumber = flightNumber;
         this.flightDataAndTimeArriving = flightDataAndTimeArriving;
         this.flightDataAndTimeDeparture = flightDataAndTimeDeparture;
         this.price = price;
         this.availableSeat = availableSeat;
         this.airportArriving = airportArriving;
         this.airportDeparture = airportDeparture;
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

     public Airport getAirportArriving() {
         return airportArriving;
     }

     public void setAirportArriving(Airport airportArriving) {
         this.airportArriving = airportArriving;
     }

     public Airport getAirportDeparture() {
         return airportDeparture;
     }

     public void setAirportDeparture(Airport airportDeparture) {
         this.airportDeparture = airportDeparture;
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
