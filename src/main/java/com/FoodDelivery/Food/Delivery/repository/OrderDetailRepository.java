package com.FoodDelivery.Food.Delivery.repository;

import com.FoodDelivery.Food.Delivery.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This Repository interface is used for performing all CRUD related operations in database
 *
 *
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {

    OrderDetail findById(int id);

}

