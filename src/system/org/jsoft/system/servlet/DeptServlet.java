package org.jsoft.system.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.system.service.IDeptService;
import org.jsoft.system.service.IOperateLogService;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.DeptSevice;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;

public class DeptServlet extends BaseServlet{
private IDeptService deptService =new DeptSevice();
private IOperaterService operaterService = new OperaterService();
private IOperateLogService operateLogService = new OperateLogService();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String queryDept(HttpServletRequest req,HttpServletResponse resp) {
		List<Department> departments = deptService.queryAll();
		System.out.println("querydept");
		req.setAttribute("departments", departments);
		System.out.println(departments.size());
		/*日志*/
		String info="查询了所有的部门";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/basic/dept/deptQuery.jsp";
	}

	public String query(HttpServletRequest req,HttpServletResponse resp) {
		String page = req.getParameter("page");
		List<Department> departments = deptService.queryNpage(page);
		req.setAttribute("departments", departments);
		PageDivid pageDivid =deptService.getPageDivid(page);
		req.setAttribute("pageDivid", pageDivid);
		/*日志*/
		String info="查看了所有的部门";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/basic/dept/deptQuery.jsp";
	}
	public String addDept(HttpServletRequest req,HttpServletResponse resp) {
		String deptName = req.getParameter("deptName");
		deptService.add(deptName);
		/*日志*/
		String info="增加了一个部门"+deptName;
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return redirPath+"dept.sys?method=query";
	}
	public String jumpAdd(HttpServletRequest req,HttpServletResponse resp) {
		return "jsps/system/basic/dept/addDept.jsp";
	}
	public String jumpEdit(HttpServletRequest req,HttpServletResponse resp) {
		String[] checkbox =req.getParameterValues("checkbox");
		String departmentId=req.getParameter("departmentId");
		if(checkbox!=null){
			departmentId=checkbox[0];
		}
		Department department = deptService.getdept(departmentId);
		req.setAttribute("department", department);
		/*日志*/
		String info="查看了"+department.getDepartmentName()+"的名称";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/basic/dept/editDept.jsp";
	}
	public String del(HttpServletRequest req,HttpServletResponse resp) {
		String[] checkbox =req.getParameterValues("checkbox");
		String departmentId=req.getParameter("departmentId");
		System.out.println(checkbox);
		if(checkbox==null){
			deptService.delLie(departmentId);
		}else{
			deptService.delLie(checkbox);
		}
		/*日志*/
		String info="删除了一个部门";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return redirPath+"dept.sys?method=query";
	}
	public String edit(HttpServletRequest req,HttpServletResponse resp) {
		String departmentId=req.getParameter("departmentId");
		String departmentName = req.getParameter("departmentName");
		deptService.updateDept(departmentId, departmentName);
		/*日志*/
		String info="将原部门该位了"+departmentName;
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return redirPath+"dept.sys?method=query";
	}
	
}
