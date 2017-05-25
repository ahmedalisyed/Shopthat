/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webyo.models;

/**
 *
 * @author Welcome
 */
public class ShippingAdd {
    String userName;
    String Location;
    String State;
    int pinCode;
    String userId;
    int phoneNumber;

    public ShippingAdd(String userName, String Location, String State, int pinCode, String userId, int phoneNumber) {
        this.userName = userName;
        this.Location = Location;
        this.State = State;
        this.pinCode = pinCode;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    

    public String getLocation() {
        return Location;
    }

    

    public String getState() {
        return State;
    }

   

    public int getPinCode() {
        return pinCode;
    }

   

    public String getUserId() {
        return userId;
    }

  
    public int getPhoneNumber() {
        return phoneNumber;
    }

   
    
    
    
}
