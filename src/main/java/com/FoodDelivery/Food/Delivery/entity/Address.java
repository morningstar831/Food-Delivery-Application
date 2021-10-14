package com.FoodDelivery.Food.Delivery.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class Address {
    /*
     * Id of customer
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    /*
     * Building name of address
     */
    private String buildingName;
    /*
     * Street no of address
     */
    private String streetNo;
    /*
     * Area of address
     */
    private String area;
    /*
     * City of address
     */
    private String city;
    /*
     * State of address
     */
    private String state;
    /*
     * Country of address
     */
    private String country;
    /*
     *Pin code of address
     */
    @Pattern(regexp="(^$|[0-9]{6})" , message="enter a valid pin code")
    private String pinCode;

    //One to One Mapping 
    @OneToOne(fetch= FetchType.EAGER)
    @JsonIgnore
    private Customer customer;

    public Address() {
        super();
    }

//Implementing getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }




}
