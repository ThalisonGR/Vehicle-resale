package br.com.revenda.service.entities;

import br.com.revenda.domain.entities.Vehicle;
import br.com.revenda.dto.VehicleDTO;
import br.com.revenda.service.interfaces.ICRUD;

import java.util.Optional;

public class VehicleService implements ICRUD <VehicleDTO , Vehicle , String> {

    @Override
    public VehicleDTO save(VehicleDTO object) {
        return null;
    }

    @Override
    public VehicleDTO update(VehicleDTO id, String object) {
        return null;
    }

    @Override
    public void delete(Vehicle id) {

    }

    @Override
    public Optional<VehicleDTO> getById(Vehicle id) {
        return Optional.empty();
    }
}
