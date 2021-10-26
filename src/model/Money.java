/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mkhanh
 */
public class Money {
    private int code;
    private int price;
    private int quantity;
    
    public Money(int code, int price, int quantity){
        this.code=code;
        this.price=price;
        this.quantity=quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }
    
    public void refundQuantity(int quantity) {
        this.quantity -= quantity;
    }
    
}
