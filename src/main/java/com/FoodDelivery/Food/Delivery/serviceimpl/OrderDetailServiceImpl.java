package com.FoodDelivery.Food.Delivery.serviceimpl;

import com.FoodDelivery.Food.Delivery.entity.FoodCart;
import com.FoodDelivery.Food.Delivery.entity.OrderDetail;
import com.FoodDelivery.Food.Delivery.exception.ResourceNotFoundException;
import com.FoodDelivery.Food.Delivery.repository.OrderDetailRepository;
import com.FoodDelivery.Food.Delivery.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this OrderDetailService class is used for performing all business related operations
 *
 *
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderRepository;


    public OrderDetail SaveOrUpdate(OrderDetail orderDetail)  {
        try {
            orderDetail.setOrderNo(orderDetail.getOrderNo().toUpperCase());
            FoodCart cart=new FoodCart();
            orderDetail.setCart(cart);
            cart.setOrderDetail(orderDetail);
            cart.setOrderNo(orderDetail.getOrderNo().toUpperCase());
            return orderRepository.save(orderDetail);
        }
        catch(Exception e) {
            throw new ResourceNotFoundException(orderDetail.getOrderNo().toUpperCase()+"  already exist");
        }
    }

    public List<OrderDetail> getAllOrderDetails(){
        return orderRepository.findAll();
    }

    public void deleteOrderDetailsById(int id)  {
        OrderDetail order=orderRepository.findById(id);
        if(order==null) {
            throw new ResourceNotFoundException("Order Id doesn't exists");
        }
        orderRepository.deleteById(id);
    }

    @Override
    public OrderDetail findById(int id) {
        OrderDetail order=orderRepository.findById(id);
        if(order==null) {
            throw new ResourceNotFoundException("Order Id doesn't exists");
        }
        return order;
    }


}
