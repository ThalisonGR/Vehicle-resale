package br.com.revenda.domain.entities;

import br.com.revenda.dto.VehicleDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

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
    private Integer id;

    @Column(length = 10 )
    private String brand;

    @Column(length = 10)
    private String model;

    @Column(length = 10 )
    private Integer n_doors;

    @Column(length = 10 )
    private Double motorcycle_literacy;

    @Column(length = 10 )
    private Double price_vehicle;

    @Column(length = 10 , unique = true )
    private String plate_vehicle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private CategoryVehicle categoryVehicle;

    @CreationTimestamp
    Date date_register_vehicle;

    public Vehicle(VehicleDTO vehicleDTO) {
        this.brand = vehicleDTO.brand();
        this.model = vehicleDTO.model();
        this.n_doors = vehicleDTO.n_doors();
        this.motorcycle_literacy = vehicleDTO.motorcycle_literacy();
        this.price_vehicle = vehicleDTO.price_vehicle();
        this.plate_vehicle = vehicleDTO.plate_vehicle();
        this.categoryVehicle = vehicleDTO.categoryVehicle();
        this.date_register_vehicle = vehicleDTO.date();
    }
}
