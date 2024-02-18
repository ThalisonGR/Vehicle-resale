package br.com.revenda.service.other.image;

import br.com.revenda.domain.entities.Image;
import br.com.revenda.domain.enums.ImagensExtesion;
import br.com.revenda.dto.ImageDTO;
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

    public ImageDTO imageToDTO(Image image , String url){
        return ImageDTO.builder()
                .url(url)
                .extension(image.getExtension().name())
                .name(image.getName())
                .size(image.getSize())
                .uploadDate(image.getUploadDate().toLocalDate())
                .build();
    }
}
