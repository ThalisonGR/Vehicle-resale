package br.com.revenda.service.entities;

import br.com.revenda.domain.entities.Image;
import br.com.revenda.respository.ImageRepository;
import br.com.revenda.service.interfaces.ICRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public  class ImageService implements ICRUD <Image ,String> {

    @Autowired
    ImageRepository imageRepository;


    @Override
    @Transactional
    public Image save(Image image) {
        Image nImage = imageRepository.save(image);
        return nImage;
    }

    @Override
    public Image update(Image id, Image object) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List getAll() {
        return null;
    }
}
