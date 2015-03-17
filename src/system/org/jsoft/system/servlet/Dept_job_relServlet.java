package org.jsoft.system.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Bak;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.DeptJobRel;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.system.service.IDeptService;
import org.jsoft.system.service.IDept_job_relService;
import org.jsoft.system.service.IOperateLogService;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.BakService;
import org.jsoft.system.service.impl.DeptSevice;
import org.jsoft.system.service.impl.Dept_job_relService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;

public class Dept_job_relServlet extends BaseServlet{
	private IDept_job_relService dept_job_relService = new Dept_job_relService();
	private IDeptService deptService = new DeptSevice();
	private IOperaterService operaterService = new OperaterService();
	private IOperateLogService operateLogService = new OperateLogService();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String query(HttpServletRequest req,HttpServletResponse resp) {
		
		String page = req.getParameter("page");
		List<DeptJobRel> deptJobRels = dept_job_relService.queryNpage(page);
		req.setAttribute("deptJobRels", deptJobRels);
		PageDivid pageDivid =dept_job_relService.getPageDivid(page);
		req.setAttribute("pageDivid", pageDivid);
		/*日志*/
		String info="查询了所有职位的信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/basic/job/jobQuery.jsp";
	}
	public String adddjr(HttpServletRequest req,HttpServletResponse resp) {
		String jobName = req.getParameter("jobName");
		String departmentId = req.getParameter("departmentId");
		System.out.println(jobName);
		System.out.println(departmentId);
		dept_job_relService.add(departmentId, jobName);
		/*日志*/
		String info="增加了一个职位";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return redirPath+"djr.sys?method=query";
	}
	public String jumpAdd(HttpServletRequest req,HttpServletResponse resp) {
		List<Department> departments = deptService.queryAll();
		req.setAttribute("departments", departments);
		return "jsps/system/basic/job/addJob.jsp";
	}
	public String jumpEdit(HttpServletRequest req,HttpServletResponse resp) {
		String[] checkbox =req.getParameterValues("checkbox");
		String deptJobRelId=req.getParameter("deptJobRelId");
		if(checkbox!=null){
			deptJobRelId=checkbox[0];
		}
		DeptJobRel deptJobRel = dept_job_relService.getduty(deptJobRelId);
		req.setAttribute("deptJobRel", deptJobRel);
		return "jsps/system/basic/job/editJob.jsp";
	}
	public String del(HttpServletRequest req,HttpServletResponse resp) {
		String[] checkbox =req.getParameterValues("checkbox");
		String deptJobRelId=req.getParameter("deptJobRelId");
		System.out.println(checkbox);
		if(checkbox==null){
			dept_job_relService.delLie(deptJobRelId);
		}else{
			dept_job_relService.delLie(checkbox);
		}
		/*日志*/
		String info="删除了一个部门";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return redirPath+"djr.sys?method=query";
	}
	public String edit(HttpServletRequest req,HttpServletResponse resp) {
		String deptJobRelId=req.getParameter("deptJobRelId");
		String jobName = req.getParameter("jobName");
		System.out.println(jobName);
		dept_job_relService.updateDept(deptJobRelId, jobName);
		/*日志*/
		String info="对部门进行了修改 将原部门名改为"+jobName;
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return redirPath+"djr.sys?method=query";
	}
	
	public String queryByCondition(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("djdskfjlksdjfksldfjslkfjslkd");
		String page =req.getParameter("page");
		String departmentId = req.getParameter("departmentId");
		System.err.println(page);
		System.err.println(departmentId);
		List<DeptJobRel> deptJobRels = new ArrayList<DeptJobRel>();
		PageDivid pageDivid = dept_job_relService.getPageDivid(page);
		deptJobRels = dept_job_relService.queryNpageByDeptName(pageDivid, departmentId);
		req.setAttribute("pageDivid", pageDivid);
		req.setAttribute("departmentId", departmentId);
		req.setAttribute("deptJobRels", deptJobRels);

		/*日志*/
		String info="查询了的一个部门的职务";
		/*日志*/
		return "jsps/system/basic/job/queryList.jsp";
	}
	public String jumpQuery(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("JumpQueryBak");
		List<Department> departments = deptService.queryAll();
		req.setAttribute("departments", departments);
		return "jsps/system/basic/job/queryJob.jsp";
	}
	
}
