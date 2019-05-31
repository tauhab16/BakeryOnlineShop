
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class BL{
/**
 * Diese Klasse beinhaltet das Befüllen der VerkäuferListe aus einer File,
 * sowie das speichern der Liste des Käufers, mit allen Produkten,welche er erworben hat.
 * Desweiteren generiert sie die Connection und die Table
 */
    Verkäufer v;
    Käufer k;
    Connection con;
    Product p;
    File f;
    Download d;
    public BL() throws ClassNotFoundException, SQLException, Exception {
     
    }
    public void load(Verkäufer v, Käufer k  ) throws Exception {
        System.out.println("Hopping into load");
        this.v=v;
        this.k=k;
        
        JFileChooser jf = new JFileChooser();
        int res = jf.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            f = jf.getSelectedFile();
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                try{
                String parts[] = line.split(",");
                Product p = new Product(Integer.parseInt(parts[0]),parts[1],Integer.parseInt(parts[2]),Double.parseDouble(parts[3]));
                v.setList(p);
                }catch(Exception ex){
                    //verwirf
                }
            }
        } catch (Exception ex) {
            

        }
        
        
        /**
         * First, a file is chosen, and the list
         * of v is setted with the products extracted from the file
         */
//        System.out.println("Choosing file");
//        JFileChooser jf = new JFileChooser();
//        int res = jf.showOpenDialog(null);
//        if (res == JFileChooser.APPROVE_OPTION) {
//            f = jf.getSelectedFile();
//        }
//
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
//        System.out.println("Reading file");
//        int groesse = ois.readInt();
//        for (int i = 0; i < groesse; ++i) {
//            p = (Product) ois.readObject();
//            this.v.setList(p);
//        }
//        System.out.println("end");
//        ois.close();

                }
    
    public void start() throws Exception{
        System.out.println("Hopping into start");
        Thread up = new Thread(new Upload(v,con));
        
        Thread down = new Thread(new Download(k,con));
        
        up.start();
//        down.start();
        
        
//        save();
    }
    

    public void save() throws Exception {
        System.out.println("Saving");
        JFileChooser jf = new JFileChooser();
        int res = jf.showOpenDialog(null);
        
        if (res == JFileChooser.APPROVE_OPTION) {
            f = jf.getSelectedFile();
        }
        
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeInt(k.getProductList().size());
        for (int i = 0; i < k.getProductList().size(); i++) {
            oos.writeObject((k.getProductList().get(i)));

        }
        oos.flush();
        oos.close();
        System.out.println("Good Night");
    }

    public void createDatabase() throws SQLException{
        String url = "jdbc:postgresql://localhost:5432/";
        String sql = "DROP DATABASE IF EXISTS prod; CREATE DATABASE prod;";
        con = DriverManager.getConnection(url,"postgres","postgres");
         Statement stmt = con.createStatement();   
         stmt.executeUpdate(sql);
         
    }
    public void generateTable() throws SQLException, ClassNotFoundException {
          
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/OnlineBackShop", "postgres", "postgres");
        String sql1 = "DROP TABLE IF EXISTS prod;CREATE TABLE prod (ID int PRIMARY KEY, Bezeichnung VARCHAR(20) NOT NULL, Menge int, Preis NUMERIC(9,2) );";
        Statement s1 = con.createStatement();
        s1.execute(sql1);

    }

  
}
