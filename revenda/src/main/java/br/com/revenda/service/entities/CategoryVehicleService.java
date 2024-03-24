package br.com.revenda.service.entities;

import br.com.revenda.domain.entities.CategoryVehicle;
import br.com.revenda.dto.CategoryVehicleDTO;
import br.com.revenda.respository.CategoryVehicleRepository;
import br.com.revenda.service.interfaces.ICRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CategoryVehicleService implements ICRUD<CategoryVehicle, Integer , CategoryVehicleDTO> {
    private Logger logger;
    @Autowired
    private CategoryVehicleRepository categoryVehicleRepository;
    @Override
    public CategoryVehicle save(CategoryVehicleDTO categoryVehicleDTO) {
        try {
            CategoryVehicle categoryVehicle = new CategoryVehicle(categoryVehicleDTO);
            categoryVehicleRepository.save(categoryVehicle);
            return categoryVehicle;
            s
        }catch (Exception e){
            logger.info("CategoryVehicleService: " + e.getMessage());
        }
        return  null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public CategoryVehicle update(String id, CategoryVehicleDTO Object) {
        return null;
    }

    @Override
    public Optional<CategoryVehicle> getById(Integer id) {
        return Optional.empty();
    }
}
