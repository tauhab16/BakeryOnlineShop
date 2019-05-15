
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
    String name;
    ArrayList<Product> productList = new ArrayList<>();

    public Käufer(String name) {
        this.name = name;
    }
    
    public String toString(){
        return name;
    }
    
    
    
    
    
}
