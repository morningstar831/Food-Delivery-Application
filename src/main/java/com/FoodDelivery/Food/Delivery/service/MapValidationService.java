package com.FoodDelivery.Food.Delivery.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface MapValidationService {

    ResponseEntity<?> mapValidationError(BindingResult result);
}
