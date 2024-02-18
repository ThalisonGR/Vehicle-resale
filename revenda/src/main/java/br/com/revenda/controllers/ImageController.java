package br.com.revenda.controllers;

import br.com.revenda.domain.entities.Image;
import br.com.revenda.domain.enums.ImagensExtesion;
import br.com.revenda.service.entities.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/imageS")
@Slf4j
@RequiredArgsConstructor   //N
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity save(@RequestParam ("file") MultipartFile file,
                               @RequestParam ("name") String name,
                               @RequestParam ("tags") List <String> tags){

        Image image = Image.builder()
                .name(name)
                .tags(String.join(",",tags))
                .size(file.getSize())
                .extension(ImagensExtesion.valueOf(MediaType.valueOf(file.getContentType())))
                
                .build();


        return  ResponseEntity.ok().build();

    }
}
