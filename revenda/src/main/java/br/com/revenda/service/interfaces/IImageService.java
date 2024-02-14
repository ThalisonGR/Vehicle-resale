package br.com.revenda.service.interfaces;

import br.com.revenda.domain.entities.Image;

public interface IImageService {

    Image save (Image image);
    Image update(String id, Image image);
    void  delete(String id);



}
