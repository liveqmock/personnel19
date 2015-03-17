package org.jsoft.salary.dao;

import java.util.List;

import org.jsoft.comm.vo.DeptJobRel;

public interface IDeptJobRelDAO {
	//通过departmentid查询 dept_job_rel
		public List<DeptJobRel> queryDeptJobRelFromDepartmentId(String departmentid);
	//通过dept_job_relid查询 dept_job_rel
		public DeptJobRel queryDeptJobRelFromDeptJobRelId(String deptjobrelid);	
}
