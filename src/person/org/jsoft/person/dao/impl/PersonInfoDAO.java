package org.jsoft.person.dao.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DictionLog;
import org.jsoft.comm.vo.Duty;
import org.jsoft.comm.vo.Job;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.person.dao.IPersonInfoDAO;

public class PersonInfoDAO extends BaseDAO<Personnelinfo> implements IPersonInfoDAO {

	@Override
	public List<Personnelinfo> queryPersonsAll(PageDivid pg) {
		String isDelete = "0";
		List<Personnelinfo> persons = this.find("from Personnelinfo where isDelete = '"+isDelete+"'   " , pg);   // 查找 
		return persons;		
	}
	
	public List<Personnelinfo> queryPersonsAll() {
		String isDelete = "0";
		List<Personnelinfo> persons = this.find("from Personnelinfo where isDelete = '"+isDelete+"'   ");   // 查找 
		return persons;		
	}
	
	@Override
	public Personnelinfo queryPersonSingle(String personnelId) {
		
		String hql = "from Personnelinfo where personnelId =  '"+personnelId+"'   ";
		Personnelinfo p = this.get(hql);
		return p;
	}
	
	@Override
	public void addPerson(Personnelinfo p) {
		this.save(p);
	}

	
	@Override
	public void updatePerson(Personnelinfo p) {
		this.update(p);
	}
	
	@Override
	public List<Duty> queryDutysAll() {
		BaseDAO<Duty> bDAO = new BaseDAO<Duty>();
		List<Duty> dutys = bDAO.find("from Duty");
		return dutys;

	}

	@Override
	public List<Department>  queryDepartmentsAll() {
		BaseDAO<Department> bDAO = new BaseDAO<Department>();
		List<Department> departments = bDAO.find("from Department");
		return departments;
	}

	@Override
	public List<Job>  queryJobsAll() {
		BaseDAO<Job> bDAO = new BaseDAO<Job>();
		List<Job> jobs = bDAO.find("from Job");
		return jobs;
	}
	public Personnelinfo queryNo(String personnelNo) {
		String hql = "from Personnelinfo where personnelNo='"+personnelNo+"'";
		Personnelinfo personnelinfo=new Personnelinfo();
		personnelinfo=this.get(hql);
		return personnelinfo;
	}

	public static void main(String[] args) {    //  测试可用
		PersonInfoDAO piDAO = new PersonInfoDAO();
		/*List<Personnelinfo> persons = piDAO.queryPersonsAll();
		for(Personnelinfo p : persons){
			System.out.println(p.getPersonnelId());
		}*/
		
		/*Personnelinfo p = new Personnelinfo();
		p.setPersonnelName("asdasd");
		piDAO.addPerson(p);*/
		
		/*Personnelinfo p = new Personnelinfo();
		p.setPersonnelId("testId6");
		piDAO.delete(p);*/
		
	/*	Personnelinfo p = new Personnelinfo();
		p.setPersonnelId("testId5");
		p.setPersonnelName("测试修改的名字");
		piDAO.updatePerson(p);*/
		/*String hql = "from Personnelinfo where deptJobRel in (from DeptJobRel where salary in (from Salary where basicSalary = 3000))"; //多个DeptJobRel.java
		List<Personnelinfo> ps=piDAO.find(hql);
		for (int i = 0; i < ps.size(); i++) {
			System.out.println(ps.get(i).getPersonnelId());
		}*/
		
		List<Job> jobs = piDAO.queryJobsAll();
		for(Job j : jobs){
			System.out.println(j.getJobName());
		}
	}

	@Override
	public Personnelinfo getPersonnelinfoByPersonnelNo(String personnelNo) {
		// TODO Auto-generated method stub
		String hql="FROM Personnelinfo WHERE personnelNo='"+personnelNo+"'";
		Personnelinfo personnelinfo=get(hql);
		return personnelinfo;
	}

	

	


	
	
	

}
