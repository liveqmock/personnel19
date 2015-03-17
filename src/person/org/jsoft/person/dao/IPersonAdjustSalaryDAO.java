package org.jsoft.person.dao;

import java.util.List;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.Salary;

/**
 * <关于员工调薪的查询DAO的接口>
 * @author xfd
 *
 * @param <T>
 */
public interface IPersonAdjustSalaryDAO<T> extends IBaseDAO<T> {
	/**
	 * 	根据员工id得到deptJobRel
	 * @param personnelId
	 * @return
	 * 		deptJobRel
	 */
	public DeptJobRel getDeptJobRelByPersonnelId(String personnelId);
	
	/**
	 * 	根据DeptJobRel得到
	 * @param deptJobRel
	 * @return
	 * 		工资list
	 */
	public List<Salary> getSalaryByDeptJobRel(DeptJobRel deptJobRel);
	
}
