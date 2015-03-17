package org.jsoft.comm.vo;

import java.util.HashSet;
import java.util.Set;


/**
 * DeptJobRel entity. @author MyEclipse Persistence Tools
 */

public class DeptJobRel  implements java.io.Serializable {


    // Fields    

     private String deptJobRelId;
     private Department department;
     private Job job;
     private Salary salary;
     private Integer isDelete;
     private Set personnelinfos = new HashSet(0);
     private Set personneladjustsalaries = new HashSet(0);


    // Constructors

    /** default constructor */
    public DeptJobRel() {
    }

	/** minimal constructor */
    public DeptJobRel(String deptJobRelId) {
        this.deptJobRelId = deptJobRelId;
    }
    
    /** full constructor */
    public DeptJobRel(String deptJobRelId, Department department, Job job, Salary salary, Set personnelinfos, Set personneladjustsalaries) {
        this.deptJobRelId = deptJobRelId;
        this.department = department;
        this.job = job;
        this.salary = salary;
        this.personnelinfos = personnelinfos;
        this.personneladjustsalaries = personneladjustsalaries;
    }

   
    // Property accessors

    public String getDeptJobRelId() {
        return this.deptJobRelId;
    }
    
    public void setDeptJobRelId(String deptJobRelId) {
        this.deptJobRelId = deptJobRelId;
    }

    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }

    public Job getJob() {
        return this.job;
    }
    
    public void setJob(Job job) {
        this.job = job;
    }

    public Salary getSalary() {
        return this.salary;
    }
    
    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Set getPersonnelinfos() {
        return this.personnelinfos;
    }
    
    public void setPersonnelinfos(Set personnelinfos) {
        this.personnelinfos = personnelinfos;
    }

    public Set getPersonneladjustsalaries() {
        return this.personneladjustsalaries;
    }
    
    public void setPersonneladjustsalaries(Set personneladjustsalaries) {
        this.personneladjustsalaries = personneladjustsalaries;
    }

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
   








}