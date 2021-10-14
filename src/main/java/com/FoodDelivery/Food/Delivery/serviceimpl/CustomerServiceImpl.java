package com.FoodDelivery.Food.Delivery.serviceimpl;

import com.FoodDelivery.Food.Delivery.entity.Customer;
import com.FoodDelivery.Food.Delivery.exception.ResourceNotFoundException;
import com.FoodDelivery.Food.Delivery.repository.CustomerRepository;
import com.FoodDelivery.Food.Delivery.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository  customerRepository;



    /*
     * This method will save or Update Customer details
     * @param customer
     * @return Saved Customer
     */
    public Customer saveOrUpdate(Customer customer)
    {


        customer.setAddress(customer.getAddress());
        customer.getAddress().setCustomer(customer);
        customer.getAddress().setArea(customer.getAddress().getArea());
        customer.getAddress().setBuildingName(customer.getAddress().getBuildingName());
        customer.getAddress().setStreetNo(customer.getAddress().getStreetNo());
        customer.getAddress().setCity(customer.getAddress().getCity());
        customer.getAddress().setState(customer.getAddress().getState());
        customer.getAddress().setCountry(customer.getAddress().getCountry());
        customer.getAddress().setPinCode(customer.getAddress().getPinCode());

        return customerRepository.save(customer);

    }

    /*
     * This method is for finding all  customer details
     * @return all customer details
     */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }


    /*
     * This method is for finding customer details by id
     * @param id
     */
    public  Customer findCustomerById(int id) {

        Customer customer=customerRepository.findById(id);
        if(customer==null) {
            throw new ResourceNotFoundException("Invalid Customer");
        }
        return customer;

    }


    /*
     * This method is for deleting the customer details by id
     * @param id
     */
    public void deleteCustomerById(int id)
    {
        Customer customer=customerRepository.findById(id);
        if(customer==null) {
            throw new ResourceNotFoundException("Invalid Customer");
        }
        customerRepository.deleteById(id);
    }
}
