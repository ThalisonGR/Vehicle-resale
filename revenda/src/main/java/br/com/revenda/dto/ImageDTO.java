package br.com.revenda.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record ImageDTO(String url , String name , String extension, Long size , LocalDate uploadDate){

}
