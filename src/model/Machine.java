/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mkhanh
 */
public class Machine {

    private List<Product> products;
    private List<Money> moneys;
    private User user;

    Scanner cin = new Scanner(System.in);

    public Machine(List<Product> products, List<Money> moneys) {
        this.products = products;
        this.moneys = moneys;
        this.user = null;
    }

    public void newUser() {
        user = new User();
    }

    public void logout() {
        this.user = null;
    }

    public boolean Action() {
        System.out.println("_______________________");
        if (user == null) {
            System.out.println("NEW USER");
            newUser();
        } else {
            CheckBalance();
        }
        System.out.println("_______________________");
        System.out.println("Choose option:");
        System.out.println("1.Deposit.");
        System.out.println("2.Check balance.");
        System.out.println("3.Choose Item.");
        System.out.println("4.Cancel Request.");

        int choice = cin.nextInt();
        switch (choice) {
            case 1:
                Deposit();
                break;
            case 2:
                CheckBalance();
                break;
            case 3:
                while (ChooseItem());
                break;
            case 4:
                ReturnMoney();
                logout();
                break;
            default:
                System.out.println("Choose again!");
                return true;
        }
        return false;
    }

    public void Deposit() {
        int idMoney = -1;
        System.out.println("Choose coin value:");
        for (int i = 0; i < moneys.size(); i++) {
            System.out.println(moneys.get(i).getCode() + ". " + moneys.get(i).getPrice() + " VND");
        }
        int code = cin.nextInt();

        for (int i = 0; i < moneys.size(); i++) {
            if (moneys.get(i).getCode() == code) {
                idMoney = i;
                break;
            }
        }
        int numberOfCoin = 0;

        if (idMoney >= 0) {
            while (numberOfCoin <= 0) {
                System.out.println("Number of coin:");
                numberOfCoin = cin.nextInt();
                moneys.get(idMoney).addQuantity(numberOfCoin);
                user.addBalance(numberOfCoin * moneys.get(idMoney).getPrice());
            }
        }
        CheckBalance();
        return;

    }

    public boolean ChooseItem() {
        System.out.println("Choose item:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getCode()
                    + ". " + products.get(i).getName() + " :"
                    + products.get(i).getPrice());
        }

        System.out.println("0. Back:");
        cin.nextLine();
        int code = cin.nextInt();
        if (code == 0) {
            return true;
        }
        for (int i = 0; i < products.size(); i++) {
            if (code == products.get(i).getCode()) {
                if (user.getBalance() >= products.get(i).getPrice()) {
                    if (products.get(i).getQuantity() > 0) {
                        int numberOfItem = 0;
                        while (numberOfItem <= 0) {
                            System.out.println("Number of " + products.get(i).getName() + ":");
                            numberOfItem = cin.nextInt();
                            if (user.getBalance() < products.get(i).getPrice() * numberOfItem) {
                                numberOfItem = 0;
                                System.out.println("Not enough money to buy, buy less item!");
                                return false;
                            }
                        }
                        products.get(i).minusQuantity(numberOfItem);
                        BuyItem(products.get(i).getPrice() * numberOfItem);
                        System.out.println("You get " + numberOfItem + " " + products.get(i).getName());

                    } else {
                        System.out.println("Out of stock, please select a different item.");
                        return false;
                    }

                } else {
                    System.out.println("Not enough money to buy, choose another item!");
                    return false;
                }
                break;
            }
        }
        return true;
    }

    public void BuyItem(int value) {
        user.buy(value);
    }

    public void ReturnMoney() //resets balance to 0 (Refunds money back to user)
    {
        System.out.println("Your change:");
        for (int i = moneys.size() - 1; i >= 0; i--) {
            if (user.getBalance() > moneys.get(i).getPrice()) {
                int num = user.getBalance() / moneys.get(i).getPrice();
                user.buy(num * moneys.get(i).getPrice());
                System.out.println(num + " x " + moneys.get(i).getPrice() + "VND");
            }
        }
        if (user.getBalance() > 0) {
            System.out.println("You have " + user.getBalance()
                    + " VND left, but machine is out of cash!");
        }

    }

    public int CalTotal(List<Money> moneysDeposite) {
        int total = 0;
        for (int i = 0; i < moneysDeposite.size(); i++) {
            total += moneys.get(i).getPrice() * moneys.get(i).getQuantity();
        }
        return total;
    }

    public int FindCoin(List<Money> moneys, int code) {
        int idx = -1;
        for (int i = 0; i < moneys.size(); i++) {
            if (code == moneys.get(i).getCode()) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    public void CheckBalance() {
        System.out.println("Your balance: " + user.getBalance());
    }

}
