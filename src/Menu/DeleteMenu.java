/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;
import Inventory.*;
import dataobject.Department;
import dataobject.Doctor;
import globlas.CheckInput;
import globlas.PatternValidation;
import java.util.Scanner;
/**
 *
 * @author nguyenminh
 */
public class DeleteMenu {
    private ListOfObject<Doctor> colDoc;
    private ListOfObject<Department> colDep;
    

    public DeleteMenu(ListOfObject<Doctor> colDoc, ListOfObject<Department> colDep) {
        this.colDoc = colDoc;
        this.colDep = colDep;
    }
    
    
    public void showMenu(){
        System.out.println("\t ---------------MENU--------------");
        System.out.println("\t|    1. Delete a doctor            |");
        System.out.println("\t|    2. Delete a department        |");
        System.out.println("\t|    3. Quit Deleting              |");
        System.out.println("\t --------------*****--------------");
        System.out.print("     \t Enter you choice(1..3): "); 
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        this.makeChoice(choice);
    }
    
    public void makeChoice(String choice){
        switch(choice){
            case "1" -> this.deleteDoctor();
            case "2" -> this.deleteDepartment();
            case "3" -> {}
            default -> {System.out.println("Not in our menu"); this.showMenu();}
        }
    }
    
    public void deleteDoctor(){
        String tmpId = CheckInput.processId(CheckInput.input("Enter doctor ID(e.g ab123): ", PatternValidation.doctorPat[0]));
        if(tmpId == null){
            System.out.println("Unvalid doctor id");
            this.showMenu();
        }else{
            if(!colDoc.hasElement(tmpId)){
                System.out.println(String.format("Doctor ID %s does not exist",tmpId));
                this.showMenu();
            }else{
                System.out.print("Do you ensure to delete doctor ID: "+tmpId);
                if(new Scanner(System.in).nextLine().strip().equalsIgnoreCase("y")){
                    colDoc.deleteElement(colDoc.find(tmpId));
                    System.out.println(String.format("Doctor ID %s has been removed",tmpId));
                }else System.out.println("Delete fail");
                this.showMenu();
            }
        }   
    }
    
    public void deleteDepartment(){
        String tmpId = CheckInput.processId(CheckInput.input("Enter department ID(e.g abc123): ", PatternValidation.departPat[0]));
        if(tmpId == null){
            System.out.println("Unvalid doctor id");
            this.showMenu();
        }else{
            if(!colDep.hasElement(tmpId)){
                System.out.println(String.format("Department ID %s does not exist",tmpId));
                this.showMenu();
            }else{
                if(colDoc.stream().filter((ele)-> ele.getDepartId().equals(tmpId)).count() == 0){
                    System.out.print("Do you ensure to delete department ID: "+tmpId);
                    if(new Scanner(System.in).nextLine().strip().equalsIgnoreCase("y")){
                        colDep.deleteElement(colDep.find(tmpId));
                        System.out.println(String.format("Department ID %s has been removed",tmpId));
                    }else System.out.println("Delete fail");
                }else System.out.println(String.format("Can not delete departement ID %s, as there are doctor here!!!", tmpId));
                this.showMenu();
            }
        }
    }
}
