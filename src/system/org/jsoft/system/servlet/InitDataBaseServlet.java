package org.jsoft.system.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.servlet.BaseServlet;
import org.jsoft.comm.vo.Operater;
import org.jsoft.system.service.IInitDataBaseService;
import org.jsoft.system.service.IOperateLogService;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.InitDataBaseService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;

public class InitDataBaseServlet  extends BaseServlet{
	private IOperaterService operaterService = new OperaterService();
	private IOperateLogService operateLogService = new OperateLogService();
	private IInitDataBaseService initDataBaseService = new InitDataBaseService();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String initDB(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("JumpaddBak");
		String path = req.getSession().getServletContext().getRealPath("\\");
		initDataBaseService.initDateBase(path);
		/*return redirPath+"bak.sys?method=query";*/
		/*日志*/
		String info="初始化了数据库";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		return "jsps/system/bak/result.jsp";
	}
}
