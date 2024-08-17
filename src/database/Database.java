/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import Inventory.*;
import dataobject.Department;
import dataobject.Doctor;
import dataobject.Patient;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author nguyenminh
 */
public class Database {
    private ListOfObject<Doctor> doctorList;
    private ListOfObject<Department> departmentList;
    private ListOfObject<Patient> patienttList;
    
    private String fileDoctor;
    private String fileDepartment;
    private String filePatient;

    public Database(String docfile,String depFile, String patFile) {
        this.fileDoctor = docfile;
        this.fileDepartment = depFile;
        this.filePatient = patFile;
        
        this.createFile("Doctor", this.fileDoctor);
        this.createFile("Department", this.fileDepartment);
        
        this.createCollections();
    }
    
    public void createDoctorCollections(){
        this.doctorList = new ListDoctor();
        System.out.println("1 collection of Doctor is created to contain old/new data");
        this.takeOldData(this.doctorList, this.fileDoctor);
    }

    public void createDepartmentCollections(){
        this.departmentList = new ListDepartment();
        System.out.println("1 collection of Department is create to contain dold/new data");
        this.takeOldData(this.departmentList, this.fileDepartment);
    }
    
    public void createPatientCollections(){
        this.patienttList = new ListPatient();
        System.out.println("1 collection of Patient is created to contain old/new data");
        this.takeOldData(this.patienttList, this.filePatient);
    }
    
    private void createCollections(){
        this.createDoctorCollections();
        this.createDepartmentCollections();
    }
    
    public void createDoctorFile(){
        try{
            File file = new File(this.fileDoctor);
            if(!file.exists()){
                file.createNewFile();
                System.out.println(String.format("File %s has been created to save Doctor list", this.fileDoctor));
                ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(this.fileDoctor));
            }else{
                System.out.println("The file existed");
            }
        }catch(IOException ex1){
            System.out.println(String.format("Can not create file '%s'",this.fileDoctor));
        }
    }
    
    public void createFile(String target,String fileName){
        try{
            File file = new File(fileName);
            if(!file.exists()){
                file.createNewFile();
                System.out.println(String.format("File %s has been created to save %s list", fileName,target));
                ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fileName));
            }else{
                System.out.println("The file existed");
            }
        }catch(IOException ex1){
            System.out.println(String.format("Can not create file '%s'",fileName));
        }
    }
        
    public void createDepartmentFile(){
        try{
            File file = new File(this.fileDepartment);
            if(!file.exists()){
                file.createNewFile();
                System.out.println(String.format("File %s has been created to save Department list", this.fileDepartment));
                ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(this.fileDepartment));
            }else{
                System.out.println("The file existed");
            }
        }catch(IOException ex1){
            System.out.println(String.format("Can not create file '%s'",this.fileDepartment));
        }
    }
    
    public void takeOldData(ListOfObject col, String fileOldData){
        try{
            ObjectInputStream oldData = new ObjectInputStream(new FileInputStream(fileOldData));
            while(true){
                col.addElement(oldData.readObject());
            }
        }catch(FileNotFoundException ex1){
            System.out.println(String.format("The file '%s' does not exist", fileOldData));
        }catch(IOException ex2){
            System.out.println("All objects are ready in collection");
        }catch(ClassNotFoundException ex3){
            System.out.println("ClassNotFoundException");
        }
    }

    
    public ListOfObject<Doctor> getDoctorList() {return doctorList;}

    public ListOfObject<Department> getDepartmentList() {return departmentList;}
    
     public ListOfObject<Patient> getPatienttList() {return patienttList;}

    public String getFileDoctor() {return fileDoctor;}

    public String getFileDepartment() {return fileDepartment;}
    
    public String getFilePatient() {return filePatient;}
    
    
}
