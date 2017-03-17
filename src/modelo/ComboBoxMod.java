/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Rosa Sandoval
 */

public class ComboBoxMod implements ComboBoxModel {
    
    ArrayList<ComboBoxItem> itemsArr;
    ComboBoxItem selecteditem;
    
    public ComboBoxMod(){
        itemsArr = new ArrayList();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selecteditem = (ComboBoxItem) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return this.selecteditem;
    }

    @Override
    public int getSize() {
        return itemsArr.size();
    }

    @Override
    public Object getElementAt(int index) {
        return itemsArr.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addItem(ComboBoxItem item){
        this.itemsArr.add(item);
    }

    
    
}
