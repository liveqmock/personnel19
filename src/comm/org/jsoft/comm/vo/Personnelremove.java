package org.jsoft.comm.vo;

import java.sql.Timestamp;


/**
 * Personnelremove entity. @author MyEclipse Persistence Tools
 */

public class Personnelremove  implements java.io.Serializable {


    // Fields    

     private String personnelRemoveId;
     private Personnelinfo personnelinfo;
     private String afterRemoveDepartment;
     private String beforeRemoveDepartment;
     private String afterRemoveJob;
     private String beforeRemoveJob;
     private Timestamp removeDate;
     private String removeReason;
     private String personnelRemoveRemark;
     private Integer isDelete;


    // Constructors

    /** default constructor */
    public Personnelremove() {
    }

	/** minimal constructor */
    public Personnelremove(String personnelRemoveId) {
        this.personnelRemoveId = personnelRemoveId;
    }
    
    /** full constructor */
    public Personnelremove(String personnelRemoveId, Personnelinfo personnelinfo, String afterRemoveDepartment, String beforeRemoveDepartment, String afterRemoveJob, String beforeRemoveJob, Timestamp removeDate, String removeReason, String personnelRemoveRemark, Integer isDelete) {
        this.personnelRemoveId = personnelRemoveId;
        this.personnelinfo = personnelinfo;
        this.afterRemoveDepartment = afterRemoveDepartment;
        this.beforeRemoveDepartment = beforeRemoveDepartment;
        this.afterRemoveJob = afterRemoveJob;
        this.beforeRemoveJob = beforeRemoveJob;
        this.removeDate = removeDate;
        this.removeReason = removeReason;
        this.personnelRemoveRemark = personnelRemoveRemark;
        this.isDelete = isDelete;
    }

   
    // Property accessors

    public String getPersonnelRemoveId() {
        return this.personnelRemoveId;
    }
    
    public void setPersonnelRemoveId(String personnelRemoveId) {
        this.personnelRemoveId = personnelRemoveId;
    }

    public Personnelinfo getPersonnelinfo() {
        return this.personnelinfo;
    }
    
    public void setPersonnelinfo(Personnelinfo personnelinfo) {
        this.personnelinfo = personnelinfo;
    }

    public String getAfterRemoveDepartment() {
        return this.afterRemoveDepartment;
    }
    
    public void setAfterRemoveDepartment(String afterRemoveDepartment) {
        this.afterRemoveDepartment = afterRemoveDepartment;
    }

    public String getBeforeRemoveDepartment() {
        return this.beforeRemoveDepartment;
    }
    
    public void setBeforeRemoveDepartment(String beforeRemoveDepartment) {
        this.beforeRemoveDepartment = beforeRemoveDepartment;
    }

    public String getAfterRemoveJob() {
        return this.afterRemoveJob;
    }
    
    public void setAfterRemoveJob(String afterRemoveJob) {
        this.afterRemoveJob = afterRemoveJob;
    }

    public String getBeforeRemoveJob() {
        return this.beforeRemoveJob;
    }
    
    public void setBeforeRemoveJob(String beforeRemoveJob) {
        this.beforeRemoveJob = beforeRemoveJob;
    }

    public Timestamp getRemoveDate() {
        return this.removeDate;
    }
    
    public void setRemoveDate(Timestamp removeDate) {
        this.removeDate = removeDate;
    }

    public String getRemoveReason() {
        return this.removeReason;
    }
    
    public void setRemoveReason(String removeReason) {
        this.removeReason = removeReason;
    }

    public String getPersonnelRemoveRemark() {
        return this.personnelRemoveRemark;
    }
    
    public void setPersonnelRemoveRemark(String personnelRemoveRemark) {
        this.personnelRemoveRemark = personnelRemoveRemark;
    }

    public Integer getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
   








}