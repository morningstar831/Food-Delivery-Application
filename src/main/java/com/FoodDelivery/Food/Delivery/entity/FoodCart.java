package com.FoodDelivery.Food.Delivery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FoodCart {

    /**
     * id of Food Cart
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    //One to one relationship
    @OneToOne(fetch=FetchType.EAGER)
    @JsonIgnore
    private com.FoodDelivery.Food.Delivery.entity.OrderDetail orderDetail;
    //One to many relationship

    //@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    //@JoinColumn(name="item_idd")
    //@JsonIgnore
    //@JsonIgnore
    //@OneToMany(mappedBy = "cart",
    // cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "cart",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private Set<com.FoodDelivery.Food.Delivery.entity.Item> itemList;

    @Column(unique=true,updatable=false)
    private String orderNo;
    public FoodCart() {
        super();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public com.FoodDelivery.Food.Delivery.entity.OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(com.FoodDelivery.Food.Delivery.entity.OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }


    public Set<com.FoodDelivery.Food.Delivery.entity.Item> getItemList() {
        return itemList;
    }


    public void setItemList(Set<com.FoodDelivery.Food.Delivery.entity.Item> itemList) {
        this.itemList = itemList;
    }


    public String getOrderNo() {
        return orderNo;
    }


    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }


}
