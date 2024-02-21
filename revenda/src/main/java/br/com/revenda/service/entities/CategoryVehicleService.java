package br.com.revenda.service.entities;

import br.com.revenda.domain.entities.CategoryVehicle;
import br.com.revenda.dto.CategoryVehicleDTO;
import br.com.revenda.respository.CategoryVehicleRepository;
import br.com.revenda.service.interfaces.ICRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoryVehicleService implements ICRUD <CategoryVehicle , Integer , CategoryVehicleDTO>{

    @Autowired
    CategoryVehicleRepository categoryVehicleRepository;

    @Transactional
    @Override
    public CategoryVehicle save(CategoryVehicleDTO categoryVehicleDTO) {
            CategoryVehicle categoryVehicle = new CategoryVehicle(categoryVehicleDTO);
            categoryVehicleRepository.save(categoryVehicle);
            return categoryVehicle;
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        categoryVehicleRepository.deleteById(id);
    }

    @Transactional
    @Override
    public CategoryVehicle update(Integer id, CategoryVehicleDTO categoryVehicleDTO) {
       CategoryVehicle categoryVehicle = getByIdNotOptional(id);
       categoryVehicle.setName_category(categoryVehicleDTO.name_category());
       categoryVehicleRepository.save(categoryVehicle);
       return categoryVehicle;

    }

    @Transactional
    @Override
    public Optional<CategoryVehicle> getById(Integer id) {
        Optional<CategoryVehicle> categoryVehicle  = categoryVehicleRepository.findById(id);
        return categoryVehicle;
    }

    @Transactional
    public CategoryVehicle getByIdNotOptional(Integer id){
        CategoryVehicle  categoryVehicle = categoryVehicleRepository.findById(id).orElse(null);
        return categoryVehicle;
    }


}
