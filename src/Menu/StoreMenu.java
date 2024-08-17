/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import Inventory.ListOfObject;
import dataobject.Department;
import dataobject.Doctor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 *
 * @author nguyenminh
 */
public class StoreMenu {
    private ListOfObject collec;
    private String fileName;
    
    public StoreMenu(ListOfObject collec,String file){
        this.collec = collec;
        this.fileName = file;
        this.storeCollections();
    }
    
    public void storeCollections(){
        try{
            ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(fileName));
            for(Object item: this.collec){
                objOut.writeObject(item);
            }
            System.out.println("Store successfully");
        }catch(FileNotFoundException e1){}
        catch(IOException e2){
           System.out.println("Can not open object output stream");
        }  
    }
}
