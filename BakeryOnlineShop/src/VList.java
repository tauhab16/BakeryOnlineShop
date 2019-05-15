
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
class VList extends AbstractListModel{
ArrayList<Verkäufer> vList = new ArrayList<>();
    
    public void add(Verkäufer v){
        vList.add(v);
        fireIntervalAdded(this, vList.size()-1, vList.size()-1);
    }

    @Override
    public int getSize() {
        return vList.size();
    }

    @Override
    public Verkäufer getElementAt(int index) {
        return vList.get(index);
    }
    
}
