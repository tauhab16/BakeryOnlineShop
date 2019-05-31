
import java.io.Serializable;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Product implements Serializable{
    private String name;
    private int amount,id;
    private double price;

    public Product(int id,String name, int amount, double price) {
        this.id=id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }
    public int getId(){
        return id;
    }
    
}
