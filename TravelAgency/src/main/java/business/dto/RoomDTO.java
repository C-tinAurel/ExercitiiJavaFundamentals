package business.dto;

import persistence.entities.Hotel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class RoomDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([a-z-A-Z])*")
    private String type;
    @NotBlank
    @NotEmpty
    @NotNull
    @Pattern(regexp = "([0-9])*")
    private int numberAvailable;
    private boolean extraBed;
    private Set<HotelDTO> hotelDTOSetSet;

    public RoomDTO() {
    }

    public RoomDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") String type, @NotBlank @NotEmpty @NotNull @Pattern(regexp = "([0-9])*") int numberAvailable, boolean extraBed) {
        this.type = type;
        this.numberAvailable = numberAvailable;
        this.extraBed = extraBed;
    }

    public RoomDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") String type, @NotBlank @NotEmpty @NotNull @Pattern(regexp = "([0-9])*") int numberAvailable, boolean extraBed, Set<HotelDTO> hotelDTOSetSet) {
        this.type = type;
        this.numberAvailable = numberAvailable;
        this.extraBed = extraBed;
        this.hotelDTOSetSet = hotelDTOSetSet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberAvailable() {
        return numberAvailable;
    }

    public void setNumberAvailable(int numberAvailable) {
        this.numberAvailable = numberAvailable;
    }

    public boolean isExtraBed() {
        return extraBed;
    }

    public void setExtraBed(boolean extraBed) {
        this.extraBed = extraBed;
    }

    public Set<HotelDTO> getHotelDTOSetSet() {
        return hotelDTOSetSet;
    }

    public void setHotelDTOSetSet(Set<HotelDTO> hotelDTOSetSet) {
        this.hotelDTOSetSet = hotelDTOSetSet;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "type='" + type + '\'' +
                ", numberAvailable=" + numberAvailable +
                ", extraBed=" + extraBed +
                '}';
    }
}
