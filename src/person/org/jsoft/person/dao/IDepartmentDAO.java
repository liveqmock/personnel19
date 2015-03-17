package org.jsoft.person.dao;

import java.util.List;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.Department;

/**  
 * <对于Department的操作接口> 
 * @author xfd   
 * @version 创建时间：2014-9-29 下午7:47:44  
 */
public interface IDepartmentDAO extends IBaseDAO<Department> {
	
	/**
	 * 
	 * @param departmentId
	 * @return
	 * 		Department
	 */
	public Department getDepartmentByDepartmentId(String departmentId);
	
	/**
	 * 得到所有的department
	 * @return
	 * 		department list
	 */
	public List<Department> getAllDepartment();

}
