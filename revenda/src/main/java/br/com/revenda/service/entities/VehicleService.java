package br.com.revenda.service.entities;

import br.com.revenda.domain.entities.CategoryVehicle;
import br.com.revenda.domain.entities.Vehicle;
import br.com.revenda.dto.VehicleDTO;
import br.com.revenda.service.interfaces.ICRUD;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements ICRUD <Vehicle , Integer , VehicleDTO> {

    @Override
    public Vehicle save(VehicleDTO vehicleDTO) {
        return null;
    }

    @Override
    public Vehicle update(Integer id, VehicleDTO vehicleDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Vehicle getById(Integer id) {
        return null;
    }

    public List<Vehicle> getAll (){
        return null;
    }
}
