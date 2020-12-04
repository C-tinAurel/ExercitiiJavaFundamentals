package business.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class TripDTO {
    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([0-9])*")
    private String departureDate;
    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([0-9])*")
    private String returnData;
    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([0-9])*")
    private int numberDay;
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "([a-z-A-Z])*")
    private String mealType;
    @NotEmpty
    @NotBlank
    private double adultPrice;
    @NotEmpty
    @NotBlank
    private double kidPrice;
    private boolean promoted;
    @NotEmpty
    @NotBlank
    @NotNull
    @Pattern(regexp = "([0-9])*")
    private int adultNumber;
    @NotEmpty
    @NotBlank
    private int kidNumber;
    @NotEmpty
    @NotBlank
    @NotNull
    @Pattern(regexp = "([0-9])*")
    private int availableStock;
    @NotNull
    private AirportDTO airportDTO;
    @NotNull
    private HotelDTO hotelDTO;
    @NotNull
    private Set<PurchaseDTO> purchaseDTOSetSet;

    public TripDTO() {
    }

    public TripDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([0-9])*") String departureDate, @NotNull @NotEmpty @NotBlank @Pattern(regexp = "([0-9])*") String returnData, @NotNull @NotEmpty @NotBlank @Pattern(regexp = "([0-9])*") int numberDay, @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") String mealType, @NotEmpty @NotBlank double adultPrice, @NotEmpty @NotBlank double kidPrice, boolean promoted, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([0-9])*") int adultNumber, @NotEmpty @NotBlank int kidNumber, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([0-9])*") int availableStock) {
        this.departureDate = departureDate;
        this.returnData = returnData;
        this.numberDay = numberDay;
        this.mealType = mealType;
        this.adultPrice = adultPrice;
        this.kidPrice = kidPrice;
        this.promoted = promoted;
        this.adultNumber = adultNumber;
        this.kidNumber = kidNumber;
        this.availableStock = availableStock;
    }

    public TripDTO(@NotNull @NotEmpty @NotBlank @Pattern(regexp = "([0-9])*") String returnData, @NotNull @NotEmpty @NotBlank @Pattern(regexp = "([0-9])*") int numberDay, @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") String mealType, @NotEmpty @NotBlank double adultPrice, @NotEmpty @NotBlank double kidPrice, boolean promoted, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([0-9])*") int adultNumber, @NotEmpty @NotBlank int kidNumber, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([0-9])*") int availableStock, @NotNull AirportDTO airportDTO, @NotNull HotelDTO hotelDTO, @NotNull Set<PurchaseDTO> purchaseDTOSetSet) {
        this.returnData = returnData;
        this.numberDay = numberDay;
        this.mealType = mealType;
        this.adultPrice = adultPrice;
        this.kidPrice = kidPrice;
        this.promoted = promoted;
        this.adultNumber = adultNumber;
        this.kidNumber = kidNumber;
        this.availableStock = availableStock;
        this.airportDTO = airportDTO;
        this.hotelDTO = hotelDTO;
        this.purchaseDTOSetSet = purchaseDTOSetSet;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    public int getNumberDay() {
        return numberDay;
    }

    public void setNumberDay(int numberDay) {
        this.numberDay = numberDay;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(double adultPrice) {
        this.adultPrice = adultPrice;
    }

    public double getKidPrice() {
        return kidPrice;
    }

    public void setKidPrice(double kidPrice) {
        this.kidPrice = kidPrice;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public int getAdultNumber() {
        return adultNumber;
    }

    public void setAdultNumber(int adultNumber) {
        this.adultNumber = adultNumber;
    }

    public int getKidNumber() {
        return kidNumber;
    }

    public void setKidNumber(int kidNumber) {
        this.kidNumber = kidNumber;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

    public AirportDTO getAirportDTO() {
        return airportDTO;
    }

    public void setAirportDTO(AirportDTO airportDTO) {
        this.airportDTO = airportDTO;
    }

    public HotelDTO getHotelDTO() {
        return hotelDTO;
    }

    public void setHotelDTO(HotelDTO hotelDTO) {
        this.hotelDTO = hotelDTO;
    }

    public Set<PurchaseDTO> getPurchaseDTOSetSet() {
        return purchaseDTOSetSet;
    }

    public void setPurchaseDTOSetSet(Set<PurchaseDTO> purchaseDTOSetSet) {
        this.purchaseDTOSetSet = purchaseDTOSetSet;
    }

    @Override
    public String toString() {
        return "TripDTO{" +
                "departureDate=" + departureDate +
                ", returnData=" + returnData +
                ", numberDay=" + numberDay +
                ", mealType='" + mealType + '\'' +
                ", adultPrice=" + adultPrice +
                ", kidPrice=" + kidPrice +
                ", promoted=" + promoted +
                ", adultNumber=" + adultNumber +
                ", kidNumber=" + kidNumber +
                ", availableStock=" + availableStock +
                '}';
    }
}
