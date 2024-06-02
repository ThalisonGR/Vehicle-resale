package br.com.revenda.service.entities;

import br.com.revenda.domain.entities.CategoryVehicle;
import br.com.revenda.dto.CategoryVehicleDTO;
import br.com.revenda.respository.CategoryVehicleRepository;
import br.com.revenda.service.interfaces.ICRUD;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

@Slf4j
@Service
public class CategoryVehicleService implements ICRUD<CategoryVehicle, Integer , CategoryVehicleDTO> {
    @Autowired
    private CategoryVehicleRepository categoryVehicleRepository;
    @Override
    public CategoryVehicle save(CategoryVehicleDTO categoryVehicleDTO) {
        try {
            CategoryVehicle categoryVehicle = new CategoryVehicle(categoryVehicleDTO);
            categoryVehicleRepository.save(categoryVehicle);
            log.info("Save sucess");
            return categoryVehicle;
        }catch (Exception e){
           log.info("Error: CategoryVehicleService: Save :" + e.getMessage());
        }
        return  null;
    }

    @Override
    public void delete(Integer id) {
        try {
            categoryVehicleRepository.deleteById(id);
            log.info("Delete sucess");
        }catch (Exception e){
            log.info("Error: CategoryVehicleService: Delete : " + e.getMessage());
        }
    }

    @Override
    public CategoryVehicle update(Integer id, CategoryVehicleDTO categoryVehicleDTO) {
        try {
            CategoryVehicle categoryVehicle = getById(id);
            categoryVehicle.setName_category(categoryVehicleDTO.name_category());
            categoryVehicleRepository.save(categoryVehicle);
            log.info("Update sucess");
            return categoryVehicle;
        }catch (Exception e){
            log.info("Error: CategoryVehicleService: Update : " + e.getMessage());
        }
        return null;
    }

    @Override
    public CategoryVehicle getById(Integer id) {
        try {
            return categoryVehicleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Veiculo não existe"));
        }catch (Exception e){
            log.info("Error: CategoryVehicleService: getByID : " + e.getMessage());
        }
        return null;
    }

    public List<CategoryVehicle> getAll (){
        List <CategoryVehicle> lista = categoryVehicleRepository.findAll();
        return lista;
    }
}
