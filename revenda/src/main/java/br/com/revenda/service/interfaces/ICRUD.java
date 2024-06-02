package br.com.revenda.service.interfaces;

import br.com.revenda.domain.entities.Image;
import br.com.revenda.domain.entities.Vehicle;
import br.com.revenda.dto.VehicleDTO;

import java.util.List;
import java.util.Optional;

public interface ICRUD <T,S,R> {

    T save (R object);
    void  delete(S id);
    T update(Integer id , R Object);
    T getById(S id);
}
