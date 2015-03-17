package org.jsoft.comm.vo;

import java.sql.Timestamp;


/**
 * Personneltrain entity. @author MyEclipse Persistence Tools
 */

public class Personneltrain  implements java.io.Serializable {


    // Fields    

     private String personnelTrainId;
     private Personnelinfo personnelinfo;
     private Timestamp personnelTrainDate;
     private String personnelTrainConten;
     private String personnelTrainRemark;
     private Integer isDelete;


    // Constructors

    /** default constructor */
    public Personneltrain() {
    }

	/** minimal constructor */
    public Personneltrain(String personnelTrainId) {
        this.personnelTrainId = personnelTrainId;
    }
    
    /** full constructor */
    public Personneltrain(String personnelTrainId, Personnelinfo personnelinfo, Timestamp personnelTrainDate, String personnelTrainConten, String personnelTrainRemark, Integer isDelete) {
        this.personnelTrainId = personnelTrainId;
        this.personnelinfo = personnelinfo;
        this.personnelTrainDate = personnelTrainDate;
        this.personnelTrainConten = personnelTrainConten;
        this.personnelTrainRemark = personnelTrainRemark;
        this.isDelete = isDelete;
    }

   
    // Property accessors

    public String getPersonnelTrainId() {
        return this.personnelTrainId;
    }
    
    public void setPersonnelTrainId(String personnelTrainId) {
        this.personnelTrainId = personnelTrainId;
    }

    public Personnelinfo getPersonnelinfo() {
        return this.personnelinfo;
    }
    
    public void setPersonnelinfo(Personnelinfo personnelinfo) {
        this.personnelinfo = personnelinfo;
    }

    public Timestamp getPersonnelTrainDate() {
        return this.personnelTrainDate;
    }
    
    public void setPersonnelTrainDate(Timestamp personnelTrainDate) {
        this.personnelTrainDate = personnelTrainDate;
    }

    public String getPersonnelTrainConten() {
        return this.personnelTrainConten;
    }
    
    public void setPersonnelTrainConten(String personnelTrainConten) {
        this.personnelTrainConten = personnelTrainConten;
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