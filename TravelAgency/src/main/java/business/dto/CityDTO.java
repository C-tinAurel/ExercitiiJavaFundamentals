package business.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class CityDTO {
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([a-z-A-Z])*")
    @NotNull
    private String name;
    @NotNull
    private CountryDTO countryDTO;
    private Set<AirportDTO> airportDTOSetSet;
    private Set<HotelDTO> hotelDTOSetSet;

    public CityDTO() {
    }

    public CityDTO(@NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") @NotNull String name) {
        this.name = name;
    }

    public CityDTO(@NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") @NotNull String name, @NotNull CountryDTO countryDTO, @NotNull Set<AirportDTO> airportDTOSetSet, @NotNull Set<HotelDTO> hotelDTOSetSet) {
        this.name = name;
        this.countryDTO = countryDTO;
        this.airportDTOSetSet = airportDTOSetSet;
        this.hotelDTOSetSet = hotelDTOSetSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryDTO getCountryDTO() {
        return countryDTO;
    }

    public void setCountryDTO(CountryDTO countryDTO) {
        this.countryDTO = countryDTO;
    }

    public Set<AirportDTO> getAirportDTOSetSet() {
        return airportDTOSetSet;
    }

    public void setAirportDTOSetSet(Set<AirportDTO> airportDTOSetSet) {
        this.airportDTOSetSet = airportDTOSetSet;
    }

    public Set<HotelDTO> getHotelDTOSetSet() {
        return hotelDTOSetSet;
    }

    public void setHotelDTOSetSet(Set<HotelDTO> hotelDTOSetSet) {
        this.hotelDTOSetSet = hotelDTOSetSet;
    }

    @Override
    public String toString() {
        return "CityDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
