package org.jsoft.comm.vo;

import java.sql.Timestamp;


/**
 * OperateLog entity. @author MyEclipse Persistence Tools
 */

public class OperateLog  implements java.io.Serializable {


    // Fields    

     private String operateLogId;
     private Operater operater;
     private Timestamp bakDate;
     private String event;
     private Integer isDelete;


    // Constructors

    /** default constructor */
    public OperateLog() {
    }

	/** minimal constructor */
    public OperateLog(String operateLogId) {
        this.operateLogId = operateLogId;
    }
    
    /** full constructor */
    public OperateLog(String operateLogId, Operater operater, Timestamp bakDate, String event, Integer isDelete) {
        this.operateLogId = operateLogId;
        this.operater = operater;
        this.bakDate = bakDate;
        this.event = event;
        this.isDelete = isDelete;
    }

   
    // Property accessors

    public String getOperateLogId() {
        return this.operateLogId;
    }
    
    public void setOperateLogId(String operateLogId) {
        this.operateLogId = operateLogId;
    }

    public Operater getOperater() {
        return this.operater;
    }
    
    public void setOperater(Operater operater) {
        this.operater = operater;
    }

    public Timestamp getBakDate() {
        return this.bakDate;
    }
    
    public void setBakDate(Timestamp bakDate) {
        this.bakDate = bakDate;
    }

    public String getEvent() {
        return this.event;
    }
    
    public void setEvent(String event) {
        this.event = event;
    }

    public Integer getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
   








}