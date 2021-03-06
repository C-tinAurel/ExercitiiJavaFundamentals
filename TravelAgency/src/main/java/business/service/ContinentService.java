package business.service;

import business.dto.ContinentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.ContinentDAO;
import persistence.entities.Continent;


@Service
public class ContinentService {
    @Autowired
    ContinentDAO continentDAO;

    public void insertContinent(ContinentDTO continentDTO) {
        Continent continent = new Continent();
        continent.setName(continentDTO.getName());
        continentDAO.insertContinent(continent);

    }

    public ContinentDTO findContinent(String name) {
        Continent continent = continentDAO.findContinent(name);
        if(continent==null){
            return null;
        }
        ContinentDTO continentDTO = new ContinentDTO();
        continentDTO.setName(continent.getName());
        return continentDTO;

    }


}

