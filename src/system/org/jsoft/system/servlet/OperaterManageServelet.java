package org.jsoft.system.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Menu;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.person.service.impl.PersonInfoService;
import org.jsoft.system.dao.impl.OperaterDAO;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.MenuService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;

/**
 * Servlet implementation class OperaterManageServelet
 */
public class OperaterManageServelet extends BaseServlet {
	private OperateLogService operateLogService = new OperateLogService();
	private IOperaterService operaterService = new OperaterService();
	private static final long serialVersionUID = 1L;

	public String operater(HttpServletRequest req, HttpServletResponse resp) {
		String strpage = req.getParameter("currentPage");
		
		int currentPage;
		if (null == strpage) {
			currentPage = 1;
		} else {

			currentPage = Integer.parseInt(strpage);
		}
		PageDivid pageDivid = new PageDivid();
		pageDivid = operaterService.getPageDividByPage(currentPage);
		List<Operater> operaters = operaterService
				.getOperatersByPageDivid(pageDivid);
		req.setAttribute("pageDivid", pageDivid);
		req.setAttribute("operaters", operaters);
		/* 日志 
		String info = "查看了管理人员信息列表";
		operateLogService.add(operaterService.getById(((Operater) req
				.getSession().getAttribute("operater")).getOpId()), info);
		 日志 */
		return "jsps/system/operater/operater.jsp";
	}

	public String operatermassage(HttpServletRequest req,
			HttpServletResponse resp) {
		String opId = req.getParameter("opId");
		OperaterDAO operaterdao = new OperaterDAO();
		Operater operater = operaterdao.getOperaterByMessage("opId", opId);
		req.setAttribute("operater", operater);
		/* 日志 
		String info = "查看了管理人员" + operater.getOpName() + "的详细信息";
		operateLogService.add(operaterService.getById(((Operater) req
				.getSession().getAttribute("operater")).getOpId()), info);
		 日志 */
		return "jsps/system/operater/operatermessage.jsp";
	}

	public String jumpAddOperater(HttpServletRequest req,
			HttpServletResponse resp) {
		PersonInfoService personInfoService=new PersonInfoService();
		String personnelNos = "";
		List<String> personnelNolist = personInfoService.getAllPersonnelNo();
		if (personnelNolist.size() != 0) {
			personnelNos = personnelNolist.get(0);
			for (int i = 1; i < personnelNolist.size(); i++) {
				personnelNos = personnelNos + "," + personnelNolist.get(i);
			}
		}
		req.setAttribute("personnelNos", personnelNos);
		String opNames = "";
		List<String> opNamelist = operaterService.getAllopNames();
		if (opNamelist.size() != 0) {
			personnelNos = opNamelist.get(0);
			for (int i = 1; i < opNamelist.size(); i++) {
				opNames = opNames + "," + opNamelist.get(i);
			}
		}
		req.setAttribute("opNames", opNames);
		return "jsps/system/operater/addOperater.jsp";

	}

	public String addOperater(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("addOperater");
		String personnelNo = req.getParameter("personnelNo");
		String opName = req.getParameter("opName");
		String opPassword = req.getParameter("opPassword");
		String operatertype = req.getParameter("operatertype");
		operaterService.addOperater(personnelNo, opName, opPassword,
				operatertype);
		/* 日志 */
		String info = "添加了管理人员:" + opName;
		operateLogService.add(operaterService.getById(((Operater) req
				.getSession().getAttribute("operater")).getOpId()), info);
		/* 日志 */
		return redirPath + "operatermanage.sys?method=operater";

	}

	public String deloperaters(HttpServletRequest req, HttpServletResponse resp) {
		String[] opIds = req.getParameterValues("checkbox");
		/* 日志 */
		String info = "删除了管理人员:";
		if (opIds != null) {
			for (int i = 0; i < opIds.length; i++) {
				info = info + operaterService.getById(opIds[i]) + " ";
			}
		}
		operateLogService.add(operaterService.getById(((Operater) req
				.getSession().getAttribute("operater")).getOpId()), info);
		/* 日志 */
		operaterService.deleteOperaters(opIds);
		return redirPath + "operatermanage.sys?method=operater";
	}

	public String deleteAoperater(HttpServletRequest req,
			HttpServletResponse resp) {
		String opId = req.getParameter("opId");
		/* 日志 */
		String info = "删除了管理人员:" + operaterService.getById(opId);
		operateLogService.add(operaterService.getById(((Operater) req
				.getSession().getAttribute("operater")).getOpId()), info);
		/* 日志 */
		operaterService.deleteOperater("opId", opId);
		return redirPath + "operatermanage.sys?method=operater";
	}
}
