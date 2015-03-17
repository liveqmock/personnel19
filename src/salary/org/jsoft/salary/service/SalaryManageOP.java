package org.jsoft.salary.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.Job;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Personneladjustsalary;
import org.jsoft.comm.vo.Salary;
import org.jsoft.salary.dao.impl.DepartmentDAO;
import org.jsoft.salary.dao.impl.JobDAO;
import org.jsoft.salary.dao.impl.SalaryDAO;

public class SalaryManageOP
{
	/**
	 * 返回所有没有被删除的职位
	 * 
	 * @return
	 */
	public List<Job> queryJob()
	{
		JobDAO jobdao = new JobDAO();
		return jobdao.queryAllJob();
	}

	/**
	 * 
	 * 
	 * 返回所有没有被删除的部门
	 * 
	 * @return
	 */
	public List<Department> queryDept()
	{
		DepartmentDAO dd = new DepartmentDAO();
		return dd.queryAllDept();

	}

	/**
	 * 给定一个jobid和一个deptid 从而查询salaryid 获得一个salary对象的方法
	 * 
	 * @return
	 */
	public DeptJobRel querySalary(String jobid, String deptid)
	{
		SalaryDAO salary = new SalaryDAO();
		DeptJobRel deptjobrel = salary.queryDeptJobRel(jobid, deptid);
		return deptjobrel;

	}

	public void updateSalary(Salary salary)
	{
		SalaryDAO s = new SalaryDAO();
		s.updateSalary(salary);
	}

	public List<DeptJobRel> queryFistPage()
	{
		// TODO Auto-generated method stub
		SalaryDAO salarydao = new SalaryDAO();
		PageDivid pageDivid = new PageDivid();
		int all = salarydao.AllCount();
		pageDivid.setAllPage(all / pageDivid.getEachPageNum() + 1);
		pageDivid.setCurrentPage(1);
		List<DeptJobRel> baks = salarydao.queryAll(pageDivid);
		return baks;
	}

	public List<DeptJobRel> queryNPage(int page)
	{
		// TODO Auto-generated method stub
		SalaryDAO salarydao = new SalaryDAO();
		PageDivid pageDivid = new PageDivid();
		int all = salarydao.AllCount();
		pageDivid.setAllPage(all / pageDivid.getEachPageNum() + 1);
		pageDivid.setCurrentPage(page);
		List<DeptJobRel> baks = salarydao.queryAll(pageDivid);
		if (baks.size() == 0)
		{
			baks = null;
		}
		return baks;
	}

	public List<DeptJobRel> query(String page)
	{
		// TODO Auto-generated method stub
		int currentpage = 0;
		if (page != null)
		{
			currentpage = Integer.parseInt(page);
		}
		List<DeptJobRel> baks = queryNPage(currentpage);
		return baks;
	}

	public PageDivid getPageDivide(String page)
	{
		// TODO Auto-generated method stub
		SalaryDAO salarydao = new SalaryDAO();
		PageDivid pageDivid = new PageDivid();
		int all = salarydao.AllCount();
		pageDivid.setNum(all);
		pageDivid.setAllPage((all - 1) / pageDivid.getEachPageNum() + 1);
		int currentpage = 1;
		System.err.println(page);
		if (page != null && page != "" && !("null".equals(page)))
		{
			System.err.println(page);
			currentpage = Integer.parseInt(page);
		}
		pageDivid.setCurrentPage(currentpage);
		return pageDivid;
	}

	public List<DeptJobRel> queryNPage(PageDivid pageDivid)
	{
		// TODO Auto-generated method stub
		SalaryDAO salarydao = new SalaryDAO();
		List<DeptJobRel> baks = salarydao.queryAll(pageDivid);
		if (baks.size() == 0)
		{
			baks = null;
		}
		return baks;
	}

	/**
	 * 
	 * 处理存储工资的
	 * 
	 * @param bonus
	 * @param lunchSalary
	 * @param trafficSalary
	 * @param basicSalary
	 * @param allSalary
	 */
	public Salary dealSaveSalary(double bonus, double lunchSalary,
			double trafficSalary, double basicSalary, double allSalary)
	{
		SalaryDAO sa = new SalaryDAO();
		Salary salary = new Salary();
		salary.setBasicSalary(basicSalary);
		salary.setBonus(bonus);
		salary.setLunchSalary(lunchSalary);
		salary.setTrafficSalary(trafficSalary);
		salary.setAllSalary(allSalary);
		sa.saveSalary(salary);
		return salary;
		/*
		 * 上面对新的salary进行了生成
		 */
	}

	public void savesalaryadjust(DeptJobRel dept)
	{
		Personneladjustsalary per = new Personneladjustsalary();
		Date ud = new java.util.Date();
		Timestamp st;
		st = new Timestamp(ud.getTime());// 当前时间
		per.setAdjustSalaryDate(st);
		per.setIsDelete(0);
		per.setDeptJobRel(dept);
		per.setSalary(dept.getSalary());
		SalaryDAO sa = new SalaryDAO();
		sa.save(per);

	}

	@SuppressWarnings("null")
	public Map<Department, StringBuffer> queryDeptJobRel()
	{
		Map<Department, StringBuffer> map = new HashMap<Department, StringBuffer>();
		DepartmentDAO department = new DepartmentDAO();
		List<Department> deptlist = department.queryAllDept();// 首先查询出所有的部门
		for (Department de : deptlist)
		{

			List<DeptJobRel> deptjobrellist = department
					.queryDeptJobRelbyDept(de);
			if(deptjobrellist.size()==0){
				break;
			}
			StringBuffer jobstring = new StringBuffer() ;
			for (DeptJobRel djr : deptjobrellist)
			{
				System.out.println(djr.getJob().getJobName());
				jobstring.append("<option >" + djr.getJob().getJobName()
						+ "</option>;");
			}
			System.out.println(jobstring);
			map.put(de, jobstring);
		}

		return map;

	}
	
	public static void main(String[] args)
	{
		SalaryManageOP sa=new SalaryManageOP();
		Map map=sa.queryDeptJobRel();
	}
}
