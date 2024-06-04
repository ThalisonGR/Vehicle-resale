package br.com.revenda.dto;

import br.com.revenda.domain.entities.CategoryVehicle;

import java.util.Date;

public record VehicleDTO(String brand, String model, Integer n_doors, Double motorcycle_literacy, Double price_vehicle, String plate_vehicle, CategoryVehicle categoryVehicle, Date date_register_vehicle) {
}
