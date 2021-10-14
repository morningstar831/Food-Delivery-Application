package com.FoodDelivery.Food.Delivery.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @OneToOne(fetch=FetchType.EAGER,cascade= CascadeType.ALL)
    @JoinColumn(name="orderDetail_id")
    private com.FoodDelivery.Food.Delivery.entity.OrderDetail order;
    private Date billDate;
    private  Date created_At;
    private Date updated_At;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getBillDate() {
        return billDate;
    }
    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }
    public Date getCreated_At() {
        return created_At;
    }
    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }
    public Date getUpdated_At() {
        return updated_At;
    }
    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }
    @PrePersist
    public void onCreate() {
        this.created_At = new Date();

    }
    @PostUpdate
    public void onUpdate() {
        this.updated_At = new Date();
    }
    public com.FoodDelivery.Food.Delivery.entity.OrderDetail getOrder() {
        return order;
    }
    public void setOrder(com.FoodDelivery.Food.Delivery.entity.OrderDetail order) {
        this.order = order;
    }

}
