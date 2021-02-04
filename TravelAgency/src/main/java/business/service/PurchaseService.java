package business.service;

import business.dto.PurchaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.ClientDAO;
import persistence.dao.TripDAO;
import persistence.entities.Purchase;



@Service
public class PurchaseService {
    @Autowired
    ClientDAO clientDAO;
    @Autowired
    TripDAO tripDAO;


    public void insertPurchase(PurchaseDTO purchaseDTO){
        Purchase purchase=new Purchase();
        purchase.setTrip(tripDAO.findTripByName(purchaseDTO.getTripDTO().getName()));
        

        }
}
