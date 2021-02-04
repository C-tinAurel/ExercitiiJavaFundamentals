package persistence.entities;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({@NamedQuery(name = "updateRoomNumberAvailable", query = "update Room set numberAvailable=:numberAvailable where type=:type")})

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "room_type")
    private String type;
    @Column(name = "number_available")
    private int numberAvailable;
    @Column(name = "extra_bed")
    private boolean extraBed;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "rooms_hotels", joinColumns = {@JoinColumn(name = "rooms_id")},
            inverseJoinColumns = {@JoinColumn(name = "hotels_id")})
    private Set<Hotel> hotelSet;

    public Room() {
    }

    public Room(String type, int numberAvailable, boolean extraBed) {
        this.type = type;
        this.numberAvailable = numberAvailable;
        this.extraBed = extraBed;
    }

    public Room(String type, int numberAvailable, boolean extraBed, Set<Hotel> hotelSet) {
        this.type = type;
        this.numberAvailable = numberAvailable;
        this.extraBed = extraBed;
        this.hotelSet = hotelSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Hotel> getHotelSet() {
        return hotelSet;
    }

    public void setHotelSet(Set<Hotel> hotelSet) {
        this.hotelSet = hotelSet;
    }

    @Override
    public String toString() {
        return "Room{" +
                "type='" + type + '\'' +
                ", numberAvailable=" + numberAvailable +
                ", extraBed=" + extraBed +
                '}';
    }
}
