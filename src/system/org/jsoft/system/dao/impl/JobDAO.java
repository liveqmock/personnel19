package org.jsoft.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.Job;
import org.jsoft.system.dao.IJobDAO;

public class JobDAO extends BaseDAO<Job> implements IJobDAO{

	@Override
	public Job getByName(String jobName) {
		// TODO Auto-generated method stub
		String hql = "from Job where isDelete=? and jobName=?";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(0);
		paraments.add(jobName);
		Job job = get(hql, paraments); 
		return job;
	}
public static void main(String[] args) {
	JobDAO dao = new JobDAO();
	System.out.println(dao.getByName("经理"));
}
}
