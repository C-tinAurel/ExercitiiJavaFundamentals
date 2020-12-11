package business.dto;

import persistence.entities.Airport;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class FlightDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    private String flightNumber;
    @NotEmpty
    @NotNull
    @NotBlank
    private String flightDataAndTimeDeparture;
    private String flightDataAndTimeArriving;
    @NotNull
    private double price;
    @NotNull
    private int availableSeat;
    private AirportDTO airportDTODeparture;
    private AirportDTO airportDTOArriving;

    public FlightDTO() {
    }

    public FlightDTO(@NotNull @NotEmpty @NotBlank String flightNumber, @NotEmpty @NotNull @NotBlank String flightDataAndTimeDeparture, String flightDataAndTimeArriving, @NotNull double price, @NotNull int availableSeat) {
        this.flightNumber = flightNumber;
        this.flightDataAndTimeDeparture = flightDataAndTimeDeparture;
        this.flightDataAndTimeArriving = flightDataAndTimeArriving;
        this.price = price;
        this.availableSeat = availableSeat;
    }

    public FlightDTO(@NotNull @NotEmpty @NotBlank String flightNumber, @NotEmpty @NotNull @NotBlank String flightDataAndTimeDeparture, String flightDataAndTimeArriving, @NotNull double price, @NotNull int availableSeat, @NotNull AirportDTO airportDTODeparture, AirportDTO airportDTOArriving) {
        this.flightNumber = flightNumber;
        this.flightDataAndTimeDeparture = flightDataAndTimeDeparture;
        this.flightDataAndTimeArriving = flightDataAndTimeArriving;
        this.price = price;
        this.availableSeat = availableSeat;
        this.airportDTODeparture = airportDTODeparture;
        this.airportDTOArriving = airportDTOArriving;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public AirportDTO getAirportDTODeparture() {
        return airportDTODeparture;
    }

    public void setAirportDTODeparture(AirportDTO airportDTODeparture) {
        this.airportDTODeparture = airportDTODeparture;
    }

    public AirportDTO getAirportDTOArriving() {
        return airportDTOArriving;
    }

    public void setAirportDTOArriving(AirportDTO airportDTOArriving) {
        this.airportDTOArriving = airportDTOArriving;
    }

    public String getFlightDataAndTimeDeparture() {
        return flightDataAndTimeDeparture;
    }

    public void setFlightDataAndTimeDeparture(String flightDataAndTimeDeparture) {
        this.flightDataAndTimeDeparture = flightDataAndTimeDeparture;
    }

    public String getFlightDataAndTimeArriving() {
        return flightDataAndTimeArriving;
    }

    public void setFlightDataAndTimeArriving(String flightDataAndTimeArriving) {
        this.flightDataAndTimeArriving = flightDataAndTimeArriving;
    }

    @Override
    public String toString() {
        return "FlightDTO{" +
                "flightNumber='" + flightNumber + '\'' +
                ", flightDataAndTimeDeparture='" + flightDataAndTimeDeparture + '\'' +
                ", flightDataAndTimeArriving='" + flightDataAndTimeArriving + '\'' +
                ", price=" + price +
                ", availableSeat=" + availableSeat +
                '}';
    }
}
