package org.jsoft.comm.vo;

import java.util.HashSet;
import java.util.Set;


/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department  implements java.io.Serializable {


    // Fields    

     private String departmentId;
     private String departmentName;
     private Integer isDelete;
     private Set deptJobRels = new HashSet(0);


    // Constructors

    /** default constructor */
    public Department() {
    }

	/** minimal constructor */
    public Department(String departmentId) {
        this.departmentId = departmentId;
    }
    
    /** full constructor */
    public Department(String departmentId, String departmentName, Integer isDelete, Set deptJobRels) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.isDelete = isDelete;
        this.deptJobRels = deptJobRels;
    }

   
    // Property accessors

    public String getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Set getDeptJobRels() {
        return this.deptJobRels;
    }
    
    public void setDeptJobRels(Set deptJobRels) {
        this.deptJobRels = deptJobRels;
    }
   








}