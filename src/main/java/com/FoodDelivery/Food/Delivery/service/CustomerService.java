package com.FoodDelivery.Food.Delivery.service;

import com.FoodDelivery.Food.Delivery.entity.Customer;

import java.util.List;

public interface CustomerService {

    /*
     * This method will save or Update Customer details
     * @param customer
     * @return Saved Customer
     */
    public Customer saveOrUpdate(Customer customer)  ;

    /*
     * This method is for finding all  customer details
     * @return all customer details
     */
    public List<Customer> getAllCustomers() ;


    /*
     * This method is for finding customer details by id
     * @param id
     */
    public  Customer findCustomerById(int id) ;

    /*
     * This method is for deleting the customer details by id
     * @param id
     */
    public void deleteCustomerById(int id);
}



