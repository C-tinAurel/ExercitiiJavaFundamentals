package persistence.entities;

import javax.persistence.*;
import java.util.Set;

 @NamedQueries({@NamedQuery(name = "selectHotelByCity", query = "select hotel.name from Hotel hotel inner join " +
        "City city where  city.name=:name"),
        @NamedQuery(name = "selectHotelByAvailableRoomAndType",query = "select hotel.name from Hotel hotel inner join" +
                " Room room where  room.type=:type or room.type=:null and room.numberAvailable=:numberAvailable or room.numberAvailable=:null"),
        @NamedQuery(name = "selectHotelByExtraBedRoom",query = "select hotel.name from Hotel hotel inner join Room room where " +
                " room.extraBed=:extraBed"),
        @NamedQuery(name = "selectHotelName",query = "select hotel from Hotel hotel where name=:name"),
        @NamedQuery(name = "updateHotelStars", query = "update Hotel set stars=:stars where name=:name"),
        @NamedQuery(name = "updateHotelName", query = "update Hotel set name=:name where name=:name"),
        @NamedQuery(name = "deleteHotel", query = "delete Hotel where name=:name")})

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "stars")
    private int stars;
    @Column(name = "description")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cities_id")
    private City city;
    @ManyToMany(mappedBy = "hotelSet",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Room> roomSet;
    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    private Set<Trip> tripSet;

    public Hotel() {
    }

    public Hotel(String name, int stars, String description,String address) {
        this.name = name;
        this.stars = stars;
        this.description = description;
        this.address=address;
    }

    public Hotel(String name, String address,int stars, String description, City city, Set<Room> roomSet, Set<Trip> tripSet) {
        this.name = name;
        this.stars = stars;
        this.description = description;
        this.city = city;
        this.roomSet = roomSet;
        this.tripSet = tripSet;
        this.address=address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Room> getRoomSet() {
        return roomSet;
    }

    public void setRoomSet(Set<Room> roomSet) {
        this.roomSet = roomSet;
    }

    public Set<Trip> getTripSet() {
        return tripSet;
    }

    public void setTripSet(Set<Trip> tripSet) {
        this.tripSet = tripSet;
    }

     public String getAddress() {
         return address;
     }

     public void setAddress(String address) {
         this.address = address;
     }

     @Override
     public String toString() {
         return "Hotel{" +
                 "name='" + name + '\'' +
                 ", address='" + address + '\'' +
                 ", stars=" + stars +
                 ", description='" + description + '\'' +
                 '}';
     }
 }
