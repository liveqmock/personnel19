package org.jsoft.comm.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Salary entity. @author MyEclipse Persistence Tools
 */

public class Salary implements java.io.Serializable {

	// Fields

	private String salaryId;
	private Double bonus;
	private Double lunchSalary;
	private Double trafficSalary;
	private Double basicSalary;
	private Double allSalary;
	private Timestamp useredDate;
	private Integer isDelete;
	private Set deptJobRels = new HashSet(0);
	private Set personneladjustsalaries = new HashSet(0);

	// Constructors

	/** default constructor */
	public Salary() {
	}

	/** minimal constructor */
	public Salary(String salaryId) {
		this.salaryId = salaryId;
	}

	/** full constructor */


	// Property accessors

	public String getSalaryId() {
		return this.salaryId;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	public Double getLunchSalary() {
		return lunchSalary;
	}

	public void setLunchSalary(Double lunchSalary) {
		this.lunchSalary = lunchSalary;
	}

	public Double getTrafficSalary() {
		return trafficSalary;
	}

	public void setTrafficSalary(Double trafficSalary) {
		this.trafficSalary = trafficSalary;
	}

	public Double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Double getAllSalary() {
		return allSalary;
	}

	public void setAllSalary(Double allSalary) {
		this.allSalary = allSalary;
	}

	public void setSalaryId(String salaryId) {
		this.salaryId = salaryId;
	}

	public Timestamp getUseredDate() {
		return this.useredDate;
	}

	public void setUseredDate(Timestamp useredDate) {
		this.useredDate = useredDate;
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

	public Set getPersonneladjustsalaries() {
		return this.personneladjustsalaries;
	}

	public void setPersonneladjustsalaries(Set personneladjustsalaries) {
		this.personneladjustsalaries = personneladjustsalaries;
	}

}