package br.com.revenda.domain.entities;

import br.com.revenda.dto.CategoryVehicleDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tb_category_vehicle")
public class CategoryVehicle implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10 , unique = true , nullable = false)
    private String name_category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryVehicle", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private List<Vehicle> vehicles;
    public CategoryVehicle(CategoryVehicleDTO categoryVehicleDTO) {
        this.name_category = categoryVehicleDTO.name_category();
    }
}
