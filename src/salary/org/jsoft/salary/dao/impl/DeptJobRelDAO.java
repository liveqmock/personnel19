package org.jsoft.salary.dao.impl;

import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.salary.dao.IDeptJobRelDAO;

public class DeptJobRelDAO extends BaseDAO<DeptJobRel> implements IDeptJobRelDAO {
	public List<DeptJobRel> queryDeptJobRelFromDepartmentId(String departmentid){
		String hql = "from DeptJobRel where department =  '"+departmentid+"'   ";
		List<DeptJobRel> l=this.find(hql);
		if (l==null) System.out.println("deptjobrel 获取失败");
		return l;
	}
	
	public DeptJobRel queryDeptJobRelFromDeptJobRelId(String deptjobrelid){
		String hql = "from DeptJobRel where  deptJobRelId =  "+deptjobrelid   ;
		DeptJobRel l=this.get(hql);
		if (l==null) System.out.println("deptjobrel 获取失败");
		return l;
	}
}
