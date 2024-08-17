package br.com.revenda.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.yaml.snakeyaml.events.Event;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tb_city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10 , unique = true , nullable = false)
    private Integer cod_ibge;

    @Column(length = 20 , unique = true, nullable = false)
    private String name_city;


}
