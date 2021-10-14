package com.FoodDelivery.Food.Delivery.repository;

import com.FoodDelivery.Food.Delivery.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{

    public Customer findById(int id);
}
