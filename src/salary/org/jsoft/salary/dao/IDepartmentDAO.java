package org.jsoft.salary.dao;

import java.util.List;

import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DeptJobRel;

public interface IDepartmentDAO
{
	/**
	 * 根据部门的名称查询出一个部门的对象
	 * @param DeptName
	 * @return
	 */
	public Department queryDeptByDeptName(String DeptName);
	/**
	 * 查询所有的部门
	 * @return
	 */
	public List queryAllDept();
	/**
	 * 根据deptid获得部门对象
	 * @param deptid
	 * @return
	 */
	public Department queryDeptById(String deptid);
	public List<DeptJobRel> queryDeptJobRelbyDept(Department department);

}
