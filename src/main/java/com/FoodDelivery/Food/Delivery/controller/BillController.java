//package com.FoodDelivery.Food.Delivery.controller;
//
//import com.FoodDelivery.Food.Delivery.entity.Bill;
//import com.FoodDelivery.Food.Delivery.service.BillService;
//import com.FoodDelivery.Food.Delivery.serviceimpl.MapValidationServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.Map;
//import java.util.Set;
//
//@RestController
//@RequestMapping("/bill")
//public class BillController {
//
//    @Autowired
//    private BillService billService;
//    @Autowired
//    private MapValidationServiceImpl mapValidationServiceImpl;
//
//    @GetMapping("/getAllBills")
//    public Set<Bill> getAllBills() {
//        return billService.getAllBills();
//
//
//    }
//
//    @PostMapping("/saveBill")
//    public  ResponseEntity<?> saveBill(@Valid @RequestBody Bill bill,BindingResult result) {
//        ResponseEntity<?> errorMap=mapValidationServiceImpl.mapValidationError(result);
//        if(errorMap!=null)
//        {
//            return errorMap;
//        }
//        Bill billStore=billService.saveOrUpdate(bill);
//        return new ResponseEntity<Bill>(billStore,HttpStatus.OK);
//
//    }
//    @DeleteMapping("/deleteBill")
//    public  ResponseEntity<Map<String, Object>> deleteBill(Integer billId) {
//        return null;
//
//    }
//
//    @GetMapping("/getBill")
//    public int getBill(int bill_Id) {
//        int totalCost=billService.calculateBill(bill_Id);
//        return totalCost;
//
//
//    }
//
//
//}
