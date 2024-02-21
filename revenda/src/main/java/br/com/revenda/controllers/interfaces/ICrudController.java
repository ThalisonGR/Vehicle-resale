package br.com.revenda.controllers.interfaces;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICrudController <T,L,S,D> {

    ResponseEntity<T> save(D t);
    ResponseEntity<T> udate(S id , D object);
    ResponseEntity<List<L>> getAll();
    ResponseEntity<T> getByID(S id);
    ResponseEntity delete(S id);
}

