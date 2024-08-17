/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;
import Inventory.ListOfObject;
import dataobject.Department;
import dataobject.Doctor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.ObjectInputStream;

/**
 *
 * @author nguyenminh
 */
public class PrintMenu {
    
    private ListOfObject<Doctor> colDoc;
    private ListOfObject<Department> colDep;
    private String docFile;
    private String depFile;

    public PrintMenu(String docFileName,String depFileName) {
        this.docFile = docFileName;
        this.depFile = depFileName;
        
    }
    
    public void showMenu(){
        System.out.println("\t ---------------MENU--------------");
        System.out.println("\t|    1. Print doctor list        |");
        System.out.println("\t|    2. Print department list    |");
        System.out.println("\t|    3. Quit printing            |");
        System.out.println("\t --------------*****-------------");
        System.out.print("     \t Enter you choice(1..3): "); 
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        this.makeChoice(choice);
    }
    
    public void makeChoice(String choice){
        try{
            switch(choice){
                case "1" -> this.printDoctor();
                case "2" -> this.printDepartment();
                case "3" -> {}
                default -> {
                    System.out.println("Not in our menu");
                    this.showMenu();
                }
            }
        }catch(Exception e){}
    }
    
    public void printDoctor(){
        try{
            ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(this.docFile));
            while(true){
                System.out.println(((Doctor)objIn.readObject()).allInformation());
            }
        }catch(ClassNotFoundException ex1){System.out.println("Readed all object in the file");}
        catch(FileNotFoundException ex2){System.out.println("Can not open the file");}
        catch(IOException ex3){System.out.println("Readed all object in the file");}
        finally{this.showMenu();}
    }
    
    public void printDepartment(){
        try{
            ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(this.depFile));
            while(true){
                System.out.println(((Department)objIn.readObject()).allInformation());
            }
        }catch(ClassNotFoundException ex1){System.out.println("Readed all object in the file");}
        catch(FileNotFoundException ex2){System.out.println("Can not open the file");}
        catch(IOException ex3){System.out.println("Readed all object in the file");}
        finally{this.showMenu();}
    }

}
