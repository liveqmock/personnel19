package org.jsoft.salary.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.Job;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.comm.vo.Salary;
import org.jsoft.salary.dao.impl.DepartmentDAO;
import org.jsoft.salary.dao.impl.JobDAO;
import org.jsoft.salary.dao.impl.SalaryDAO;
import org.jsoft.salary.service.SalaryManageOP;
import org.jsoft.system.service.IOperateLogService;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;

public class SalaryServlet extends BaseServlet
{

	private IOperaterService operaterService = new OperaterService();
	private IOperateLogService operateLogService = new OperateLogService();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	public String SalaryManageJump(HttpServletRequest req,
			HttpServletResponse resp)
	{

		SalaryManageOP sa = new SalaryManageOP();
		Map<Department,StringBuffer> map=sa.queryDeptJobRel();
		req.setAttribute("map", map);
		Iterator<Department> iter = map.keySet().iterator();
        Department d=iter.next();
        StringBuffer str=map.get(d);
		req.setAttribute("str", str);
		//String info="登陆了工资管理界面";
		//operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		
		return "jsps/salary/salarymanage/SalaryManage.jsp";

	}

	public String queryAllJump(HttpServletRequest req, HttpServletResponse resp)
	{
		SalaryManageOP op = new SalaryManageOP();
		List<DeptJobRel> list = op.queryFistPage();
		PageDivid pageDivid = op.getPageDivide("1");
		req.setAttribute("pageDivid", pageDivid);
		req.setAttribute("list", list);

		// String info="进行了工资管理中查询全部的操作";
		// operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()),
		// info);

		return "jsps/salary/salarymanage/QuerySalary.jsp";
	}

	public String queryOneJump(HttpServletRequest req, HttpServletResponse resp)
	{

		// System.out.println(req.getParameter("sjob"));
		// System.out.println(req.getParameter("sdept"));
		String jobname = req.getParameter("sjob");
		String deptid = req.getParameter("sdept");

		DepartmentDAO de = new DepartmentDAO();
		JobDAO jb = new JobDAO();
		String jobid = jb.queryJobByJobName(jobname).getJobId();
		String deptname = de.queryDeptById(deptid).getDepartmentName();
		req.setAttribute("jobname", jobname);
		req.setAttribute("deptname", deptname);

		SalaryManageOP sam = new SalaryManageOP();
		DeptJobRel dept = sam.querySalary(jobid, deptid);
		String deptjobid = dept.getDeptJobRelId();
		req.setAttribute("deptjobid", deptjobid);

		// Salary salary=sam.querySalary(jobid, deptid).getSalary();
		req.setAttribute("dept", dept);
		// 现在可以获得到选取的部门与职位，需要调用方法查询该部门该职位的薪资
		System.out.println("运行了salaryJump方法");

		// String info="对"+deptname+"部门"+jobname+"职位进行了查询操作";
		// operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()),
		// info);

		return "jsps/salary/salarymanage/QueryOneSalary.jsp";
	}

	public String queryByCondition(HttpServletRequest req,
			HttpServletResponse resp)
	{

		SalaryManageOP sa = new SalaryManageOP();
		String page = req.getParameter("page");
		System.out.println("第二个page" + page);
		String operaterName = req.getParameter("opName");
		System.out.println("下面将输出page");
		System.out.println(page);
		System.out.println("输出完毕");
		System.out.println(operaterName);
		List<DeptJobRel> list = new ArrayList<DeptJobRel>();
		PageDivid pageDivid = sa.getPageDivide(page);
		list = sa.queryNPage(pageDivid);
		req.setAttribute("pageDivid", pageDivid);
		req.setAttribute("list", list);

		// String info="查询了所有工资的第"+page+"页";
		// operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()),
		// info);

		/* 日志 */
		return "jsps/salary/salarymanage/QuerySalary.jsp";
	}

	public String changeSalary(HttpServletRequest req, HttpServletResponse resp)
	{
		// //从表单中获得到所有的信息
		// double bonus=Double.parseDouble(req.getParameter("bonus"));
		// double
		// lunchSalary=Double.parseDouble(req.getParameter("lunchSalary"));
		// double
		// trafficSalary=Double.parseDouble(req.getParameter("trafficSalary"));
		// double
		// basicSalary=Double.parseDouble(req.getParameter("basicSalary"));
		// double allSalary=Double.parseDouble(req.getParameter("allSalary"));
		// String id=req.getParameter("id");
		// //获取完毕
		// SalaryDAO sa=new SalaryDAO();
		// Salary salary=sa.querySalary(id);
		// salary.setBasicSalary(basicSalary);
		// salary.setAllSalary(allSalary);
		// salary.setBonus(bonus);
		// salary.setLunchSalary(lunchSalary);
		// salary.setTrafficSalary(trafficSalary);
		// SalaryManageOP sal=new SalaryManageOP();
		// sal.updateSalary(salary);
		double bonus = Double.parseDouble(req.getParameter("bonus"));
		double lunchSalary = Double
				.parseDouble(req.getParameter("lunchSalary"));
		double trafficSalary = Double.parseDouble(req
				.getParameter("trafficSalary"));
		double basicSalary = Double
				.parseDouble(req.getParameter("basicSalary"));
		double allSalary = Double.parseDouble(req.getParameter("allSalary"));
		// String id=req.getParameter("id");
		// 获取完毕
		// SalaryDAO sa=new SalaryDAO();
		// Salary salary=sa.querySalary(id);
		// salary.setBasicSalary(basicSalary);
		// salary.setAllSalary(allSalary);
		// salary.setBonus(bonus);
		// salary.setLunchSalary(lunchSalary);
		// salary.setTrafficSalary(trafficSalary);
		SalaryManageOP sal = new SalaryManageOP();
		// sal.updateSalary(salary);
		Salary newsalary = sal.dealSaveSalary(bonus, lunchSalary,
				trafficSalary, basicSalary, allSalary);
		/*
		 * 新生成一个salary
		 */
		String deptjobid = req.getParameter("deptjobid");
		System.out.println("***" + deptjobid);
		SalaryDAO saldao = new SalaryDAO();
		DeptJobRel dept = saldao.queryDeptJobRelbyId(deptjobid);// 查出来0
		sal.savesalaryadjust(dept);
		dept.setSalary(newsalary);// 改变
		saldao.update(dept);// 不知道好不好用 更新
		/*
		 * 上面是将deptjobrel表中salaryid的值改为新的值
		 */

		// String
		// info="对"+dept.getDepartment().getDepartmentName()+"部门"+dept.getJob().getJobName()+"部门进行了工资调整的操作";
		// operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()),
		// info);

		return "../salarymanage.sal?method=SalaryManageJump";
	}

	public String changeSalaryAll(HttpServletRequest req,
			HttpServletResponse resp)
	{
		String page = req.getParameter("page");
		System.out.println("第一个page" + page);
		double bonus = Double.parseDouble(req.getParameter("bonus"));
		double lunchSalary = Double
				.parseDouble(req.getParameter("lunchSalary"));
		double trafficSalary = Double.parseDouble(req
				.getParameter("trafficSalary"));
		double basicSalary = Double
				.parseDouble(req.getParameter("basicSalary"));
		double allSalary = Double.parseDouble(req.getParameter("allSalary"));
		// String id=req.getParameter("id");
		// 获取完毕
		// SalaryDAO sa=new SalaryDAO();
		// Salary salary=sa.querySalary(id);
		// salary.setBasicSalary(basicSalary);
		// salary.setAllSalary(allSalary);
		// salary.setBonus(bonus);
		// salary.setLunchSalary(lunchSalary);
		// salary.setTrafficSalary(trafficSalary);
		SalaryManageOP sal = new SalaryManageOP();
		// sal.updateSalary(salary);
		Salary newsalary = sal.dealSaveSalary(bonus, lunchSalary,
				trafficSalary, basicSalary, allSalary);
		/*
		 * 新生成一个salary
		 */
		String deptjobid = req.getParameter("deptjobid");
		System.out.println("***" + deptjobid);
		SalaryDAO saldao = new SalaryDAO();
		DeptJobRel dept = saldao.queryDeptJobRelbyId(deptjobid);// 查出来0
		sal.savesalaryadjust(dept);
		dept.setSalary(newsalary);// 改变
		saldao.update(dept);// 不知道好不好用 更新
		/*
		 * 上面是将deptjobrel表中salaryid的值改为新的值
		 */

		// String
		// info="对"+dept.getDepartment().getDepartmentName()+"部门"+dept.getJob().getJobName()+"部门进行了工资调整的操作";
		// operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()),
		// info);

		return "../salarymanage.sal?method=queryByCondition&page=" + page;

	}

}
