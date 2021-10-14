package com.FoodDelivery.Food.Delivery.repository;

import com.FoodDelivery.Food.Delivery.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address , Integer>  {

    public Address findById(int id);
}

