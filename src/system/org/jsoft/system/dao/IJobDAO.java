package org.jsoft.system.dao;

import org.jsoft.comm.dao.IBaseDAO;
import org.jsoft.comm.vo.Job;

public interface IJobDAO extends IBaseDAO<Job>{
	public Job getByName(String jobName);
}
