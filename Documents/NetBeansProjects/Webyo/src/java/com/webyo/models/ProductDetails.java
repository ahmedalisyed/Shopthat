/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webyo.models;

import java.sql.Date;

/**
 *
 * @author Welcome
 */
public class ProductDetails {
    private int serialNumber;
    private int productId;
    private Date manufactureDate;
    private Date expiryDate;
    private String size;
    private String color;
    private int sellerId;

    public ProductDetails(int serialNumber, int productId, Date manufactureDate, Date expiryDate, String size, String color, int sellerId) {
        this.serialNumber = serialNumber;
        this.productId = productId;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.size = size;
        this.color = color;
        this.sellerId = sellerId;
    }

    public ProductDetails(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }
}
