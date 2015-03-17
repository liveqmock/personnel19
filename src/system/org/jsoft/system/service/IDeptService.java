package org.jsoft.system.service;

import java.util.List;

import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.PageDivid;



public interface IDeptService {
	/**
	 * 查询所有
	 * @return
	 */
	public List<Department> queryAll();
	/**
	 * 根据前台的page 查询相应的数据
	 * @param page
	 * @return
	 */
	public List<Department> queryNpage(String page);
	
	/**
	 * 根据前台的第几页 得到PageDivid
	 * @param page
	 * @return
	 */
	public PageDivid getPageDivid(String page);
	/**
	 * 根据id修改部门名
	 * @param departmentId
	 * @param deptName
	 */
	public void updateDept(String departmentId,String deptName);
	/**
	 * 增加一个部门名为deptName 的部门
	 * @param deptName
	 */
	public void add(String deptName);
	/**
	 * 根据部门id 删除这个部门
	 * @param departmentId
	 */
	public void delLie(String departmentId);
	/**
	 * 根据id 得到部门
	 * @param deptId
	 * @return
	 */
	public Department getdept(String deptId);
	/**
	 * 删除一批或者一个
	 * @param checkbox
	 */
	public void delLie(String[] checkbox);
}
