package org.jsoft.comm.vo;

import java.sql.Timestamp;


/**
 * DictionLog entity. @author MyEclipse Persistence Tools
 */

public class DictionLog  implements java.io.Serializable {


    // Fields    

     private String sid;
     private String pid;
     private String name;
     private Timestamp dictionLogDate;
     private String dictionLogRemark;
     private Integer isDelete;


    // Constructors

    /** default constructor */
    public DictionLog() {
    }

	/** minimal constructor */
    public DictionLog(String sid) {
        this.sid = sid;
    }
    
    /** full constructor */
    public DictionLog(String sid, String pid, String name, Timestamp dictionLogDate, String dictionLogRemark, Integer isDelete) {
        this.sid = sid;
        this.pid = pid;
        this.name = name;
        this.dictionLogDate = dictionLogDate;
        this.dictionLogRemark = dictionLogRemark;
        this.isDelete = isDelete;
    }

   
    // Property accessors

    public String getSid() {
        return this.sid;
    }
    
    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getPid() {
        return this.pid;
    }
    
    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDictionLogDate() {
        return this.dictionLogDate;
    }
    
    public void setDictionLogDate(Timestamp dictionLogDate) {
        this.dictionLogDate = dictionLogDate;
    }

    public String getDictionLogRemark() {
        return this.dictionLogRemark;
    }
    
    public void setDictionLogRemark(String dictionLogRemark) {
        this.dictionLogRemark = dictionLogRemark;
    }

    public Integer getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
   








}