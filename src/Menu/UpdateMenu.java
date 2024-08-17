/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import Inventory.ListOfObject;
import dataobject.Department;
import dataobject.Doctor;
import globlas.CheckInput;
import globlas.PatternValidation;
import java.util.Scanner;

/**
 *
 * @author nguyenminh
 */
public class UpdateMenu{
    private ListOfObject<Doctor> colDoc;
    private ListOfObject<Department> colDep;
    
    public UpdateMenu(ListOfObject<Doctor> colDoc,ListOfObject<Department> colDep){
        this.colDoc = colDoc;
        this.colDep = colDep;
    }
    
    public void showMenu(){
        System.out.println("\t ---------------MENU--------------");
        System.out.println("\t|    1. Update a doctor            |");
        System.out.println("\t|    2. Update a department        |");
        System.out.println("\t|    3. Quit updateing             |");
        System.out.println("\t --------------*****--------------");
        System.out.print("     \t Enter you choice(1..3): "); 
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        this.makeChoice(choice);
    }
    
    public void makeChoice(String choice){
        switch(choice){
            case "1" -> updateDoctor();
            case "2" -> updateDepartment();
            case "3" -> {}
            default -> {
                System.out.println("Not in our menu, try again");
                showMenu();
            }
        }
    }
    
    public void updateDoctor(){
        String tmpId = CheckInput.processId(CheckInput.input("Enter doctor ID(e.g ab123): ", PatternValidation.doctorPat[0]));
        if(tmpId == null){
            System.out.println("Unvalid doctor id");
            this.showMenu();
        }else{
            if(!colDoc.hasElement(tmpId)){
                System.out.println(String.format("Doctor ID %s does not exist",tmpId));
                this.showMenu();
            }else{
                colDoc.updateElement(tmpId,colDep);
                this.showMenu();
            }
        }   
    }
        
    public void updateDepartment(){
        String tmpId = CheckInput.processId(CheckInput.input("Enter department ID(e.g abc123): ", PatternValidation.departPat[0]));
        if(tmpId == null){
            System.out.println("Unvalid doctor id");
            this.showMenu();
        }else{
            if(!colDep.hasElement(tmpId)){
                System.out.println(String.format("Department ID %s does not exist",tmpId));
                this.showMenu();
            }else{
                colDep.updateElement(tmpId,null);
                this.showMenu();
            }
        }
    }
}
