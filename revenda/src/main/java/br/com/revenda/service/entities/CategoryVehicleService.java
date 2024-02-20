package br.com.revenda.service.entities;

import br.com.revenda.domain.entities.CategoryVehicle;
import br.com.revenda.dto.CategoryVehicleDTO;
import br.com.revenda.respository.CategoryVehicleRepository;
import br.com.revenda.service.interfaces.ICRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryVehicleService implements ICRUD <CategoryVehicle , Integer , CategoryVehicleDTO>{

    @Autowired
    CategoryVehicleRepository categoryVehicleRepository;

    @Override
    public CategoryVehicle save(CategoryVehicleDTO categoryVehicleDTO) {
        try {
            CategoryVehicle categoryVehicle = new CategoryVehicle(categoryVehicleDTO);
            categoryVehicleRepository.save(categoryVehicle);
            return categoryVehicle;
        }catch (Exception e){
            e.getMessage();
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        categoryVehicleRepository.deleteById(id);
    }

    @Override
    public CategoryVehicle update(Integer id, CategoryVehicleDTO categoryVehicleDTO) {
       CategoryVehicle categoryVehicle = getByIdNotOptional(id);
       categoryVehicle.setName_catergory(categoryVehicleDTO.name_catergory());
       categoryVehicleRepository.save(categoryVehicle);
       return categoryVehicle;

    }

    @Override
    public Optional<CategoryVehicle> getById(Integer id) {
        Optional<CategoryVehicle> categoryVehicle  = categoryVehicleRepository.findById(id);
        return categoryVehicle;
    }

    public CategoryVehicle getByIdNotOptional(Integer id){
        CategoryVehicle  categoryVehicle = categoryVehicleRepository.findById(id).orElse(null);
        return categoryVehicle;
    }


}
