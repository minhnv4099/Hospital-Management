/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import Inventory.ListDepartment;
import Inventory.ListDoctor;
import Inventory.ListOfObject;
import dataobject.Doctor;
import java.util.Scanner;
import database.Database;

/**
 *
 * @author nguyenminh
 */
public class MainMenu {
    private Database mydb;
    
    private String file1;
    private String file2;
    private String file3;

    public MainMenu(String file1, String file2, String file3) {
        this.file1 = file1;
        this.file2 = file2;
        this.file3 = file3;
        this.mydb = null;
    }
    
    public void openDatabase(){
        if(this.mydb == null){
            this.mydb = new Database(this.file1,this.file2,this.file3);
        }else{
            System.out.println("The database is opened, open new one may lost data. Ensure that old datas are stored before creating new");
            System.out.println("Now you can not open new!!!");
        }
    }
    
    public void closeDatabase(){
        this.mydb = null;
    }
    
    public void showMenu(){
        System.out.println(" ---------------MENU--------------");
        System.out.println("|    0. Build program             |");
        System.out.println("|    1. Show list information     |");
        System.out.println("|    2. Add new                   |");
        System.out.println("|    3. Update                    |");
        System.out.println("|    4. Delete                    |");
        System.out.println("|    5. Search                    |");
        System.out.println("|    6. Store data                |");
        System.out.println("|    7. Quit menu                 |");
        System.out.println(" --------------*****--------------");
        System.out.print("    Enter you choice(0..7): "); 
        String choice = new Scanner(System.in).nextLine();
        this.makeChoice(choice);
    }
    
    private void makeChoice(String choice){
        try{
            switch(choice){
                case "0" -> this.openDatabase();
                case "1" -> new PrintMenu(this.mydb.getFileDoctor(),this.mydb.getFileDepartment()).showMenu();
                case "2" -> new AddMenu(this.mydb.getDoctorList(), this.mydb.getDepartmentList(),this.mydb.getPatienttList()).showMenu();
                case "3" -> new UpdateMenu(this.mydb.getDoctorList(), this.mydb.getDepartmentList()).showMenu();
                case "4" -> new DeleteMenu(this.mydb.getDoctorList(), this.mydb.getDepartmentList()).showMenu();
                case "5" -> new SearchMenu(this.mydb.getDoctorList(), this.mydb.getDepartmentList()).showMenu();
                case "6" -> {
                    new StoreMenu(this.mydb.getDoctorList(),mydb.getFileDoctor());
                    new StoreMenu(this.mydb.getDepartmentList(),mydb.getFileDepartment());
                    new StoreMenu(this.mydb.getPatienttList(),mydb.getFilePatient());
                }
                case "7" -> {
                    this.closeDatabase();
                    System.exit(0);
                }
            }
            this.showMenu();
        }catch(NullPointerException ex1){
            System.out.println("There is a empty database. You need create database before any performing.");
            this.showMenu();
        }
    }
}
