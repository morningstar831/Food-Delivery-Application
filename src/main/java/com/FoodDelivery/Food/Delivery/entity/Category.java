package com.FoodDelivery.Food.Delivery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * this class acts as data traveller from one layer to another
 *
 *
 */
@Entity
public class Category {
    /**
     * Category id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int categoryId;
    /**
     * category name
     */
    @NotBlank(message="required")
    private String name;
    @OneToOne(mappedBy="category")
    @JsonIgnore
    private com.FoodDelivery.Food.Delivery.entity.Item item;
    public int getId() {
        return categoryId;
    }
    public void setId(int id) {
        this.categoryId = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public com.FoodDelivery.Food.Delivery.entity.Item getItem() {
        return item;
    }
    public void setItem(com.FoodDelivery.Food.Delivery.entity.Item item) {
        this.item = item;
    }



}
