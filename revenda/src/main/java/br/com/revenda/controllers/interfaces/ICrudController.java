package br.com.revenda.controllers.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ICrudController <T,S,D> {

    ResponseEntity<T> save(D object);
    ResponseEntity<T> udate(S id , D object);
    ResponseEntity<List<T>> getAll();
    ResponseEntity<T> getByID(@PathVariable S id);
    ResponseEntity delete(S id);
}

