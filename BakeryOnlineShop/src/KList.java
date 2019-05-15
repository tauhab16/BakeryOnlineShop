
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
class KList extends AbstractListModel{
ArrayList<Käufer> kList = new ArrayList<>();

    public void add(Käufer k){
        kList.add(k);
         fireIntervalAdded(this, kList.size()-1, kList.size()-1);
    }

    @Override
    public int getSize() {
        return kList.size();

    }

    @Override
    public Käufer getElementAt(int index) {
        return kList.get(index);
    }
    
}
