
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
/*Diese Klasse beinhaltet das Befüllen der VerkäuferListe aus einer File,
  sowie das speichern der Liste des Käufers, mit allen Produkten,welche er erworben hat.
  Desweiteren generiert sie die Connection und die Table*/
    Verkäufer v;
    Käufer k;
    Connection con;
    Product p;
    File f;

    public BL() throws ClassNotFoundException, SQLException, Exception {
     
    }

    public void load(Verkäufer v, Käufer k  ) throws Exception {
        JFileChooser jf = new JFileChooser();
        int res = jf.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            f = jf.getSelectedFile();
        }

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        int groesse = ois.readInt();
        for (int i = 0; i < groesse; ++i) {
            p = (Product) ois.readObject();
            v.setList(p);
        }
        ois.close();
    }

    public void save() throws Exception {
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
    }


    public void generateTable() throws SQLException, ClassNotFoundException {
        /*Hier wird nun die Connection con initialisiert und eine Table generiert, welche (wenn sie bereits existiert) gedroppt wird
          Die Table trägt den Namen 'prod', welche eine Bezeichnung, die Anzahl der Produkte, sowie einen Preis beinhaltet.
          
          Das Generieren der Table, sowie der Festlegung der Spalten, wird in einem String gespeichert um dann daraus ein
          Statement zu machen, damit es ausgeführt werden kann.
      
        */
        
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/OnlineBackShop", "postgres", "postgres");
        String sql1 = "DROP TABLE IF EXISTS pet;CREATE TABLE pet ( Bezeichnung VARCHAR(20) NOT NULL PRIMARY KEY, Anzahl int, Preis NUMERIC(9,2) );";
        Statement s1 = con.createStatement();
        s1.execute(sql1);

    }

  
}
