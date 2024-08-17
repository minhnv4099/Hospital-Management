/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataobject;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.text.SimpleDateFormat;

/**
 *
 * @author nguyenminh
 */
public class Department implements Serializable{
    
    private String departmentID;
    private String name;
    private Date creatDate;
    private Date lastUpdateDate;

    public Department(String departmentID, String name) {
        this.departmentID = departmentID;
        this.name = name;
        this.creatDate = Calendar.getInstance().getTime();
        this.lastUpdateDate = this.creatDate;
    }

    public Department() {
        this(null,null);
    }

    public Department(String id){
        this(id,null);
    }
    
    public String getDepartmentID() {
        return departmentID;
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.setLastUpdateDate();
    }

    public String getCreatDate() {
        SimpleDateFormat simFm = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        return simFm.format(this.creatDate);
    }

    public String getLastUpdateDate() {
        SimpleDateFormat simFm = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        return simFm.format(this.lastUpdateDate);
    }

    public void setLastUpdateDate() {
        this.lastUpdateDate = Calendar.getInstance().getTime();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Department other = (Department) obj;
        if (!Objects.equals(this.departmentID, other.departmentID)) {
            return false;
        }
        return true;
    }
    
    public String toString(){
        return String.join("|", this.departmentID,this.name);
    }
    
    public String allInformation(){
        return String.join("|", this.toString(),this.getCreatDate(),this.getLastUpdateDate());
    }
}
