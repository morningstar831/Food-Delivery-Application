package com.FoodDelivery.Food.Delivery.service;

import com.FoodDelivery.Food.Delivery.entity.Bill;

import java.util.Set;


public interface BillService {

    public Set<Bill> getAllBills();

    public Bill saveOrUpdate(Bill bill);

    public void deleteBill(int billId);

    public Bill getBillById(int billId);

    public int calculateBill(int billId);


}

