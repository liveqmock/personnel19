package org.jsoft.salary.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.vo.Bak;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Salary;
import org.jsoft.salary.dao.ISalaryDAO;

public class SalaryDAO extends BaseDAO<Object> implements ISalaryDAO
{
	@Override
	public Salary querySalary(String salaryId)
	{
		String hql = "from Salary where salaryId = " + salaryId;
		List<Object> list = find(hql);
		Salary salary = (Salary) list.get(0);
		return salary;
	}

	@Override
	public void updateSalary(Salary salary)
	{
		update(salary);
	}

	@Override
	public DeptJobRel queryDeptJobRel(String jobid, String deptid)
	{

		// TODO Auto-generated method stub
		String hql = "from DeptJobRel where department.departmentId=? and job.jobId=? ";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(jobid);
		paraments.add(deptid);
		List<Object> list = find(hql, paraments);
		DeptJobRel d = (DeptJobRel) list.get(0);
		return d;
	}

	@Override
	public int AllCount()
	{
		String hql = "select count(*)  From DeptJobRel where isDelete=?";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(0);
		int a = Integer.parseInt(count(hql, paraments) + "");
		return a;

		// TODO Auto-generated method stub
	}

	public int AllCount2()
	{
		String hql = "select count(*)  From DeptJobRel where isDelete=? and salary is null";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(0);
		int a = Integer.parseInt(count(hql, paraments) + "");
		System.out.println("我要输出总页数了 a  A AA A A ");
		System.out.println(a);
		return a;

	}

	@Override
	public List<DeptJobRel> queryAll(PageDivid pageDivid)
	{
		BaseDAO<DeptJobRel> base = new BaseDAO<DeptJobRel>();
		String hql = "From DeptJobRel where isDelete=? and salary is not null";
		List<Object> paraments = new ArrayList<Object>();
		paraments.add(0);
		List<DeptJobRel> baks = base.find(hql, paraments, pageDivid);
		return baks;

	}

	@Override
	public void saveSalary(Salary salary)
	{
		save(salary);

		// TODO Auto-generated method stub
	}

	@Override
	public DeptJobRel queryDeptJobRelbyId(String DeptJobRelId)
	{
		// TODO Auto-generated method stub
		String hql = "from DeptJobRel where deptJobRelId =" + DeptJobRelId;
		return (DeptJobRel) (find(hql).get(0));
	}

	public static void main(String[] args)
	{
		SalaryDAO sa = new SalaryDAO();
		DeptJobRel d = sa.queryDeptJobRelbyId("2");
		System.out.println(d.getJob().getJobName());
	}

}
