package br.com.revenda.controllers;

import br.com.revenda.domain.entities.Image;
import br.com.revenda.service.entities.ImageService;
import br.com.revenda.service.other.image.ImageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Image> delete(@PathVariable String id){
        Image nImage = imageService.getById(id).orElse(null);
        if (!id.isEmpty()){
            imageService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(nImage);
        }
        return ResponseEntity.notFound().build();
    }

    //Return image in URL
    @GetMapping("{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id){
        var possibleImage = imageService.getById(id);
        if (possibleImage.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var image = possibleImage.get();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(image.getExtension().getMediaType());
        headers.setContentLength(image.getSize());
        headers.setContentDispositionFormData("" , image.getName()
                .concat(".")
                .concat(image.getExtension().name())); //FORMA DE DISPONIBILAR A IMAGEM
        return  new ResponseEntity<>(image.getFile(), headers , HttpStatus.OK);
    }
    public URI ImageBuildURI(Image image){
        String imagePath = "/" + image.getId();
        return ServletUriComponentsBuilder.fromCurrentRequest().path(imagePath).build().toUri();
    }
}
