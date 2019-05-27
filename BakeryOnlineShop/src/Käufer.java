
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Käufer {
    /*
       Der Käufer braucht nicht mehr als einen Namen und eine Liste in der er die Produkte später speichert.
       Die Liste ist bereits erstellt, der Name wird noch festgelegt (durch ADD in der GUI)
       
       Die Liste kann returnt, werden um zB gespeichert zu werden.
    */
    String name;
    ArrayList<Product> productList = new ArrayList<>();

    public Käufer(String name) {
        this.name = name;
    }
    
    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }

    public void add(Product p){
        productList.add(p);
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }
    
    
    
    
    
    
}
