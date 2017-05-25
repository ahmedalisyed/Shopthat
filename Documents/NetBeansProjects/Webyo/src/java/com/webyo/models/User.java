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
public class User {
    private int Id;
    private String firstName;
    private String lastName;
    private String mailId;
    private String password;
    private Role[] roles;
    public String error;
    
    public User(String firstName, String lastName, String mailId, String password) {
        this.firstName = firstName;
        
        this.lastName = lastName;
        this.mailId = mailId;
        
        this.password = password;
    }

    public User(String mailId, String password) {
        this.mailId = mailId;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Role[] getRoles() {
        return roles;
    }

    public void setRoles(Role[] roles) {
        this.roles = roles;
    }

   
    

   
}
