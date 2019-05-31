
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
public class Verkäufer {
    /*
     Der Verkäufer hat einen Namen, sowie eine Liste, welche durch Load in der BL belegt wird, um die Produkte zu speichern
     um sie dann später hochzuladen.
    */
    private String name;
    Product p;
    private ArrayList<Product> list = new ArrayList<>();

    public Verkäufer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public String toString(){
        return name;
    }
    
    public void setList(Product p) {
        this.p=p;
        this.list.add(p);
    }

    public Product getP() {
        return p;
    }

    public ArrayList<Product> getList() {
        return list;
    }
    
    
    
}
