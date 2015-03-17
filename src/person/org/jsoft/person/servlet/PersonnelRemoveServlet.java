package org.jsoft.person.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Department;
import org.jsoft.comm.vo.Job;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.Personnelinfo;
import org.jsoft.person.service.IPersonnelRemoveService;
import org.jsoft.person.service.impl.PersonnelRemoveService;
import org.jsoft.system.service.IOperateLogService;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;

/**
 * Servlet implementation class PersonnelRemoveServlet
 */
public class PersonnelRemoveServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private IOperaterService operaterService = new OperaterService();
	private IOperateLogService operateLogService = new OperateLogService();
	private IPersonnelRemoveService personnelRemoveService=new PersonnelRemoveService();
	public String showJob(HttpServletRequest request,HttpServletResponse response){
		String personnelNo=(String)request.getParameter("personnelNo");
		Personnelinfo personnelinfo=personnelRemoveService.getPersonnelinfoByPersonnelNo(personnelNo);
		if(personnelinfo==null){
			request.getSession().setAttribute("personnelNo", personnelNo);
			return "jsps/person/personnelRemove/personnelRemove.jsp";
		}else{
			String personnelId=personnelinfo.getPersonnelId();
			Department personDepartment=personnelRemoveService.getDepartmentByPersonnelId(personnelId);
			//该员工的部门
			Job personJob=personnelRemoveService.getJobByPersonnelId(personnelId);//该员工的职位
			List<Department> departmentList=personnelRemoveService.getAllDepartment();//所有部门
			List<Job> jobList=personnelRemoveService.getAllJob();//所有职位
			request.getSession().setAttribute("personDepartment", personDepartment);
			request.getSession().setAttribute("personJob", personJob);
			request.getSession().setAttribute("departmentList", departmentList);
			request.getSession().setAttribute("jobList", jobList);
			request.getSession().setAttribute("personnelid", personnelId);
			return "jsps/person/personnelRemove/personnelRemove.jsp";
		}
	}
	public String saveRemove(HttpServletRequest request,HttpServletResponse response){
		String personnelId=(String)request.getSession().getAttribute("personnelid");
		Personnelinfo personnelinfo=personnelRemoveService.getPersonnelinfoByPersonnelinfoId(personnelId);
		String beforeRemoveDepartment=request.getParameter("beforeRemoveDepartment");
		String beforeRemoveJob=request.getParameter("beforeRemoveJob");
		String afterRemoveDepartment=request.getParameter("afterRemoveDepartment");
		Department department=personnelRemoveService.getDepartmentByDepartmentId(afterRemoveDepartment);
		String afterRemoveJob=request.getParameter("afterRemoveJob");
		Job job=personnelRemoveService.getJobByJobId(afterRemoveJob);
		String removeReason=request.getParameter("removeReason");
		String personnelRemoveRemark=request.getParameter("personnelRemoveRemark");
		personnelRemoveService.saveRemove(personnelinfo, department.getDepartmentName(), beforeRemoveDepartment, job.getJobName(), beforeRemoveJob, removeReason, personnelRemoveRemark);
		personnelRemoveService.updateDeptJobRel(personnelId, department, job);
		/*日志*/
		String info="修改了员工id为"+personnelId+"的职位和部门";
		operateLogService.add(operaterService.getById(((Operater)request.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		request.getSession().setAttribute("personDepartment", department);
		request.getSession().setAttribute("personJob", job);
		return redirPath+"personnelRemove.per?method=showJob";
	}
	public String back(HttpServletRequest request,HttpServletResponse response){
		request.getSession().setAttribute("personnelid", null);
		request.getSession().setAttribute("personnelNo", null);
		return "jsps/person/personnelRemove/personnelRemove.jsp";
	}
}
