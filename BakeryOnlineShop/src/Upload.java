
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    PreparedStatement st1;
    int place = 0;
    ArrayList<Product> list = new ArrayList<>();

    public Upload(Verkäufer v, Connection con) {
        this.v = v;
        this.con = con;

    }
//listsize 5, count 0 1 2 3 4

    @Override
    public void run() {
        /*Hier erfolt der Upload der Produkte des Verkäuers*/

        synchronized (v) {
//            try {
                System.out.println("Entered the synchronized Block of UPLOAD");
                if (place < v.getList().size()) {
                     try {
            System.out.println("Generating Product");
            p = v.getList().get(place);
            String sql = " INSERT INTO prod (ID,Bezeichnung,Menge,Preis) VALUES(?,?,?,?);";
            
            st1 = con.prepareStatement(sql);
            st1.setInt(1, p.getId());
            st1.setString(2, p.getName());
            st1.setInt(3, p.getAmount());
            st1.setDouble(4, p.getPrice());
            
            System.out.println("Executing sql-Statement");
                    st1.execute();
                    place++;
        } catch (SQLException ex) {
            Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
        }

                    
//                    v.notifyAll();
//                    try {
//                        System.out.println("Upload-Thread start waiting");
//                        v.wait();
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//
//            } catch (SQLException ex) {
//                Logger.getLogger(Upload.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }

    }
    }
}

   

