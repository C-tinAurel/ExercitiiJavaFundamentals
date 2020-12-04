package persistence.entities;

import javax.persistence.*;
import java.util.Set;

 /*@NamedQueries({@NamedQuery(name = "selectHotelByCity", query = "select hotel from Hotel hotel inner join " +
        "City city where hotel.name=:name and city.name=:name"),
        @NamedQuery(name = "selectHotelByAvailableRoomAndType",query = "select hotel from Hotel hotel inner join" +
                " Room room where hotel.name=:name , room.type=:type and room.numberAvailable=:numberAvailable"),
        @NamedQuery(name = "selectHotelByExtraBedRoom",query = "select hotel from Hotel hotel inner join Room room where " +
                "hotel.name=:name and room.extraBed=:extraBed"),
        @NamedQuery(name = "selectHotelName",query = "select hotel from Hotel hotel where name=:name"),
        @NamedQuery(name = "updateHotelStars", query = "update Hotel set stars=:stars where name=:name"),
        @NamedQuery(name = "updateHotelDescription", query = "update Hotel set description=:description where name=:name"),
        @NamedQuery(name = "deleteHotel", query = "delete Hotel where name=:name")})*/

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "stars")
    private int stars;
    @Column(name = "description")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cities_id")
    private City city;
    @ManyToMany(mappedBy = "hotelSet", cascade = CascadeType.ALL)
    private Set<Room> roomSet;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private Set<Trip> tripSet;

    public Hotel() {
    }

    public Hotel(String name, int stars, String description) {
        this.name = name;
        this.stars = stars;
        this.description = description;
    }

    public Hotel(String name, int stars, String description, City city, Set<Room> roomSet, Set<Trip> tripSet) {
        this.name = name;
        this.stars = stars;
        this.description = description;
        this.city = city;
        this.roomSet = roomSet;
        this.tripSet = tripSet;
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

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", stars=" + stars +
                ", description='" + description + '\'' +
                '}';
    }
}
