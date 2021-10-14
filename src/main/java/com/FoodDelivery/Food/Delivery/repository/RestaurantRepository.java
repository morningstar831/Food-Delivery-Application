package com.FoodDelivery.Food.Delivery.repository;

import com.FoodDelivery.Food.Delivery.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface perform all crud operations on Restaurant class
 *
 *
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
    public Restaurant findById(int id);
    //@Query("select r restaurant from Restaurant ri where ri.itemList = (from Item i where i.itemName= ?1) ")
    @Query("select r from Restaurant r join r.itemList m where m.itemName=:itemName")
    List<Restaurant> FindRestaurantByItemName(@Param("itemName")String itemName);

}
