/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import dataobject.Doctor;
import dataobject.Department;
import dataobject.Patient;
import java.util.Scanner;
import Inventory.ListOfObject;
import globlas.CheckInput;
import globlas.PatternValidation;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author nguyenminh
 */
public class AddMenu{
    private ListOfObject<Doctor> colDoc;
    private ListOfObject<Department> colDep;
    private ListOfObject<Patient> colPati;
    
    public AddMenu(ListOfObject<Doctor> colDoc,ListOfObject<Department> colDep,ListOfObject<Patient> colPat){
        this.colDoc = colDoc;
        this.colDep = colDep;
        this.colPati = colPat;
    }
    
    public void showMenu(){
        System.out.println("\t ---------------MENU--------------");
        System.out.println("\t|    1. Add new doctor            |");
        System.out.println("\t|    2. Add new department        |");
        System.out.println("\t|    4. Add new patient           |");
        System.out.println("\t|    3. Quit adding               |");
        System.out.println("\t --------------*****--------------");
        System.out.print("     \t Enter you choice(1..4): "); 
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        this.makeChoice(choice);
    }
    
    public void makeChoice(String choice){
        switch(choice){
            case "1" -> addDoctor();
            case "2" -> addDepartment();
            //case "3" -> addPatient();
            case "3" -> {}
            default -> {
                System.out.println("Not in our menu, try again");
                showMenu();
            }
        }
    }
    
    public void addDoctor(){
        String tmpId = CheckInput.processId(CheckInput.input("Enter doctor ID(e.g ab123): ", PatternValidation.doctorPat[0]));
        if(tmpId == null){
            System.out.println("Unvalid doctor id");
            this.showMenu();
        }else{
            if(colDoc.hasElement(tmpId)){
                System.out.println(String.format("Doctor ID %s existed",tmpId));
                this.showMenu();
            }else{
                String tmpName = CheckInput.processName(CheckInput.input("Enter doctor name: ", PatternValidation.doctorPat[1]));
                String tmpGender = CheckInput.processName(CheckInput.input("Enter doctor gender(male/female): ", PatternValidation.doctorPat[2]));
                String tmpAddress = CheckInput.processName(CheckInput.input("Enter doctor address: ", PatternValidation.doctorPat[3]));
                String tmpDepartId = CheckInput.processId(CheckInput.input("Enter ID department(e.g abc123): ", PatternValidation.doctorPat[4]));

                if(tmpName == null | tmpGender == null || tmpAddress == null || tmpDepartId == null){
                    System.out.println("Some informations are not valid, can not add doctor");
                }else{
                    if(colDep.hasElement(tmpDepartId)){
                        colDoc.addElement(new Doctor(tmpId,tmpName,tmpGender,tmpAddress,tmpDepartId));
                        System.out.println(String.format("Doctor ID %s has been added",tmpId));
                        if(CheckInput.input("Continue add new doctor Yes(?) or No(n)?: ", ".*").equalsIgnoreCase("y")){addDoctor();}
                        else {this.showMenu();}
                    }else{
                        System.out.println(String.format("Department ID %s does not exist, can not add doctor",tmpDepartId));
                        this.showMenu();
                    }
                }
            }
        }   
    }
        
    public void addDepartment(){
        String tmpId =  CheckInput.processId(CheckInput.input("Enter department ID(e.g abc123): ", PatternValidation.departPat[0]));
        if(tmpId == null){
            System.out.println("Unvalid department ID");
            showMenu();
        }else{
            if(colDep.hasElement(tmpId)){
                System.out.println(String.format("Department ID %s existed",tmpId));
                this.showMenu();
            }else{
                String tmpName = CheckInput.processName(CheckInput.input("Enter department name: ", PatternValidation.departPat[1]));
                colDep.addElement(new Department(tmpId,tmpName));
                System.out.println(String.format("Department ID %s has been added",tmpId));   
                if(CheckInput.input("Continue add new department Yes(?) or No(n)?: ", ".*").equalsIgnoreCase("y")){addDepartment();}
                else{this.showMenu();}
            }
        }
    }
    
    public void addPatient(){
        String tmpId =  CheckInput.processId(CheckInput.input("Enter patient ID(e.g ab1234): ", PatternValidation.patientPat[0]));
        if(tmpId == null){
            System.out.println("Unvalid Patient ID");
            showMenu();
        }else{
            if(colDep.hasElement(tmpId)){
                System.out.println(String.format("Patient ID %s existed",tmpId));
                this.showMenu();
            }else{
                String tmpName = CheckInput.processName(CheckInput.input("Enter patient name: ", PatternValidation.patientPat[1]));
                String tmpAge = CheckInput.processName(CheckInput.input("Enter patient age: ", PatternValidation.patientPat[2]));
                String tmpAddress = CheckInput.processName(CheckInput.input("Enter patient address: ", PatternValidation.patientPat[3]));
                
                if(tmpName == null || tmpAge == null || tmpAddress == null){
                    System.out.println("Some informations are not valid, can not add patient");
                }else{
                    colPati.addElement(new Patient(tmpId,tmpName,Integer.parseInt(tmpAge),tmpAddress));
                    System.out.println(String.format("Patient ID %s has been added",tmpId));   
                    if(CheckInput.input("Continue add new patient Yes(?) or No(n)?: ", ".*").equalsIgnoreCase("y")){addDepartment();}
                    else{this.showMenu();}
                }   
            }
        }
    }
    
}
