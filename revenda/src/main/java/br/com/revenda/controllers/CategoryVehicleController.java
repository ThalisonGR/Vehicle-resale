package br.com.revenda.controllers;

import br.com.revenda.domain.entities.CategoryVehicle;
import br.com.revenda.dto.CategoryVehicleDTO;
import br.com.revenda.service.entities.CategoryVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/v1/categoryVehicle/")
public class CategoryVehicleController {

    private Logger logger;

    @Autowired
    CategoryVehicleService categoryVehicleService;

    public ResponseEntity <CategoryVehicle> save (CategoryVehicleDTO categoryVehicleDTO){
        categoryVehicleService.save(categoryVehicleDTO);
        return  null;
    }

}
