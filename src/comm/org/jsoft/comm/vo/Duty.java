package org.jsoft.comm.vo;

import java.util.HashSet;
import java.util.Set;


/**
 * Duty entity. @author MyEclipse Persistence Tools
 */

public class Duty  implements java.io.Serializable {


    // Fields    

     private String dutyId;
     private String dutyName;
     private Integer isDelete;
     private Set personnelinfos = new HashSet(0);


    // Constructors

    /** default constructor */
    public Duty() {
    }

	/** minimal constructor */
    public Duty(String dutyId) {
        this.dutyId = dutyId;
    }
    
    /** full constructor */
    public Duty(String dutyId, String dutyName, Integer isDelete, Set personnelinfos) {
        this.dutyId = dutyId;
        this.dutyName = dutyName;
        this.isDelete = isDelete;
        this.personnelinfos = personnelinfos;
    }

   
    // Property accessors

    public String getDutyId() {
        return this.dutyId;
    }
    
    public void setDutyId(String dutyId) {
        this.dutyId = dutyId;
    }

    public String getDutyName() {
        return this.dutyName;
    }
    
    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public Integer getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Set getPersonnelinfos() {
        return this.personnelinfos;
    }
    
    public void setPersonnelinfos(Set personnelinfos) {
        this.personnelinfos = personnelinfos;
    }
   








}