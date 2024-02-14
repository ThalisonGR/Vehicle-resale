package br.com.revenda.service.entities;

import br.com.revenda.domain.entities.Image;
import br.com.revenda.respository.ImageRepository;
import br.com.revenda.service.interfaces.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImageService implements IImageService {
    //

    @Autowired
    ImageRepository imageRepository;

    @Override
    @Transactional
    public Image save(Image image) {
        Image newImage = imageRepository.save(image);
        return newImage;
    }

    @Override
    public Image update(String id, Image image) { //
        Image newImage = imageRepository.findById(id).orElseThrow();
        return  newImage;
    }

    @Override
    public void delete(String id) {

    }


}
