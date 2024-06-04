package br.com.revenda.controllers;

import br.com.revenda.domain.entities.Vehicle;
import br.com.revenda.dto.VehicleDTO;
import br.com.revenda.service.entities.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/register-Vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/save")
    public ResponseEntity<Vehicle> save_Vehicle (@RequestBody VehicleDTO vehicleDTO){
        Vehicle vehicle = vehicleService.save(vehicleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> update_Vehicle (@PathVariable Integer id , @RequestBody VehicleDTO vehicleDTO){
        Vehicle vehicle = vehicleService.update(id, vehicleDTO);
        return ResponseEntity.status(HttpStatus.OK).body(vehicle);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Vehicle>> getAll_Vehicle(){
        List<Vehicle> list_vehicle = vehicleService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(list_vehicle);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Vehicle> getByID_Vehicle(@PathVariable Integer id){
        Vehicle vehicle = vehicleService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(vehicle);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete_Category (@PathVariable Integer id){
        try {
            vehicleService.delete(id);
        }catch (Exception e){

        }
        return null;
    }


}
