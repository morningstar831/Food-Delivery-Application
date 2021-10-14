package com.FoodDelivery.Food.Delivery.repository;

import com.FoodDelivery.Food.Delivery.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Integer>
{

    public Bill getBillById(int billId);


}
