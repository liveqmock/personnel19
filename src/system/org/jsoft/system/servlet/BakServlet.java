package org.jsoft.system.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Bak;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.system.service.IBakService;
import org.jsoft.system.service.IOperateLogService;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.BakService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;


public class BakServlet extends BaseServlet{
	private IOperaterService operaterService = new OperaterService();
	private IOperateLogService operateLogService = new OperateLogService();
	private IBakService bakService = new BakService();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String query(HttpServletRequest req,HttpServletResponse resp) {
		
		 bakService = new BakService();
		String page =req.getParameter("page");
		System.out.println(page);
		List<Bak> baks = new ArrayList<Bak>();
		PageDivid pageDivid = bakService.getPageDivide(page);
		baks = bakService.queryNPage(pageDivid);
		req.setAttribute("pageDivid", pageDivid);
		req.setAttribute("baks", baks);
		/*日志*/
		String info="查看了所有人的备份信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/bak/dbOperate.jsp";
	}
	
	public String jumpAddBak(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("JumpaddBak");
		
		return "jsps/system/bak/addBak.jsp";
	}
	public String jumpEditBak(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("JumpEditBak");
		
		return "jsps/system/bak/editBak.jsp";
	}
	public String jumpQueryBak(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("JumpQueryBak");
		
		return "jsps/system/bak/queryBak.jsp";
	}
	public String addBak(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("addBak");
		String path = req.getSession().getServletContext().getRealPath("\\");
		Operater operater=(Operater)req.getSession().getAttribute("operater");
		/*String bakRemark = new String(req.getParameter("remark")
				.getBytes("ISO-8859-1"), "UTF-8");*/
		String bakRemark = req.getParameter("remark");
		String fileName = req.getParameter("fileName");
		System.out.println(bakRemark);
		System.out.println(fileName);
		System.out.println(operater);
		bakService.bakAndAdd(path,bakRemark, fileName, operater);
		/*日志*/
		String info="增加了一条备份信息 备份名"+fileName;
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return redirPath+"bak.sys?method=query";
	}
	public String restore(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("restore");
		String path = req.getSession().getServletContext().getRealPath("\\");
		String fileName = req.getParameter("fileName");
		bakService.restore(path, fileName);
		/*return redirPath+"bak.sys?method=query";*/
		/*日志*/
		String info="还原了数据库信息，被还原的文件名为"+fileName;
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/bak/result.jsp";
	}
	public String del(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("del");
		String bakId = req.getParameter("id");
		System.out.println(bakId);
		System.out.println(((Operater)req.getSession().getAttribute("operater")).getOpName());
		System.out.println(req.getParameter("username"));
		String username=((Operater)req.getSession().getAttribute("operater")).getOpName();
		bakService.deleteLie(bakId,username);
		/*日志*/
		String info="删除了 一条备份信息 备份名为"+bakService.getBakById(bakId).getPath();
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		if("queryList".equals(req.getParameter("status"))){
			String page =req.getParameter("page");
			String upDate = req.getParameter("upDate");
			String downDate = req.getParameter("downDate");
			String operaterName = req.getParameter("opName");
			req.setAttribute("page", page);
			req.setAttribute("upDate", upDate);
			req.setAttribute("downDate", downDate);
			req.setAttribute("opName", operaterName);
			return redirPath+"bak.sys?method=queryByCondition&&page="+page+"&&upDate="+upDate+"&&downDate="+downDate+"&&opName="+operaterName;
		}
	
		return redirPath+"bak.sys?method=query";
	}
	public String delSome(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("delSome");
		String[] checkbox =req.getParameterValues("checkbox");
		System.out.println(checkbox);
		System.out.println(((Operater)req.getSession().getAttribute("operater")).getOpName());
		System.out.println(req.getParameter("username"));
		String username=((Operater)req.getSession().getAttribute("operater")).getOpName();
		bakService.delLieSome(checkbox, username);
		/*日志*/
		String info="删除了 一些备份信息 备份名";
		for (int i = 0; i < checkbox.length; i++) {
			info+=bakService.getBakById(checkbox[i]).getPath();
		}
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		if("queryList".equals(req.getParameter("status"))){
			String page =req.getParameter("page");
			String upDate = req.getParameter("upDate");
			String downDate = req.getParameter("downDate");
			String operaterName = req.getParameter("opName");
			req.setAttribute("page", page);
			req.setAttribute("upDate", upDate);
			req.setAttribute("downDate", downDate);
			req.setAttribute("opName", operaterName);
			
			return redirPath+"bak.sys?method=queryByCondition&&page="+page+"&&upDate="+upDate+"&&downDate="+downDate+"&&opName="+operaterName;
		}
		
		return redirPath+"bak.sys?method=query";
	}
	public String jumpEdit(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("jumpEdit");
		String bakId = req.getParameter("id");
		System.out.println(bakId);
		String[] checkbox =req.getParameterValues("checkbox");
		System.out.println(checkbox);
		if(checkbox!=null){
			if(checkbox.length>1){
				return redirPath+"bak.sys?method=query";
			}
			bakId=checkbox[0];
		}else{
			if(bakId==null||bakId==""){
				return redirPath+"bak.sys?method=query";
			}
		}
		Bak bak=bakService.getBakById(bakId);
		req.setAttribute("bak", bak);
		/*日志*/
		String info="查看了"+bak.getPath()+"备份信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/bak/editBak.jsp";
	}
	public String jumpBakDetail(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("jumpBakDetail");
		String bakId = req.getParameter("id");
		System.out.println(bakId);
		String[] checkbox =req.getParameterValues("checkbox");
		System.out.println(checkbox);
		if(checkbox!=null){
			if(checkbox.length>1){
				return redirPath+"bak.sys?method=query";
			}
			bakId=checkbox[0];
		}else{
			if(bakId==null||bakId==""){
				return redirPath+"bak.sys?method=query";
			}
		}
		Bak bak=bakService.getBakById(bakId);
		req.setAttribute("bak", bak);
		/*日志*/
		String info="查看了"+bak.getPath()+"的备份信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/bak/bakDetail.jsp";
	}
	public String edit(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("edit");
		String bakId = req.getParameter("id");
		Bak bak=bakService.getBakById(bakId);
		String path = req.getSession().getServletContext().getRealPath("\\");
		String bakRemark = req.getParameter("remark");
		String fileName = req.getParameter("fileName");
		bakService.editBakById(bakId, path, bakRemark, fileName);
		/*日志*/
		String info="更改"+bak.getPath()+"的备份信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return redirPath+"bak.sys?method=query";
	}
	public String queryByCondition(HttpServletRequest req,HttpServletResponse resp) {
		
		 bakService = new BakService();
		String page =req.getParameter("page");
		String upDate = req.getParameter("upDate");
		String downDate = req.getParameter("downDate");
		String operaterName = req.getParameter("opName");
		System.out.println(page);
		System.out.println(upDate);
		System.out.println(downDate);
		System.out.println(operaterName);
		List<Bak> baks = new ArrayList<Bak>();
		PageDivid pageDivid = bakService.getPageDivide(page);
		baks = bakService.queryByElements(operaterName, upDate, downDate, pageDivid);
		req.setAttribute("pageDivid", pageDivid);
		req.setAttribute("baks", baks);
		req.setAttribute("upDate", upDate);
		req.setAttribute("downDate", downDate);
		req.setAttribute("operaterName", operaterName);
		/*日志*/
		String info="查询了"+operaterName+"在"+upDate+"和"+downDate+"这段时间的备份信息";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/bak/queryList.jsp";
	}
	
}
