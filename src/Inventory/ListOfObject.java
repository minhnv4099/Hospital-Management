/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory;

import java.util.HashSet;
import java.util.Set;
import actionsinterface.ListObjectADT;
import Menu.AddMenu;

/**
 *
 * @author nguyenminh
 */
public abstract class ListOfObject<E> extends HashSet<E> implements ListObjectADT<E,String> {
   
    public abstract E find(String key);
    
    @Override
    public void addElement(E ele) {
        this.add(ele);
    }

    @Override
    public void deleteElement(E ele) {
        this.remove(ele);
    }
    
    @Override
    public boolean hasElement(String key) {
        return this.find(key) != null;
    }
}
