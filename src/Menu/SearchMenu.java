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
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nguyenminh
 */
public class SearchMenu {
    private ListOfObject<Doctor> colDoc;
    private ListOfObject<Department> colDep;

    public SearchMenu(ListOfObject<Doctor> colDoc, ListOfObject<Department> colDep) {
        this.colDoc = colDoc;
        this.colDep = colDep;
    }
    
    public void showMenu(){
        System.out.println("\t ---------------MENU--------------");
        System.out.println("\t|    1. Search doctor by name     |");
        System.out.println("\t|    2. Search department by id   |");
        System.out.println("\t|    3. Quit searching            |");
        System.out.println("\t --------------*****--------------");
        System.out.print("     \t Enter you choice(1..3): "); 
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        this.makeChoice(choice);
    }
    
    public void makeChoice(String choice){
        switch(choice){
            case "1" -> this.searchDoctor();
            case "2" -> this.searchDepartment();
            case "3" -> {}
            default -> {System.out.println("Not in our menu");this.showMenu();}
        }
    }
    
    public void searchDoctor(){
        final String tmpName = CheckInput.processName(CheckInput.input("Enter name: ", PatternValidation.doctorPat[1]));
        List<Doctor> desiredDoctors = colDoc.stream().filter((ele) -> ele.getName().equals(tmpName)).toList();
        desiredDoctors.forEach((ele)-> System.out.println(ele));
        this.showMenu();
    }
    
    public void searchDepartment(){
        String tmpId = CheckInput.processId(CheckInput.input("Enter department ID(e.g abc123): ", PatternValidation.departPat[0]));
        if(tmpId == null){
            System.out.println("Unvalid doctor id");
            this.showMenu();
        }else{
            if(!colDep.hasElement(tmpId)){
                System.out.println(String.format("Department ID %s does not exist",tmpId));
                this.showMenu();
            }else{
                System.out.println(colDep.find(tmpId));
                this.showMenu();
            }
        }
    }
}
