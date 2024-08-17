/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package globlas;

/**
 *
 * @author nguyenminh
 */
public class PatternValidation {
    private static String patIdDoctor = "^[a-zA-Z]{2}\\d{3}$";
    private static String patNameDoctor = "(?=[a-zA-Z])[a-zA-Z\\s]+$";
    private static String patGenderDoctor = "^[f|F]emale|[M|m]ale$";
    private static String patAddressDoctor = "[\\w|\\d|\\s]+";
    
    private static String patIdDepart = "^[a-zA-Z]{3}\\d{3}$";
    private static String patNameDepart = "(?=[a-zA-Z])[a-zA-Z\\s]+$";
    
    private static String patIdPatient = "^[a-zA-Z]{2}\\d{3}$";
    private static String patNamePatient = "(?=[a-zA-Z])[a-zA-Z\\s]+$";
    private static String patAgePatient = "^\\d{1,3}$";
    private static String patAddressPatient = "[\\w|\\d|\\s]+";
    
    public static final String[] doctorPat = {patIdDoctor,patNameDoctor,patGenderDoctor,patAddressDoctor,patIdDepart};
    public static final String[] departPat = {patIdDepart,patNameDepart};
    public static final String[] patientPat = {patIdPatient,patNamePatient,patAgePatient,patAddressPatient};
}
