package br.com.revenda.service.interfaces;

import br.com.revenda.domain.entities.Image;

import java.util.List;
import java.util.Optional;

public interface ICRUD <T,S ,R> {

    T save (R object);
    T update(T id, R object);
    void  delete(S id);

    Optional <T> getById(S id);
}
