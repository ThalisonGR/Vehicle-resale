package br.com.revenda.respository;

import br.com.revenda.domain.entities.CategoryVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryVehicleRepository extends JpaRepository<CategoryVehicle, Integer> {
}
