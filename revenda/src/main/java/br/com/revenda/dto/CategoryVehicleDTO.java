package br.com.revenda.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryVehicleDTO(@NotBlank(message = "Not null") String name_category) {
}
