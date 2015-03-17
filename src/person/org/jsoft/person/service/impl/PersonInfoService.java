package org.jsoft.person.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.DictionLog;
import org.jsoft.comm.vo.Duty;
import org.jsoft.comm.vo.Job;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.comm.vo.Salary;
import org.jsoft.person.dao.impl.PersonInfoDAO;
import org.jsoft.person.dao.impl.PersonInfoDictionDAO;
import org.jsoft.person.service.IPersonInfoService;

public class PersonInfoService implements IPersonInfoService {
	
	
	public PersonInfoService() {
	}

	@Override 
	public List<Personnelinfo> queryPersonsAll(PageDivid pg) { // 查询所有的员工
		
		PersonInfoDAO piDAO = new PersonInfoDAO();
		PersonInfoDictionDAO pidDAO = new PersonInfoDictionDAO();
		
		List<Personnelinfo> persons1 = piDAO.queryPersonsAll( pg);
		List<Personnelinfo> persons2 = new ArrayList<Personnelinfo>();
		for(Personnelinfo p1 : persons1){
			
			try {
				Personnelinfo p = new Personnelinfo();
				p.setPersonnelId(p1.getPersonnelId());
				
				Department dept = new Department();
				dept.setDepartmentId(p1.getDeptJobRel().getDepartment().getDepartmentId());
				dept.setDepartmentName(p1.getDeptJobRel().getDepartment().getDepartmentName());
				
				Job j = new Job();
				j.setJobId(p1.getDeptJobRel().getJob().getJobId());
				j.setJobName(p1.getDeptJobRel().getJob().getJobName());
				
				DeptJobRel djr = new DeptJobRel();
				djr.setDeptJobRelId(p1.getDeptJobRel().getDeptJobRelId());
				djr.setDepartment(dept);
				djr.setJob(j);
				
				p.setDeptJobRel(djr);
				
				Duty duty = new Duty();
				duty.setDutyId(p1.getDuty().getDutyId());
				duty.setDutyName(p1.getDuty().getDutyName());
				p.setDuty(duty);
				
				p.setPersonnelNo(p1.getPersonnelNo());
				p.setPersonnelName(p1.getPersonnelName());
				p.setPersonnelSex(p1.getPersonnelSex());
				p.setBirthday(p1.getBirthday());
				p.setAge(p1.getAge());
				p.setIdentityId(p1.getIdentityId());
				p.setWedLock(p1.getWedLock());
				p.setRace(p1.getRace());
				p.setNativePlace(p1.getNativePlace());
				p.setPolitic(p1.getPolitic());
				p.setEMail(p1.getEMail());
				p.setPhone(p1.getPhone());
				p.setAddress(p1.getAddress());
				p.setEngageForm(p1.getEngageForm());
				p.setTipTopDegree(p1.getTipTopDegree());
				p.setSpacialty(p1.getSpacialty());
				p.setSchool(p1.getSchool());
				p.setBeginWorkDate(p1.getBeginWorkDate());
				p.setWorkState(p1.getWorkState());
				p.setWorkId(p1.getWorkId());
				p.setContractTerm(p1.getContractTerm());
				p.setBeFormDate(p1.getBeFormDate());
				p.setNotWorkState(p1.getNotWorkState());
				p.setBeginContract(p1.getBeginContract());
				p.setEndContract(p1.getEndContract());
				p.setWorkAge(p1.getWorkAge());
				p.setScore(p1.getScore());
				p.setIsDelete(p1.getIsDelete());
				persons2.add(p);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		List<Personnelinfo> persons = pidDAO.buildPersonByDiction(persons2);
		return persons;
	}


	@Override 
	public List<Personnelinfo> queryPersonsAll() { // 查询所有的员工
		
		PersonInfoDAO piDAO = new PersonInfoDAO();
		PersonInfoDictionDAO pidDAO = new PersonInfoDictionDAO();
		
		List<Personnelinfo> persons1 = piDAO.queryPersonsAll();
		List<Personnelinfo> persons2 = new ArrayList<Personnelinfo>();
		for(Personnelinfo p1 : persons1){
			
			try {
				Personnelinfo p = new Personnelinfo();
				p.setPersonnelId(p1.getPersonnelId());
				
				Department dept = new Department();
				dept.setDepartmentId(p1.getDeptJobRel().getDepartment().getDepartmentId());
				dept.setDepartmentName(p1.getDeptJobRel().getDepartment().getDepartmentName());
				
				Job j = new Job();
				j.setJobId(p1.getDeptJobRel().getJob().getJobId());
				j.setJobName(p1.getDeptJobRel().getJob().getJobName());
				
				DeptJobRel djr = new DeptJobRel();
				djr.setDeptJobRelId(p1.getDeptJobRel().getDeptJobRelId());
				djr.setDepartment(dept);
				djr.setJob(j);
				
				p.setDeptJobRel(djr);
				
				Duty duty = new Duty();
				duty.setDutyId(p1.getDuty().getDutyId());
				duty.setDutyName(p1.getDuty().getDutyName());
				p.setDuty(duty);
				
				p.setPersonnelNo(p1.getPersonnelNo());
				p.setPersonnelName(p1.getPersonnelName());
				p.setPersonnelSex(p1.getPersonnelSex());
				p.setBirthday(p1.getBirthday());
				p.setAge(p1.getAge());
				p.setIdentityId(p1.getIdentityId());
				p.setWedLock(p1.getWedLock());
				p.setRace(p1.getRace());
				p.setNativePlace(p1.getNativePlace());
				p.setPolitic(p1.getPolitic());
				p.setEMail(p1.getEMail());
				p.setPhone(p1.getPhone());
				p.setAddress(p1.getAddress());
				p.setEngageForm(p1.getEngageForm());
				p.setTipTopDegree(p1.getTipTopDegree());
				p.setSpacialty(p1.getSpacialty());
				p.setSchool(p1.getSchool());
				p.setBeginWorkDate(p1.getBeginWorkDate());
				p.setWorkState(p1.getWorkState());
				p.setWorkId(p1.getWorkId());
				p.setContractTerm(p1.getContractTerm());
				p.setBeFormDate(p1.getBeFormDate());
				p.setNotWorkState(p1.getNotWorkState());
				p.setBeginContract(p1.getBeginContract());
				p.setEndContract(p1.getEndContract());
				p.setWorkAge(p1.getWorkAge());
				p.setScore(p1.getScore());
				p.setIsDelete(p1.getIsDelete());
				persons2.add(p);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		List<Personnelinfo> persons = pidDAO.buildPersonByDiction(persons2);
		return persons;
	}

	@Override
	public Personnelinfo queryPersonSingle(String personnelId) {
		
		PersonInfoDAO piDAO = new PersonInfoDAO();
		PersonInfoDictionDAO pidDAO = new PersonInfoDictionDAO();
		Personnelinfo p = piDAO.queryPersonSingle(personnelId);
		List<Personnelinfo> personSingle1 = new ArrayList<Personnelinfo>();
		personSingle1.add(p);
		List<Personnelinfo> personSingle = pidDAO.buildPersonByDiction(personSingle1);
		return personSingle.get(0);
	}

	@Override
	public void updatePerson(String personnelId,  String personnelNo, String personnelName,
			String personnelSex, String birthday, String age,
			String identityId, String wedLock, String race, String nativePlace,
			String politic, String EMail, String phone, String address,
			String engageForm, String tipTopDegree, String spacialty,
			String school, String beginWorkDate, String workState,
			String workId, String contractTerm, String beFormDate,
			String notWorkState, String beginContract, String endContract,
			String workAge, String score) {
		
		PersonInfoDAO piDAO = new PersonInfoDAO();
		Personnelinfo p = piDAO.queryPersonSingle(personnelId);
	
		p.setPersonnelNo(personnelNo);
		p.setPersonnelName(personnelName);
		p.setPersonnelSex(personnelSex);
		try {
			Timestamp ts = new Timestamp(new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").parse(birthday).getTime());
			// ↑ 将String转换成TimeStamp的方法
			p.setBirthday(ts);
		} catch (ParseException ee) {
			ee.printStackTrace();
		}
		p.setAge(Integer.parseInt(age));
		p.setIdentityId(identityId);
		p.setWedLock(wedLock);
		p.setRace(race);
		p.setNativePlace(nativePlace);
		p.setPolitic(politic);
		p.setEMail(EMail);
		p.setPhone(phone);
		p.setAddress(address);
		p.setEngageForm(engageForm);
		p.setTipTopDegree(tipTopDegree);
		p.setSpacialty(spacialty);
		p.setSchool(school);
		try {
			Timestamp ts = new Timestamp(new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").parse(beginWorkDate).getTime());
			// ↑ 将String转换成TimeStamp的方法
			p.setBeginWorkDate(ts);
		} catch (ParseException ee) {
			ee.printStackTrace();
		}
		p.setWorkState(workState);
		p.setWorkId(workId);
		p.setContractTerm(Integer.parseInt(contractTerm));
		try {
			Timestamp ts1 = new Timestamp(new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").parse(beFormDate).getTime());
			// ↑ 将String转换成TimeStamp的方法
			p.setBeFormDate(ts1);
			
			if ("".equals(notWorkState)){
				Timestamp ts2 = null;
				p.setNotWorkState(ts2);
			} else {
				Timestamp ts2 = new Timestamp(new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").parse(notWorkState).getTime());
				// ↑ 将String转换成TimeStamp的方法
				p.setNotWorkState(ts2);
			}
			
			Timestamp ts3 = new Timestamp(new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").parse(beginContract).getTime());
			// ↑ 将String转换成TimeStamp的方法
			p.setBeginContract(ts3);
			
			if ("".equals(endContract)){
				Timestamp ts4 = null;
				p.setEndContract(ts4);
			} else {
				Timestamp ts4 = new Timestamp(new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").parse(endContract).getTime());
				// ↑ 将String转换成TimeStamp的方法
				p.setEndContract(ts4);
			}	
			
		} catch (ParseException ee) {
			ee.printStackTrace();
		}
		p.setWorkAge(Integer.parseInt(workAge));
		p.setScore(Integer.parseInt(score));
		p.setIsDelete(0);
		
		piDAO.updatePerson(p);

	}

	@Override
	public void deletePerson(String personnelId) {
		PersonInfoDAO piDAO = new PersonInfoDAO();
		Personnelinfo p = piDAO.queryPersonSingle(personnelId);
		p.setIsDelete(1);
		piDAO.updatePerson(p);
		
	}

	@Override
	public List<DictionLog> queryDictionInfos(String pId) {
		PersonInfoDictionDAO pidDAO = new PersonInfoDictionDAO();
		List<DictionLog> dictionLogs = pidDAO.queryDictionInfos(pId);
		return dictionLogs;
	}

	@Override
	public void InsertPerson(String jobId, String dutyId, String departmentId, String personnelNo, String personnelName,
			String personnelSex, String birthday, String age,
			String identityId, String wedLock, String race, String nativePlace,
			String politic, String EMail, String phone, String address,
			String engageForm, String tipTopDegree, String spacialty,
			String school, String beginWorkDate, String workState,
			String workId, String contractTerm, String beFormDate,
			String notWorkState, String beginContract, String endContract,
			String workAge, String score) {


		PersonInfoDAO piDAO = new PersonInfoDAO();
		Personnelinfo p = new Personnelinfo();
		
		BaseDAO<Duty> bDutyDAO = new BaseDAO<Duty>();
		Duty d = bDutyDAO.get("from Duty where dutyId = '"+dutyId+"'   ");
		p.setDuty(d);
		
		BaseDAO<Department> bDepartmentDAO = new BaseDAO<Department>();
		Department dept = bDepartmentDAO.get("from Department where departmentId = '"+departmentId+"'   ");
		
		BaseDAO<Job> bJobDAO = new BaseDAO<Job>();
		Job j = bJobDAO.get("from Job where jobId = '"+jobId+"' ");
		
		BaseDAO<DeptJobRel> bDeptJobRelDAO = new BaseDAO<DeptJobRel>();
		DeptJobRel djr = new DeptJobRel();
		djr.setDepartment(dept);
		djr.setJob(j);
		
		BaseDAO<Salary> bSalaryDAO = new BaseDAO<Salary>();
		Salary s = new Salary();
		s.setAllSalary(8000.00);
		s.setBasicSalary(5000.00);
		s.setBonus(1000.00);
		s.setIsDelete(0);
		s.setLunchSalary(1000.00);
		s.setTrafficSalary(1000.00);
		Timestamp ts0 = new Timestamp(System.currentTimeMillis());
		// ↑ 将String转换成TimeStamp的方法
		s.setUseredDate(ts0);
		bSalaryDAO.save(s);
		
		djr.setSalary(s);
		djr.setIsDelete(0);
		
		bDeptJobRelDAO.save(djr);            // 先存这个
		
		p.setDeptJobRel(djr);

		p.setPersonnelNo(personnelNo);
		p.setPersonnelName(personnelName);
		p.setPersonnelSex(personnelSex);
		try {
			Timestamp ts = new Timestamp(new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").parse(birthday).getTime());
			// ↑ 将String转换成TimeStamp的方法
			p.setBirthday(ts);
		} catch (ParseException ee) {
			ee.printStackTrace();
		}
		p.setAge(Integer.parseInt(age));
		p.setIdentityId(identityId);
		p.setWedLock(wedLock);
		p.setRace(race);
		p.setNativePlace(nativePlace);
		p.setPolitic(politic);
		p.setEMail(EMail);
		p.setPhone(phone);
		p.setAddress(address);
		p.setEngageForm(engageForm);
		p.setTipTopDegree(tipTopDegree);
		p.setSpacialty(spacialty);
		p.setSchool(school);
		try {
			Timestamp ts = new Timestamp(new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").parse(beginWorkDate).getTime());
			// ↑ 将String转换成TimeStamp的方法
			p.setBeginWorkDate(ts);
		} catch (ParseException ee) {
			ee.printStackTrace();
		}
		p.setWorkState(workState);
		p.setWorkId(workId);
		p.setContractTerm(Integer.parseInt(contractTerm));
		try {
			Timestamp ts1 = new Timestamp(new SimpleDateFormat(  // 转正日期 传过来的
					"yyyy-MM-dd HH:mm:ss").parse(beFormDate).getTime());
			// ↑ 将String转换成TimeStamp的方法
			p.setBeFormDate(ts1);
			Timestamp ts2 = null;
			// ↑ 将String转换成TimeStamp的方法
			p.setNotWorkState(ts2);
			Timestamp ts3 = new Timestamp(System.currentTimeMillis());
			// ↑ 将String转换成TimeStamp的方法
			p.setBeginContract(ts3);
			Timestamp ts4 = null;
			// ↑ 将String转换成TimeStamp的方法
			p.setEndContract(ts4);
		} catch (ParseException ee) {
			ee.printStackTrace();
		}
		p.setWorkAge(Integer.parseInt(workAge));
		p.setScore(Integer.parseInt(score));
		p.setIsDelete(0);
		
		piDAO.addPerson(p);
		
	}
	
	@Override
	public List<Duty>  queryDutysAll() {
		PersonInfoDAO piDAO = new PersonInfoDAO();
		List<Duty> dutys= piDAO.queryDutysAll();
		return dutys;
	}

	@Override
	public List<Department>  queryDepartmentsAll() {
		PersonInfoDAO piDAO = new PersonInfoDAO();
		List<Department> departments = piDAO.queryDepartmentsAll();
		return departments;
	}

	@Override
	public List<Job>  queryJobsAll() {
		PersonInfoDAO piDAO = new PersonInfoDAO();
		List<Job> jobs = piDAO.queryJobsAll();
		return jobs;
	}
	
	public static void main(String[] args) {
		PersonInfoService piService = new PersonInfoService();
		List<Department> dd = piService.queryDepartmentsAll();
		
		for(Department d : dd){
			System.out.println(d.getDepartmentName());
		}
	}

	@Override
	public List<String> getAllPersonnelNo() {
		// TODO Auto-generated method stub
		List<String> personnelNos=new ArrayList<String>();
		PersonInfoDAO personInfoDAO=new PersonInfoDAO();
		List<Personnelinfo> personnelinfos=new ArrayList<Personnelinfo>();
		personnelinfos=personInfoDAO.queryPersonsAll();
		for (int i = 0; i < personnelinfos.size(); i++) {
			personnelNos.add(personnelinfos.get(i).getPersonnelNo());
		}
		return personnelNos;
	}


}
