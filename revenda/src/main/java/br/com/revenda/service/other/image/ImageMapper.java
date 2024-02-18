package br.com.revenda.service.other.image;

import br.com.revenda.domain.entities.Image;
import br.com.revenda.domain.enums.ImagensExtesion;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class ImageMapper {

    public Image mapToImage(MultipartFile file , String name , List<String> tags) throws IOException {


        Image image = Image.builder()
                .name(name)
                .tags(String.join(",",tags))
                .size(file.getSize())
                .extension(ImagensExtesion.valueOf(MediaType.valueOf(file.getContentType())))
                .file(file.getBytes())
                .build();

        return image;

    }
}
