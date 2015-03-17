package org.jsoft.salary.dao;

import java.util.List;

import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Salary;

public interface ISalaryDAO
{
	/**
	 * 给出一个部门id，给出一个职位id,得出一个
	 * @param departmentId
	 * @param jobId
	 * @return
	 */
	public Salary querySalary(String salaryId );
	public void updateSalary(Salary salary);
	/**
	 * 查询salaryid的方法
	 * @param jobid
	 * @param deptid
	 * @return
	 */
	public DeptJobRel queryDeptJobRel(String jobid,String deptid);
	/**
	 * 查询一共有多少数据
	 * @return
	 */
	public int AllCount();
	public List<DeptJobRel> queryAll(PageDivid pageDivid);
	/**
	 * 存储salary
	 */
	public void saveSalary(Salary salary);
	
	public DeptJobRel queryDeptJobRelbyId(String DeptJobRelId);
	
}
