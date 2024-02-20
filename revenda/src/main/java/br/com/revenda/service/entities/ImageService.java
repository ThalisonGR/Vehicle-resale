package br.com.revenda.service.entities;

import br.com.revenda.domain.entities.Image;
import br.com.revenda.respository.ImageRepository;
import br.com.revenda.service.interfaces.ICRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
    public  class ImageService implements ICRUD <Image ,String , Image> {

    @Autowired
    ImageRepository imageRepository;


    @Override
    @Transactional
    public Image save(Image image) {
        Image nImage = imageRepository.save(image);
        return nImage;
    }

    @Override
    public Image update(String id, Image object) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    public List<Image> getAll() {
        List <Image> images = imageRepository.findAll();
        return images;
    }

    @Override
    public Optional<Image> getById(String id){
        return imageRepository.findById(id);
    }
}
