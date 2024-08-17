/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Main.Program;
/**
 *
 * @author nguyenminh
 */

public class Main {
    public static void main(String[] argv) throws Exception{
        final String fileDoc = "./src/database/doctor.dat";
        final String fileDep = "./src/database/department.dat";
        final String filePat = "./src/database/patient.dat";
        
        Program programOne = new Program(fileDoc,fileDep,filePat);
        programOne.start();
    }
}
