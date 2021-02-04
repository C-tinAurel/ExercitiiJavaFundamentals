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
    private Set<TripDTO> tripDTOSet;
    private Set<FlightDTO> flightDTOSet;

    public AirportDTO() {
    }

    public AirportDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") String name) {
        this.name = name;
    }


    public AirportDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") String name, @NotNull CityDTO cityDTO, Set<TripDTO> tripDTOSet, Set<FlightDTO> flightDTOSet) {
        this.name = name;
        this.cityDTO = cityDTO;
        this.tripDTOSet = tripDTOSet;
        this.flightDTOSet = flightDTOSet;
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

    public Set<TripDTO> getTripDTOSet() {
        return tripDTOSet;
    }

    public void setTripDTOSet(Set<TripDTO> tripDTOSet) {
        this.tripDTOSet = tripDTOSet;
    }

    public Set<FlightDTO> getFlightDTOSet() {
        return flightDTOSet;
    }

    public void setFlightDTOSet(Set<FlightDTO> flightDTOSet) {
        this.flightDTOSet = flightDTOSet;
    }

    @Override
    public String toString() {
        return "AirportDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
