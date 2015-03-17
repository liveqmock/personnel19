package org.jsoft.person.dao;

import java.util.List;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.Salary;

/**  
 * <工资SalaryDAO接口> 
 * @author xfd   
 * @version 创建时间：2014-9-28 下午6:08:30  
 */
public interface ISalaryDAO extends IBaseDAO<Salary> {
	/**
	 * 更新salary
	 * @param salary
	 */
	public void updateSalary(Salary salary);
	/**
	 * 通过salaryId查找工资list
	 * @param salaryId
	 * @return
	 * 		工资list
	 */	
	public List<Salary> findSalayBySalaryId(String salaryId);
}
