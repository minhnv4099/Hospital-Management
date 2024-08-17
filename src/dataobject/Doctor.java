/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataobject;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Objects;
/**
 *
 * @author nguyenminh
 */
public class Doctor implements Serializable{
    private String doctId;
    private String name;
    private String gender;
    private String address;
    private String departId;
    private Date createDate;
    private Date lastUpdateDate;


    public Doctor() {
        this(null,null,null,null,null);
    }
    public Doctor(String id){
        this(id,null,null,null,null);
    }
    
    public Doctor(String doctId, String name, String gender, String address, String departId) {
        this.doctId = doctId;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.departId = departId;
        this.createDate = Calendar.getInstance().getTime();
        this.lastUpdateDate = this.createDate;
       
    }
    
    public String getDoctId() {
        return doctId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.setLastUpdateDate();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        this.setLastUpdateDate();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.setLastUpdateDate();
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
        this.setLastUpdateDate();
    }

    public String getCreateDate() {
        SimpleDateFormat simFm = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        return simFm.format(this.createDate);
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
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.doctId);
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
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Doctor other = (Doctor) obj;
        if (!Objects.equals(this.doctId, other.doctId)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return String.join("|",doctId,name,gender,address,departId);
    }
    
    public String allInformation(){
        return String.join("|", this.toString(),this.getCreateDate(),this.getLastUpdateDate());
    }
   
}
