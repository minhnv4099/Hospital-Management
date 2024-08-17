/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import Inventory.ListOfObject;
import Inventory.ListDoctor;
import Inventory.ListDepartment;
import Menu.MainMenu;

/**
 *
 * @author nguyenminh
 */
public class Program {
    private String fileNameSaveDoctor;
    private String fileNameSaveDepartment;
    private String fileNameSavePatient;

    public Program(String fileNameSaveDoctor, String fileNameSaveDepartment, String fileNameSavePatient) {
        this.fileNameSaveDoctor = fileNameSaveDoctor;
        this.fileNameSaveDepartment = fileNameSaveDepartment;
        this.fileNameSavePatient = fileNameSavePatient;
    }
    
    public void start(){
        new MainMenu(this.fileNameSaveDoctor, this.fileNameSaveDepartment, this.fileNameSavePatient).showMenu();
    }
    
   
}
