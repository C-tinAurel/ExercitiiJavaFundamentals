package business.dto;




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
    private Set<TripDTO> tripDTOSetSet;

    public AirportDTO() {
    }

    public AirportDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") String name) {
        this.name = name;
    }

    public AirportDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") String name, @NotNull CityDTO cityDTO, @NotNull Set<TripDTO> tripDTOSetSet) {
        this.name = name;
        this.cityDTO = cityDTO;
        this.tripDTOSetSet = tripDTOSetSet;
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

    public Set<TripDTO> getTripDTOSetSet() {
        return tripDTOSetSet;
    }

    public void setTripDTOSetSet(Set<TripDTO> tripDTOSetSet) {
        this.tripDTOSetSet = tripDTOSetSet;
    }

    @Override
    public String toString() {
        return "AirportDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
