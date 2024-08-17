/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory;

import dataobject.Department;
import dataobject.Doctor;
import globlas.CheckInput;
import globlas.PatternValidation;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author nguyenminh
 */
public class ListDepartment extends ListOfObject<Department>{

    @Override
    public Department find(String key) {
        try{
            return this.stream().filter((ele)-> ele.getDepartmentID().equals(key)).findFirst().get();
        }catch(NoSuchElementException e){
            return null;
        }
    }
    
    @Override
    public void updateElement(String key,ListOfObject col) {
        Department tmpDepart = this.find(key);
        String[] arrInfo = tmpDepart.toString().split("\\|");
        System.out.println("\t ---------------MENU--------------");
        System.out.println("\t|    1. Update department name    |");
        System.out.println("\t|    2. Quit updating             |");
        System.out.println("\t --------------*****--------------");
        System.out.print("     \t Enter you choice(1..2): ");
        try{
            int choice = new Scanner(System.in).nextInt();
            if(choice == 2){
                // quit updating
                // do nothing
            }else{
                System.out.println("Old information: "+arrInfo[choice]);
                String tmpInfo = CheckInput.input("Enter new information: ", PatternValidation.departPat[choice]);
                if(tmpInfo == null){
                    System.out.println("Invalid information, update fail");
                    this.updateElement(key, null);
                }else{
                    switch(choice){
                        case 0:
                            System.out.println("ID can not be changed");
                        case 1:
                            tmpDepart.setName(CheckInput.processName(tmpInfo));
                            break;
                    }
                    System.out.println("Update successfully");
                    this.updateElement(key, null);
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Let input choice with integer");
            this.updateElement(key, null);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Not in our menu");
            this.updateElement(key, null);
        }
    
    }
}
