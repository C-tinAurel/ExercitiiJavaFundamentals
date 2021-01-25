package business.dto;

import persistence.entities.Trip;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class AirportDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([a-z-A-Z])*")
    private String name;
    @NotNull
    private CityDTO cityDTO;
    private Set<TripDTO> tripDepartureDTOSet;
    private Set<TripDTO> tripArrivingDTOSet;
    private Set<FlightDTO> flightDTODepartureSet;
    private Set<FlightDTO> flightDTOArrivingSet;

    public AirportDTO() {
    }

    public AirportDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") String name) {
        this.name = name;
    }

    public AirportDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") String name, @NotNull CityDTO cityDTO, Set<TripDTO> tripDepartureDTOSet, Set<TripDTO> tripArrivingDTOSet) {
        this.name = name;
        this.cityDTO = cityDTO;
        this.tripDepartureDTOSet = tripDepartureDTOSet;
        this.tripArrivingDTOSet = tripArrivingDTOSet;
    }

    public AirportDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") String name, @NotNull CityDTO cityDTO, Set<TripDTO> tripDepartureDTOSet, Set<TripDTO> tripArrivingDTOSet, Set<FlightDTO> flightDTODepartureSet, Set<FlightDTO> flightDTOArrivingSet) {
        this.name = name;
        this.cityDTO = cityDTO;
        this.tripDepartureDTOSet = tripDepartureDTOSet;
        this.tripArrivingDTOSet = tripArrivingDTOSet;
        this.flightDTODepartureSet = flightDTODepartureSet;
        this.flightDTOArrivingSet = flightDTOArrivingSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityDTO getCityDTO() {
        return cityDTO;
    }

    public void setCityDTO(CityDTO cityDTO) {
        this.cityDTO = cityDTO;
    }

    public Set<TripDTO> getTripDepartureDTOSet() {
        return tripDepartureDTOSet;
    }

    public void setTripDepartureDTOSet(Set<TripDTO> tripDepartureDTOSet) {
        this.tripDepartureDTOSet = tripDepartureDTOSet;
    }

    public Set<TripDTO> getTripArrivingDTOSet() {
        return tripArrivingDTOSet;
    }

    public void setTripArrivingDTOSet(Set<TripDTO> tripArrivingDTOSet) {
        this.tripArrivingDTOSet = tripArrivingDTOSet;
    }

    public Set<FlightDTO> getFlightDTODepartureSet() {
        return flightDTODepartureSet;
    }

    public void setFlightDTODepartureSet(Set<FlightDTO> flightDTODepartureSet) {
        this.flightDTODepartureSet = flightDTODepartureSet;
    }

    public Set<FlightDTO> getFlightDTOArrivingSet() {
        return flightDTOArrivingSet;
    }

    public void setFlightDTOArrivingSet(Set<FlightDTO> flightDTOArrivingSet) {
        this.flightDTOArrivingSet = flightDTOArrivingSet;
    }

    @Override
    public String toString() {
        return "AirportDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
