package business.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.Set;

public class TripDTO {
    @NotNull
    private String name;
    @NotNull
    private java.sql.Date departureDate;
    @NotNull
    private java.sql.Date returnData;
    @NotNull
    private java.sql.Date checkIn;
    @NotNull
    private java.sql.Date checkOut;
    @NotNull
    private int numberDay;
    @NotNull
    private String mealType;
    @NotNull
    private double adultPrice;
    @NotNull
    private double kidPrice;
    @NotNull
    private boolean promoted;
    @NotNull
    private int adultNumber;
    private int kidNumber;
    @NotNull
    private int availableStock;
    private AirportDTO airportDTO;
    @NotNull
    private HotelDTO hotelDTO;
   // @NotNull
    private Set<PurchaseDTO> purchaseDTOSetSet;

    public TripDTO() {
    }

    public TripDTO(@NotNull String name, Date departureDate, Date returnData, @NotNull Date checkIn, Date checkOut, @NotNull @NotEmpty @NotBlank @Pattern(regexp = "([0-9])*") int numberDay, @NotEmpty @NotBlank @Pattern(regexp = "([a-z-A-Z])*") String mealType, @NotEmpty @NotBlank double adultPrice, @NotEmpty @NotBlank double kidPrice, boolean promoted, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([0-9])*") int adultNumber, @NotEmpty @NotBlank int kidNumber, @NotEmpty @NotBlank @NotNull @Pattern(regexp = "([0-9])*") int availableStock) {
        this.name = name;
        this.departureDate = departureDate;
        this.returnData = returnData;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numberDay = numberDay;
        this.mealType = mealType;
        this.adultPrice = adultPrice;
        this.kidPrice = kidPrice;
        this.promoted = promoted;
        this.adultNumber = adultNumber;
        this.kidNumber = kidNumber;
        this.availableStock = availableStock;
    }

    public TripDTO(@NotNull String name, Date departureDate, Date returnData, Date checkIn, Date checkOut, @NotNull int numberDay, @NotNull String mealType, @NotNull double adultPrice, @NotNull double kidPrice, @NotNull boolean promoted, @NotNull int adultNumber, int kidNumber, @NotNull int availableStock, AirportDTO airportDTO, @NotNull HotelDTO hotelDTO, Set<PurchaseDTO> purchaseDTOSetSet) {
        this.name = name;
        this.departureDate = departureDate;
        this.returnData = returnData;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getReturnData() {
        return returnData;
    }

    public void setReturnData(Date returnData) {
        this.returnData = returnData;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TripDTO{" +
                "name='" + name + '\'' +
                ", departureDate=" + departureDate +
                ", returnData=" + returnData +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
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
