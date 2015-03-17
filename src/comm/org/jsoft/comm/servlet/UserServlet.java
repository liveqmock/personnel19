package org.jsoft.comm.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserServlet extends BaseServlet	{
	
	
	
	
	/**
	 * 
	 * ��ҳ
	 * 
	 * Page 
	 * 
	 * Page.jsp
	 * 
	 * 
	 * user.jsp
	 * 
	 * 
	 */
	//private UserDAO userDAO=new UserDAO();
	/**
	 * 
	 */
	private static final long serialVersionUID = 4164722184246175015L;
	public String list(HttpServletRequest req,HttpServletResponse resp) {
		System.out.println("list");
	//	List users=userDAO.queryList();
	//	req.setAttribute("users", users);
		return "user/list.jsp";
	}
	public String add(HttpServletRequest req,HttpServletResponse resp) {

		System.out.println("add");
		try {
		//	userDao.add(u);
		} catch (Exception e) {
			req.setAttribute("errorMsg",e.getMessage());
			return "inc/error.jsp";
		}
		return redirPath+"user.do?method=list";
	}
}
