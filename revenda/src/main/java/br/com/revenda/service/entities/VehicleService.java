package br.com.revenda.service.entities;


import br.com.revenda.domain.entities.Vehicle;
import br.com.revenda.dto.VehicleDTO;
import br.com.revenda.respository.VehicleRepository;
import br.com.revenda.service.interfaces.ICRUD;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class VehicleService implements ICRUD <Vehicle , Integer , VehicleDTO> {

    @Autowired
    VehicleRepository vehicleRepository;
    @Override
    public Vehicle save(VehicleDTO vehicleDTO) {
        try {
            Vehicle vehicle = new Vehicle(vehicleDTO);
            vehicleRepository.save(vehicle);
            log.info("Save sucess: Vehicle");
        }catch (Exception e){
            log.info("Error: VehicleService : Save: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Vehicle update(Integer id, VehicleDTO vehicleDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        try {
            vehicleRepository.deleteById(id);
            log.info("Delete sucess: Vehicle");
        }catch (Exception e) {
            log.info("Error: VehicleService: Delete: " + e.getMessage());
        }
    }

    @Override
    public Vehicle getById(Integer id) {
        try {
            Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not exist vehicle"));
            return vehicle;
        }catch (Exception e){
            log.info("Error: VehicleService: getByID: "+ e.getMessage());
        }
        return null;
    }

    public List<Vehicle> getAll (){
        try {
            List<Vehicle> list_vehicle = vehicleRepository.findAll();
            return list_vehicle;
        }catch (Exception e){
            log.info("Error: VehicleService: getAll: " + e.getMessage());
        }
        return null;
    }
}
