package org.jsoft.comm.vo;

import java.sql.Timestamp;


/**
 * Personnelappraise entity. @author MyEclipse Persistence Tools
 */

public class Personnelappraise  implements java.io.Serializable {


    // Fields    

     private String personnelAppraiseId;
     private Personnelinfo personnelinfo;
     private Timestamp personnelAppraiseDate;
     private String personnelAppraiseResult;
     private String personnelAppraiseContent;
     private String personnelAppraiseRemark;
     private Integer isDelete;


    // Constructors

    /** default constructor */
    public Personnelappraise() {
    }

	/** minimal constructor */
    public Personnelappraise(String personnelAppraiseId) {
        this.personnelAppraiseId = personnelAppraiseId;
    }
    
    /** full constructor */
    public Personnelappraise(String personnelAppraiseId, Personnelinfo personnelinfo, Timestamp personnelAppraiseDate, String personnelAppraiseResult, String personnelAppraiseContent, String personnelAppraiseRemark, Integer isDelete) {
        this.personnelAppraiseId = personnelAppraiseId;
        this.personnelinfo = personnelinfo;
        this.personnelAppraiseDate = personnelAppraiseDate;
        this.personnelAppraiseResult = personnelAppraiseResult;
        this.personnelAppraiseContent = personnelAppraiseContent;
        this.personnelAppraiseRemark = personnelAppraiseRemark;
        this.isDelete = isDelete;
    }

   
    // Property accessors

    public String getPersonnelAppraiseId() {
        return this.personnelAppraiseId;
    }
    
    public void setPersonnelAppraiseId(String personnelAppraiseId) {
        this.personnelAppraiseId = personnelAppraiseId;
    }

    public Personnelinfo getPersonnelinfo() {
        return this.personnelinfo;
    }
    
    public void setPersonnelinfo(Personnelinfo personnelinfo) {
        this.personnelinfo = personnelinfo;
    }

    public Timestamp getPersonnelAppraiseDate() {
        return this.personnelAppraiseDate;
    }
    
    public void setPersonnelAppraiseDate(Timestamp personnelAppraiseDate) {
        this.personnelAppraiseDate = personnelAppraiseDate;
    }

    public String getPersonnelAppraiseResult() {
        return this.personnelAppraiseResult;
    }
    
    public void setPersonnelAppraiseResult(String personnelAppraiseResult) {
        this.personnelAppraiseResult = personnelAppraiseResult;
    }

    public String getPersonnelAppraiseContent() {
        return this.personnelAppraiseContent;
    }
    
    public void setPersonnelAppraiseContent(String personnelAppraiseContent) {
        this.personnelAppraiseContent = personnelAppraiseContent;
    }

    public String getPersonnelAppraiseRemark() {
        return this.personnelAppraiseRemark;
    }
    
    public void setPersonnelAppraiseRemark(String personnelAppraiseRemark) {
        this.personnelAppraiseRemark = personnelAppraiseRemark;
    }

    public Integer getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
   








}