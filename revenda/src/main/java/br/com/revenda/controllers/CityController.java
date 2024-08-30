package br.com.revenda.controllers;

import br.com.revenda.domain.entities.City;
import br.com.revenda.service.entities.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    public ResponseEntity<City> save_City(){
        return null;
    }

}
