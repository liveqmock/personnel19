package org.jsoft.person.service;

import java.util.List;

import org.jsoft.comm.service.IBaseService;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.Salary;

/**  
 * <关于员工调薪的查询的Service接口> 
 * @author xfd   
 * @version 创建时间：2014-9-25 下午8:29:28  
 */
/**
 * @author Administrator
 *
 */
public interface IPersonAdjustSalaryService extends IBaseService {
	/**
	 * @param personnelId
	 * @return
	 * 		工资list
	 */
	public List<Salary> showSalaryByPersonnelId(String personnelId);

	
	/**
	 * 更新salary
	 * @param salaryId
	 * @param bonus
	 * @param lunchSalary
	 * @param trafficSalary
	 * @param basicSalary
	 * @param allSalary
	 */
	public void updateSalary(String salaryId,Double bonus,Double lunchSalary,Double trafficSalary
			,Double basicSalary,Double allSalary);
	/**
	 * 添加一条员工调薪数据
	 * @param personnelAdjustSalaryId
	 * @param adjustSalaryReason
	 * @param personnelAdjustSalaryRemark
	 */
	public void addPersonneladjustsalary(String adjustSalaryReason,
			String personnelAdjustSalaryRemark,DeptJobRel deptJobRel);
	
	/**
	 * 通过salaryId查找工资list
	 * @param salaryId
	 * @return
	 * 		工资list
	 */
	public List<Salary> findSalaryBySalaryId(String salaryId);
}
