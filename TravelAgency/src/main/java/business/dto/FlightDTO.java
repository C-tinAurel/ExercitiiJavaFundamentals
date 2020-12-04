package business.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class FlightDTO {
    @NotEmpty
    @NotNull
    @NotBlank
    @Pattern(regexp = "([0-9])*")
    private String flightData;
    @NotBlank
    @NotNull
    @NotEmpty
    private String flightHour;
    @NotEmpty
    @NotBlank
    @NotNull
    @Pattern(regexp = "([a-z-A-Z])*")
    private String flightTo;
    @NotBlank
    @NotEmpty
    @NotNull
    @Pattern(regexp = "([0-9])*")
    private double price;
    @NotEmpty
    @NotBlank
    @NotNull
    @Pattern(regexp = "([0-9])*")
    private int availableSeat;
    @NotNull
    private AirportDTO airportDTO;

    public FlightDTO() {
    }

    public FlightDTO(@NotEmpty @NotNull @NotBlank @Pattern(regexp = "([0-9])*") String flightData, @NotBlank @NotNull @NotEmpty String flightHour, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([a-z-A-Z])*") String flightTo, @NotBlank @NotEmpty @NotNull @Pattern(regexp = "([0-9])*") double price, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([0-9])*") int availableSeat) {
        this.flightData = flightData;
        this.flightHour = flightHour;
        this.flightTo = flightTo;
        this.price = price;
        this.availableSeat = availableSeat;
    }

    public FlightDTO(@NotEmpty @NotNull @NotBlank @Pattern(regexp = "([0-9])*") String flightData, @NotBlank @NotNull @NotEmpty String flightHour, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([a-z-A-Z])*") String flightTo, @NotBlank @NotEmpty @NotNull @Pattern(regexp = "([0-9])*") double price, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([0-9])*") int availableSeat, @NotNull AirportDTO airportDTO) {
        this.flightData = flightData;
        this.flightHour = flightHour;
        this.flightTo = flightTo;
        this.price = price;
        this.availableSeat = availableSeat;
        this.airportDTO = airportDTO;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public AirportDTO getAirportDTO() {
        return airportDTO;
    }

    public void setAirportDTO(AirportDTO airportDTO) {
        this.airportDTO = airportDTO;
    }

    @Override
    public String toString() {
        return "FlightDTO{" +
                "flightData=" + flightData +
                ", flightHour=" + flightHour +
                ", flightTo='" + flightTo + '\'' +
                ", price=" + price +
                ", availableSeat=" + availableSeat +
                '}';
    }
}
