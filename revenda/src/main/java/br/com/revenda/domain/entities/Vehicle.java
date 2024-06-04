package br.com.revenda.domain.entities;

import br.com.revenda.dto.VehicleDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tb_vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(length = 10 , unique = true , nullable = false)
    String brand;

    @Column(length = 10 , unique = true , nullable = false)
    String model;

    @Column(length = 10 , unique = true , nullable = false)
    Integer n_doors;

    @Column(length = 10 , unique = true , nullable = false)
    Double motorcycle_literacy;

    @Column(length = 10 , unique = true , nullable = false)
    Double price_vehicle;

    @Column(length = 10 , unique = true , nullable = false)
    String plate_vehicle;

    @ManyToOne
    @JoinColumn
    CategoryVehicle categoryVehicle;

    @CreatedDate
    Date date_register_vehicle;


    public Vehicle(VehicleDTO vehicleDTO) {
        this.brand = vehicleDTO.brand();
        this.n_doors = vehicleDTO.n_doors();
        this.motorcycle_literacy = vehicleDTO.motorcycle_literacy();
        this.price_vehicle = vehicleDTO.price_vehicle();
        this.plate_vehicle = vehicleDTO.plate_vehicle();
        this.categoryVehicle = vehicleDTO.categoryVehicle();
        this.date_register_vehicle = vehicleDTO.date_register_vehicle();
    }
}
