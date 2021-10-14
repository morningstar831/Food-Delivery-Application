package com.FoodDelivery.Food.Delivery.controller;

import com.FoodDelivery.Food.Delivery.entity.Category;
import com.FoodDelivery.Food.Delivery.service.CategoryService;
import com.FoodDelivery.Food.Delivery.serviceimpl.MapValidationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private MapValidationServiceImpl mapValidationErrorService;
    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Category category, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
        if (errorMap != null)
            return errorMap;
        Category proj = categoryService.saveOrUpdate(category);
        return new ResponseEntity<Category>(proj, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable int id)
    {
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<String>("category deleted",HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public List<Category> getAllCategories()
    {
        return categoryService.getAllCategory();
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable int id)
    {
        Category category=categoryService.getCategoryById(id);
        return new ResponseEntity<Category>(category,HttpStatus.OK);
    }

}
