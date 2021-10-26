/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadeveloper_nguyenminhkhanh;

import java.util.ArrayList;
import java.util.List;
import model.Machine;
import model.Money;
import model.Product;

/**
 *
 * @author mkhanh
 */
public class JavaDeveloper_NguyenMinhKhanh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Coke", 10000,10));
        products.add(new Product(2, "Pepsi", 10000,10));
        products.add(new Product(3, "Soda", 20000,10));
        
        List<Money> moneys = new ArrayList<Money>();
        moneys.add(new Money(1, 10000, 20));
        moneys.add(new Money(2, 20000, 20));
        moneys.add(new Money(3, 50000, 20));
        moneys.add(new Money(4, 100000, 20));
        moneys.add(new Money(5, 200000, 20));
        
        Machine machine = new Machine(products, moneys);
        
        while(true){
            while(machine.Action());
        }
    }

}
