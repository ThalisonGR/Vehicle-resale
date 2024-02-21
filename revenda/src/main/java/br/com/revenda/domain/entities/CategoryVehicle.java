package br.com.revenda.domain.entities;

import br.com.revenda.dto.CategoryVehicleDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    public CategoryVehicle(CategoryVehicleDTO categoryVehicleDTO) {
        this.name_category = categoryVehicleDTO.name_category();
    }
}
