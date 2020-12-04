package business.dto;

import persistence.entities.City;
import persistence.entities.Room;
import persistence.entities.Trip;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class HotelDTO {
    @NotNull
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "([a-z-A-Z])*")
    private String name;
    @NotEmpty
    @NotBlank
    @NotNull
    @Pattern(regexp = "([0-9])*")
    private int stars;
    @NotEmpty
    @NotBlank
    @NotNull
    @Pattern(regexp = "([a-z-A-Z-0-9])*")
    private String description;
    @NotNull
    private CityDTO cityDTO;
    @NotNull
    private Set<RoomDTO> roomDTOSetSet;
    @NotNull
    private Set<TripDTO> tripDTOSetSet;

    public HotelDTO() {
    }

    public HotelDTO(@NotNull @NotBlank @NotEmpty @Pattern(regexp = "([a-z-A-Z])*") String name, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([0-9])*") int stars, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([a-z-A-Z-0-9])*") String description) {
        this.name = name;
        this.stars = stars;
        this.description = description;
    }

    public HotelDTO(@NotNull @NotBlank @NotEmpty @Pattern(regexp = "([a-z-A-Z])*") String name, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([0-9])*") int stars, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([a-z-A-Z-0-9])*") String description, @NotNull CityDTO cityDTO, @NotNull Set<RoomDTO> roomDTOSetSet, @NotNull Set<TripDTO> tripDTOSetSet) {
        this.name = name;
        this.stars = stars;
        this.description = description;
        this.cityDTO = cityDTO;
        this.roomDTOSetSet = roomDTOSetSet;
        this.tripDTOSetSet = tripDTOSetSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CityDTO getCityDTO() {
        return cityDTO;
    }

    public void setCityDTO(CityDTO cityDTO) {
        this.cityDTO = cityDTO;
    }

    public Set<RoomDTO> getRoomDTOSetSet() {
        return roomDTOSetSet;
    }

    public void setRoomDTOSetSet(Set<RoomDTO> roomDTOSetSet) {
        this.roomDTOSetSet = roomDTOSetSet;
    }

    public Set<TripDTO> getTripDTOSetSet() {
        return tripDTOSetSet;
    }

    public void setTripDTOSetSet(Set<TripDTO> tripDTOSetSet) {
        this.tripDTOSetSet = tripDTOSetSet;
    }

    @Override
    public String toString() {
        return "HotelDTO{" +
                "name='" + name + '\'' +
                ", stars=" + stars +
                ", description='" + description + '\'' +
                '}';
    }
}
