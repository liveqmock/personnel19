package org.jsoft.salary.vo;

import java.util.List;

import org.jsoft.comm.vo.Peoc;
import org.jsoft.comm.vo.Salary;

public class PayRollResult {
	private Salary salary;
	private List<Peoc> peoc;
	private int year;
	private int month;
	private double total;
	private int pbtimes;
	
	public PayRollResult(Salary salary,List<Peoc> peoc,int year,int month,double total,int pbtimes){
		this.salary=salary;
		this.peoc=peoc;
		this.year=year;
		this.month=month;
		this.total=total;
		this.pbtimes=pbtimes;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPbtimes() {
		return pbtimes;
	}
	public void setPbtimes(int pbtimes) {
		this.pbtimes = pbtimes;
	}
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	public List<Peoc> getPeoc() {
		return peoc;
	}
	public void setPeoc(List<Peoc> peoc) {
		this.peoc = peoc;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
}
