package com.FoodDelivery.Food.Delivery.serviceimpl;

import com.FoodDelivery.Food.Delivery.entity.FoodCart;
import com.FoodDelivery.Food.Delivery.exception.ResourceNotFoundException;
import com.FoodDelivery.Food.Delivery.repository.FoodCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodCartServiceImpl {

    @Autowired
    private FoodCartRepository cartRepository;

    public FoodCart saveOrUpdate(FoodCart cart) {
        try {
            return cartRepository.save(cart);
        }
        catch(Exception e) {
            throw new ResourceNotFoundException("Cart Not Found");
        }
    }

    public FoodCart findById(int cartId) {
        FoodCart cart=cartRepository.findById(cartId);
        if(cart==null) {
            throw new ResourceNotFoundException("Cart doesn't exist");
        }
        return cart;
    }
}
