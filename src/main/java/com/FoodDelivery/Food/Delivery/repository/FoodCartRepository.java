package com.FoodDelivery.Food.Delivery.repository;

import com.FoodDelivery.Food.Delivery.entity.FoodCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart,Integer>{

    FoodCart findById(int id);
}
