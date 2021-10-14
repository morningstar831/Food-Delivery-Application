package com.FoodDelivery.Food.Delivery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;


/**
 * This class will be working as data traveler from one layer to another layer
 *
 *
 */
@Entity
public class Item {
    /**
     * Id of Item
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int itemId;
    /**
     * Name of item
     */
    @NotBlank(message="Name required")
    @Pattern(regexp="^[A-Za-z]{5,15}",message = "Name should have minimum 5 characters")
    @Column(unique=true)
    private String itemName;
    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="category_id")
    private Category category;
    private int quantity;
    /**
     * cost of item
     */

    private double cost;
    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="itemList")
    @JsonIgnore
    private List<com.FoodDelivery.Food.Delivery.entity.Restaurant> restaurants;
    //@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    //@JsonIgnore
    //@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    //@JoinColumn(name = "foodcart_id")
    //@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="foodCart_id")
    @JsonIgnore
    private FoodCart cart;

    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public int getItemId() {
        return itemId;
    }
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    public List<com.FoodDelivery.Food.Delivery.entity.Restaurant> getRestaurants() {
        return restaurants;
    }
    public void setRestaurants(List<com.FoodDelivery.Food.Delivery.entity.Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
    public FoodCart getCart() {
        return cart;
    }
    public void setCart(FoodCart cart) {
        this.cart = cart;
    }


}
