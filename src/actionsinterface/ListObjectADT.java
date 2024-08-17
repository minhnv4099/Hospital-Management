/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actionsinterface;
import Inventory.ListOfObject;

/**
 *
 * @author nguyenminh
 */
public interface ListObjectADT<E,K> {
    void addElement(E ele);
    void updateElement(K key, ListOfObject col);
    void deleteElement(E ele);
    boolean hasElement(K key);
}
