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
public class User {

    private int balance;

    public User() {
        balance = 0;
    }

    /**
     * {
     *
     * @return 0: so tien khong hop le 1: them vao tai khoan thanh cong 2: them
     * vao tai khoan that bai }
     */
    public int addBalance(int value) {
        if (value < 0) {
            return 0;
        }
        balance += value;
        return 1;
    }

    public int getBalance() {
        return balance;
    }

    public void buy(int value) {
        balance -= value;
    }

    public void withdrawAll() {
        balance = 0;
    }
}
