package org.jsoft.salary.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.Operater;
import org.jsoft.salary.service.impl.DepartmentPBService;
import org.jsoft.system.service.IOperateLogService;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;

public class DepartmentPBServlet extends BaseServlet
{
	private IOperaterService operaterService = new OperaterService();
	private IOperateLogService operateLogService = new OperateLogService();
	private static final long serialVersionUID = 1L;
	
	public String search(HttpServletRequest req,HttpServletResponse resp)
	{
		
		System.out.println("jumpIntoSearch");
		DepartmentPBService dept = new DepartmentPBService();
		List<Department> deptlist = dept.queryDept();
		req.setAttribute("dept", deptlist);
		String method=dept.checkMethod(req.getMethod());
		req.setAttribute("method", method);
		System.out.println(method);
	
		String pbtype=req.getParameter("pbtype");
		String pbpoint=req.getParameter("pbpoint");
		String pbmoney=req.getParameter("pbmoney");
		String pblevel=req.getParameter("pblevel");
		String pbreason=req.getParameter("pbreason");
		String pbremark=req.getParameter("pbremark");
		String[] chosendept=req.getParameterValues("checkbox");
		String pbresult=dept.dopb(method,pbtype, pbpoint, pbmoney, pblevel, pbreason, pbremark,chosendept);
		req.setAttribute("pbresult", pbresult);
		System.out.println(pbresult);
		/*日志*/
		String info="执行了查询所有部门操作";
		if (method=="post"){
			info="执行了部门奖罚操作";
		}
//		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/salary/DepartmentPB/Search.jsp";
	}
	
	public String search2(HttpServletRequest req,HttpServletResponse resp)
	{
		
		System.out.println("jumpIntoSearch");
		DepartmentPBService dept = new DepartmentPBService();
		List<Department> deptlist = dept.queryDept();
		req.setAttribute("dept", deptlist);
		String method=dept.checkMethod(req.getMethod());
		req.setAttribute("method", method);
		System.out.println(method);
	
		String pbtype=req.getParameter("pbtype");
		String pbpoint=req.getParameter("pbpoint");
		String pbmoney=req.getParameter("pbmoney");
		String pblevel=req.getParameter("pblevel");
		String pbreason=req.getParameter("pbreason");
		String pbremark=req.getParameter("pbremark");
		String[] chosendept=req.getParameterValues("checkbox");
		String pbresult=dept.dopb(method,pbtype, pbpoint, pbmoney, pblevel, pbreason, pbremark,chosendept);
		req.setAttribute("pbresult", pbresult);
		System.out.println(pbresult);
		/*日志*/
		String info="执行了查询所有部门操作";
		if (method=="post"){
			info="执行了部门奖罚操作";
		}
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/salary/DepartmentPB/Search.jsp";
	}
}
