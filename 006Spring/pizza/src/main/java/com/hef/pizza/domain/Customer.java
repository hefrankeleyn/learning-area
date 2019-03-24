package com.hef.pizza.domain;

import java.io.Serializable;

public class Customer implements Serializable {


    private String phoneNumber;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    public Customer(){
      new Customer("000");
    }
    public Customer(String phoneNumber){
        this.phoneNumber=phoneNumber;
        this.name="aaa";
        this.address="BeiJing";
        this.city = "HaiDianQu";
        this.state="30020";
        this.zipCode="34578";
    }

    public Customer(String phoneNumber, String name, String address,
                    String city, String state, String zipCode) {
        this.phoneNumber=phoneNumber;
        this.name=name;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zipCode=zipCode;

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
