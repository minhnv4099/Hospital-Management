/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventory;
import dataobject.Doctor;
import java.util.NoSuchElementException;
import java.util.Scanner;
import globlas.CheckInput;
import globlas.PatternValidation;
/**
 *
 * @author nguyenminh
 */
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ListDoctor extends ListOfObject<Doctor> {

    @Override
    public Doctor find(String key) {
        try{
            return this.stream().filter((ele)-> ele.getDoctId().equals(key)).findFirst().get();
        }catch(NoSuchElementException e){
            return null;
        }
    }

    @Override
    public void updateElement(String key,ListOfObject colDep) {
        Doctor doctor = this.find(key);
        String[] arrInfo = doctor.toString().split("\\|");
        System.out.println("\t ---------------MENU--------------");
        System.out.println("\t|    1. Update doctor name        |");
        System.out.println("\t|    2. Update doctor gender      |");
        System.out.println("\t|    3. Update doctor address     |");
        System.out.println("\t|    4. Update department ID      |");
        System.out.println("\t|    5. Quit updating doctor      |");
        System.out.println("\t --------------*****--------------");
        System.out.print("     \t Enter you choice(1..5): "); 
        try{
            int choice = new Scanner(System.in).nextInt();
            if(choice == 5){
                // here will quit updating
                // do nothing
            }else{
                System.out.println("Old information: "+arrInfo[choice]);
                String tmpInfo = CheckInput.input("Enter new information: ", PatternValidation.doctorPat[choice]);
                if(tmpInfo == null){
                    System.out.println("Invalid information, update fail");
                    this.updateElement(key, colDep);
                }else{
                    switch(choice){
                        case 0:
                            System.out.println("ID can not be changed");
                        case 1:
                            doctor.setName(CheckInput.processName(tmpInfo));
                            break;
                        case 2:
                            doctor.setGender(CheckInput.processName(tmpInfo));
                            break;
                        case 3:
                            doctor.setAddress(CheckInput.processName(tmpInfo));
                            break;
                        case 4:
                            tmpInfo = CheckInput.processId(tmpInfo);
                            if(colDep.find(tmpInfo) == null)
                                System.out.println(String.format("Department ID %s does not exist",tmpInfo));
                            else
                                doctor.setDepartId(tmpInfo);
                            break;
                    }
                    System.out.println("Update successfully");
                    this.updateElement(key, colDep);
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Let input choice with integer");
            this.updateElement(key, colDep);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Not in our menu");
            this.updateElement(key, colDep);
        }
    }
}
