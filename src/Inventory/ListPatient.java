/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory;

import dataobject.Patient;
import java.util.NoSuchElementException;

/**
 *
 * @author nguyenminh
 */
public class ListPatient extends ListOfObject<Patient>{

    @Override
    public Patient find(String key) {
        try{
            return this.stream().filter((ele) -> ele.getId().equals(key)).findFirst().get();
        }catch(NoSuchElementException e){
            return null;
        }
    }

    @Override
    public void updateElement(String key, ListOfObject col) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
