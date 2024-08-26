package br.com.revenda.domain.entities;

import br.com.revenda.dto.VehicleDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "tb_vehicle")
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
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
