package business.dto;
import persistence.entities.City;
import persistence.entities.Continent;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class CountryDTO {
    @NotNull
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "([a-z-A-Z])*")
    private String name;
    @NotNull
    private ContinentDTO continentDTO;
    private Set<CityDTO> cityDTOSet;

    public CountryDTO() {
    }

    public CountryDTO(@NotNull @NotBlank @NotEmpty @Pattern(regexp = "([a-z-A-Z])*") String name) {
        this.name = name;
    }

    public CountryDTO(@NotNull @NotBlank @NotEmpty @Pattern(regexp = "([a-z-A-Z])*") String name, @NotNull ContinentDTO continentDTO, Set<CityDTO> cityDTOSet) {
        this.name = name;
        this.continentDTO = continentDTO;
        this.cityDTOSet = cityDTOSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContinentDTO getContinentDTO() {
        return continentDTO;
    }

    public void setContinentDTO(ContinentDTO continentDTO) {
        this.continentDTO = continentDTO;
    }

    public Set<CityDTO> getCityDTOSet() {
        return cityDTOSet;
    }

    public void setCityDTOSet(Set<CityDTO> cityDTOSet) {
        this.cityDTOSet = cityDTOSet;
    }

    @Override
    public String toString() {
        return "CountryDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
