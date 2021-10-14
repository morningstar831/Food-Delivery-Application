package com.FoodDelivery.Food.Delivery.controller;

import com.FoodDelivery.Food.Delivery.entity.FoodCart;
import com.FoodDelivery.Food.Delivery.service.MapValidationService;
import com.FoodDelivery.Food.Delivery.serviceimpl.FoodCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ofd/api/cart")
public class FoodCartController {

    @Autowired
    private MapValidationService mapValidationService;

    @Autowired
    private FoodCartServiceImpl cartServiceImpl;

    @PostMapping("")
    public ResponseEntity<?> addToCart(@Valid @RequestBody FoodCart cart, BindingResult result) {
        ResponseEntity<?> errorMap=mapValidationService.mapValidationError(result);
        if(errorMap!=null) {
            return errorMap;
        }
        FoodCart cart1=cartServiceImpl.saveOrUpdate(cart);
        return new ResponseEntity<FoodCart>(cart1,HttpStatus.OK);
    }

    @GetMapping("/{cartId}")
    public FoodCart findCart(@PathVariable int cartId){
        FoodCart cart=cartServiceImpl.findById(cartId);
        return cart;
    }
}
