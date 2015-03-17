package org.jsoft.person.dao.impl;


import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.person.dao.IDeptJobRelDAO;

/**  
 * <对于DeptJobRel的操作实现> 
 * @author xfd   
 * @version 创建时间：2014-9-29 下午7:28:20  
 */
public class DeptJobRelDAO extends BaseDAO<DeptJobRel> implements IDeptJobRelDAO {

	@Override
	public DeptJobRel getDeptJobRelByPersonnelId(String personnelId) {
		// TODO Auto-generated method stub
		String hql="SELECT deptJobRel FROM Personnelinfo WHERE personnelId='"+personnelId+"'";
		DeptJobRel deptJobRel=get(hql);
		return deptJobRel;
	}

	@Override
	public void updateDeptJobRel(DeptJobRel deptJobRel) {
		// TODO Auto-generated method stub
		save(deptJobRel);
	}



}
