package com.FoodDelivery.Food.Delivery.serviceimpl;

import com.FoodDelivery.Food.Delivery.entity.Category;
import com.FoodDelivery.Food.Delivery.exception.ResourceNotFoundException;
import com.FoodDelivery.Food.Delivery.repository.CategoryRepository;
import com.FoodDelivery.Food.Delivery.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category saveOrUpdate(Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(int id) {
        Category category=categoryRepository.findById(id);
        if(category==null)
        {
            throw new ResourceNotFoundException("id doesnt exist");
        }
        categoryRepository.deleteById(id);


    }

    @Override
    public Category getCategoryById(int id) {
        Category category=categoryRepository.findById(id);
        if(category==null)
        {
            throw new ResourceNotFoundException("id doesnt exist");
        }
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> getAllCategory() {
        return  categoryRepository.findAll();
    }

}
