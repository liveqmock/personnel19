package org.jsoft.comm.vo;

import java.sql.Timestamp;


/**
 * Peoc entity. @author MyEclipse Persistence Tools
 */

public class Peoc  implements java.io.Serializable {


    // Fields    

     private String peocId;
     private Encorchast encorchast;
     private Personnelinfo personnelinfo;
     private Timestamp peocDate;
     private String peocReason;
     private String personnelTrainRemark;
     private Integer isDelete;


    // Constructors

    /** default constructor */
    public Peoc() {
    }

	/** minimal constructor */
    public Peoc(String peocId) {
        this.peocId = peocId;
    }
    
    /** full constructor */
    public Peoc(String peocId, Encorchast encorchast, Personnelinfo personnelinfo, Timestamp peocDate, String peocReason, String personnelTrainRemark, Integer isDelete) {
        this.peocId = peocId;
        this.encorchast = encorchast;
        this.personnelinfo = personnelinfo;
        this.peocDate = peocDate;
        this.peocReason = peocReason;
        this.personnelTrainRemark = personnelTrainRemark;
        this.isDelete = isDelete;
    }

   
    // Property accessors

    public String getPeocId() {
        return this.peocId;
    }
    
    public void setPeocId(String peocId) {
        this.peocId = peocId;
    }

    public Encorchast getEncorchast() {
        return this.encorchast;
    }
    
    public void setEncorchast(Encorchast encorchast) {
        this.encorchast = encorchast;
    }

    public Personnelinfo getPersonnelinfo() {
        return this.personnelinfo;
    }
    
    public void setPersonnelinfo(Personnelinfo personnelinfo) {
        this.personnelinfo = personnelinfo;
    }

    public Timestamp getPeocDate() {
        return this.peocDate;
    }
    
    public void setPeocDate(Timestamp peocDate) {
        this.peocDate = peocDate;
    }

    public String getPeocReason() {
        return this.peocReason;
    }
    
    public void setPeocReason(String peocReason) {
        this.peocReason = peocReason;
    }

    public String getPersonnelTrainRemark() {
        return this.personnelTrainRemark;
    }
    
    public void setPersonnelTrainRemark(String personnelTrainRemark) {
        this.personnelTrainRemark = personnelTrainRemark;
    }

    public Integer getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
   








}