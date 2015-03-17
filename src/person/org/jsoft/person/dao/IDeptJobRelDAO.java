package org.jsoft.person.dao;


import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.DeptJobRel;

/**  
 * <对于DeptJobRel的操作接口> 
 * @author xfd   
 * @version 创建时间：2014-9-29 下午7:24:24  
 */
public interface IDeptJobRelDAO extends IBaseDAO<DeptJobRel> {
	
	/**
	 * 通过personnelId获得DeptJobRel
	 * @param personnelId
	 * @return
	 * 		DeptJobRel
	 */
	public DeptJobRel getDeptJobRelByPersonnelId(String personnelId);
	
	/**
	 * 保存DeptJobRel
	 * @param deptJobRel
	 */
	public void updateDeptJobRel(DeptJobRel deptJobRel);
	

}
