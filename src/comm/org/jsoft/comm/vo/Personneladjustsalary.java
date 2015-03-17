package org.jsoft.comm.vo;

import java.sql.Timestamp;

/**
 * Personneladjustsalary entity. @author MyEclipse Persistence Tools
 */

public class Personneladjustsalary implements java.io.Serializable {

	// Fields

	private String personnelAdjustSalaryId;
	private DeptJobRel deptJobRel;
	private Salary salary;
	private Timestamp adjustSalaryDate;
	private String adjustSalaryReason;
	private String personnelAdjustSalaryRemark;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public Personneladjustsalary() {
	}

	/** minimal constructor */
	public Personneladjustsalary(String personnelAdjustSalaryId) {
		this.personnelAdjustSalaryId = personnelAdjustSalaryId;
	}

	/** full constructor */
	public Personneladjustsalary(String personnelAdjustSalaryId,
			DeptJobRel deptJobRel, Salary salary, Timestamp adjustSalaryDate,
			String adjustSalaryReason, String personnelAdjustSalaryRemark,
			Integer isDelete) {
		this.personnelAdjustSalaryId = personnelAdjustSalaryId;
		this.deptJobRel = deptJobRel;
		this.salary = salary;
		this.adjustSalaryDate = adjustSalaryDate;
		this.adjustSalaryReason = adjustSalaryReason;
		this.personnelAdjustSalaryRemark = personnelAdjustSalaryRemark;
		this.isDelete = isDelete;
	}

	// Property accessors

	public String getPersonnelAdjustSalaryId() {
		return this.personnelAdjustSalaryId;
	}

	public void setPersonnelAdjustSalaryId(String personnelAdjustSalaryId) {
		this.personnelAdjustSalaryId = personnelAdjustSalaryId;
	}

	public DeptJobRel getDeptJobRel() {
		return this.deptJobRel;
	}

	public void setDeptJobRel(DeptJobRel deptJobRel) {
		this.deptJobRel = deptJobRel;
	}

	public Salary getSalary() {
		return this.salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public Timestamp getAdjustSalaryDate() {
		return this.adjustSalaryDate;
	}

	public void setAdjustSalaryDate(Timestamp adjustSalaryDate) {
		this.adjustSalaryDate = adjustSalaryDate;
	}

	public String getAdjustSalaryReason() {
		return this.adjustSalaryReason;
	}

	public void setAdjustSalaryReason(String adjustSalaryReason) {
		this.adjustSalaryReason = adjustSalaryReason;
	}

	public String getPersonnelAdjustSalaryRemark() {
		return this.personnelAdjustSalaryRemark;
	}

	public void setPersonnelAdjustSalaryRemark(
			String personnelAdjustSalaryRemark) {
		this.personnelAdjustSalaryRemark = personnelAdjustSalaryRemark;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}