package com.FoodDelivery.Food.Delivery.controller;

import com.FoodDelivery.Food.Delivery.entity.OrderDetail;
import com.FoodDelivery.Food.Delivery.service.OrderDetailService;
import com.FoodDelivery.Food.Delivery.serviceimpl.MapValidationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/ofd/api/orderdetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private MapValidationServiceImpl mapValidationServiceImpl;

    @PostMapping("")
    public ResponseEntity<?> addOrderDetail(@Valid @RequestBody OrderDetail orderDetail, BindingResult result)  {
        ResponseEntity<?> errorMap=mapValidationServiceImpl.mapValidationError(result);
        if(errorMap!=null) {
            return errorMap;
        }
        OrderDetail order=orderDetailService.SaveOrUpdate(orderDetail);
        return new ResponseEntity<OrderDetail>(order,HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public OrderDetail findOrderDetail(@PathVariable int id)  {
        OrderDetail order= orderDetailService.findById(id);
        return order;

    }

    @GetMapping("/all")
    public Iterable<OrderDetail> getAllOrders(){
        return orderDetailService.getAllOrderDetails();
    }
    @DeleteMapping("/{id}")
    public void deleteOrderDetail(@PathVariable int id)
    {
        orderDetailService.deleteOrderDetailsById(id);

    }

}
