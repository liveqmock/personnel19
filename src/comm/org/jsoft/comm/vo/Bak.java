package org.jsoft.comm.vo;

import java.sql.Timestamp;


/**
 * Bak entity. @author MyEclipse Persistence Tools
 */

public class Bak  implements java.io.Serializable {


    // Fields    

     private String bakId;
     private Operater operater;
     private String bakRemark;
     private Timestamp bakDate;
     private String path;
     private Integer isDelete=0;


    // Constructors

    /** default constructor */
    public Bak() {
    }

	/** minimal constructor */
    public Bak(String bakId) {
        this.bakId = bakId;
    }
    
    /** full constructor */
    public Bak(String bakId, Operater operater, String bakRemark, Timestamp bakDate, String path, Integer isDelete) {
        this.bakId = bakId;
        this.operater = operater;
        this.bakRemark = bakRemark;
        this.bakDate = bakDate;
        this.path = path;
        this.isDelete = isDelete;
    }

   
    // Property accessors

    public String getBakId() {
        return this.bakId;
    }
    
    public void setBakId(String bakId) {
        this.bakId = bakId;
    }

    public Operater getOperater() {
        return this.operater;
    }
    
    public void setOperater(Operater operater) {
        this.operater = operater;
    }

    public String getBakRemark() {
        return this.bakRemark;
    }
    
    public void setBakRemark(String bakRemark) {
        this.bakRemark = bakRemark;
    }

    public Timestamp getBakDate() {
        return this.bakDate;
    }
    
    public void setBakDate(Timestamp bakDate) {
        this.bakDate = bakDate;
    }

    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }

    public Integer getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
   








}