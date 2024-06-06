package br.com.revenda.domain.entities;

import br.com.revenda.dto.CategoryVehicleDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tb_category_vehicle")
public class CategoryVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10 , unique = true , nullable = false)
    private String name_category;

    @OneToMany(mappedBy = "categoryVehicle" , cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles = new HashSet<>();
    public CategoryVehicle(CategoryVehicleDTO categoryVehicleDTO) {
        this.name_category = categoryVehicleDTO.name_category();
    }
}
