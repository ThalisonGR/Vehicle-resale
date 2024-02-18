package br.com.revenda.controllers;

import br.com.revenda.domain.entities.Image;
import br.com.revenda.service.entities.ImageService;
import br.com.revenda.service.other.image.ImageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/images")
@Slf4j
@RequiredArgsConstructor   //N
public class ImageController {

    @Autowired
    ImageService imageService;

    @Autowired
    ImageMapper imageMapper;

    @PostMapping("/upload")
    public ResponseEntity save(@RequestParam ("file") MultipartFile file,
                               @RequestParam ("name") String name,
                               @RequestParam ("tags") List <String> tags) throws IOException{

        Image image = imageMapper.mapToImage(file,name,tags);
        Image savedImage = imageService.save(image);
        URI imageURI = ImageBuildURI(savedImage);
        return  ResponseEntity.created(imageURI).build();

    }

    public URI ImageBuildURI(Image image){
        String imagePath = "/" + image.getId();
        return ServletUriComponentsBuilder.fromCurrentRequest().path(imagePath).build().toUri();
    }
}
