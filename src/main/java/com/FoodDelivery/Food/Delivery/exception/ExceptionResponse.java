package com.FoodDelivery.Food.Delivery.exception;

public class ExceptionResponse  {

    private String orderNo;
    public ExceptionResponse(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}

