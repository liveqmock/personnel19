package org.jsoft.person.dao.impl;


import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Salary;
import org.jsoft.person.dao.ISalaryDAO;

/**  
 * <工资SalaryDAO实现类> 
 * @author xfd   
 * @version 创建时间：2014-9-28 下午6:09:31  
 */
public class SalaryDAO extends BaseDAO<Salary> implements ISalaryDAO {

	@Override
	public void updateSalary(Salary salary) {
		// TODO Auto-generated method stub
		save(salary);
	}

	@Override
	public List<Salary> findSalayBySalaryId(String salaryId) {
		// TODO Auto-generated method stub
		String hql="FROM Salary WHERE salaryId='"+salaryId+"'";
		List<Salary> salaryList = find(hql);
		return salaryList;
	}



}
