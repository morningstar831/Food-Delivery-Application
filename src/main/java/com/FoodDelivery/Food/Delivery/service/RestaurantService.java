package com.FoodDelivery.Food.Delivery.service;

import com.FoodDelivery.Food.Delivery.entity.Restaurant;

import java.util.List;

public interface RestaurantService {
    public Restaurant saveOrUpdate(Restaurant restaurant);
    public void deleteRestaurantById(int id);
    public Restaurant getRestaurantById(int id);
    public List<Restaurant> getAllRestaurant();
    public List<Restaurant> getRestaurantByItemName(String name);

}
