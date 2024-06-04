package br.com.revenda.controllers;

import br.com.revenda.domain.entities.CategoryVehicle;
import br.com.revenda.dto.CategoryVehicleDTO;
import br.com.revenda.service.entities.CategoryVehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/v1/categoryVehicle/")
public class CategoryVehicleController {

    @Autowired
    CategoryVehicleService categoryVehicleService;


    @PostMapping("/save")
    public ResponseEntity <CategoryVehicle> created_Category (@RequestBody  CategoryVehicleDTO categoryVehicleDTO){
        CategoryVehicle categoryVehicle = categoryVehicleService.save(categoryVehicleDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(categoryVehicle);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryVehicle> update_Category (@PathVariable Integer id ,@RequestBody CategoryVehicleDTO categoryVehicleDTO){
        CategoryVehicle categoryVehicle = categoryVehicleService.update(id, categoryVehicleDTO);
        return ResponseEntity.status(HttpStatus.OK).body(categoryVehicle);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryVehicle>> getAll_Category(){
        List<CategoryVehicle> list = categoryVehicleService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CategoryVehicle> getByID_Category(@PathVariable Integer id){
        CategoryVehicle categoryVehicle = categoryVehicleService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoryVehicle);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete_Category (@PathVariable Integer id){
        try {
            categoryVehicleService.delete(id);
        }catch (Exception e){
        }
        return null;
    }

}
