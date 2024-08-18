package br.com.revenda.service.interfaces;

public interface ICRUDImport<T,S,R> {

    T save (R object);
    T getById(S id);
}
