package org.jsoft.system.service.impl;

import java.util.List;

import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.Job;
import org.jsoft.comm.vo.PageDivid;

import org.jsoft.system.dao.IDeptDAO;
import org.jsoft.system.dao.IDept_job_relDAO;
import org.jsoft.system.dao.IJobDAO;
import org.jsoft.system.dao.impl.DeptDAO;
import org.jsoft.system.dao.impl.Dept_job_relDAO;
import org.jsoft.system.dao.impl.JobDAO;
import org.jsoft.system.service.IDept_job_relService;

import com.mysql.jdbc.exceptions.DeadlockTimeoutRollbackMarker;

public class Dept_job_relService implements IDept_job_relService {
private IDept_job_relDAO dept_job_relDAO = new Dept_job_relDAO();
	@Override
	public List<DeptJobRel> queryNpage(String page) {
		// TODO Auto-generated method stub
		PageDivid pageDivid = new PageDivid();
		pageDivid =getPageDivid(page);
		List<DeptJobRel> deptJobRels =dept_job_relDAO.query(pageDivid);
		return deptJobRels;
	}

	@Override
	public PageDivid getPageDivid(String page) {
		// TODO Auto-generated method stub
		PageDivid pageDivid = new PageDivid();
		int all =  dept_job_relDAO.Allcount();
		pageDivid.setNum(all);
		pageDivid.setAllPage((all-1)/pageDivid.getEachPageNum()+1);
		int currentpage = 1;
		System.err.println(page);
		if(page!=null&&page!=""&&!("null".equals(page))){
			System.err.println(page);
			currentpage=Integer.parseInt(page);
		}
		pageDivid.setCurrentPage(currentpage);
		return pageDivid;
	}

	@Override
	public void updateDept(String dept_job_relId,Department department, Job job) {
		DeptJobRel deptJobRel = dept_job_relDAO.getDeptJobRel(dept_job_relId);
		deptJobRel.setDepartment(department);
		deptJobRel.setJob(job);
		dept_job_relDAO.update(deptJobRel);
		
	}

	@Override
	public void add(Department department, Job job) {
		// TODO Auto-generated method stub
		DeptJobRel deptJobRel = new DeptJobRel();
		deptJobRel.setDepartment(department);
		deptJobRel.setJob(job);
		deptJobRel.setIsDelete(0);
		dept_job_relDAO.add(deptJobRel);
	}

	@Override
	public void delLie(String dept_job_relId) {
		// TODO Auto-generated method stub
		DeptJobRel deptJobRel = dept_job_relDAO.getDeptJobRel(dept_job_relId);
		deptJobRel.setIsDelete(1);
		dept_job_relDAO.update(deptJobRel);
	}

	@Override
	public DeptJobRel getduty(String dept_job_relId) {
		// TODO Auto-generated method stub
		return dept_job_relDAO.getDeptJobRel(dept_job_relId);
	}

	@Override
	public void delLie(String[] checkbox) {
		// TODO Auto-generated method stub
		for (int i = 0; i < checkbox.length; i++) {
			delLie(checkbox[i]);
		}
	}

	@Override
	public void updateDept(String dept_job_relId, String jobName) {
		
		DeptJobRel deptJobRel = dept_job_relDAO.getDeptJobRel(dept_job_relId);
		deptJobRel.getJob().setJobName(jobName);
		dept_job_relDAO.update(deptJobRel);
	}

	@Override
	public void add(String departmentId, String jobName) {
		IDeptDAO deptDAO = new DeptDAO();
		Department department = deptDAO.getDept(departmentId);
		Job job = new Job();
		job.setJobName(jobName);
		job.setIsDelete(0);
		IJobDAO jobDAO = new JobDAO();
		if (jobDAO.getByName(jobName)==null) {
			jobDAO.save(job);
		}else{
			job = jobDAO.getByName(jobName);
		}
		
		add(department, job);
	}

	@Override
	public List<DeptJobRel> queryNpageByDeptName(PageDivid pageDivid, String deptId) {
		// TODO Auto-generated method stub
	
		IDeptDAO deptDAO = new DeptDAO();
		Department department = deptDAO.getDept(deptId);
		
		List<DeptJobRel> deptJobRels =dept_job_relDAO.queryBydeptName(pageDivid, department);
		return deptJobRels;
	}

}
