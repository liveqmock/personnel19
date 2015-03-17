package org.jsoft.comm.vo;

import java.util.HashSet;
import java.util.Set;


/**
 * Encorchast entity. @author MyEclipse Persistence Tools
 */

public class Encorchast  implements java.io.Serializable {


    // Fields    

     private String encOrChastId;
     private double personnelEncOrChastPoint;
     private double money;
     private String personnelEncOrChastSort;
     private Integer isDelete;
     private Set peocs = new HashSet(0);


    // Constructors

    /** default constructor */
    public Encorchast() {
    }

	/** minimal constructor */
    public Encorchast(String encOrChastId) {
        this.encOrChastId = encOrChastId;
    }
    
    /** full constructor */
    public Encorchast(String encOrChastId, Double personnelEncOrChastPoint, Double money, String personnelEncOrChastSort, Integer isDelete, Set peocs) {
        this.encOrChastId = encOrChastId;
        this.personnelEncOrChastPoint = personnelEncOrChastPoint;
        this.money = money;
        this.personnelEncOrChastSort = personnelEncOrChastSort;
        this.isDelete = isDelete;
        this.peocs = peocs;
    }

   
    // Property accessors

    public String getEncOrChastId() {
        return this.encOrChastId;
    }
    
    public void setEncOrChastId(String encOrChastId) {
        this.encOrChastId = encOrChastId;
    }

    public double getPersonnelEncOrChastPoint() {
        return this.personnelEncOrChastPoint;
    }
    
    public void setPersonnelEncOrChastPoint(Double personnelEncOrChastPoint) {
        this.personnelEncOrChastPoint = personnelEncOrChastPoint;
    }

    public double getMoney() {
        return this.money;
    }
    
    public void setMoney(Double money) {
        this.money = money;
    }

    public String getPersonnelEncOrChastSort() {
        return this.personnelEncOrChastSort;
    }
    
    public void setPersonnelEncOrChastSort(String personnelEncOrChastSort) {
        this.personnelEncOrChastSort = personnelEncOrChastSort;
    }

    public Integer getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Set getPeocs() {
        return this.peocs;
    }
    
    public void setPeocs(Set peocs) {
        this.peocs = peocs;
    }
   








}