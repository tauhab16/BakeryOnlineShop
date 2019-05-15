
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Product {
    private String name;
    private String amount;
    private double price;

    public Product(String name, String amount, double price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }
    
    
}
