package org.jsoft.comm.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoft.comm.vo.Operater;
import org.jsoft.system.service.IOperateLogService;
import org.jsoft.system.service.IOperaterService;
import org.jsoft.system.service.impl.OperateLogService;
import org.jsoft.system.service.impl.OperaterService;

public class LogServlet extends BaseServlet{
private IOperaterService operaterService = new OperaterService();
private IOperateLogService operateLogService = new OperateLogService();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String login(HttpServletRequest req,HttpServletResponse resp) {
		
		System.out.println("login");
		String username = req.getParameter("username");
		String password =req.getParameter("password");
		Operater operater = operaterService.getOperaterByUP(username, password);
		System.out.println(operater);
		req.getSession().setAttribute("operater", operater);
		if(operater!=null){
			/*日志*/
			String info="执行了登陆操作";
			operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
			/*日志*/
			return "jsps/comm/login/main.jsp";
		}else{
			req.setAttribute("result", "username or password is wrong");
			return "jsps/comm/login/login.jsp";
		}
	}
	public String logout(HttpServletRequest req,HttpServletResponse resp) {
		
		System.out.println("logout");
		/*日志*/
		String info="执行了登出操作";
		operateLogService.add(operaterService.getById(((Operater)req.getSession().getAttribute("operater")).getOpId()), info);
		/*日志*/
		req.getSession().invalidate();
		return "jsps/comm/login/login.jsp";
	}

}
