package br.com.revenda.domain.entities;

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
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(length = 10 , unique = true , nullable = false)
    String brand;

    @Column(length = 10 , unique = true , nullable = false)
    Integer n_doors;

    @Column(length = 10 , unique = true , nullable = false)
    Double motorcycle_literacy;

    @Column(length = 10 , unique = true , nullable = false)
    Double price_vehicle;

    @Column(length = 10 , unique = true , nullable = false)
    String plate_vehicle;

    @OneToOne
    CategoryVehicle categoryVehicle;

    @CreatedDate
    Date date_register_vehicle;


}
