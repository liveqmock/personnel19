package org.jsoft.information.service;

import java.util.List;

import org.jsoft.comm.vo.Peoc;
import org.jsoft.comm.vo.Personneladjustsalary;
import org.jsoft.comm.vo.Personnelappraise;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.comm.vo.Personnelremove;
import org.jsoft.comm.vo.Personneltrain;
import org.jsoft.comm.vo.Salary;
import org.jsoft.information.dao.impl.UserDAO;

public class UserService {

	UserDAO userDAO = new UserDAO();

	public List<Personnelinfo> queryAll() {

		List<Personnelinfo> personInfo = userDAO.queryAll();

		return personInfo;
	}
	
	public List<Personnelinfo> queryByPersonnelId(String id) {
		
		List<Personnelinfo> personInfo = userDAO.queryByPersonnelId(id);
		
		return personInfo;
	}
	
	public List<Personneltrain> queryTrain() {
		
		List<Personneltrain> personTrain = userDAO.queryTrain();
		
		return personTrain;
	}

	public List<Personnelappraise> queryAppraise(){
		List<Personnelappraise> personAppraise = userDAO.queryAppraise();
		
		return personAppraise;
	}

	public List<Personneladjustsalary> querySalary(){
		List<Personneladjustsalary> personSalary = userDAO.querySalary();
		return personSalary;
	}
	
	public List<Personnelremove> queryRemove(){
		List<Personnelremove> personRemove = userDAO.queryRemove();
		return personRemove;
	}
	
	public List<Salary> querySal(){
		List<Salary> personSal = userDAO.querySal();
		return personSal;
	}
	
	public List<Peoc> queryEn(){
		List<Peoc> personEn = userDAO.queryEn();
		return personEn;
	}
}
