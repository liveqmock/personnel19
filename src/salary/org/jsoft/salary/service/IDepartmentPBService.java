package org.jsoft.salary.service;

import java.util.List;

import org.jsoft.comm.vo.Department;

public interface IDepartmentPBService {

	/**
	 * 查询所有没有被删除的部门
	 * 
	 * @return List<Department>
	 */
	public List<Department> queryDept();
	
	/**
	 * 判断当前request方法
	 * 
	 */
	public String checkMethod(String method);
	
	/**
	 *先检验输入合法性
	 *其次进行数据库操作
	 */
	public String dopb(String method,String pbtype,String pbpoint,String pbmoney,String pblevel,String pbreason,String pbremark,String[] deptid);
}
