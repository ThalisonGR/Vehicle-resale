package br.com.revenda.dto;

import java.time.LocalDate;

public record ImageDTO(String url , String name , String extension, Long size , LocalDate uploadDate){

}
