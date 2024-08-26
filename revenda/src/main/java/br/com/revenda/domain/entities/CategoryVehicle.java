package br.com.revenda.domain.entities;

import br.com.revenda.dto.CategoryVehicleDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import java.io.Serializable;
import java.util.List;

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
    private Long id;

    @Column(length = 10 , unique = true , nullable = false)
    private String name_category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryVehicle", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private List<Vehicle> vehicles;
    public CategoryVehicle(CategoryVehicleDTO categoryVehicleDTO) {
        this.name_category = categoryVehicleDTO.name_category();
    }
}
