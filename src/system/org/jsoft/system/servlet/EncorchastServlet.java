package org.jsoft.system.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Encorchast;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.system.service.IEncorchastService;
import org.jsoft.system.service.IOperateLogService;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.EncorchastService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;

public class EncorchastServlet extends BaseServlet{
private IEncorchastService encorchastService = new EncorchastService();
private IOperaterService operaterService = new OperaterService();
private IOperateLogService operateLogService = new OperateLogService();
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String query(HttpServletRequest req,HttpServletResponse resp) {
		String page = req.getParameter("page");
		List<Encorchast> encorchasts = encorchastService.queryNpage(page);
		req.setAttribute("encorchasts", encorchasts);
		PageDivid pageDivid =encorchastService.getPageDivid(page);
		req.setAttribute("pageDivid", pageDivid);
		/*日志*/
		String info="查询了所有的奖惩制度信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/basic/encorchast/encorchastQuery.jsp";
	}
	public String addEncorchast(HttpServletRequest req,HttpServletResponse resp) {
		double personnelEncorchastPoint =Double.parseDouble(req.getParameter("personnelEncOrChastPoint"));
		String personnelEncorchastSort = req.getParameter("personnelEncOrChastSort");
		double money = Double.parseDouble(req.getParameter("money"));
		encorchastService.add(personnelEncorchastPoint, money, personnelEncorchastSort);
		/*日志*/
		String info="增加了一个奖惩制度信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return redirPath+"encorchast.sys?method=query";
	}
	public String jumpAdd(HttpServletRequest req,HttpServletResponse resp) {
		return "jsps/system/basic/encorchast/addEncorchast.jsp";
	}
	public String jumpEdit(HttpServletRequest req,HttpServletResponse resp) {
		String[] checkbox =req.getParameterValues("checkbox");
		String encOrChastId=req.getParameter("encOrChastId");
		if(checkbox!=null){
			encOrChastId=checkbox[0];
		}
		Encorchast encorchast = encorchastService.getEncorchast(encOrChastId);
		req.setAttribute("encorchast", encorchast);
		System.out.println(encOrChastId);
		/*日志*/
		String info="查看了一个奖惩制度信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/basic/encorchast/editEncorchast.jsp";
	}
	public String del(HttpServletRequest req,HttpServletResponse resp) {
		String[] checkbox =req.getParameterValues("checkbox");
		String encOrChastId=req.getParameter("encOrChastId");
		System.out.println(checkbox);
		if(checkbox==null){
			encorchastService.delLie(encOrChastId);
		}else{
			encorchastService.delLie(checkbox);
		}
		/*日志*/
		String info="删除了一个奖惩制度信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return redirPath+"encorchast.sys?method=query";
	}
	public String edit(HttpServletRequest req,HttpServletResponse resp) {
		String encOrChastId=req.getParameter("encOrChastId");
		System.out.println(encOrChastId);
		double personnelEncorchastPoint =Double.parseDouble(req.getParameter("personnelEncOrChastPoint"));
		String personnelEncorchastSort = req.getParameter("personnelEncOrChastSort");
		double money = Double.parseDouble(req.getParameter("money"));
		System.out.println(personnelEncorchastPoint);
		System.out.println(personnelEncorchastSort);
		System.out.println(money);
		encorchastService.updateDept(encOrChastId, personnelEncorchastPoint, money, personnelEncorchastSort);
		/*日志*/
		String info="修改了一个奖惩制度信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return redirPath+"encorchast.sys?method=query";
	}
}
