package br.com.revenda.respository;

import br.com.revenda.domain.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City , Integer> {
}
