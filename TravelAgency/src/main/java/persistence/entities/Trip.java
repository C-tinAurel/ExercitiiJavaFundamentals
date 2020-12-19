package persistence.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@NamedQueries({@NamedQuery(name = "selectTripName", query = "select trip from Trip trip where name=:name"),
        @NamedQuery(name = "selectTripPromoted", query = "select trip from Trip trip where  promoted=:promoted"),
        @NamedQuery(name = "findAllTrips", query = "select trip from Trip trip"),
        @NamedQuery(name = "findTripByCity", query = "select trip from Trip trip inner join trip.hotel hotel inner join hotel.city city where city.name=:name"),
        @NamedQuery(name = "findTripByCountry", query = "select trip from Trip trip inner join trip.hotel hotel inner join hotel.city city inner join" +
                " city.country country where name=:name"),
        @NamedQuery(name = "findTripByContinent", query = "select trip from Trip trip inner join trip.hotel hotel inner join hotel.city city " +
                "inner join city.country country inner join country.continent continent where name=:name"),
        @NamedQuery(name = "findTripRecently", query = "select trip from Trip trip where departureDate=:departureDate"),
        @NamedQuery(name = "updateNumbersOfDays", query = "update from Trip set numberDay=:numberDay where name=:name"),
        @NamedQuery(name = "updateAvailableStock",query = "update from Trip set availableStock=:availableStock where name=:name"),
        @NamedQuery(name = "deleteTrip", query = "delete from Trip where name=:name")})


@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "departure_date")
    private Date departureDate;
    @Column(name = "return_data")
    private Date returnData;
    @JoinColumn(name = "check_in")
    private Date checkIn;
    @JoinColumn(name = "check_out")
    private Date checkOut;
    @Column(name = "number_days")
    private int numberDay;
    @Column(name = "meal_type")
    private String mealType;
    @Column(name = "adult_price")
    private double adultPrice;
    @Column(name = "kid_price")
    private double kidPrice;
    @Column(name = "promoted")
    private boolean promoted;
    @Column(name = "adult_number")
    private int adultNumber;
    @Column(name = "kid_number")
    private int kidNumber;
    @Column(name = "available_stock")
    private int availableStock;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airports_id")
    private Airport airport;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotels_id")
    private Hotel hotel;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private Set<Purchase> purchaseSet;


    public Trip() {
    }

    public Trip(String name, Date departureDate, Date returnData, Date checkIn, Date checkOut, int numberDay, String mealType, double adultPrice, double kidPrice, boolean promoted, int adultNumber, int kidNumber, int availableStock) {
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

    public Trip(String name, Date departureDate, Date returnData, Date checkIn, Date checkOut, int numberDay, String mealType, double adultPrice, double kidPrice, boolean promoted, int adultNumber, int kidNumber, int availableStock, Airport airport, Hotel hotel, Set<Purchase> purchaseSet) {
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
        this.airport = airport;
        this.hotel = hotel;
        this.purchaseSet = purchaseSet;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Set<Purchase> getPurchaseSet() {
        return purchaseSet;
    }

    public void setPurchaseSet(Set<Purchase> purchaseSet) {
        this.purchaseSet = purchaseSet;
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

    @Override
    public String toString() {
        return "Trip{" +
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
