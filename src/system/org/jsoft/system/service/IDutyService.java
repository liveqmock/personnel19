package org.jsoft.system.service;

import java.util.List;

import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.Duty;
import org.jsoft.comm.vo.PageDivid;

public interface IDutyService {
	/**
	 * 根据前台的page 查询相应的数据
	 * @param page
	 * @return
	 */
	public List<Duty> queryNpage(String page);
	
	/**
	 * 根据前台的第几页 得到PageDivid
	 * @param page
	 * @return
	 */
	public PageDivid getPageDivid(String page);
	/**
	 * 根据id修改职称名
	 * @param departmentId
	 * @param deptName
	 */
	public void updateDept(String dutytId,String dutyName);
	/**
	 * 增加一个部门名为dutyName 的职称
	 * @param deptName
	 */
	public void add(String dutyName);
	/**
	 * 根据部门id删除这个职称
	 * @param departmentId
	 */
	public void delLie(String dutyId);
	/**
	 * 根据id得到 职称
	 * @param deptId
	 * @return
	 */
	public Duty getduty(String dutyId);
	/**
	 * 删除一批或者一个
	 * @param checkbox
	 */
	public void delLie(String[] checkbox);
}
