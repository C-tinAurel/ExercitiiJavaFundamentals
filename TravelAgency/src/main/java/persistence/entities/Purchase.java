package persistence.entities;

import javax.persistence.*;
import java.util.Set;
 /*@NamedQueries({@NamedQuery(name = "selectPurchaseByTrip",query = "select purchase from Purchase purchase inner join purchase.trip" +
        " trip where trip.name=:name")})*/

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "amount")
    private double amount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trips_id")
    private Trip trip;
    @ManyToMany(mappedBy = "purchaseSet",cascade = CascadeType.ALL)
    private Set<Client> clientSet;

    public Purchase() {
    }

    public Purchase(double amount) {
        this.amount = amount;
    }

    public Purchase(double amount, Trip trip, Set<Client> clientSet) {
        this.amount = amount;
        this.trip = trip;
        this.clientSet = clientSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Set<Client> getClientSet() {
        return clientSet;
    }

    public void setClientSet(Set<Client> clientSet) {
        this.clientSet = clientSet;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "amount=" + amount +
                '}';
    }
}
