package com.FoodDelivery.Food.Delivery.service;


import com.FoodDelivery.Food.Delivery.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public Category saveOrUpdate(Category category);
    public void deleteCategoryById(int id);
    public Category getCategoryById(int id);
    public List<Category> getAllCategory();

}

