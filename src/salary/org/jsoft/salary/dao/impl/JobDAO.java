package org.jsoft.salary.dao.impl;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Job;
import org.jsoft.salary.dao.IJobDAO;
public class JobDAO extends BaseDAO<Job> implements IJobDAO
{
	@Override
	public Job queryJobByJobName(String JobName)
	{
		Session session= getSession();
		Query query=session.createQuery("from Job where JobName=:Jobname").setString("Jobname",JobName);    
		// TODO Auto-generated method stub
		List<Job> Joblist=query.list();
		return Joblist.get(0);
	
	}

	@Override
	public List<Job> queryAllJob()
	{
	String hql="from Job where isDelete = 0";
	
		return find(hql);
	}
	
	public static void main(String[] args)
	{
		JobDAO u=new JobDAO();
		List<Job> list=u.queryAllJob();
		for (Job d : list)
		{System.out.println(d.getJobName());
			
			
		}
	}

	@Override
	public Job queryJobById(String jobid)
	{
		String hql="from Job where jobId="+jobid;
		List<Job> list=find(hql);
		Job job=list.get(0);
		return job;
	}
}
