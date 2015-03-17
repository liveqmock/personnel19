package org.jsoft.salary.dao;

import java.util.List;

import org.jsoft.comm.vo.Job;

public interface IJobDAO
{
	/**
	 * 
	 * 根据一个职位的名称查询出一个职位 
	 * @param DutyName
	 * @return
	 */
	public Job queryJobByJobName(String JobName);
	/**
	 * 查询出所有没有删除的职位
	 * @return
	 */
	public List<Job> queryAllJob();
	public Job queryJobById(String jobid);
	
}
