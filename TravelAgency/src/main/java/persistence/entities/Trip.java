package persistence.entities;

import javax.persistence.*;
import java.util.Set;

/*@NamedQueries({@NamedQuery(name = "selectTripName", query = "select trip from Trip trip where name=:name"),
        @NamedQuery(name = "selectTripPromoted", query = "select trip from Trip trip where name=:name and promoted=:promoted")})
//mai trebuie adaugat select dupa continent si country*/

@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "departure_date")
    private String departureDate;
    @Column(name = "return_data")
    private String returnData;
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

    public Trip( String name, String departureDate, String returnData, int numberDay, String mealType, double adultPrice, double kidPrice, boolean promoted, int adultNumber, int kidNumber, int availableStock) {
        this.name = name;
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

    public Trip(String name, String departureDate, String returnData, int numberDay, String mealType, double adultPrice, double kidPrice, boolean promoted, int adultNumber, int kidNumber, int availableStock, Airport airport, Hotel hotel, Set<Purchase> purchaseSet) {
        this.name = name;
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
        this.airport = airport;
        this.hotel = hotel;
        this.purchaseSet = purchaseSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Trip{" +
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
