
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class BL {
    Verkäufer v;
    Käufer k;
    Connection con;
    
    public BL(Verkäufer v,Käufer k) throws ClassNotFoundException, SQLException{
        this.v=v;
        this.k=k;
        generateProducts();
        generateCon();
        generateTable();
    }

    private void generateProducts() {
        v.setList(new Product("Milch",5,1.0));
        v.setList(new Product("Wasser",5,0.0));
        v.setList(new Product("Brot",5,2.0));
        v.setList(new Product("Kekse",5,2.5));
    }

    private void generateCon() throws ClassNotFoundException, SQLException {
        
        con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/OnlineBackShop","postgres","Hanna2605");
    }

    private void generateTable() throws SQLException {
        String sql1= "DROP TABLE IF EXIST pet;CREATE TABLE pet{Bezeichnung character varying NOT NULL PRIMARY KEY,Anzahl int,Preis NUMBER(9,2)};";
        Statement s1 = con.createStatement();
        s1.execute(sql1);
        
    }
}
