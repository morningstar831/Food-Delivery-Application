package com.FoodDelivery.Food.Delivery.controller;

import com.FoodDelivery.Food.Delivery.entity.Customer;
import com.FoodDelivery.Food.Delivery.serviceimpl.CustomerServiceImpl;
import com.FoodDelivery.Food.Delivery.serviceimpl.MapValidationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private MapValidationServiceImpl mapValidationErrorService;

    @PostMapping("/add")
    public ResponseEntity<?> createNewCustomer(@Valid @RequestBody Customer customer ,BindingResult result) {
        ResponseEntity<?> errorMap= mapValidationErrorService.mapValidationError(result);
        if(errorMap!=null) {
            return errorMap;
        }
        Customer custom=customerService.saveOrUpdate(customer);
        return new  ResponseEntity<Customer>(custom,HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> getCustomerById(int id){
        Customer custm= customerService.findCustomerById(id);
        return new ResponseEntity<Customer>(custm ,HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<Customer> getAllCustomer(){
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteById(@PathVariable int id){
        customerService.deleteCustomerById(id);
        return new  ResponseEntity<String>("Customer deleted" , HttpStatus.OK);

    }
}
