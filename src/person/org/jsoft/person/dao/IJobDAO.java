package org.jsoft.person.dao;

import java.util.List;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.Job;

/**  
 * <对于Job的操作接口> 
 * @author xfd   
 * @version 创建时间：2014-9-29 下午7:50:47  
 */
public interface IJobDAO extends IBaseDAO<Job> {
	
	/**
	 * @param jobId
	 * @return
	 * 		Job
	 */
	public Job getJobByJobId(String jobId);
	
	/**
	 * 得到所有的job
	 * @return
	 * 		job list
	 */
	public List<Job> getAllJob();

}
