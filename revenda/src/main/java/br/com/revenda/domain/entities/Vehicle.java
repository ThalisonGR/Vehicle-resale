package br.com.revenda.domain.entities;

import br.com.revenda.dto.VehicleDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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

    @Column(length = 10 )
    String brand;

    @Column(length = 10)
    String model;

    @Column(length = 10 )
    Integer n_doors;

    @Column(length = 10 )
    Double motorcycle_literacy;

    @Column(length = 10 )
    Double price_vehicle;

    @Column(length = 10 , unique = true )
    String plate_vehicle;


    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "categoryVehicle_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    CategoryVehicle categoryVehicle;

    @CreationTimestamp
    Date date_register_vehicle;


    public Vehicle(VehicleDTO vehicleDTO) {
        this.brand = vehicleDTO.brand();
        this.n_doors = vehicleDTO.n_doors();
        this.motorcycle_literacy = vehicleDTO.motorcycle_literacy();
        this.price_vehicle = vehicleDTO.price_vehicle();
        this.plate_vehicle = vehicleDTO.plate_vehicle();
        this.categoryVehicle = vehicleDTO.categoryVehicle();
        this.date_register_vehicle = vehicleDTO.date();
    }
}
