package business.dto;

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
    @NotBlank
    @NotEmpty
    @NotNull
    private String address;
    @NotNull
    private int stars;
    @NotNull
    private String description;
    @NotNull
    private CityDTO cityDTO;

    private Set<RoomDTO> roomDTOSetSet;

    private Set<TripDTO> tripDTOSetSet;

    public HotelDTO() {
    }

    public HotelDTO(@NotNull @NotBlank @NotEmpty @Pattern(regexp = "([a-z-A-Z])*") String name, @NotBlank @NotEmpty @NotNull String address, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([0-9])*") int stars, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([a-z-A-Z-0-9])*") String description) {
        this.name = name;
        this.address = address;
        this.stars = stars;
        this.description = description;
    }

    public HotelDTO(@NotNull @NotBlank @NotEmpty @Pattern(regexp = "([a-z-A-Z])*") String name, @NotBlank @NotEmpty @NotNull String address, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([0-9])*") int stars, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([a-z-A-Z-0-9])*") String description, @NotNull CityDTO cityDTO, @NotNull Set<RoomDTO> roomDTOSetSet, @NotNull Set<TripDTO> tripDTOSetSet) {
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTripDTOSetSet(Set<TripDTO> tripDTOSetSet) {
        this.tripDTOSetSet = tripDTOSetSet;
    }

    @Override
    public String toString() {
        return "HotelDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", stars=" + stars +
                ", description='" + description + '\'' +
                '}';
    }
}
