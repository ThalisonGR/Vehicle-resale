package br.com.revenda.service.entities;

import br.com.revenda.domain.entities.Vehicle;
import br.com.revenda.dto.VehicleDTO;
import br.com.revenda.service.interfaces.ICRUD;

import java.util.Optional;

public class VehicleService implements ICRUD <Vehicle , String , VehicleDTO> {

    @Override
    public Vehicle save(VehicleDTO vehicleDTO) {
        return null;
    }

    @Override
    public Vehicle update(Integer id, VehicleDTO vehicleDTO) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Vehicle getById(String id) {
        return null;
    }
}
