package org.jsoft.system.dao;

import java.util.List;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DeptJobRel;

import org.jsoft.comm.vo.PageDivid;

public interface IDept_job_relDAO extends IBaseDAO<DeptJobRel> {
	/**
	 * 根据pagedivid信息查询deptJObrel
	 * @param pageDivid
	 * @return
	 */
	public List<DeptJobRel> query(PageDivid pageDivid);
	
	/**
	 * 根据pagedivid信息查询deptJObrel
	 * @param pageDivid
	 * @return
	 */
	public List<DeptJobRel> queryBydeptName(PageDivid pageDivid,Department department);
	
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
	 * 增加一个职称
	 * @param duty
	 */
	public void add(DeptJobRel deptJobRel);
	/**
	 * 修改一个职称的信息
	 * @param duty
	 */
	public void updateDeptJobRel(DeptJobRel deptJobRel);
	/**
	 * 删除一个职称的信息
	 * @param duty
	 */
	public void dele(DeptJobRel deptJobRel);
	/**
	 * 根据id 得到一个职称的信息
	 * @param dutyId
	 */
	public DeptJobRel getDeptJobRel(String deptJobRelId);
}
