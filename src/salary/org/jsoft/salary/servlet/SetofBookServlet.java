package org.jsoft.salary.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.dao.impl.BaseDAO;
import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Salary;
import org.jsoft.salary.dao.impl.DeptJobRelDAO;
import org.jsoft.salary.dao.impl.SalaryDAO;
import org.jsoft.salary.service.impl.SetofBookService;
import org.jsoft.system.service.IDept_job_relService;
import org.jsoft.system.service.impl.Dept_job_relService;

public class SetofBookServlet extends BaseServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IDept_job_relService dept_job_relService = new Dept_job_relService();
	private SetofBookService sob=new SetofBookService();

	public String wel(HttpServletRequest req, HttpServletResponse resp)
	{
		SetofBookService setofbook = new SetofBookService();
		PageDivid pageDivid =sob.getPageDivid("1");
		pageDivid.setCurrentPage(1);
		List<DeptJobRel> deptJobRels = setofbook.queryDeptJobwithoutSalary(pageDivid);
		req.setAttribute("deptJobRels", deptJobRels);
		req.setAttribute("pageDivid", pageDivid);
		return "jsps/salary/setofbook/setofbook.jsp";
	}

	public String jumpEdit(HttpServletRequest req, HttpServletResponse resp)
	{
		String[] checkbox = req.getParameterValues("checkbox");
		String deptJobRelId = req.getParameter("deptJobRelId");
		if (checkbox != null)
		{
			deptJobRelId = checkbox[0];
		}
		DeptJobRel deptJobRel = dept_job_relService.getduty(deptJobRelId);
		req.setAttribute("deptJobRel", deptJobRel);
		return "jsps/salary/setofbook/editJob.jsp";

	}

	public String edit(HttpServletRequest req, HttpServletResponse resp)
	{
		double bonus = Double.parseDouble(req.getParameter("bonus"));
		double lunchSalary = Double.parseDouble(req.getParameter("lunch"));
		double trafficSalary = Double.parseDouble(req.getParameter("traffic"));
		double basicSalary = Double.parseDouble(req.getParameter("base"));
		double allSalary = Double.parseDouble(req.getParameter("all"));
		System.out.println(bonus);
		System.out.println(lunchSalary);
		System.out.println(trafficSalary);
		System.out.println(basicSalary);
		System.out.println(allSalary);
		Salary salary=new Salary();
		salary.setAllSalary(allSalary);
		salary.setBasicSalary(basicSalary);
		salary.setBonus(bonus);
		salary.setLunchSalary(lunchSalary);
		salary.setTrafficSalary(trafficSalary);
		BaseDAO<Salary> base=new BaseDAO<Salary>();
		base.save(salary);
		String deptjobid=req.getParameter("name");
		System.out.println(deptjobid);
		DeptJobRelDAO dept=new DeptJobRelDAO();
		DeptJobRel deptjob=dept.queryDeptJobRelFromDeptJobRelId(deptjobid);
		deptjob.setSalary(salary);
		SalaryDAO sal=new SalaryDAO();
		sal.update(deptjob);
		return "../setofbook.sal?method=wel";
	}
	
	public String query(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("执行了query");
		String page = req.getParameter("page");
		List<DeptJobRel> deptJobRels = sob.queryNpage(page);
		req.setAttribute("deptJobRels", deptJobRels);
		PageDivid pageDivid =sob.getPageDivid(page);
		req.setAttribute("pageDivid", pageDivid);
		return "jsps/salary/setofbook/setofbook.jsp";
	}

}
