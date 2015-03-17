package org.jsoft.comm.vo;

import java.util.HashSet;
import java.util.Set;


/**
 * Operater entity. @author MyEclipse Persistence Tools
 */

public class Operater  implements java.io.Serializable {


    // Fields    

     private String opId;
     private Personnelinfo personnelinfo;
     private String popedom;
     private String opName;
     private String opPassword;
     private Integer isDelete;
     private Set operateLogs = new HashSet(0);
     private Set baks = new HashSet(0);


    // Constructors

    /** default constructor */
    public Operater() {
    }

	/** minimal constructor */
    public Operater(String opId) {
        this.opId = opId;
    }
    
    /** full constructor */
    public Operater(String opId, Personnelinfo personnelinfo, String popedom, String opName, String opPassword, Integer isDelete, Set operateLogs, Set baks) {
        this.opId = opId;
        this.personnelinfo = personnelinfo;
        this.popedom = popedom;
        this.opName = opName;
        this.opPassword = opPassword;
        this.isDelete = isDelete;
        this.operateLogs = operateLogs;
        this.baks = baks;
    }

   
    // Property accessors

    public String getOpId() {
        return this.opId;
    }
    
    public void setOpId(String opId) {
        this.opId = opId;
    }

    public Personnelinfo getPersonnelinfo() {
        return this.personnelinfo;
    }
    
    public void setPersonnelinfo(Personnelinfo personnelinfo) {
        this.personnelinfo = personnelinfo;
    }

    public String getPopedom() {
        return this.popedom;
    }
    
    public void setPopedom(String popedom) {
        this.popedom = popedom;
    }

    public String getOpName() {
        return this.opName;
    }
    
    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getOpPassword() {
        return this.opPassword;
    }
    
    public void setOpPassword(String opPassword) {
        this.opPassword = opPassword;
    }

    public Integer getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Set getOperateLogs() {
        return this.operateLogs;
    }
    
    public void setOperateLogs(Set operateLogs) {
        this.operateLogs = operateLogs;
    }

    public Set getBaks() {
        return this.baks;
    }
    
    public void setBaks(Set baks) {
        this.baks = baks;
    }
   








}