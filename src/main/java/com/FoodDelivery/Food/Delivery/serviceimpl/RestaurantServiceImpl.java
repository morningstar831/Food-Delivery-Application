package com.FoodDelivery.Food.Delivery.serviceimpl;

import com.FoodDelivery.Food.Delivery.entity.Restaurant;
import com.FoodDelivery.Food.Delivery.exception.ResourceNotFoundException;
import com.FoodDelivery.Food.Delivery.repository.RestaurantRepository;
import com.FoodDelivery.Food.Delivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class will perform all Restaurant related services
 *
 *
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    /**
     * Save restaurant details or update details
     * @param restaurant
     * @return
     */
    public Restaurant saveOrUpdate(Restaurant restaurant)
    {
        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurantById(int id)
    {
        Restaurant restaurant=restaurantRepository.findById(id);
        if(restaurant==null)
        {
            //throw new ResourceNotFoundException("This id does not exist");
        }
        restaurantRepository.deleteById(id);
    }
    public Restaurant getRestaurantById(int id)
    {
        Restaurant restaurant= restaurantRepository.findById(id);
        if(restaurant==null)
        {
            throw new ResourceNotFoundException("This id does not  exist");
        }
        return restaurant;
    }
    public List<Restaurant> getAllRestaurant()
    {
        return restaurantRepository.findAll();
    }
    public List<Restaurant> getRestaurantByItemName(String name)
    {
        return restaurantRepository.FindRestaurantByItemName(name);
    }

}
