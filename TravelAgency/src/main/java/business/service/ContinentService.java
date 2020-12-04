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
        Continent continentFound = continentDAO.findContinent(continentDTO.getName());
        if (continentFound == null) {
            continent.setName(continentDTO.getName());
            continentDAO.insertContinent(continent);
        } else if (continentFound.getName().equalsIgnoreCase(continentDTO.getName())) {
            continent.setName(continentFound.getName());
            continent.setId(continentFound.getId());
        }
    }

    public ContinentDTO findContinent(String name) {
        Continent continent = continentDAO.findContinent(name);
        ContinentDTO continentDTO = new ContinentDTO();
        continentDTO.setName(continent.getName());
        return continentDTO;
    }

    public Continent setContinent(ContinentDTO continentDTO) {
        Continent continent = new Continent();
        Continent continentFound = continentDAO.findContinent(continentDTO.getName());
        if (continentFound == null) {
            continent.setName(continentDTO.getName());
            continentDAO.insertContinent(continent);
        } else if (continentFound.getName().equalsIgnoreCase(continentDTO.getName())) {
            continent.setName(continentFound.getName());
            continent.setId(continentFound.getId());
        }
        return continent;
    }
}

