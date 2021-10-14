package com.FoodDelivery.Food.Delivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
class CustomExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(com.FoodDelivery.Food.Delivery.exception.ResourceNotFoundException.class)
    public ResponseEntity<?> handleRestaurantNotFoundException(com.FoodDelivery.Food.Delivery.exception.ResourceNotFoundException ex, WebRequest request)
    {
        com.FoodDelivery.Food.Delivery.exception.ExceptionResponse restaurantNotFoundException=new com.FoodDelivery.Food.Delivery.exception.ExceptionResponse(ex.getMessage());
        return new ResponseEntity<Object>(restaurantNotFoundException,HttpStatus.BAD_REQUEST);
    }

}
