package org.jsoft.person.service;

import java.util.List;

import org.jsoft.comm.service.IBaseService;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.Job;
import org.jsoft.comm.vo.Personnelinfo;

/**  
 * <员工调动Service接口> 
 * @author xfd   
 * @version 创建时间：2014-9-29 下午7:40:51  
 */
public interface IPersonnelRemoveService extends IBaseService {
	
	/**
	 * 得到某一员工的部门
	 * @param personnelId
	 * @return
	 * 		Department
	 */
	public Department getDepartmentByPersonnelId(String personnelId);
	
	/**
	 * 得到某一员工的职位
	 * @param personnelId
	 * @return
	 * 		Job
	 */
	public Job getJobByPersonnelId(String personnelId);
	
	/**
	 * 得到某一员工的DeptJobRel
	 * @param personnelId
	 * @return
	 * 		DeptJobRel
	 */
	public DeptJobRel getDeptJobRelByPersonnelId(String personnelId);
	
	/**
	 * 得到所有的department
	 * @return
	 * 		department list
	 */
	public List<Department> getAllDepartment();
	
	/**
	 * 得到所有的job
	 * @return
	 * 		job list
	 */
	public List<Job> getAllJob();
	
	
	/**
	 * 保存员工调动
	 * @param personnelinfo
	 * @param afterRemoveDepartment
	 * @param beforeRemoveDepartment
	 * @param afterRemoveJob
	 * @param beforeRemoveJob
	 * @param removeReason
	 * @param personnelRemoveRemark
	 */
	public void saveRemove(Personnelinfo personnelinfo,String afterRemoveDepartment,String beforeRemoveDepartment,
			String afterRemoveJob,String beforeRemoveJob,String removeReason,String personnelRemoveRemark);
	
	
	/**
	 *  修改某员工的DeptJobRel
	 * @param personnelId
	 * @param department
	 * @param job
	 */
	
	public void updateDeptJobRel(String personnelId,Department department,Job job);
	
	/**
	 * @param departmentId
	 * @return
	 * 		Department
	 */
	public Department getDepartmentByDepartmentId(String departmentId);
	
	/**
	 * @param jobId
	 * @return
	 * 		Job
	 */
	public Job getJobByJobId(String jobId);
	
	/**
	 * @param personnelId
	 * @return
	 * 		Personnelinfo
	 */
	public Personnelinfo getPersonnelinfoByPersonnelinfoId(String personnelId);
	
	/**
	 * @param personnelNo
	 * @return
	 * 		Personnelinfo
	 */
	public Personnelinfo getPersonnelinfoByPersonnelNo(String personnelNo);

}
