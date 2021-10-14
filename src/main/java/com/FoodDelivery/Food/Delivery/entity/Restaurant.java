package com.FoodDelivery.Food.Delivery.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;


/**
 * This class will be working as a data traveler object from layer to layer
 *
 *
 */
@Entity
public class Restaurant {
    /**
     * Id of Restaurant
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    /**
     * Name of restaurant
     */
    @NotBlank(message="Restaurant name required")
    private String name;
    //OneToOne relation with Address class
    //ManyToMany  relation with Item class
    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Item> itemList;
    @Pattern(regexp="^[A-Za-z]{5,15}",message = "Invalid Input")
    private String managerName;
    @NotBlank(message="Contact number is required ")
    //@Pattern(regexp="",message="Enter a valid phone number")
    private String contactNumber;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getManagerName() {
        return managerName;
    }
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public List<Item> getItemList() {
        return itemList;
    }
    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }



}
