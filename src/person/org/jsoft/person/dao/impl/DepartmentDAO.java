package org.jsoft.person.dao.impl;


import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Department;
import org.jsoft.person.dao.IDepartmentDAO;

/**  
 * <对于Department的操作实现> 
 * @author xfd   
 * @version 创建时间：2014-9-29 下午7:52:47  
 */
public class DepartmentDAO extends BaseDAO<Department> implements IDepartmentDAO {

	@Override
	public Department getDepartmentByDepartmentId(String departmentId) {
		// TODO Auto-generated method stub
		String hql="FROM Department WHERE departmentId='"+departmentId+"'";
		Department department=get(hql);
		return department;
	}

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		String hql="FROM Department WHERE isDelete="+0+"";
		List<Department> departmentList=find(hql);
		return departmentList;
	}


}
