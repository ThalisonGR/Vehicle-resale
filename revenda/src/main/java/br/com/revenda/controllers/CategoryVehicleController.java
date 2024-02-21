package br.com.revenda.controllers;

import br.com.revenda.controllers.interfaces.ICrudController;
import br.com.revenda.domain.entities.CategoryVehicle;
import br.com.revenda.dto.CategoryVehicleDTO;
import br.com.revenda.service.entities.CategoryVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/categoriaVeiculo")
public class CategoryVehicleController implements ICrudController<CategoryVehicle , String , CategoryVehicleDTO> {

    @Autowired
    CategoryVehicleService categoryVehicleService;

    @Override
    @PostMapping("/save")
    public ResponseEntity<CategoryVehicle> save(@RequestBody CategoryVehicleDTO object) {
        CategoryVehicle categoryVehicle = categoryVehicleService.save(object);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryVehicle);
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryVehicle> udate(@PathVariable String id, @RequestBody CategoryVehicleDTO object) {
        return null;
    }

    @Override
    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryVehicle>> getAll() {
        return null;
    }

    @Override
    @GetMapping("/getBtID/{id}")
    public ResponseEntity<CategoryVehicle> getByID(@PathVariable String id) {
        return null;
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        return null;
    }
}
