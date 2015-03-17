package org.jsoft.person.dao;

import java.util.List;

import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DictionLog;
import org.jsoft.comm.vo.Duty;
import org.jsoft.comm.vo.Job;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelinfo;

public interface IPersonInfoDAO {
	public List<Personnelinfo> queryPersonsAll(PageDivid pg);  // 查询所有的员工 
	public List<Personnelinfo> queryPersonsAll();  // 查询所有的员工 
	
	public Personnelinfo queryPersonSingle(String personnelId);  // 查询单个员工
	
	public void addPerson(Personnelinfo p);  // 增加员工 

	public void updatePerson(Personnelinfo p);  // 修改员工
	
	public List<Duty> queryDutysAll();  // 查询所有职称
	public List<Department> queryDepartmentsAll();  // 查询所有部门
	public List<Job> queryJobsAll();  // 查询所有职务
	public Personnelinfo queryNo(String personnelNo);//查询员工编号
	
	/**
	 * 通过员工编号得到员工
	 * @param personnelNo
	 * @return
	 * 		Personnelinfo
	 */
	public Personnelinfo getPersonnelinfoByPersonnelNo(String personnelNo);

}
