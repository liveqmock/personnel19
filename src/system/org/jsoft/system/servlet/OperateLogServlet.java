package org.jsoft.system.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.OperateLog;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.system.service.IOperateLogService;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;

public class OperateLogServlet extends BaseServlet{
	private IOperaterService operaterService = new OperaterService();
	private IOperateLogService operateLogService = new OperateLogService();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String query(HttpServletRequest req,HttpServletResponse resp) {

		String page =req.getParameter("page");
		System.out.println(page);
		List<OperateLog> operateLogs = new ArrayList<OperateLog>();
		PageDivid pageDivid = operateLogService.getPageDivid(page);
		operateLogs = operateLogService.queryAll(pageDivid);
		req.setAttribute("pageDivid", pageDivid);
		req.setAttribute("operateLogs", operateLogs);
		/*日志*/
		String info="查看了所有人的日志信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/log/operateLog.jsp";
	}
	public String jumpQuery(HttpServletRequest req,HttpServletResponse resp) {

		return "jsps/system/log/queryLog.jsp";
	}
	public String jumpSee(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("jumpSee");
		String operateLogId = req.getParameter("id");
		System.out.println(operateLogId);
		String[] checkbox =req.getParameterValues("checkbox");
		System.out.println(checkbox);
		if(checkbox!=null){
			if(checkbox.length>1){
				return redirPath+"bak.sys?method=query";
			}
			operateLogId=checkbox[0];
		}else{
			if(operateLogId==null||operateLogId==""){
				return redirPath+"bak.sys?method=query";
			}
		}
		OperateLog operateLog=operateLogService.getById(operateLogId);
		req.setAttribute("operateLog", operateLog);
		/*日志*/
		String info="查看了"+operateLog.getOperater().getOpName()+"的日志信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/log/logDetail.jsp";
	}
	public String queryByCondition(HttpServletRequest req,HttpServletResponse resp) {
		String page =req.getParameter("page");
		String upDate = req.getParameter("upDate");
		String downDate = req.getParameter("downDate");
		String operaterName = req.getParameter("opName");
		System.out.println(page);
		System.out.println(upDate);
		System.out.println(downDate);
		System.out.println(operaterName);
		List<OperateLog> operateLogs = new ArrayList<OperateLog>();
		PageDivid pageDivid = operateLogService.getPageDivid(page);
		operateLogs = operateLogService.queryByElements(operaterName, upDate, downDate, pageDivid);
		req.setAttribute("pageDivid", pageDivid);
		req.setAttribute("operateLogs", operateLogs);
		req.setAttribute("upDate", upDate);
		req.setAttribute("downDate", downDate);
		req.setAttribute("operaterName", operaterName);
		/*日志*/
		String info="查询了"+operaterName+"在"+upDate+"和"+downDate+"这段时间的日志信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/log/queryList.jsp";
	}
}
