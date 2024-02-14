package br.com.revenda.controllers;

import br.com.revenda.domain.entities.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/image")
@Slf4j
public class ImageController {

    @PostMapping("/upload")
    public ResponseEntity save(@RequestParam ("file") MultipartFile file,
                               @RequestParam ("name") String name,
                               @RequestParam ("tags") List <String> tags){

    }
}
