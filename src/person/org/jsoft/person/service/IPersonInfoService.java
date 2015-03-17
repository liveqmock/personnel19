package org.jsoft.person.service;

import java.util.List;

import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.DictionLog;
import org.jsoft.comm.vo.Duty;
import org.jsoft.comm.vo.Job;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelinfo;



public interface IPersonInfoService {
	
	public List<Personnelinfo> queryPersonsAll(PageDivid pg);  // 查询所有的员工 
	public List<Personnelinfo> queryPersonsAll();  // 查询所有的员工 
	public Personnelinfo queryPersonSingle(String personnelId);  // 查询所有的员工
	// 增加员工
	public void InsertPerson(String jobId, String dutyId, String departmentId,  String personnelNo, String personnelName , String personnelSex, String birthday , String age , String identityId, String wedLock, String race , String nativePlace , String politic, String EMail, String phone, String address, String engageForm, String tipTopDegree, String spacialty, String school, String beginWorkDate, String workState, String workId, String contractTerm, String beFormDate, String notWorkState ,String beginContract  ,String endContract , String workAge, String score );
	// 修改员工
	public void updatePerson(String personnelId ,  String personnelNo, String personnelName , String personnelSex, String birthday , String age , String identityId, String wedLock, String race , String nativePlace , String politic, String EMail, String phone, String address, String engageForm, String tipTopDegree, String spacialty, String school, String beginWorkDate, String workState, String workId, String contractTerm, String beFormDate, String notWorkState ,String beginContract  ,String endContract , String workAge, String score );
	public void deletePerson(String personnelId);    // 删除员工
	
	public List<DictionLog> queryDictionInfos(String pId);    // 查询字典值
	
	public List<Duty> queryDutysAll();  // 查询所有职称
	public List<Department> queryDepartmentsAll();  // 查询所有部门
	public List<Job> queryJobsAll();  // 查询所有职务
	/**
	 * 查询所有员工编号
	 * @return List<String>
	 */
	public List<String> getAllPersonnelNo();

	

}
