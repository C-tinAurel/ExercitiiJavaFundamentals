package frontend;

import business.dto.DepositDTO;
import business.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import persistence.entities.Deposit;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepositController {
    @Autowired
    DepositService depositService;

    @PostMapping(path = "/insertDeposit")
    public String insert(@RequestBody @Valid DepositDTO insertDeposit) {
        depositService.insert(insertDeposit);
        return "Ati introdus adresa " + insertDeposit.getCity() + " " + insertDeposit.getAddress();
    }

    @GetMapping(path = "/findDeposit")
    public List<DepositDTO> findDepositByCity(@RequestParam String city) {
        List<DepositDTO> depositDTOList = depositService.findDepositByCity(city);
        return depositDTOList;
    }

    @DeleteMapping(path = "/deleteDeposit")
    public String deleteDepositByAddress(@RequestParam String address) {
        Integer numberOfDeletedDeposit = depositService.deleteDepositByAddress(address);
        if (numberOfDeletedDeposit > 0) {
            return "Ati sters cu succes Depozitul ";
        } else {
            return "Nu ati sters Depozitul";
        }
    }

    @PutMapping(path = "/updateDeposit")
    public String updateDepositAddress(@RequestParam String address,@RequestParam String city) {
        Integer numberUpdatedDeposit = depositService.updateDepositAddress(address, city);
        if (numberUpdatedDeposit > 0) {
            return "Ati actualizat cu succes Depozitul ";
        } else {
            return "Nu ati sters Depozitul";
        }
    }
}
