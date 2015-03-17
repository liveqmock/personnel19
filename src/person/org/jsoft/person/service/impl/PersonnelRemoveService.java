package org.jsoft.person.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.jsoft.comm.service.impl.BaseService;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.Job;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.comm.vo.Personnelremove;
import org.jsoft.person.dao.IDepartmentDAO;
import org.jsoft.person.dao.IDeptJobRelDAO;
import org.jsoft.person.dao.IJobDAO;
import org.jsoft.person.dao.IPersonInfoDAO;
import org.jsoft.person.dao.IPersonnelRemoveDAO;
import org.jsoft.person.dao.impl.DepartmentDAO;
import org.jsoft.person.dao.impl.DeptJobRelDAO;
import org.jsoft.person.dao.impl.JobDAO;
import org.jsoft.person.dao.impl.PersonInfoDAO;
import org.jsoft.person.dao.impl.PersonnelRemoveDAO;
import org.jsoft.person.service.IPersonnelRemoveService;

/**  
 * <员工调动Service实现> 
 * @author xfd   
 * @version 创建时间：2014-9-29 下午8:02:59  
 */
public class PersonnelRemoveService extends BaseService implements IPersonnelRemoveService {

	private IDeptJobRelDAO deptJobRelDAO=new DeptJobRelDAO();
	private IDepartmentDAO departmentDAO=new DepartmentDAO();
	private IJobDAO jobDAO=new JobDAO();
	private IPersonnelRemoveDAO personnelRemoveDAO=new PersonnelRemoveDAO();
	private IPersonInfoDAO personInfoDAO=new PersonInfoDAO();
	@Override
	public Department getDepartmentByPersonnelId(String personnelId) {
		// TODO Auto-generated method stub
		Department department=this.getDeptJobRelByPersonnelId(personnelId).getDepartment();
		return department;
	}

	@Override
	public Job getJobByPersonnelId(String personnelId) {
		// TODO Auto-generated method stub
		Job job=this.getDeptJobRelByPersonnelId(personnelId).getJob();
		return job;
	}

	@Override
	public DeptJobRel getDeptJobRelByPersonnelId(String personnelId) {
		// TODO Auto-generated method stub
		DeptJobRel deptJobRel=deptJobRelDAO.getDeptJobRelByPersonnelId(personnelId);
		return deptJobRel;
	}

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		List<Department> departmentList=departmentDAO.getAllDepartment();
		return departmentList;
	}

	@Override
	public List<Job> getAllJob() {
		// TODO Auto-generated method stub
		List<Job> jobList=jobDAO.getAllJob();
		return jobList;
	}

	@Override
	public void updateDeptJobRel(String personnelId,
			Department department, Job job) {
		// TODO Auto-generated method stub
		DeptJobRel deptJobRel=this.getDeptJobRelByPersonnelId(personnelId);
		deptJobRel.setDepartment(department);
		deptJobRel.setJob(job);
		deptJobRelDAO.updateDeptJobRel(deptJobRel);
	}

	@Override
	public void saveRemove(Personnelinfo personnelinfo,
			String afterRemoveDepartment, String beforeRemoveDepartment,
			String afterRemoveJob, String beforeRemoveJob, String removeReason,
			String personnelRemoveRemark) {
		// TODO Auto-generated method stub
		Personnelremove personnelRemove=new Personnelremove();
		personnelRemove.setAfterRemoveDepartment(afterRemoveDepartment);
		personnelRemove.setAfterRemoveJob(afterRemoveJob);
		personnelRemove.setBeforeRemoveDepartment(beforeRemoveDepartment);
		personnelRemove.setBeforeRemoveJob(beforeRemoveJob);
		personnelRemove.setIsDelete(0);
		personnelRemove.setPersonnelinfo(personnelinfo);
		personnelRemove.setPersonnelRemoveRemark(personnelRemoveRemark);
		personnelRemove.setRemoveDate(new Timestamp(new Date().getTime()));
		personnelRemove.setRemoveReason(removeReason);
		personnelRemoveDAO.saveRemove(personnelRemove);
	}

	@Override
	public Department getDepartmentByDepartmentId(String departmentId) {
		// TODO Auto-generated method stub
		Department department=departmentDAO.getDepartmentByDepartmentId(departmentId);
		return department;
	}

	@Override
	public Job getJobByJobId(String jobId) {
		// TODO Auto-generated method stub
		Job job=jobDAO.getJobByJobId(jobId);
		return job;
	}

	@Override
	public Personnelinfo getPersonnelinfoByPersonnelinfoId(String personnelId) {
		// TODO Auto-generated method stub
		Personnelinfo personnelInfo=personInfoDAO.queryPersonSingle(personnelId);
		return personnelInfo;
	}

	@Override
	public Personnelinfo getPersonnelinfoByPersonnelNo(String personnelNo) {
		// TODO Auto-generated method stub
		Personnelinfo personnelInfo=personInfoDAO.getPersonnelinfoByPersonnelNo(personnelNo);
		return personnelInfo;
	}
	

}
