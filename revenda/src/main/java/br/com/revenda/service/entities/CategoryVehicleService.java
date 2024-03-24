package br.com.revenda.service.entities;

import br.com.revenda.domain.entities.CategoryVehicle;
import br.com.revenda.dto.CategoryVehicleDTO;
import br.com.revenda.respository.CategoryVehicleRepository;
import br.com.revenda.service.interfaces.ICRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
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
            logger.info("Save sucess");
            return categoryVehicle;
        }catch (Exception e){
            logger.info("CategoryVehicleService: Save : " + e.getMessage());
        }
        return  null;
    }

    @Override
    public void delete(Integer id) {
        try {
            categoryVehicleRepository.deleteById(id);
        }catch (Exception e){
            logger.info("CategoryVehicleService: Delete : " + e.getMessage());
        }
    }

    @Override
    public CategoryVehicle update(Integer id, CategoryVehicleDTO categoryVehicleDTO) {
        try {
            CategoryVehicle categoryVehicle = getById(id);
            categoryVehicle.setName_catergory(categoryVehicleDTO.name_catergory());
            categoryVehicleRepository.save(categoryVehicle);
            logger.info("Update sucess");
            return categoryVehicle;
        }catch (Exception e){
            logger.info("CategoryVehicleService: Update : " + e.getMessage());
        }
        return null;
    }

    @Override
    public CategoryVehicle getById(Integer id) {
        try {
            CategoryVehicle  categoryVehicle= getById(id);
            logger.info("GetByID sucess");
            return categoryVehicle;
        }catch (Exception e){
            logger.info("CategoryVehicleService: getByID : " + e.getMessage());
        }
        return null;
    }
}
