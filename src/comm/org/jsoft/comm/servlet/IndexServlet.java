package org.jsoft.comm.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndexServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String login(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("list");
	//	List users=userDAO.queryList();
	//	req.setAttribute("users", users);
		return "jsps/comm/login/login.jsp";
	}

}
