package br.com.revenda.domain.enums;

import org.springframework.http.MediaType;

import java.util.Arrays;

public enum ImagensExtesion {
     JPEG(MediaType.IMAGE_JPEG),
     PNG(MediaType.IMAGE_PNG),
     GIF(MediaType.IMAGE_GIF);

     private  MediaType mediaType;

     ImagensExtesion(MediaType mediaType) {
          this.mediaType = mediaType;
     }


     public static  ImagensExtesion valueOf(MediaType mediaType){
          return Arrays.stream(values())
                  .filter(ie -> ie.mediaType.equals(mediaType))
                  .findFirst()
                  .orElse(null);
     }
}
