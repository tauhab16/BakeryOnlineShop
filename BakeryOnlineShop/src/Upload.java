
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Upload implements Runnable {

    Verkäufer v;
    Connection con;
    Product p;
    Statement st;
    ArrayList<Product> list = new ArrayList<>();

    public Upload(Verkäufer v) {
        this.v = v;
        getProducts();
    }

    @Override
    public void run() {
        /*Hier erfolt der Upload der Produkte des Verkäuers*/
        synchronized (list) {
            for (int i = 0; i < list.size(); i++) {
                try {
                    p = list.get(i);
                    String sql = " INSERT INTO prod VALUES("+p.getName()+","+p.getAmount()+", "+p.getPrice()+");";
                    st = con.createStatement();
                    st.execute(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }

        }

    }

    private void getProducts() {
        int size = v.getList().size();
        for (int i = 0; i < size; i++) {
            list.add(v.getList().get(i));
        }
    }

}
