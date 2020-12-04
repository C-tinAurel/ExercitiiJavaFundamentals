package business.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class PurchaseDTO {
    @NotBlank
    @NotEmpty
    @NotNull
    private double amount;
    @NotNull
    private TripDTO tripDTO;
    @NotNull
    private Set<ClientDTO> clientDTOSetSet;

    public PurchaseDTO() {
    }

    public PurchaseDTO(@NotBlank @NotEmpty @NotNull double amount) {
        this.amount = amount;
    }

    public PurchaseDTO(@NotBlank @NotEmpty @NotNull double amount, @NotNull TripDTO tripDTO, @NotNull Set<ClientDTO> clientDTOSetSet) {
        this.amount = amount;
        this.tripDTO = tripDTO;
        this.clientDTOSetSet = clientDTOSetSet;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TripDTO getTripDTO() {
        return tripDTO;
    }

    public void setTripDTO(TripDTO tripDTO) {
        this.tripDTO = tripDTO;
    }

    public Set<ClientDTO> getClientDTOSetSet() {
        return clientDTOSetSet;
    }

    public void setClientDTOSetSet(Set<ClientDTO> clientDTOSetSet) {
        this.clientDTOSetSet = clientDTOSetSet;
    }

    @Override
    public String toString() {
        return "PurchaseDTO{" +
                "amount=" + amount +
                '}';
    }
}
