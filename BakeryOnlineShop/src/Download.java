
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Download implements Runnable {

    Product p;
    Connection con3;
    static Käufer k;
    ResultSet rs, rs1;
    Statement stnt;
    int c = 0;
    boolean exit = false;

    public Download(Käufer k, Connection con) {
        this.k = k;
        this.con3 = con;
    }

    @Override
    public void run() {

        synchronized (k) {
            System.out.println("Entered the synchronized-Block of DOWNLOAD");
            while (!exit) {
                try {
                    c++;
                    stnt = con3.createStatement();
                    rs = stnt.executeQuery("SELECT COUNT(*) AS count FROM prod");
                    rs.next();

                    if (0 != rs.getInt("count")) {
                        System.out.println("Amount of Rows is not 0, will now start executing Statements");
                        

                        String getProd = "SELECT * from prod WHERE id=" + c;
                        String delProd = "DELETE FROM prod WHERE id=" + c;
                        
                        rs1 = stnt.executeQuery(getProd);
                        p = new Product(rs1.getInt("ID"), rs1.getString("Bezeichnung"), rs1.getInt("Menge"), rs1.getDouble("Preis"));
                        k.add(p);

                        stnt.executeUpdate(delProd);
                        System.out.println("Received Product and deleted its Row in the Database");
                        k.notifyAll();
                        try {
                            System.out.println("Download-Thread starts waiting");
                            k.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        System.out.println("Enthält keine Daten");
                        exit=true;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }

    public static Käufer retK() {
        return k;
    }

}
