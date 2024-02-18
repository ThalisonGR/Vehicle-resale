package br.com.revenda.service.interfaces;

import br.com.revenda.domain.entities.Image;

import java.util.List;
import java.util.Optional;

public interface ICRUD <T,S> {

    T save (T object);
    T update(T id, T object);
    void  delete(S id);
    List <T> getAll();
    Optional <T> getById(S id);
}
