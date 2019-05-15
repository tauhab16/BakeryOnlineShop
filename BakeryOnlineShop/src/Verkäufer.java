
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
    private String name;
    private ArrayList<Product> list = new ArrayList<>();

    public Verkäufer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getList() {
        return list;
    }
    
    
}
