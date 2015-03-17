package org.jsoft.person.dao.impl;


import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Job;
import org.jsoft.person.dao.IJobDAO;

/**  
 * <对于Job的操作实现> 
 * @author xfd   
 * @version 创建时间：2014-9-29 下午7:55:45  
 */
public class JobDAO extends BaseDAO<Job> implements IJobDAO {

	@Override
	public Job getJobByJobId(String jobId) {
		// TODO Auto-generated method stub
		String hql="FROM Job WHERE jobId='"+jobId+"'";
		Job job=get(hql);
		return job;
	}

	@Override
	public List<Job> getAllJob() {
		// TODO Auto-generated method stub
		String hql="FROM Job WHERE isDelete="+0+"";
		List<Job> jobList=find(hql);
		return jobList;
	}

	
}
