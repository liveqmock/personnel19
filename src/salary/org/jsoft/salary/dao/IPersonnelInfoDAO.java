package org.jsoft.salary.dao;

import org.jsoft.comm.vo.Personnelinfo;

public interface IPersonnelInfoDAO {
	// 通过dept_job_relId 查询personnelInfo
	public Personnelinfo queryPersonnelInfoFromDeptJobRelId(String deptjobrelid);
	// 通过 workid 查询personnelInfo
	public Personnelinfo queryPersonnelInfoFromWorkId(String workid);
}
