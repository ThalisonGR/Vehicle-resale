package br.com.revenda.service.entities;

import br.com.revenda.domain.entities.City;
import br.com.revenda.dto.CityDTO;
import br.com.revenda.respository.CityRepository;
import br.com.revenda.service.interfaces.ICRUD;
import br.com.revenda.service.interfaces.ICRUDImport;
import ch.qos.logback.core.encoder.EchoEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CityService implements ICRUDImport<City , Integer , CityDTO> {

    @Autowired
    CityRepository cityRepository;
    @Override
    public City save(CityDTO object) {
        try {
            City city  = new City(object);
            cityRepository.save(city);
            log.info("Save sucess: Category");
        }catch (Exception e){
            log.info("Error : CityService: Save " + e.getMessage());
        }
        return null;
    }
    @Override
    public City getById(Integer id) {
        return null;
    }
}
