package org.jsoft.system.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Operater;
import org.jsoft.system.service.IOperateLogService;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;

public class OperateServlet  extends BaseServlet{
private IOperaterService operaterService = new OperaterService();
private IOperateLogService operateLogService = new OperateLogService();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String jumpUpdatePassword(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("jumpUpdatePassword");
		
		return "jsps/system/operater/updatePassword.jsp";
	}
	public String updatePassword(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("updatePassword");
		String newPassword=req.getParameter("newPassword");
		String opId = ((Operater)req.getSession().getAttribute("operater")).getOpId();
		operaterService.updatePassword(opId, newPassword);
		/*日志*/
		String info="更改了密码";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/operater/result.jsp";
	}
	
}
