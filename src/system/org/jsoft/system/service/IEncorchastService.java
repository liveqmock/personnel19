package org.jsoft.system.service;

import java.util.List;


import org.jsoft.comm.vo.Encorchast;
import org.jsoft.comm.vo.PageDivid;

public interface IEncorchastService {

	/**
	 * 根据前台的page 查询相应的数据
	 * @param page
	 * @return
	 */
	public List<Encorchast> queryNpage(String page);
	
	/**
	 * 根据前台的第几页 得到PageDivid
	 * @param page
	 * @return
	 */
	public PageDivid getPageDivid(String page);
	/**
	 * 根据id修改奖惩制度
	 * @param EncorchastId
	 * @param deptName
	 */
	public void updateDept(String EncorchastId,double personnelEncorchastPoint,double money,String personnelEncorchastSort);
	/**
	 * 增加一个部门名为deptName 的部门
	 * @param deptName
	 */
	public void add(double personnelEncorchastPoint,double money,String personnelEncorchastSort);
	/**
	 * 根据部门id 删除这个部门
	 * @param EncorchastId
	 */
	public void delLie(String EncorchastId);
	/**
	 * 根据id 得到部门
	 * @param deptId
	 * @return
	 */
	public Encorchast getEncorchast(String encorchastId);
	/**
	 * 删除一批或者一个
	 * @param checkbox
	 */
	public void delLie(String[] checkbox);
}
