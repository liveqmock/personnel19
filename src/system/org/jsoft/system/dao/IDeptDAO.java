package org.jsoft.system.dao;

import java.util.List;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.PageDivid;

public interface IDeptDAO extends IBaseDAO<Department>{
	/**
	 * 查询所有
	 * @return
	 */
	public List<Department> queryAll();
	/**
	 * 根据分页信息查询所有
	 * @param pageDivid
	 * @return
	 */
	public List<Department> query(PageDivid pageDivid);
	/**
	 * 查询所有信息的条数
	 * @return
	 */
	public int Allcount();
	/**
	 * 根据条件查询所有条数
	 * @param hql
	 * @param paraments
	 * @return
	 */
	public int Allcount(String hql,List<Object> paraments);
	/**
	 * 增加一个部门
	 * @param department
	 */
	public void add(Department department);
	/**
	 * 修改一个部门的信息
	 */
	public void updateDepartment(Department department);
	/**
	 * 伪删除一个部门的信息
	 * @param department
	 */
	public void dele(Department department);
	/**
	 * 根据id 得到部门
	 * @param deptId
	 * @return
	 */
	public Department getDept(String deptId);
	
	/**
	 * 根据id 得到部门
	 * @param deptId
	 * @return
	 */
	public Department getDeptByName(String deptName);
}
