package com.FoodDelivery.Food.Delivery.controller;

import com.FoodDelivery.Food.Delivery.entity.Restaurant;
import com.FoodDelivery.Food.Delivery.serviceimpl.MapValidationServiceImpl;
import com.FoodDelivery.Food.Delivery.serviceimpl.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantServiceImpl restaurantService;
    @Autowired
    private MapValidationServiceImpl mapValidationerrorService;
    @PostMapping("/add")
    public ResponseEntity<?> createRestaurant(@Valid @RequestBody Restaurant restaurant,BindingResult result)
    {
        ResponseEntity<?> errorMap=mapValidationerrorService.mapValidationError(result);
        if(errorMap!=null)
        {
            return errorMap;
        }

        Restaurant res=restaurantService.saveOrUpdate(restaurant);
        return new ResponseEntity<Restaurant>(res,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRestaurantById(@PathVariable int id)
    {
        restaurantService.deleteRestaurantById(id);
        return new ResponseEntity<String>("Restaurant Deleted",HttpStatus.OK);
    }
    @GetMapping("/all")
    public List<Restaurant> getAllRestaurants()
    {
        return restaurantService.getAllRestaurant();
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> getRestaurantById(@PathVariable int id)
    {

        Restaurant res=restaurantService.getRestaurantById(id);
        return new ResponseEntity<Restaurant>(res,HttpStatus.OK);


    }
    @GetMapping("/findRestaurant/{name}")
    public List<Restaurant> getRestaurantByItemName(@PathVariable String name)
    {
        return restaurantService.getRestaurantByItemName(name);
    }


}
