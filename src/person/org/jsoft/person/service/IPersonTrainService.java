package org.jsoft.person.service;

import java.util.List;

import org.jsoft.comm.vo.Personneltrain;


public interface IPersonTrainService {
	public List<Personneltrain> findAll(String tempCurrentPage);
	
	public Personneltrain findSingle(String personnelTrainId);
	
	public List<Personneltrain> findByDepartment(String departmentName,
			String tempCurrentPage);
	public List<Personneltrain> findByJob(String jobName,
			String tempCurrentPage);
	
	
	public void add(String personnelId, String personnelTrainConten,
			String ptdTemp, String personnelTrainRemark);
	public void update(String personnelTrainId,String personnelTrainConten,String ptdTemp,String personnelTrainRemark,int isDelete );
}
