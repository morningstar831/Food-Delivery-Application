package com.FoodDelivery.Food.Delivery.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Customer {
    /*
     * Id of customer
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private int id;
    /*
     * first name of customer
     */
    @NotBlank(message="First name required")
    @Pattern(regexp="[a-zA-Z]{5,20}" ,message="Name  can only have characters with min size of 5 and max size of 20 ")
    private String firstName;
    /*
     * last name of customer
     */
    @NotBlank(message="Last name required")
    private String lastName;
    /*
     * Age of customer
     */
    @NotNull(message="Age is required")
    private int age;
    /*
     * Gender of customer
     */
    @NotBlank(message="Gender is required")
    @Column(updatable=false)
    private String gender;
    /*
     * Mobile number of customer
     */
    @NotBlank(message="Mobile number is required")
    @Pattern(regexp="(^$|[0-9]{10})" , message="Enter a valid  mobile number")
    private String mobileNumber;
    /*
     * Address of customer
     */
    @OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL , mappedBy="customer")
    private Address address;
    /*
     * Email of customer
     */
    @NotBlank(message="Email is required")
    @Pattern(regexp="[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}" , message="Enter a valid email id")
    @Column(unique=true)
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }




}
