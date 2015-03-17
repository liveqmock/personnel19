package org.jsoft.person.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.Personneladjustsalary;
import org.jsoft.comm.vo.Salary;
import org.jsoft.person.dao.IPersonAdjustSalaryDAO;
import org.jsoft.person.dao.IPersonneladjustsalaryDAO;
import org.jsoft.person.dao.ISalaryDAO;
import org.jsoft.person.dao.impl.PersonAdjustSalaryDAO;
import org.jsoft.person.dao.impl.PersonneladjustsalaryDAO;
import org.jsoft.person.dao.impl.SalaryDAO;
import org.jsoft.person.service.IPersonAdjustSalaryService;

/**  
 * <关于员工调薪Service实现类> 
 * @author xfd   
 * @version 创建时间：2014-9-25 下午8:32:25  
 */
public class PersonAdjustSalaryService implements IPersonAdjustSalaryService {
	
	private IPersonAdjustSalaryDAO<Salary> personAdjustSalaryDAO=new PersonAdjustSalaryDAO();
	private ISalaryDAO salaryDAO = new SalaryDAO();
	private IPersonneladjustsalaryDAO addPersonAdjustSalaryDAO=new PersonneladjustsalaryDAO();
	@Override
	public List<Salary> showSalaryByPersonnelId(String personnelId) {
		// TODO Auto-generated method stub
		DeptJobRel deptJobRel=personAdjustSalaryDAO.getDeptJobRelByPersonnelId(personnelId);
		List<Salary> salaryList=personAdjustSalaryDAO.getSalaryByDeptJobRel(deptJobRel);
		return salaryList;
	}


	@Override
	public void updateSalary(String salaryId, Double bonus, Double lunchSalary,
			Double trafficSalary, Double basicSalary, Double allSalary) {
		// TODO Auto-generated method stub
		Salary salary=this.findSalaryBySalaryId(salaryId).get(0);
		salary.setSalaryId(salaryId);
		salary.setAllSalary(allSalary);
		salary.setBasicSalary(basicSalary);
		salary.setBonus(bonus);
		salary.setLunchSalary(lunchSalary);
		salary.setTrafficSalary(trafficSalary);
		salary.setUseredDate(new Timestamp(new Date().getTime()));
		salary.setIsDelete(0);
		salaryDAO.update(salary);
	}
	@Override
	public void addPersonneladjustsalary(
			String adjustSalaryReason, String personnelAdjustSalaryRemark,DeptJobRel deptJobRel) {
		// TODO Auto-generated method stub
		Personneladjustsalary personneladjustsalary=new Personneladjustsalary();
		personneladjustsalary.setAdjustSalaryDate(new Timestamp(new Date().getTime()));
		personneladjustsalary.setAdjustSalaryReason(adjustSalaryReason);
		personneladjustsalary.setIsDelete(0);
		personneladjustsalary.setPersonnelAdjustSalaryRemark(personnelAdjustSalaryRemark);
		personneladjustsalary.setDeptJobRel(deptJobRel);
		addPersonAdjustSalaryDAO.save(personneladjustsalary);
	}


	@Override
	public List<Salary> findSalaryBySalaryId(String salaryId) {
		// TODO Auto-generated method stub
		List<Salary> salaryList=salaryDAO.findSalayBySalaryId(salaryId);
		return salaryList;
	}


}
